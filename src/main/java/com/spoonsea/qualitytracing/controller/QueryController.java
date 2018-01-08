package com.spoonsea.qualitytracing.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spoonsea.qualitytracing.entity.BarcodeQueryResultDetail;
import com.spoonsea.qualitytracing.service.BarcodeQueryService;

@Controller
public class QueryController {
	
	private final Logger logger = LoggerFactory.getLogger(QueryController.class);

	@Autowired
	private BarcodeQueryService barcodeQueryService;

	@RequestMapping("/queryByBoxCode")
	@ResponseBody
	public List<BarcodeQueryResultDetail> queryByBoxCode(@RequestParam String boxCode) {
		try {
			List<BarcodeQueryResultDetail> result = barcodeQueryService.queryByBoxCode(boxCode);
			return result;
		} catch (Exception ex) {
			logger.warn("query by box code failed: {}", ex.getMessage());
			return null;
		}
	}

	@RequestMapping("/queryByInterval")
	@ResponseBody
	public List<BarcodeQueryResultDetail> queryByInterval(@RequestParam String factoryCode,
			@RequestParam String lineCode, @RequestParam Long startTime, @RequestParam Long endTime) {
		try {
			Date startDate = new Date(startTime);
			Date endDate = new Date(endTime);
			List<BarcodeQueryResultDetail> result =
					barcodeQueryService.queryByTimeInterval(factoryCode, lineCode, startDate, endDate);
			return result;
		} catch (Exception ex) {
			logger.warn("query by interval failed: {}", ex.getMessage());
			return null;
		}
	}
	
	@RequestMapping("/query")
	public ModelAndView queryPage() {
		return new ModelAndView("/templates/index");
	}
}
