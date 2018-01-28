package com.spoonsea.qualitytracing.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoonsea.qualitytracing.braumat.entity.Braumat;
import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.constant.Constants.Category;
import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.Braumat;
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
import com.spoonsea.qualitytracing.service.ReportService;


@Service
@ReportServiceAnnotation(name=BraumatSakeReportService.reportName, id="BraumatSakeReport", category=Category.Brewing)
public class BraumatSakeReportService implements ReportService<Braumat> {

    protected static final String reportName = "酿造清酒报表";

    private static final Logger logger = LoggerFactory.getLogger(BraumatSakeReportService.class);

    @Autowired
    private ArLottabRepository arlottabRepo;
    
    @Autowired
    private BarcodeRepository barcodeRepo;
    
    @Autowired
    private SakeRepository sakeRepo;
    
    @Autowired
    private Report_DetailRepository reportDetailRepo;

    private Map<String, String> columnMap;
    private List<String> columnName;
    private List<String> columnId;

    public String getReportId() {
        return this.getClass().getAnnotation(ReportServiceAnnotation.class).id();
    }

    public List<Sake> getSakeList(CodeInfo code) {
        List<Barcode> barcodeList = barcodeRepo.findTop1ByPackagingLineAndDateAndTimeLessThanOrderByTimeDesc(code.getLine(), code.getDate(), code.getTime());
        if (barcodeList.isEmpty()) {
            logger.warn("barcode not found for: line={}, date={}, time={}", code.getLine(), code.getDate(), code.getTime());
            return Arrays.asList();
        }
        Barcode barcode = barcodeList.get(0);
        logger.info("barcode: hid={}, workshop={}", barcode.getHid(), barcode.getPackagingLine());
        List<Sake> sakeList = sakeRepo.findByHidAndWineIDNotNull(barcode.getHid());
        return sakeList;
    }

    public List<Broth> getBrothList(CodeInfo code) {
        
    }

    @Override
    public ReportTemplate<Braumat> getReport(CodeInfo code) {
        // 1. find the full sake record in barcode table
        // 2. use the full sake time and sake number to query the braumat lab_check record
        // 3. find the first start record around lab_check record
        // 4. search the record between the two start record of step 3.
        // 5. return the reports
        List<Braumat> result = new ArrayList<Braumat>();
        List<Barcode> barcodeList = barcodeRepo.findTop1ByPackagingLineAndDateAndTimeLessThanOrderByTimeDesc(code.getLine(), code.getDate(), code.getTime());
        if (barcodeList.isEmpty()) {
            logger.warn("barcode not found for: line={}, date={}, time={}", code.getLine(), code.getDate(), code.getTime());
            return generateReport(result);
        }
        Barcode barcode = barcodeList.get(0);
        logger.info("barcode: hid={}, workshop={}", barcode.getHid(), barcode.getPackagingLine());
        List<Sake> sakeList = sakeRepo.findByHidAndWineIDNotNull(barcode.getHid());
        
        
        return generateReport(result);
    }

    public ReportTemplate<Braumat> generateReport(List<Braumat> records) {
        if (columnName == null) {
            List<Report_Detail> reportDetails = reportDetailRepo.findByPacket(Tpo.class.getSimpleName());
            columnMap = new HashMap<String, String>();
            columnId = new ArrayList<String>();
            columnName = new ArrayList<String>();
            for (Report_Detail record: reportDetails) {
                columnMap.put(record.getEnglish(), record.getChinese());
            }
            for (Field field: Braumat.class.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    columnId.add(field.getName());
                    columnName.add(columnMap.getOrDefault(field.getName(), field.getName()));
                }
            }
        }

        ReportTemplate<Braumat> report = new ReportTemplate<Braumat>();
        report.setColumnId(columnId);
        report.setColumnName(columnName);
        report.setReportId(getReportId());
        report.setReportName(reportName);
        report.setRecords(records);
        return report;
    }

    @Override
    public ReportTemplate<Braumat> getReport(String barcode) {
        List<Barcode> barcodeList = barcodeRepo.findByBarcode(barcode);
        logger.info("found barcode: {}", barcodeList.size());
        Set<Braumat> recordSet = new HashSet<Braumat>();
        for (Barcode rec: barcodeList) {
            if (rec.getPackagingLine() != null) {
                List<Braumat> result = tpoRepo.findByHidAndWorkshop(rec.getHid(), rec.getPackagingLine());
                recordSet.addAll(result);
            } else if (rec.getSid() != null){
                List<Braumat> result = tpoRepo.findByHid(rec.getHid());
                recordSet.addAll(result);
            } else {
                List<Braumat> result = tpoRepo.findBySid(rec.getHid());
                recordSet.addAll(result);
            }
        }
        return generateReport(recordSet.stream().collect(Collectors.toList()));
    }

}
