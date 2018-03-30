package com.spoonsea.qualitytracing.service;

import com.spoonsea.qualitytracing.dto.ReportTemplate;

public interface ReportByHid {

    ReportTemplate<?> getReportByHid(String code);

}
