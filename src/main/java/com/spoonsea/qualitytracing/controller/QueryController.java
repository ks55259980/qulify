package com.spoonsea.qualitytracing.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spoonsea.qualitytracing.entity.BarcodeQueryResultDetail;
import com.spoonsea.qualitytracing.service.BarcodeQueryService;

@RestController
@RequestMapping("/query")
public class QueryController {
	
	private final Logger logger = LoggerFactory.getLogger(QueryController.class);

	@Autowired
	private BarcodeQueryService barcodeQueryService;

	@RequestMapping("/boxCode/{boxCode}")
	@ResponseBody
	public List<BarcodeQueryResultDetail> boxCodeQuery(@PathVariable String boxCode) {
		try {
			List<BarcodeQueryResultDetail> result = barcodeQueryService.queryByBoxCode(boxCode);
			return result;
		} catch (Exception ex) {
			logger.warn("query by box code failed: {}", ex.getMessage());
			return null;
		}
	}

}
