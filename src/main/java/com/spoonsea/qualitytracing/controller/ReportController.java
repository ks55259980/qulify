package com.spoonsea.qualitytracing.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.service.ReportService;
import com.spoonsea.qualitytracing.util.ResponseUtil;

@RestController
@RequestMapping("/report")
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private ApplicationContext context;

    @RequestMapping("/{reportId}")
    public ResponseEntity<?> searchTable(@PathVariable String reportId,
            @RequestParam(required = false) String barcode,
            @RequestParam(required = false) String batchCode) {
        ReportService service = (ReportService) context.getBean(reportId);
        logger.info("look for service: {}", reportId);
        if (service != null) {
            if (barcode != null) {
                logger.info("use barcode '{}' to search ...", barcode);
                return ResponseUtil.makeResponse(service.getReport(barcode));
            } else {
                logger.info("use batch code '{}' to search ...", batchCode);
                CodeInfo codeInfo = new CodeInfo(batchCode);
                logger.info("date: {}, time: {}, line: {}", codeInfo.getDate(), codeInfo.getTime(), codeInfo.getLine());
                return ResponseUtil.makeResponse(service.getReport(codeInfo));
            }
        }
        return ResponseUtil.makeErrorResponse(-100, "unknown reportId: " + reportId);
    }

    @RequestMapping("/")
    public ResponseEntity<?> getReportList() {
        Map<String, Object> services = context.getBeansWithAnnotation(ReportServiceAnnotation.class);
        Map<String, List<Map<String, String>>> result = new HashMap<String, List<Map<String, String>>>();
        for (Object bean: services.values()) {
            ReportService service = (ReportService) bean;
            ReportServiceAnnotation anno = service.getClass().getAnnotation(ReportServiceAnnotation.class);
            if (!result.containsKey(anno.category())) {
                result.put(anno.category(), new ArrayList<Map<String, String>>());
            }
            Map<String, String> item = new HashMap<String, String>();
            item.put(anno.id(), anno.name());
            result.get(anno.category()).add(item);
        }
        return ResponseUtil.makeResponse(result);
    }
}
