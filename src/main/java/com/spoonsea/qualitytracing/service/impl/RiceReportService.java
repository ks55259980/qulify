package com.spoonsea.qualitytracing.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.constant.Constants.Category;
import com.spoonsea.qualitytracing.lims.dao.RiceRepository;
import com.spoonsea.qualitytracing.lims.model.Rice;

@Service
@ReportServiceAnnotation(name = "大米报表", id = "RiceReport", category = Category.Original, enabled = true)
public class RiceReportService extends RawReportService<Rice> {

	private static final Logger logger = LoggerFactory.getLogger(RiceReportService.class);

	@Autowired
	private RiceRepository riceRepo;

	@Override
	public List<String> getColumnIdList() {
		return Arrays.asList(
			"date",
			"Factory",
			"Location",
			"Variety",
			"Carnumber",
			"batch",
			"ProductionDate",
			"ArrivalDate",
			"odor",
			"Exterior",
			"Color",
			"Freshness",
			"Tasting",
			"conclusion",
			"Remark",
			"Detecting_human",
			"Reviewer"
		);
	}

	@Override
	public List<Rice> getRecordsFromId(Set<String> idSet) {
		return riceRepo.findByIdIn(idSet);
	}

}
