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

import com.spoonsea.qualitytracing.braumat.dao.Brau33Repository;
import com.spoonsea.qualitytracing.braumat.entity.Brau33;
import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.constant.Constants.Category;
import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.ReportTemplate;
import com.spoonsea.qualitytracing.lims.model.BarcodeBroth;
import com.spoonsea.qualitytracing.service.LimsService;
import com.spoonsea.qualitytracing.util.MiscUtil;

@Service
@ReportServiceAnnotation(name = "酿造发酵报表", id = "BraumatUTReport", category = Category.Brewing)
public class BraumatUTReportService extends BaseBraumatReportService {

    private static final Logger logger = LoggerFactory.getLogger(BraumatUTReportService.class);

    @Autowired
    private LimsService limsService;

    @Autowired
    private Brau33Repository braumatRepo;

    public ReportTemplate<Map<String, String>> getReport(List<BarcodeBroth> brothList) {
        Set<Brau33> result = new HashSet<Brau33>();
        logger.info("barcode broth found: {}", brothList.size());
        String rezTyp = "UT";
        for (BarcodeBroth broth : brothList) {
            DateTime dt = MiscUtil.getDateTime(broth.getDate(), broth.getTime());
            String teilanl = rezTyp + broth.getFermenter();
            logger.info("teilanl: {}, dt: {}", teilanl, dt);
            Brau33 record = braumatRepo.findOneByRezTypAndTeilanlAndStartTsLessThanEqualAndEndTsGreaterThanEqual(rezTyp,
                    teilanl, BigInteger.valueOf(dt.getMillis() / 1000), BigInteger.valueOf(dt.getMillis() / 1000));
            if (record != null) {
                List<Brau33> all = braumatRepo.findByRezTypAndTeilanlAndAuftrNrAndChargNr(rezTyp, teilanl,
                        record.getAuftrNr(), record.getChargNr());
                result.addAll(all);
            }
        }
        return generateReport(result.stream().collect(Collectors.toList()));
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(CodeInfo code) {
        List<BarcodeBroth> brothList = limsService.getBarcodeBrothList(code);
        return getReport(brothList);
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(String barcode) {
        List<BarcodeBroth> brothList = limsService.getBarcodeBrothList(barcode);
        return getReport(brothList);
    }

}
