package com.spoonsea.qualitytracing.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.dto.MapReport;
import com.spoonsea.qualitytracing.lims.dao.Report_DetailRepository;
import com.spoonsea.qualitytracing.lims.model.Report_Detail;
import com.spoonsea.qualitytracing.service.ReportService;

public abstract class BaseLimsReportService<T> implements ReportService<Map<String, String>> {

	private static final Logger logger = LoggerFactory.getLogger(BaseLimsReportService.class);

	@Autowired
	private Report_DetailRepository reportDetailRepo;

	private Map<String, String> columnMap;
	private Map<String, String> fieldMap;
	private List<String> columnName;

	abstract public List<String> getColumnIdList();

	@SuppressWarnings("unchecked")
	protected Class<T> clz() {
		return (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public String getReportId() {
		return this.getClass().getAnnotation(ReportServiceAnnotation.class).id();
	}

	public String getReportName() {
		return this.getClass().getAnnotation(ReportServiceAnnotation.class).name();
	}

	public MapReport generateReport(List<T> records) {
		List<String> columnList = getColumnIdList();
		Class<T> clz = this.clz();
		if (columnName == null) {
			String tableName = clz.getSimpleName();
			if (clz.isAnnotationPresent(Table.class) &&
					!clz.getAnnotation(Table.class).name().isEmpty()) {
				tableName = clz.getAnnotation(Table.class).name();
			}
			List<Report_Detail> reportDetails = reportDetailRepo.findByPacket(tableName);
			columnMap = new HashMap<String, String>();
			columnName = new ArrayList<String>();
			fieldMap = new HashMap<String, String>();
			for (Report_Detail record : reportDetails) {
				columnMap.put(record.getEnglish(), record.getChinese());
			}
			for (Field field : clz.getDeclaredFields()) {
				String name = field.getName();
				if (field.isAnnotationPresent(Column.class) &&
						!field.getAnnotation(Column.class).name().isEmpty()) {
					name = field.getAnnotation(Column.class).name();
				}
				if (columnList.contains(name)) {
					fieldMap.put(name, field.getName());
					columnName.add(columnMap.getOrDefault(name, name));
				}
			}
		}

		MapReport report = new MapReport();
		report.setColumnId(columnList);
		report.setColumnName(columnName);
		report.setReportId(getReportId());
		report.setReportName(getReportName());
		report.setRecords(records.stream().map(v -> {
			Map<String, String> item = new HashMap<String, String>();
			for (String column : columnList) {
				try {
					Field field = clz.getDeclaredField(fieldMap.getOrDefault(column, column));
					field.setAccessible(true);
					item.put(column, String.valueOf(field.get(v)));
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						| IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}).collect(Collectors.toList()));
		return report;
	}

}
