package com.spoonsea.qualitytracing.dto;

import java.io.Serializable;
import java.util.List;

public class ReportTemplate implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String reportName;
    private String reportId;
    private List<String> columnId;
    private List<String> columnName;
    private List<ReportRecord> records;

    public static ReportTemplate GenerateReport(String reportId) {
        return null;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public List<String> getColumnId() {
        return columnId;
    }

    public void setColumnId(List<String> columnId) {
        this.columnId = columnId;
    }

    public List<String> getColumnName() {
        return columnName;
    }

    public void setColumnName(List<String> columnName) {
        this.columnName = columnName;
    }

    public List<ReportRecord> getRecords() {
        return records;
    }

    public void setRecords(List<ReportRecord> records) {
        this.records = records;
    }

}
