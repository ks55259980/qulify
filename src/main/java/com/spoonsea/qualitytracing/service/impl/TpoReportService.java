package com.spoonsea.qualitytracing.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.constant.Constants.Category;
import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.TpoRecord;
import com.spoonsea.qualitytracing.dto.ReportTemplate;
import com.spoonsea.qualitytracing.lims.dao.ArLottabRepository;
import com.spoonsea.qualitytracing.lims.dao.BarcodeRepository;
import com.spoonsea.qualitytracing.lims.dao.TpoRepository;
import com.spoonsea.qualitytracing.lims.dao.Report_DetailRepository;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.lims.model.Tpo;
import com.spoonsea.qualitytracing.lims.model.Report_Detail;
import com.spoonsea.qualitytracing.service.ReportService;

@Service
@ReportServiceAnnotation(name = TpoReportService.reportName, id = "TPOReport", category = Category.Packaging)
public class TpoReportService implements ReportService<TpoRecord> {

	protected static final String reportName = "总氧分析报表";

	private static final Logger logger = LoggerFactory.getLogger(TpoReportService.class);

	@Autowired
	private ArLottabRepository arlottabRepo;

	@Autowired
	private BarcodeRepository barcodeRepo;

	@Autowired
	private TpoRepository tpoRepo;

	@Autowired
	private Report_DetailRepository reportDetailRepo;

	private Map<String, String> columnMap;
	private List<String> columnName;
	private List<String> columnId;

	public String getReportId() {
		return this.getClass().getAnnotation(ReportServiceAnnotation.class).id();
	}

	@Override
	public ReportTemplate<TpoRecord> getReport(CodeInfo code) {
		List<TpoRecord> result = new ArrayList<TpoRecord>();
		Barcode barcode = barcodeRepo.findTop1ByPackagingLineAndDateAndTimeLessThanOrderByDateDescTimeDesc(code.getLine(),
				code.getDate(), code.getTime());
		if (barcode != null) {
			logger.info("barcode: hid={}, workshop={}", barcode.getHid(), barcode.getPackagingLine());
			result = tpoRepo.findByHidAndWorkshop(barcode.getHid(), barcode.getPackagingLine());
		} else {
			logger.warn("barcode not found for: line={}, date={}, time={}", code.getLine(), code.getDate(),
					code.getTime());
		}
		return generateReport(result);
	}

	public ReportTemplate<TpoRecord> generateReport(List<TpoRecord> records) {
		if (columnName == null) {
			List<Report_Detail> reportDetails = reportDetailRepo.findByPacket(Tpo.class.getSimpleName());
			columnMap = new HashMap<String, String>();
			columnId = new ArrayList<String>();
			columnName = new ArrayList<String>();
			for (Report_Detail record : reportDetails) {
				columnMap.put(record.getEnglish(), record.getChinese());
			}
			for (Field field : TpoRecord.class.getDeclaredFields()) {
				if (!Modifier.isStatic(field.getModifiers())) {
					columnId.add(field.getName());
					columnName.add(columnMap.getOrDefault(field.getName(), field.getName()));
				}
			}
		}

		ReportTemplate<TpoRecord> report = new ReportTemplate<TpoRecord>();
		report.setColumnId(columnId);
		report.setColumnName(columnName);
		report.setReportId(getReportId());
		report.setReportName(reportName);
		report.setRecords(records);
		return report;
	}

	@Override
	public ReportTemplate<TpoRecord> getReport(String barcode) {
		Barcode record = barcodeRepo.findOneByBarcode(barcode);
		Set<TpoRecord> recordSet = new HashSet<TpoRecord>();
		if (record.getPackagingLine() != null) {
			List<TpoRecord> result = tpoRepo.findByHidAndWorkshop(record.getHid(), record.getPackagingLine());
			recordSet.addAll(result);
		} else if (record.getSid() != null) {
			List<TpoRecord> result = tpoRepo.findByHid(record.getHid());
			recordSet.addAll(result);
		} else {
			List<TpoRecord> result = tpoRepo.findBySid(record.getHid());
			recordSet.addAll(result);
		}
		return generateReport(recordSet.stream().collect(Collectors.toList()));
	}

}
