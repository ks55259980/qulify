package com.spoonsea.qualitytracing.service.impl;

import java.math.BigInteger;
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

import com.spoonsea.qualitytracing.braumat.dao.BraumatRepository;
import com.spoonsea.qualitytracing.braumat.entity.Brau33;
import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.constant.Constants.Category;
import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.MapReport;
import com.spoonsea.qualitytracing.dto.ReportTemplate;
import com.spoonsea.qualitytracing.lims.dao.BarcodeRepository;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.lims.model.BarcodeBroth;
import com.spoonsea.qualitytracing.util.MiscUtil;


@Service
@ReportServiceAnnotation(name=BraumatBHReportService.reportName,
id="BraumatBHReport",
category=Category.Brewing,
enabled=false)
public class BraumatBHReportService extends BaseBraumatReportService {

    protected static final String reportName = "酿造糖化报表";

    private static final Logger logger = LoggerFactory.getLogger(BraumatBHReportService.class);

    @Autowired
    private BarcodeRepository barcodeRepo;

    @Autowired
    private BraumatRepository braumatRepo;

    public MapReport getReport(List<BarcodeBroth> brothList) {
		Set<Brau31> result = new HashSet<Brau31>();
		logger.info("barcode broth found: {}", brothList.size());
		String rezTyp = "UT";
		for (BarcodeBroth broth: brothList) {
			DateTime dt = MiscUtil.getDateTime(broth.getDate(), broth.getTime());
			String teilanl = rezTyp + broth.getFermenter();
			logger.info("teilanl: {}, dt: {}", teilanl, dt);
			Brau33 record = braumatRepo.findOneByRezTypAndTeilanlAndStartTsLessThanEqualAndEndTsGreaterThanEqual(
					rezTyp, teilanl, BigInteger.valueOf(dt.getMillis() / 1000), BigInteger.valueOf(dt.getMillis() / 1000));
			if (record != null) {
				Brau33 filling = braumatRepo.findOneByRezTypAndTeilanlAndAuftrNrAndChargNrAndGopName(
						rezTyp, teilanl, record.getAuftrNr(), record.getChargNr(), "Filling");
				Brau33 fillingUT = braumatRepo.findOneByRezTypAndSwDfm1AndStartTs("1.FillingUT", teilanl, filling.getStartTs());
				// add BH search
			}
		}
		return generateReport(result.stream().collect(Collectors.toList()));
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(CodeInfo code) {
        Set<Brau33> result = new HashSet<Brau33>();
        return generateReport(result.stream().collect(Collectors.toList()));
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(String barcode) {
        List<Barcode> barcodeList = barcodeRepo.findByBarcode(barcode);
        logger.info("found barcode: {}", barcodeList.size());
        Set<Brau33> recordSet = new HashSet<Brau33>();
        return generateReport(recordSet.stream().collect(Collectors.toList()));
    }

}
