package com.spoonsea.qualitytracing.service;

import com.spoonsea.qualitytracing.dto.ReportTemplate;

public interface LimsReportBySid {

    ReportTemplate<?> getReportBySid(String code);

}
