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
import com.spoonsea.qualitytracing.dto.DiatomiteRecord;
import com.spoonsea.qualitytracing.dto.ReportTemplate;
import com.spoonsea.qualitytracing.lims.dao.ArLottabRepository;
import com.spoonsea.qualitytracing.lims.dao.AuxiliaryMaterialRepository;
import com.spoonsea.qualitytracing.lims.dao.BarcodeRepository;
import com.spoonsea.qualitytracing.lims.dao.Report_DetailRepository;
import com.spoonsea.qualitytracing.lims.model.ArLottab;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.lims.model.CapacityTba;
import com.spoonsea.qualitytracing.lims.model.Report_Detail;
import com.spoonsea.qualitytracing.service.LimsService;
import com.spoonsea.qualitytracing.service.ReportService;


@Service
@ReportServiceAnnotation(
		name=DiatomiteReportService.reportName, id="DiatomiteReport", category=Category.Original)
public class DiatomiteReportService implements ReportService<DiatomiteRecord> {

    protected static final String reportName = "硅藻土报表";

    private static final Logger logger = LoggerFactory.getLogger(DiatomiteReportService.class);

    @Autowired
    private ArLottabRepository arlottabRepo;
    
    @Autowired
    private BarcodeRepository barcodeRepo;
    
    @Autowired
    private AuxiliaryMaterialRepository auxiliaryMaterialRepo;
    
    @Autowired
    private LimsService limsService;

    @Autowired
    private Report_DetailRepository reportDetailRepo;

    private Map<String, String> columnMap;
    private List<String> columnName;
    private List<String> columnId;

    public String getReportId() {
        return this.getClass().getAnnotation(ReportServiceAnnotation.class).id();
    }

    @Override
    public ReportTemplate<DiatomiteRecord> getReport(CodeInfo code) {
        List<DiatomiteRecord> result = new ArrayList<DiatomiteRecord>();
        List<ArLottab> list = limsService.getArLottabList(code);
        if (!list.isEmpty()) {
            result = auxiliaryMaterialRepo.findDiatomiteById(list.stream().map(v -> v.getId()).collect(Collectors.toSet()));
        } else {
            logger.warn("nothing found");
        }
        return generateReport(result);
    }

    public ReportTemplate<DiatomiteRecord> generateReport(List<DiatomiteRecord> records) {
        if (columnName == null) {
            List<Report_Detail> reportDetails = reportDetailRepo.findByPacket(CapacityTba.class.getSimpleName());
            columnMap = new HashMap<String, String>();
            columnId = new ArrayList<String>();
            columnName = new ArrayList<String>();
            for (Report_Detail record: reportDetails) {
                columnMap.put(record.getEnglish(), record.getChinese());
            }
            for (Field field: DiatomiteRecord.class.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    columnId.add(field.getName());
                    columnName.add(columnMap.getOrDefault(field.getName(), field.getName()));
                }
            }
        }

        ReportTemplate<DiatomiteRecord> report = new ReportTemplate<DiatomiteRecord>();
        report.setColumnId(columnId);
        report.setColumnName(columnName);
        report.setReportId(getReportId());
        report.setReportName(reportName);
        report.setRecords(records);
        return report;
    }

    @Override
    public ReportTemplate<DiatomiteRecord> getReport(String barcode) {
    	List<DiatomiteRecord> result = new ArrayList<DiatomiteRecord>();
        List<ArLottab> list = limsService.getArLottabList(barcode);
        if (!list.isEmpty()) {
            result = auxiliaryMaterialRepo.findDiatomiteById(list.stream().map(v -> v.getId()).collect(Collectors.toSet()));
        } else {
            logger.warn("nothing found");
        }
        return generateReport(result);
    }

}
