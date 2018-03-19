package com.spoonsea.qualitytracing.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.constant.Constants.Category;
import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.MapReport;
import com.spoonsea.qualitytracing.entity.BarcodeQueryResult;
import com.spoonsea.qualitytracing.entity.BarcodeQueryResultDetail;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.service.BarcodeQueryService;
import com.spoonsea.qualitytracing.service.LimsService;
import com.spoonsea.qualitytracing.service.ReportService;
import com.spoonsea.qualitytracing.util.MiscUtil;
import com.spoonsea.qualitytracing.util.WorkshopUtil;

@Service
@ReportServiceAnnotation(name = "物流库存报表", id = "LogisticsReport", category = Category.Logistics)
public class LogisticsReportService implements ReportService<Map<String, String>> {

    private static final Logger logger = LoggerFactory.getLogger(LogisticsReportService.class);

    @Autowired
    private LimsService limsService;

    @Autowired
    private BarcodeQueryService barcodeQueryService;

    private List<String> columnId = Arrays.asList("type", "time", "number", "code", "name", "area", "barcode",
            "startTime", "endTime");
    private List<String> columnName = Arrays.asList("类型", "入库/发货时间", "批次号/交货单号", "物料代码/经销商代码", "物料名称/经销商名称", "库位/发运路线",
            "托盘条码", "第一箱喷码时间", "最后一箱喷码时间");

    public String getReportId() {
        return this.getClass().getAnnotation(ReportServiceAnnotation.class).id();
    }

    public String getReportName() {
        return this.getClass().getAnnotation(ReportServiceAnnotation.class).name();
    }

    @Override
    public MapReport getReport(CodeInfo code) {
        DateTime dt = MiscUtil.getDateTime(code.getDate(), code.getTime());
        Date startTime = dt.toDate();
        Date endTime = dt.plus(120 * 60000).toDate();
        BarcodeQueryResult result = new BarcodeQueryResult(0, "", Arrays.asList(), null);
        try {
            result = barcodeQueryService.queryByTimeInterval(WorkshopUtil.getBarcodeWorkshopCode(code.getWorkshop()),
                    WorkshopUtil.getBarcodeLineCode(code.getLine()), startTime, endTime);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return generateReport(result);
    }

    @Override
    public MapReport getReport(String barcode) {
        Barcode rec = limsService.getPackaging(barcode);
        DateTime dt = MiscUtil.getDateTime(rec.getDate(), rec.getTime());
        Date startTime = dt.toDate();
        Date endTime = dt.plus(600 * 60000).toDate();
        BarcodeQueryResult result = new BarcodeQueryResult(0, "", Arrays.asList(), null);
        try {
            result = barcodeQueryService.queryByTimeInterval(WorkshopUtil.getBarcodeWorkshopCode("22"),
                    WorkshopUtil.getBarcodeLineCode(rec.getPackagingLine()), startTime, endTime);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return generateReport(result);
    }

    public MapReport generateReport(BarcodeQueryResult result) {
        if (result.getCode() != 0) {
            logger.warn("error: {}-{}", result.getCode(), result.getMsg());
        }

        List<Map<String, String>> ret = new ArrayList<Map<String, String>>();
        if (result.getDetailList() != null) {
            for (BarcodeQueryResultDetail detail : result.getDetailList()) {
                Map<String, String> record = new HashMap<String, String>();
                String type = detail.getType();
                if ("01".compareTo(type) == 0) {
                    record.put("type", "库存");
                } else if ("02".compareTo(type) == 0) {
                    record.put("type", "发运");
                } else {
                    record.put("type", "未知(" + type + ")");
                }
                record.put("time", detail.getTargetTimeString());
                record.put("number", String.valueOf(detail.getNumberNo()));
                record.put("code", String.valueOf(detail.getCode()));
                record.put("name", String.valueOf(detail.getName()));
                record.put("area", String.valueOf(detail.getArea()));
                record.put("barcode", detail.getBarcode());
                record.put("startTime", detail.getStartTimeString());
                record.put("endTime", detail.getEndTimeString());
                ret.add(record);
            }
        }

        MapReport report = new MapReport();
        report.setColumnId(columnId);
        report.setColumnName(columnName);
        report.setReportId(this.getReportId());
        report.setReportName(this.getReportName());
        report.setRecords(ret);
        return report;
    }

}
