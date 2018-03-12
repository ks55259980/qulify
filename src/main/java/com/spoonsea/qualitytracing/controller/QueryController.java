package com.spoonsea.qualitytracing.controller;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spoonsea.qualitytracing.entity.BarcodeQueryResult;
import com.spoonsea.qualitytracing.service.BarcodeQueryService;


@Controller
public class QueryController {

    private final Logger logger = LoggerFactory.getLogger(QueryController.class);

    @Autowired
    private BarcodeQueryService barcodeQueryService;

    @RequestMapping("/queryByBoxCode")
    @ResponseBody
    public BarcodeQueryResult queryByBoxCode(@RequestParam String boxCode) {
        try {
            return barcodeQueryService.queryByBoxCode(boxCode);
        } catch (Exception ex) {
            logger.warn("query by box code failed: {}", ex.getMessage());
            ex.printStackTrace();
            return new BarcodeQueryResult(-1, ex.getMessage(), null, null);
        }
    }

    @RequestMapping("/queryByInterval")
    @ResponseBody
    public BarcodeQueryResult queryByInterval(@RequestParam String factoryCode, @RequestParam String lineCode,
            @RequestParam Long startTime, @RequestParam Long endTime) {
        try {
            Date startDate = new Date(startTime);
            Date endDate = new Date(endTime);
            return barcodeQueryService.queryByTimeInterval(factoryCode, lineCode, startDate, endDate);
        } catch (Exception ex) {
            logger.warn("query by interval failed: {}", ex.getMessage());
            ex.printStackTrace();
            return new BarcodeQueryResult(-1, ex.getMessage(), null, null);
        }
    }

    @RequestMapping("/queryByBarcode")
    @ResponseBody
    public BarcodeQueryResult queryByBarcodeCode(@RequestParam String barcode) {
        try {
            return barcodeQueryService.queryByBarcode(barcode);
        } catch (Exception ex) {
            logger.warn("query by barcode failed: {}", ex.getMessage());
            ex.printStackTrace();
            return new BarcodeQueryResult(-1, ex.getMessage(), null, null);
        }
    }

    @RequestMapping("/query")
    public String queryPage() {
        return "index";
    }
}
