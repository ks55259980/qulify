package com.spoonsea.qualitytracing.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoonsea.qualitytracing.braumat.entity.Brau33;
import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.constant.Constants.Category;
import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.ReportTemplate;
import com.spoonsea.qualitytracing.lims.dao.BarcodeRepository;
import com.spoonsea.qualitytracing.lims.model.Barcode;


@Service
@ReportServiceAnnotation(name=BraumatBHReportService.reportName,
id="BraumatBHReport",
category=Category.Brewing,
enabled=false)
public class BraumatBHReportService extends BaseBraumatReportService {

    protected static final String reportName = "酿造糖化报表";

    private static final Logger logger = LoggerFactory.getLogger(BraumatBHReportService.class);

    @Autowired
    private BarcodeRepository barcodeRepo;

    @Override
    public ReportTemplate<Map<String, String>> getReport(CodeInfo code) {
        Set<Brau33> result = new HashSet<Brau33>();
        return generateReport(result.stream().collect(Collectors.toList()));
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(String barcode) {
        List<Barcode> barcodeList = barcodeRepo.findByBarcode(barcode);
        logger.info("found barcode: {}", barcodeList.size());
        Set<Brau33> recordSet = new HashSet<Brau33>();
        return generateReport(recordSet.stream().collect(Collectors.toList()));
    }

}
