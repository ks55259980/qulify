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
import com.spoonsea.qualitytracing.lims.dao.MaltRepository;
import com.spoonsea.qualitytracing.lims.model.Malt;

@Service
@ReportServiceAnnotation(name = "麦芽报表", id = "MaltReport", category = Category.Original, enabled = true)
public class MaltReportService extends RawReportService<Malt> {

	private static final Logger logger = LoggerFactory.getLogger(MaltReportService.class);

	@Autowired
	private MaltRepository maltRepo;

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
	public List<Malt> getRecordsFromId(Set<String> idSet) {
		return maltRepo.findByIdIn(idSet);
	}

}
