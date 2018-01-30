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
import com.spoonsea.qualitytracing.lims.dao.GranuleHopRepository;
import com.spoonsea.qualitytracing.lims.model.GranuleHop;

@Service
@ReportServiceAnnotation(name = "颗粒酒花报表", id = "GranuleHopReport", category = Category.Original, enabled = true)
public class GranuleHopReportService extends RawReportService<GranuleHop> {

	private static final Logger logger = LoggerFactory.getLogger(GranuleHopReportService.class);

	@Autowired
	private GranuleHopRepository granuleHopRepo;

	@Override
	public List<String> getColumnIdList() {
		return Arrays.asList(
			"date",
			"Factory",
			"Origin",
			"model",
			"specification",
			"location",
			"Enterthequantity",
			"supplier",
			"batch",
			"ProductionDate",
			"SubmissionDate",
			"Fragrance",
			"Color",
			"Moisture",
			"а_Acid",
			"β_Acid",
			"Storage",
			"JumpingTime",
			"conclusion",
			"Remark",
			"Detecting_human",
			"Reviewer"
		);
	}

	@Override
	public List<GranuleHop> getRecordsFromId(Set<String> idSet) {
		return granuleHopRepo.findByIdIn(idSet);
	}

}
