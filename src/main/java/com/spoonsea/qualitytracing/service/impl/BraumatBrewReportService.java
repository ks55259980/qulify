package com.spoonsea.qualitytracing.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoonsea.qualitytracing.braumat.dao.BraumatRepository;
import com.spoonsea.qualitytracing.braumat.entity.Brau33;
import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.constant.Constants.Category;
import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.ReportTemplate;
import com.spoonsea.qualitytracing.lims.dao.ArLottabRepository;
import com.spoonsea.qualitytracing.lims.dao.BarcodeRepository;
import com.spoonsea.qualitytracing.lims.dao.TpoRepository;
import com.spoonsea.qualitytracing.lims.dao.Report_DetailRepository;
import com.spoonsea.qualitytracing.lims.dao.SakeRepository;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.lims.model.Tpo;
import com.spoonsea.qualitytracing.lims.model.Report_Detail;
import com.spoonsea.qualitytracing.lims.model.Sake;
import com.spoonsea.qualitytracing.service.LimsService;
import com.spoonsea.qualitytracing.service.ReportService;


@Service
@ReportServiceAnnotation(name=BraumatBrewReportService.reportName,
id="BraumatBrewReport",
category=Category.Brewing,
enabled=false)
public class BraumatBrewReportService implements ReportService<Map<String, String>> {

    protected static final String reportName = "酿造糖化报表";

    private static final Logger logger = LoggerFactory.getLogger(BraumatBrewReportService.class);

    @Autowired
    private LimsService limsService;
    
    @Autowired
    private BarcodeRepository barcodeRepo;

    @Autowired
    private BraumatRepository braumatRepo;

    public String getReportId() {
        return this.getClass().getAnnotation(ReportServiceAnnotation.class).id();
    }
    
    private DateTime getFullSakeDateTime(Sake sake) {
        String dateStr = String.format("%s %s", sake.getDate(), sake.getFullTankTime().substring(0, 2));
        logger.info("local date string from sake: {}", dateStr);
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH");
        DateTime dt = DateTime.parse(dateStr, format).toDateTime(DateTimeZone.getDefault()).withZone(DateTimeZone.UTC);
        logger.info("local date time from sake in UTC: {}", dt.toString());
        return dt;
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(CodeInfo code) {
        // 1. find the full sake record in barcode table
        // 2. use the full sake time and sake number to query the braumat lab_check record
        // 3. find the first start record around lab_check record
        // 4. search the record between the two start record of step 3.
        // 5. return the reports
        Set<Brau33> result = new HashSet<Brau33>();
        List<Sake> sakeList = limsService.getSakeListWithWineID(code);
        for (Sake sake: sakeList) {
            DateTime dt = getFullSakeDateTime(sake);
            String teilanl = "BBT" + sake.getSakeTank();
            Brau33 labCheck = braumatRepo.findOneBySzJahrAndSzMonatAndSzTagAndSzStundeAndTeilanl(
                    dt.getYear() % 2000, dt.getMonthOfYear(), dt.getDayOfMonth(), dt.getHourOfDay(), teilanl);
            if (labCheck != null) {
                Brau33 first = braumatRepo.findTop1ByTeilanlAndGopNameAndEndTsLessThanOrderByStartTsDesc(teilanl, "End", labCheck.getStartTs());
                Brau33 last = braumatRepo.findTop1ByTeilanlAndGopNameAndStartTsGreaterThanOrderByStartTsAsc(teilanl, "Start", labCheck.getEndTs());
                List<Brau33> all = braumatRepo.findByTeilanlAndStartTsGreaterThanAndEndTsLessThan(teilanl, first.getEndTs(), last.getStartTs());
                result.addAll(all);
            }
        }
        return generateReport(result.stream().collect(Collectors.toList()));
    }

    public ReportTemplate<Map<String, String>> generateReport(List<Brau33> records) {
        List<String> columnId = new ArrayList<String>();
        List<String> columnName = new ArrayList<String>();
        
        columnId.addAll(Arrays.asList("startTs","endTs","teilanl", "gopName", "paramCount"));
        columnName.addAll(Arrays.asList("开始时间","结束时间","工艺单元名称","工艺步骤名称", "参数个数"));
        List<Map<String, String>> ret = new ArrayList<Map<String, String>>();
        for (Brau33 rec: records) {
            Map<String,String> result = new HashMap<String, String>();    
            result.put("startTs", new Date(rec.getStartTs().longValue() * 1000).toLocaleString());
            result.put("endTs", new Date(rec.getEndTs().longValue() * 1000).toLocaleString());
            result.put("teilanl", rec.getTeilanl());
            result.put("gopName", rec.getGopName());
            result.put("paramCount", Integer.toString(rec.getDfmAnz()));
            for (int i = 0; i < rec.getDfmAnz(); i++) {
                try {
                    String dim = (String) Brau33.class.getDeclaredField("dimDfm" + i).get(rec);
                    result.put("param" + i, (String) Brau33.class.getDeclaredField("nameDfm" + i).get(rec));
                    result.put("paramset" + i, (String) Brau33.class.getDeclaredField("swDfm" + i).get(rec) + dim);
                    result.put("paramval" + i, (String) Brau33.class.getDeclaredField("iwDfm" + i).get(rec) + dim);
                    if (columnId.size() < 5 + (i + 1) * 3) {
                        columnId.add("param" + i);
                        columnId.add("paramset" + i);
                        columnId.add("paramval" + i);
                        columnName.add("参数" + i);
                        columnName.add("参数" + i + "设定值");
                        columnName.add("参数" + i + "实际值");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    break;
                }
            }
            ret.add(result);
        }
        
        ReportTemplate<Map<String, String>> report = new ReportTemplate<Map<String, String>>();
        report.setColumnId(columnId);
        report.setColumnName(columnName);
        report.setReportId(getReportId());
        report.setReportName(reportName);
        report.setRecords(ret);
        return report;
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(String barcode) {
        List<Barcode> barcodeList = barcodeRepo.findByBarcode(barcode);
        logger.info("found barcode: {}", barcodeList.size());
        Set<Brau33> recordSet = new HashSet<Brau33>();
        return generateReport(recordSet.stream().collect(Collectors.toList()));
    }

}
