package com.spoonsea.qualitytracing.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.constant.Constants.Category;
import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.ReportTemplate;
import com.spoonsea.qualitytracing.dto.SakeLabCheckRecord;
import com.spoonsea.qualitytracing.lims.dao.BarcodeRepository;
import com.spoonsea.qualitytracing.lims.dao.SakeRepository;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.lims.model.Sake;
import com.spoonsea.qualitytracing.service.ReportByHid;

@Service
@ReportServiceAnnotation(name = SakeLabCheckReportService.reportName, id = "SakeLabCheckReport", category = Category.Brewing)
public class SakeLabCheckReportService extends BaseLimsReportService<SakeLabCheckRecord> implements ReportByHid {

    private static final Logger logger = LoggerFactory.getLogger(SakeLabCheckReportService.class);

    protected static final String reportName = "清酒实验室检测参数";

    @Autowired
    private BarcodeRepository barcodeRepo;

    @Autowired
    private SakeRepository sakeRepo;

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
        List<SakeLabCheckRecord> result = new ArrayList<>();
        logger.info("hid for lab check: {}, and sid: {}", barcode.getHid(), barcode.getSid());
        if (barcode != null) {
            result = sakeRepo.findSakeLabCheckRecordByHid(barcode.getHid());
        }
        return generateReport(result, Sake.class);
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(String barcode) {
        Barcode record = barcodeRepo.findOneByBarcode(barcode);
        List<SakeLabCheckRecord> list;
        if (record == null) {
            list = Collections.emptyList();
        } else if (StringUtils.isNotBlank(record.getSid())) {
            list = sakeRepo.findSakeLabCheckRecordByHid(record.getHid());
        } else {
            list = sakeRepo.findSakeLabCheckRecordBySidLike(record.getHid());
        }
        return generateReport(list, Sake.class);
    }

    @Override
    public ReportTemplate<?> getReportByHid(String hid) {
        logger.info("hid for lab check: {}", hid);
        return generateReport(sakeRepo.findSakeLabCheckRecordByHid(hid), Sake.class);
    }

}
