package com.spoonsea.qualitytracing.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.MapReport;
import com.spoonsea.qualitytracing.lims.model.ArLottab;
import com.spoonsea.qualitytracing.service.LimsService;


public abstract class RawReportService<T> extends BaseLimsReportService<T> {

	private static final Logger logger = LoggerFactory.getLogger(RawReportService.class);

	@Autowired
	private LimsService limsService;

	abstract public List<T> getRecordsFromId(Set<String> idSet);

	private MapReport getReport(List<ArLottab> list) {
		List<T> result = new ArrayList<T>();
		logger.info("get arlottab list: {}", list.size());
		if (!list.isEmpty()) {
			result = getRecordsFromId(list.stream().map(v -> {
				logger.info("name: {}, tabId: {}", v.getName(), v.getTabID());
				return v.getTabID();
			}).collect(Collectors.toSet()));
		}
		return generateReport(result);
	}

	@Override
	public MapReport getReport(CodeInfo code) {
		List<ArLottab> list = limsService.getArLottabList(code);
		return getReport(list);
	}

	@Override
	public MapReport getReport(String barcode) {
		List<ArLottab> list = limsService.getArLottabList(barcode);
		return getReport(list);
	}

}
