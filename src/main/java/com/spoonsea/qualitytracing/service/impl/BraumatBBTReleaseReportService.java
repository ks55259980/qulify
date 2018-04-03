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
import com.spoonsea.qualitytracing.lims.dao.BarcodeRepository;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.service.ReportByHidAndCapCode;
import com.spoonsea.qualitytracing.util.MiscUtil;

@Service
@ReportServiceAnnotation(name = "清酒送包装生产信息报表", id = "BraumatBBTReleaseReport", category = Category.Brewing)
public class BraumatBBTReleaseReportService extends BaseBraumatReportService implements ReportByHidAndCapCode {

    private static final Logger logger = LoggerFactory.getLogger(BraumatBBTReleaseReportService.class);

    @Autowired
    private BarcodeRepository barcodeRepo;

    @Autowired
    private Brau33Repository braumatRepo;

    private ReportTemplate<Map<String, String>> getReport(Barcode sakeRelease) {
        Set<Brau33> result = new HashSet<Brau33>();
        DateTime dt = MiscUtil.getDateTime(sakeRelease.getDate(), sakeRelease.getTime());
        String rezTyp = "BBT.Release";
        String packagingLine = sakeRelease.getPackagingLine().startsWith("KL") ? "KegLine"
                : sakeRelease.getPackagingLine();
        int bbtNo = 0;
        try {
            bbtNo = Integer.parseInt(sakeRelease.getSakeTank());
        } catch (NumberFormatException ex) {
            logger.warn("bbt number is not integer: {}", sakeRelease.getSakeTank());
        }
        logger.info("year: {}, month: {}, day: {}, start_hour: {}, end_hour: {}, rezTyp: {}, bbtNo: {}",
                dt.getYear() % 2000, dt.getMonthOfYear(), dt.getDayOfMonth(), dt.getHourOfDay(), dt.getHourOfDay(),
                rezTyp, bbtNo);
        Brau33 one = braumatRepo
                .findTop1ByRezTypAndTeilanlStartingWithAndSwDfm1AndEndTsGreaterThanEqualOrderByStartTsAsc(rezTyp,
                        packagingLine, String.format("BBT%02d", bbtNo), BigInteger.valueOf(dt.getMillis() / 1000));
        if (one != null) {
            logger.info("found one bbt release: {} - {}", one.getStartTs(), one.getEndTs());
            Brau33 start = braumatRepo
                    .findTop1ByAuftrNrAndChargNrAndTeilanlAndGopNameAndStartTsLessThanEqualOrderByStartTsDesc(
                            one.getAuftrNr(), one.getChargNr(), one.getTeilanl(), "Start", one.getStartTs());
            Brau33 end = braumatRepo
                    .findTop1ByAuftrNrAndChargNrAndTeilanlAndGopNameAndStartTsGreaterThanEqualOrderByStartTsAsc(
                            one.getAuftrNr(), one.getChargNr(), one.getTeilanl(), "End", one.getEndTs());
            List<Brau33> all = braumatRepo
                    .findByAuftrNrAndChargNrAndTeilanlAndStartTsGreaterThanEqualAndEndTsLessThanEqual(one.getAuftrNr(),
                            one.getChargNr(), one.getTeilanl(), start.getStartTs(), end.getEndTs());
            logger.info("get {} braumat records", all.size());
            result.addAll(all);
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
        Barcode barcode = barcodeRepo.findTop1ByPackagingLineAndDateAndTimeLessThanOrderByDateDescTimeDesc(
                code.getLine(), code.getDate(), code.getTime());
        Barcode sakeRelease = barcodeRepo
                .findTop1ByPackagingLineAndHidAndDateAndTimeLessThanEqualOrderByDateDescTimeDesc(code.getLine(),
                        barcode.getHid(), code.getDate(), code.getTime());
        return getReport(sakeRelease);
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(String barcode) {
        Barcode one = barcodeRepo.findOneByBarcode(barcode);
        if (one != null && one.getSid() != null) {
            if (one.getPackagingLine() != null) {
                return getReport(one);
            }
        }
        return new ReportTemplate<>();
    }

    @Override
    public ReportTemplate<?> getReportByHidAndCapCode(String hid, String capCode) {
        CodeInfo code = new CodeInfo(capCode);
        Barcode sakeRelease = barcodeRepo
                .findTop1ByPackagingLineAndHidAndDateAndTimeLessThanEqualOrderByDateDescTimeDesc(code.getLine(), hid,
                        code.getDate(), code.getTime());
        return getReport(sakeRelease);
    }

}
