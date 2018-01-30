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
import com.spoonsea.qualitytracing.lims.dao.AuxiliaryMaterialRepository;
import com.spoonsea.qualitytracing.lims.model.AuxiliaryMaterial;

@Service
@ReportServiceAnnotation(name = "辅料报表", id = "AuxiliaryMaterialReport", category = Category.Original, enabled = true)
public class AuxiliaryMaterialReportService extends RawReportService<AuxiliaryMaterial> {

	private static final Logger logger = LoggerFactory.getLogger(AuxiliaryMaterialReportService.class);

	@Autowired
	private AuxiliaryMaterialRepository auxiliaryMaterialRepo;

	@Override
	public List<String> getColumnIdList() {
		return Arrays.asList(
			"ID",
			"date",
			"sample",
			"Factory",
			"batch",
			"Lot",
			"ProductionDate",
			"ArrivalDate",
			"SubmissionDate",
			"Tasting",
			"conclusion",
			"Remark",
			"Detecting_human",
			"Reviewer"
		);
	}

	@Override
	public List<AuxiliaryMaterial> getRecordsFromId(Set<String> idSet) {
		return auxiliaryMaterialRepo.findByIdIn(idSet);
	}

}
