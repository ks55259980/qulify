package com.spoonsea.qualitytracing.service;

import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.ReportTemplate;

public interface ReportService<T> {

    ReportTemplate<T> getReport(CodeInfo code);

    ReportTemplate<T> getReport(String barcode);

}
