package com.spoonsea.qualitytracing.service;

import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.ReportTemplate;

public interface ReportService {

    ReportTemplate getReport(CodeInfo code);

    ReportTemplate getReport(String barcode);

}
