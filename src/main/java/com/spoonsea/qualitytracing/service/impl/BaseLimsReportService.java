package com.spoonsea.qualitytracing.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
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
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public String getReportId() {
        return this.getClass().getAnnotation(ReportServiceAnnotation.class).id();
    }

    public String getReportName() {
        return this.getClass().getAnnotation(ReportServiceAnnotation.class).name();
    }

    @SuppressWarnings("unchecked")
    public <M> MapReport generateReport(List<T> records, Class<M> modelClz) {
        List<String> columnList = getColumnIdList();
        Class<T> dtoClz = this.clz();
        Class<M> modelClz_ = modelClz == null ? (Class<M>) this.clz() : modelClz;
        if (columnName == null) {
            String tableName = modelClz_.getSimpleName();
            if (modelClz_.isAnnotationPresent(Table.class) && !modelClz_.getAnnotation(Table.class).name().isEmpty()) {
                tableName = modelClz_.getAnnotation(Table.class).name();
            }
            List<Report_Detail> reportDetails = reportDetailRepo.findByPacket(tableName);
            columnMap = new HashMap<String, String>();
            fieldMap = new HashMap<String, String>();
            for (Report_Detail record : reportDetails) {
                columnMap.put(record.getEnglish(), record.getChinese());
            }
            columnName = columnList.stream().map(c -> columnMap.getOrDefault(c, c)).collect(Collectors.toList());
            for (Field field : dtoClz.getDeclaredFields()) {
                String name = field.getName();
                if (field.isAnnotationPresent(Column.class) && !field.getAnnotation(Column.class).name().isEmpty()) {
                    name = field.getAnnotation(Column.class).name();
                }
                if (columnList.contains(name)) {
                    fieldMap.put(name, field.getName());
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
                    Field field = dtoClz.getDeclaredField(fieldMap.getOrDefault(column, column));
                    field.setAccessible(true);
                    item.put(column, field.get(v) == null ? null : field.get(v).toString());
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

    public MapReport generateReport(List<T> records) {
        return generateReport(records, null);
    }
}
