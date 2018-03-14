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
import com.spoonsea.qualitytracing.lims.model.Sake;
import com.spoonsea.qualitytracing.service.LimsService;
import com.spoonsea.qualitytracing.util.MiscUtil;

@Service
@ReportServiceAnnotation(name = "酿造清酒报表", id = "BraumatBBTReport", category = Category.Brewing)
public class BraumatBBTReportService extends BaseBraumatReportService {

    private static final Logger logger = LoggerFactory.getLogger(BraumatBBTReportService.class);

    @Autowired
    private LimsService limsService;

    @Autowired
    private Brau33Repository braumatRepo;

    private ReportTemplate<Map<String, String>> getReport(List<Sake> sakeList) {
        Set<Brau33> result = new HashSet<Brau33>();
        for (Sake sake : sakeList) {
            DateTime dt = MiscUtil.getDateTime(sake.getDate(), sake.getFullTankTime());
            String rezTyp = "BBT";
            int bbtNo = 0;
            try {
                bbtNo = Integer.parseInt(sake.getSakeTank());
            } catch (NumberFormatException ex) {
                logger.warn("bbt number is not integer: {}", sake.getSakeTank());
            }
            logger.info("year: {}, month: {}, day: {}, start_hour: {}, end_hour: {}, rezTyp: {}, bbtNo: {}",
                    dt.getYear() % 2000, dt.getMonthOfYear(), dt.getDayOfMonth(), dt.getHourOfDay(), dt.getHourOfDay(),
                    rezTyp, bbtNo);
            Brau33 labCheck = braumatRepo
                    .findTop1ByRezTypAndTeilanlNrAndGopNameAndStartTsGreaterThanEqualOrderByStartTsAsc(rezTyp, bbtNo,
                            "Lab Check", BigInteger.valueOf(dt.getMillis() / 1000));
            if (labCheck != null) {
                logger.info("found labCheck: {} - {}", labCheck.getStartTs(), labCheck.getEndTs());
                Brau33 first = braumatRepo.findTop1ByRezTypAndTeilanlNrAndGopNameAndEndTsLessThanOrderByStartTsDesc(
                        rezTyp, bbtNo, "End", labCheck.getStartTs());
                Brau33 last = braumatRepo.findTop1ByRezTypAndTeilanlNrAndGopNameAndStartTsGreaterThanOrderByStartTsAsc(
                        rezTyp, bbtNo, "Start", labCheck.getEndTs());
                List<Brau33> all = braumatRepo.findByRezTypAndTeilanlNrAndStartTsGreaterThanAndEndTsLessThan(rezTyp,
                        bbtNo, first.getEndTs(), last.getStartTs());
                logger.info("get {} braumat records", all.size());
                result.addAll(all);
            }
        }
        return super.generateReport(result.stream().collect(Collectors.toList()));
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(CodeInfo code) {
        // 1. find the full sake record in barcode table
        // 2. use the full sake time and sake number to query the braumat lab_check
        // record
        // 3. find the first start record around lab_check record
        // 4. search the record between the two start record of step 3.
        // 5. return the reports
        List<Sake> sakeList = limsService.getSakeList(code);
        return getReport(sakeList);
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(String barcode) {
        List<Sake> sakeList = limsService.getSakeList(barcode);
        return getReport(sakeList);
    }

}
