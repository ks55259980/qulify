package com.spoonsea.qualitytracing.service.impl;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
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
import com.spoonsea.qualitytracing.service.ReportByHid;
import com.spoonsea.qualitytracing.util.MiscUtil;

@Service
@ReportServiceAnnotation(name = "过滤机生产信息报表", id = "BraumatPVPPBReport", category = Category.Brewing)
public class BraumatPVPPBReportService extends BaseBraumatReportService implements ReportByHid {

    private static final Logger logger = LoggerFactory.getLogger(BraumatPVPPBReportService.class);

    @Autowired
    private BarcodeRepository barcodeRepo;

    @Autowired
    private Brau33Repository braumatRepo;

    private ReportTemplate<Map<String, String>> getReport(Barcode sake) {
        if (sake == null || sake.getSid() == null || sake.getHid() == null
                || StringUtils.isEmpty(sake.getFermenter())) {
            return generateReport(Collections.emptyList());
        }
        logger.info("sake barcode, hid: {}, tank: {}, line: {}, wine: {}", sake.getHid(), sake.getSakeTank(),
                sake.getPackagingLine(), sake.getWineID());
        Set<Brau33> result = new HashSet<Brau33>();
        DateTime dt = MiscUtil.getDateTime(sake.getDate(), sake.getTime());
        String rezTyp = "BBT.Filling";
        int bbtNo = 0;
        try {
            bbtNo = Integer.parseInt(sake.getSakeTank());
        } catch (NumberFormatException ex) {
            logger.warn("bbt number is not integer: {}", sake.getSakeTank());
        }
        Brau33 fillingOne = braumatRepo.findTop1ByRezTypAndIwDfm1AndStartTsLessThanEqualOrderByStartTsDesc(rezTyp,
                String.format("BBT%02d", bbtNo), BigInteger.valueOf(dt.getMillis() / 1000));
        if (fillingOne != null) {
            String fillingUnitNo = fillingOne.getTeilanl().substring(5);
            String[] split = sake.getFermenter().split("\\+");
            for (String ut : split) {
                Brau33 utrOne = braumatRepo
                        .findTop1ByTeilanlLikeAndIwDfm1StartingWithAndStartTsLessThanOrderByStartTsDesc(
                                "UTR%" + fillingUnitNo, "UT" + ut, fillingOne.getStartTs());
                result.addAll(braumatRepo.findByTeilanlAndAuftrNrAndChargNr("PVPP", utrOne.getAuftrNr(),
                        utrOne.getChargNr()));
            }
        }
        return generateReport(result.stream().collect(Collectors.toList()));
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(CodeInfo code) {
        // when OrderBy clause contains two or more columns, each column should come with its own sort direction
        Barcode barcode = barcodeRepo.findTop1ByPackagingLineAndDateAndTimeLessThanOrderByDateDescTimeDesc(
                code.getLine(), code.getDate(), code.getTime());
        if (barcode == null || barcode.getSid() == null || barcode.getHid() == null) {
            return generateReport(Collections.emptyList());
        }
        return getReport(barcodeRepo.findTop1ByHidAndEnglishOrderByDateAscTimeAsc(barcode.getHid(), "Sake"));
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(String barcode) {
        Barcode record = barcodeRepo.findOneByBarcode(barcode);
        if (record == null || record.getSid() == null || record.getHid() == null) {
            return generateReport(Collections.emptyList());
        }
        return getReport(barcodeRepo.findTop1ByHidAndEnglishOrderByDateAscTimeAsc(record.getHid(), "Sake"));
    }

    @Override
    public ReportTemplate<?> getReportByHid(String code) {
        return getReport(barcodeRepo.findTop1ByHidAndEnglishOrderByDateAscTimeAsc(code, "Sake"));
    }

}
