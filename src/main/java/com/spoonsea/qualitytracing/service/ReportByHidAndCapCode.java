package com.spoonsea.qualitytracing.service;

import com.spoonsea.qualitytracing.dto.ReportTemplate;

public interface ReportByHidAndCapCode {

    ReportTemplate<?> getReportByHidAndCapCode(String hid, String capCode);

}
