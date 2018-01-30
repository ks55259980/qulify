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
import com.spoonsea.qualitytracing.lims.dao.HopRepository;
import com.spoonsea.qualitytracing.lims.model.Hop;

@Service
@ReportServiceAnnotation(name = "其它酒花报表", id = "HopReport", category = Category.Original, enabled = true)
public class HopReportService extends RawReportService<Hop> {

	private static final Logger logger = LoggerFactory.getLogger(HopReportService.class);

	@Autowired
	private HopRepository hopRepo;

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
			"TetrahydroisoAcid",
			"conclusion",
			"Remark",
			"Detecting_human",
			"Reviewer"
		);
	}

	@Override
	public List<Hop> getRecordsFromId(Set<String> idSet) {
		return hopRepo.findByIdIn(idSet);
	}

}
