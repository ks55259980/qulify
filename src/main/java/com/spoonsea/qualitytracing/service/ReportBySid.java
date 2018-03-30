package com.spoonsea.qualitytracing.service;

import com.spoonsea.qualitytracing.dto.ReportTemplate;

public interface ReportBySid {

    ReportTemplate<?> getReportBySid(String code);

}
