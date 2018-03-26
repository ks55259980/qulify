package com.spoonsea.qualitytracing.service.impl;

import java.math.BigInteger;
import java.util.Collections;
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
@ReportServiceAnnotation(name = "酿造过滤报表", id = "BraumatKGFReport", category = Category.Brewing, enabled = true)
public class BraumatKGFReportService extends BaseBraumatReportService {

    private static final Logger logger = LoggerFactory.getLogger(BraumatKGFReportService.class);

    @Autowired
    private BarcodeRepository barcodeRepo;

    @Autowired
    private Brau33Repository brau33Repo;

    private ReportTemplate<Map<String, String>> getReport(Barcode sake) {
        if (sake == null || sake.getSid() == null || sake.getHid() == null) {
            return generateReport(Collections.emptyList());
        }
        logger.info("sake barcode, hid: {}, tank: {}, line: {}, wine: {}", sake.getHid(), sake.getSakeTank(),
                sake.getPackagingLine(), sake.getWineID());
        // sake.getWineId()'s first character is the number of sake tank //or filter line?
        String number = MiscUtil.getFilterLineNumber(sake);
        Set<Brau33> result = new HashSet<Brau33>();
        if (number != null) {
            DateTime dt = MiscUtil.getDateTime(sake.getDate(), sake.getTime());
            String rezTyp = "BBT";
            int bbtNo = 0;
            try {
                bbtNo = Integer.parseInt(sake.getSakeTank());
            } catch (NumberFormatException ex) {
                logger.warn("bbt number is not integer: {}", sake.getSakeTank());
            }
            Brau33 labCheck = brau33Repo
                    .findTop1ByRezTypAndTeilanlNrAndGopNameAndStartTsGreaterThanEqualOrderByStartTsAsc(rezTyp, bbtNo,
                            "Lab Check", BigInteger.valueOf(dt.getMillis() / 1000));
            // when the record's TEILANL='BBT.F2', its auftr_nr and charg_nr
            // will be the same with the record which TEILANL='KGF'
            Brau33 sakeFilling = brau33Repo
                    .findTop1ByRezTypAndTeilanlNrAndGopNameAndAuftrNrAndChargNrAndEndTsLessThanEqualOrderByStartTsDesc(
                            rezTyp, bbtNo, "Filling", labCheck.getAuftrNr(), labCheck.getChargNr(),
                            labCheck.getStartTs());
            Brau33 filterOne = brau33Repo.findTop1ByRezTypAndStartTsGreaterThanEqualAndEndTsLessThanEqualOrderByStartTs(
                    "KGF.B", sakeFilling.getStartTs(), sakeFilling.getEndTs());
            if (filterOne != null) {
                List<Brau33> filters = brau33Repo.findByRezTypAndTeilanlAndAuftrNrAndChargNr("KGF.B", "KGF",
                        filterOne.getAuftrNr(), filterOne.getChargNr());
                result.addAll(filters);
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

}
