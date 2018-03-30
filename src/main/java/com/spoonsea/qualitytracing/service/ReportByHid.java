package com.spoonsea.qualitytracing.service;

import com.spoonsea.qualitytracing.dto.ReportTemplate;

public interface LimsReportByHid {

    ReportTemplate<?> getReportByHid(String code);

}
