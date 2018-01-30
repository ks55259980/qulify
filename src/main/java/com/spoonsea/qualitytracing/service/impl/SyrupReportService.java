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
import com.spoonsea.qualitytracing.lims.dao.SyrupRepository;
import com.spoonsea.qualitytracing.lims.model.Syrup;

@Service
@ReportServiceAnnotation(name = "糖浆报表", id = "SyrupReport", category = Category.Original, enabled = true)
public class SyrupReportService extends RawReportService<Syrup> {

	private static final Logger logger = LoggerFactory.getLogger(SyrupReportService.class);

	@Autowired
	private SyrupRepository syrupRepo;

	@Override
	public List<String> getColumnIdList() {
		return Arrays.asList(
			"date",
			"Origin",
			"Material",
			"specification",
			"batch",
			"location",
			"Dateofinspection",
			"Dateofpurchase",
			"BakedTime",
			"Log",
			"fragrance",
			"Color",
			"Moisture",
			"Chroma",
			"boiled",
			"Water",
			"NoWater",
			"FIN",
			"Saccharification",
			"difference",
			"SolubleNitrogen",
			"protein",
			"KurbachValue",
			"Viscosity",
			"BetaGlucan",
			"Tasting",
			"conclusion",
			"Remark",
			"Detecting_human",
			"Reviewer"
		);
	}

	@Override
	public List<Syrup> getRecordsFromId(Set<String> idSet) {
		return syrupRepo.findByIdIn(idSet);
	}

}
