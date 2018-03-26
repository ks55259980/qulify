package com.spoonsea.qualitytracing.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.constant.Constants.Category;
import com.spoonsea.qualitytracing.dto.BrothQualityRecord;
import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.ReportTemplate;
import com.spoonsea.qualitytracing.lims.dao.BarcodeRepository;
import com.spoonsea.qualitytracing.lims.dao.BrothRepository;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.lims.model.Broth;
import com.spoonsea.qualitytracing.service.LimsReportBySid;

@Service
@ReportServiceAnnotation(name = BrothQualityReportService.reportName, id = "BrothQualityReport", category = Category.Brewing)
public class BrothQualityReportService extends BaseLimsReportService<BrothQualityRecord> implements LimsReportBySid {

    private static final Logger logger = LoggerFactory.getLogger(BrothQualityReportService.class);

    protected static final String reportName = "发酵液质量参数";

    @Autowired
    private BarcodeRepository barcodeRepo;

    @Autowired
    private BrothRepository brothRepo;

    @Override
    public List<String> getColumnIdList() {
        List<String> columnId = new ArrayList<>();
        for (Field field : clz().getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                columnId.add(field.getName());
            }
        }
        return columnId;
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(CodeInfo code) {
        Barcode barcode = barcodeRepo.findTop1ByPackagingLineAndDateAndTimeLessThanOrderByDateDescTimeDesc(
                code.getLine(), code.getDate(), code.getTime());
        List<BrothQualityRecord> result = new ArrayList<>();
        logger.info("hid for lab check: {}, and sid: {}", barcode.getHid(), barcode.getSid());
        if (barcode != null) {
            result = brothRepo.findBrothQualityRecordByLikeHid(barcode.getSid());
        }
        return generateReport(result, Broth.class);
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(String barcode) {
        Barcode record = barcodeRepo.findOneByBarcode(barcode);
        List<BrothQualityRecord> list;
        if (record == null) {
            list = Collections.emptyList();
        } else {
            list = brothRepo.findBrothQualityRecordByLikeHid(record.getSid());
        }
        return generateReport(list, Broth.class);
    }

    @Override
    public ReportTemplate<?> getReportBySid(String code) {
        logger.info("search broth quality report using sid: {}", code);
        return generateReport(brothRepo.findBrothQualityRecordByLikeHid(code), Broth.class);
    }

}
