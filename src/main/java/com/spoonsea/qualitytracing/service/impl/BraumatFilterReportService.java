package com.spoonsea.qualitytracing.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoonsea.qualitytracing.braumat.dao.Brau33Repository;
import com.spoonsea.qualitytracing.braumat.entity.Brau33;
import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.constant.Constants.Category;
import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.ReportTemplate;
import com.spoonsea.qualitytracing.lims.dao.BarcodeRepository;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.util.MiscUtil;


@Service
@ReportServiceAnnotation(name="酿造过滤报表",
id="BraumatFilterReport",
category=Category.Brewing,
enabled=false)
public class BraumatFilterReportService extends BaseBraumatReportService {

    private static final Logger logger = LoggerFactory.getLogger(BraumatFilterReportService.class);

    @Autowired
    private BarcodeRepository barcodeRepo;

    @Autowired
    private Brau33Repository brau33Repo;

    @Override
    public ReportTemplate<Map<String, String>> getReport(CodeInfo code) {
    		Barcode barcode = barcodeRepo.findTop1ByPackagingLineAndDateAndTimeLessThanOrderByTimeDesc(
    				code.getLine(), code.getDate(), code.getTime());
    		Barcode sake = barcodeRepo.findOneByHidAndEnglish(barcode.getHid(), "Sake");
    		// sake.getWineId()'s first character is the number of sake tank
    		// TODO: finish the below logic...
//    		String number = MiscUtil.getSakeTankNumber(sake);
//    		if (number != null) {
//    			DateTime dt = MiscUtil.getDateTime(sake.getDate(), sake.getTime());
//    			String rezTyp = "BBT";
//    			int bbtNo = 0;
//    			try {
//    				bbtNo = Integer.parseInt(sake.getSakeTank());
//    			} catch (NumberFormatException ex) {
//    				logger.warn("bbt number is not integer: {}", sake.getSakeTank());
//    			}
//    			brau33Repo.findByRezTypAndTeilanlNrAndStartTsGreaterThanAndEndTsLessThan(rezTyp, bbtNo, endTs, startTs);
//    					teilanl, startTs, endTs);
//    		}
        Set<Brau33> result = new HashSet<Brau33>();
        return generateReport(result.stream().collect(Collectors.toList()));
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(String barcode) {
        Barcode record = barcodeRepo.findOneByBarcode(barcode);
        Set<Brau33> recordSet = new HashSet<Brau33>();
        // TODO: add logic...
        return generateReport(recordSet.stream().collect(Collectors.toList()));
    }

}
