package com.spoonsea.qualitytracing.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.service.ReportService;
import com.spoonsea.qualitytracing.util.ResponseUtil;

@RestController
@RequestMapping("/report")
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    @Qualifier("Reports")
    private Map<String, List<Map<String, Object>>> reports;

    @Autowired
    @Qualifier("ReportServices")
    private Map<String, ReportService> reportServices;

    @RequestMapping("/{reportId}")
    public ResponseEntity<?> searchReport(@PathVariable String reportId,
            @RequestParam(required = false) String barcode,
            @RequestParam(required = false) String batchCode) {
        ReportService service = reportServices.get(reportId);
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

    @RequestMapping({"", "/"})
    public ResponseEntity<?> getReportList() {
        return ResponseUtil.makeResponse(reports);
    }
}
