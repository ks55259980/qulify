package com.spoonsea.qualitytracing.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spoonsea.qualitytracing.service.BarcodeQueryService;
import com.spoonsea.qualitytracing.service.TracingService;

@Controller
public class TracingController {

    private static final Logger logger = LoggerFactory.getLogger(TracingController.class);

    @Autowired
    private BarcodeQueryService barcodeQueryService;

    @Autowired
    private TracingService tracingService;

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

}
