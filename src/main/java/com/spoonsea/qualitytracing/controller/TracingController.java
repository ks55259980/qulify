package com.spoonsea.qualitytracing.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spoonsea.qualitytracing.constant.Constants.ProductionProcessEnum;
import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.ReportTemplate;
import com.spoonsea.qualitytracing.service.ReportByHid;
import com.spoonsea.qualitytracing.service.ReportByHidAndCapCode;
import com.spoonsea.qualitytracing.service.ReportBySid;
import com.spoonsea.qualitytracing.service.ReportService;
import com.spoonsea.qualitytracing.service.TracingService;
import com.spoonsea.qualitytracing.util.ResponseUtil;

@Controller
public class TracingController {

    private static final Logger logger = LoggerFactory.getLogger(TracingController.class);

    @Autowired
    private TracingService tracingService;

    @Autowired
    @Qualifier("ReportServices")
    private Map<String, ReportService<?>> reportServices;

    @RequestMapping("/tracing")
    public String tracePage() {
        return "trace";
    }

    @RequestMapping("/tracingByBoxCode")
    @ResponseBody
    public String tracingByBoxCode(@RequestParam("boxCode") String boxCode) throws IOException {
        return tracingService.tracingByBoxCode(boxCode);
    }

    @RequestMapping("/tracingByCapCode")
    @ResponseBody
    public String tracingByCapCode(@RequestParam("capCode") String capCode) throws IOException {
        return tracingService.tracingByCapCode(capCode);
    }

    @RequestMapping("/tracing/report")
    @ResponseBody
    public ResponseEntity<?> searchReport(@RequestParam Integer type, @RequestParam String code,
            @RequestParam String originalCode) {
        List<String> reportIdList = ProductionProcessEnum.getReportsByType(type);
        List<ReportTemplate<?>> reports = reportIdList.parallelStream()
                .map(id -> getReport(type, code, originalCode, id)).filter(report -> report != null)
                .collect(Collectors.toList());
        return ResponseUtil.makeResponse(reports);
    }

    /**
     * @param type 追溯树图中节点的类型，分为包装、清酒、发酵和糖化
     * @param code 对应上述类型的追溯码，分为capCode、hid、sid
     * @param originalCode capCode
     * @param reportId 报表id
     * @return 报表集合，由Constants定义{@link com.spoonsea.qualitytracing.constant.Constants.ProductionProcessEnum}
     */
    private ReportTemplate<?> getReport(Integer type, String code, String originalCode, String reportId) {
        ReportService<?> service = reportServices.get(reportId);
        if (service != null) {
            if (ProductionProcessEnum.queryUsingCapCode(type, code)) {
                logger.info("use batch code '{}' to search ...", code);
                CodeInfo codeInfo = new CodeInfo(code);
                logger.info("date: {}, time: {}, line: {}", codeInfo.getDate(), codeInfo.getTime(), codeInfo.getLine());
                return service.getReport(codeInfo);
            } else if (ProductionProcessEnum.queryUsingBarcode(type, code)) {
                logger.info("use barcode '{}' to search ...", code);
                return service.getReport(code);
            } else if (ProductionProcessEnum.queryUsingHid(type)) {
                logger.info("use hid '{}' to search ...", code);
                if (service instanceof ReportByHidAndCapCode) {
                    return ((ReportByHidAndCapCode) service).getReportByHidAndCapCode(code, originalCode);
                } else if (service instanceof ReportByHid) {
                    return ((ReportByHid) service).getReportByHid(code);
                }
            } else if (ProductionProcessEnum.queryUsingSid(type)) {
                logger.info("use sid '{}' to search ...", code);
                if (service instanceof ReportBySid) {
                    return ((ReportBySid) service).getReportBySid(code);
                }
            }
        }
        return null;
    }

}
