package com.spoonsea.qualitytracing.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.constant.Constants.Category;
import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.FinishedWineRecord;
import com.spoonsea.qualitytracing.dto.ReportRecord;
import com.spoonsea.qualitytracing.dto.ReportTemplate;
import com.spoonsea.qualitytracing.lims.dao.ArLottabRepository;
import com.spoonsea.qualitytracing.lims.dao.BarcodeRepository;
import com.spoonsea.qualitytracing.lims.dao.FinishedWineRepository;
import com.spoonsea.qualitytracing.lims.dao.Report_DetailRepository;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.lims.model.FinishedWine;
import com.spoonsea.qualitytracing.lims.model.Report_Detail;
import com.spoonsea.qualitytracing.service.ReportService;


@Service("FinishedWineReport")
@ReportServiceAnnotation(name=FinishedWineReportService.reportName, id="FinishedWineReport", category=Category.Packaging)
public class FinishedWineReportService implements ReportService {

    protected static final String reportName = "成品酒分析报表";

    private static final Logger logger = LoggerFactory.getLogger(FinishedWineReportService.class);

    @Autowired
    private ArLottabRepository arlottabRepo;
    
    @Autowired
    private BarcodeRepository barcodeRepo;
    
    @Autowired
    private FinishedWineRepository finishedWineRepo;
    
    @Autowired
    private Report_DetailRepository reportDetailRepo;

    private Map<String, String> columnMap;
    private List<String> columnName;
    private List<String> columnId;

    public String getReportId() {
        return this.getClass().getAnnotation(ReportServiceAnnotation.class).id();
    }

    @Override
    public ReportTemplate getReport(CodeInfo code) {
        List<FinishedWineRecord> result = new ArrayList<FinishedWineRecord>();
        List<Barcode> barcodeList = barcodeRepo.findTop1ByPackagingLineAndDateAndTimeLessThanOrderByTimeDesc(code.getLine(), code.getDate(), code.getTime());
        if (!barcodeList.isEmpty()) {
            Barcode barcode = barcodeList.get(0);
            logger.info("barcode: hid={}, workshop={}", barcode.getHid(), barcode.getPackagingLine());
            result = finishedWineRepo.findByHidAndWorkshop(barcode.getHid(), barcode.getPackagingLine());
        } else {
            logger.warn("barcode not found for: line={}, date={}, time={}", code.getLine(), code.getDate(), code.getTime());
        }
        return generateReport(result.stream().map(r -> (ReportRecord)r).collect(Collectors.toList()));
    }

    public ReportTemplate generateReport(List<ReportRecord> records) {
        if (columnName == null) {
            List<Report_Detail> reportDetails = reportDetailRepo.findByPacket(FinishedWine.class.getSimpleName());
            columnMap = new HashMap<String, String>();
            columnId = new ArrayList<String>();
            columnName = new ArrayList<String>();
            for (Report_Detail record: reportDetails) {
                columnMap.put(record.getEnglish(), record.getChinese());
            }
            for (Field field: FinishedWineRecord.class.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    columnId.add(field.getName());
                    columnName.add(columnMap.getOrDefault(field.getName(), field.getName()));
                }
            }
        }

        ReportTemplate report = new ReportTemplate();
        report.setColumnId(columnId);
        report.setColumnName(columnName);
        report.setReportId(getReportId());
        report.setReportName(reportName);
        report.setRecords(records);
        return report;
    }

    @Override
    public ReportTemplate getReport(String barcode) {
        List<Barcode> barcodeList = barcodeRepo.findByBarcode(barcode);
        Set<FinishedWineRecord> recordSet = new HashSet<FinishedWineRecord>();
        for (Barcode rec: barcodeList) {
            if (rec.getPackagingLine() != null) {
                List<FinishedWineRecord> result = finishedWineRepo.findByHidAndWorkshop(rec.getHid(), rec.getPackagingLine());
                recordSet.addAll(result);
            } else if (rec.getSid() != null){
                List<FinishedWineRecord> result = finishedWineRepo.findByHid(rec.getHid());
                recordSet.addAll(result);
            } else {
                List<FinishedWineRecord> result = finishedWineRepo.findBySid(rec.getHid());
                recordSet.addAll(result);
            }
        }
        return generateReport(Arrays.asList(recordSet.toArray(new FinishedWineRecord[recordSet.size()])));
    }

}
