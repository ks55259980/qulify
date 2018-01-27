package com.spoonsea.qualitytracing.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
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
import com.spoonsea.qualitytracing.dto.PickWineRecord;
import com.spoonsea.qualitytracing.dto.ReportTemplate;
import com.spoonsea.qualitytracing.lims.dao.ArLottabRepository;
import com.spoonsea.qualitytracing.lims.dao.BarcodeRepository;
import com.spoonsea.qualitytracing.lims.dao.PickWineRepository;
import com.spoonsea.qualitytracing.lims.dao.Report_DetailRepository;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.lims.model.PickWine;
import com.spoonsea.qualitytracing.lims.model.Report_Detail;
import com.spoonsea.qualitytracing.service.ReportService;


@Service("PickWineReport")
@ReportServiceAnnotation(name=PickWineReportService.reportName, id="PickWineReport", category=Category.Packaging)
public class PickWineReportService implements ReportService<PickWineRecord> {

    protected static final String reportName = "包装接酒分析报表";

    private static final Logger logger = LoggerFactory.getLogger(PickWineReportService.class);

    @Autowired
    private ArLottabRepository arlottabRepo;
    
    @Autowired
    private BarcodeRepository barcodeRepo;
    
    @Autowired
    private PickWineRepository pickWineRepo;
    
    @Autowired
    private Report_DetailRepository reportDetailRepo;

    private Map<String, String> columnMap;
    private List<String> columnName;
    private List<String> columnId;

    public String getReportId() {
        return this.getClass().getAnnotation(ReportServiceAnnotation.class).id();
    }

    @Override
    public ReportTemplate<PickWineRecord> getReport(CodeInfo code) {
        List<PickWineRecord> result = new ArrayList<PickWineRecord>();
        List<Barcode> barcodeList = barcodeRepo.findTop1ByPackagingLineAndDateAndTimeLessThanOrderByTimeDesc(code.getLine(), code.getDate(), code.getTime());
        if (!barcodeList.isEmpty()) {
            Barcode barcode = barcodeList.get(0);
            logger.info("barcode: hid={}, workshop={}", barcode.getHid(), barcode.getPackagingLine());
            result = pickWineRepo.findByHidAndWorkshop(barcode.getHid(), barcode.getPackagingLine());
        } else {
            logger.warn("barcode not found for: line={}, date={}, time={}", code.getLine(), code.getDate(), code.getTime());
        }
        return generateReport(result);
    }

    public ReportTemplate<PickWineRecord> generateReport(List<PickWineRecord> records) {
        if (columnName == null) {
            List<Report_Detail> reportDetails = reportDetailRepo.findByPacket(PickWine.class.getSimpleName());
            columnMap = new HashMap<String, String>();
            columnId = new ArrayList<String>();
            columnName = new ArrayList<String>();
            for (Report_Detail record: reportDetails) {
                columnMap.put(record.getEnglish(), record.getChinese());
            }
            for (Field field: PickWineRecord.class.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    columnId.add(field.getName());
                    columnName.add(columnMap.getOrDefault(field.getName(), field.getName()));
                }
            }
        }

        ReportTemplate<PickWineRecord> report = new ReportTemplate<PickWineRecord>();
        report.setColumnId(columnId);
        report.setColumnName(columnName);
        report.setReportId(getReportId());
        report.setReportName(reportName);
        report.setRecords(records);
        return report;
    }

    @Override
    public ReportTemplate<PickWineRecord> getReport(String barcode) {
        List<Barcode> barcodeList = barcodeRepo.findByBarcode(barcode);
        Set<PickWineRecord> recordSet = new HashSet<PickWineRecord>();
        for (Barcode rec: barcodeList) {
            if (rec.getPackagingLine() != null) {
                List<PickWineRecord> result = pickWineRepo.findByHidAndWorkshop(rec.getHid(), rec.getPackagingLine());
                recordSet.addAll(result);
            } else if (rec.getSid() != null){
                List<PickWineRecord> result = pickWineRepo.findByHid(rec.getHid());
                recordSet.addAll(result);
            } else {
                List<PickWineRecord> result = pickWineRepo.findBySid(rec.getHid());
                recordSet.addAll(result);
            }
        }
        return generateReport(recordSet.stream().collect(Collectors.toList()));
    }

}
