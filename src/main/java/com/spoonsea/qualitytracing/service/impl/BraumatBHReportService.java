package com.spoonsea.qualitytracing.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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

import com.spoonsea.qualitytracing.braumat.dao.Brau31Repository;
import com.spoonsea.qualitytracing.braumat.dao.Brau33Repository;
import com.spoonsea.qualitytracing.braumat.entity.Brau31;
import com.spoonsea.qualitytracing.braumat.entity.Brau33;
import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.constant.Constants.Category;
import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.MapReport;
import com.spoonsea.qualitytracing.dto.ReportTemplate;
import com.spoonsea.qualitytracing.lims.dao.BarcodeRepository;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.util.MiscUtil;

@Service
@ReportServiceAnnotation(name = BraumatBHReportService.reportName, id = "BraumatBHReport", category = Category.Brewing, enabled = true)
public class BraumatBHReportService extends BaseBraumatReportService {

    protected static final String reportName = "酿造糖化报表";

    private static final Logger logger = LoggerFactory.getLogger(BraumatBHReportService.class);

    @Autowired
    private BarcodeRepository barcodeRepo;

    @Autowired
    private Brau33Repository brau33Repo;

    @Autowired
    private Brau31Repository brau31Repo;

    public MapReport getReport(List<Barcode> wortList) {
        Set<Brau31> result = new HashSet<Brau31>();
        String rezTyp = "UT";
        Map<String, Integer> count = new HashMap<String, Integer>();
        List<Barcode> usefulWorts = new ArrayList<Barcode>();
        for (Barcode barcode : wortList) {
            String sid = barcode.getHid();
            if (count.containsKey(sid)) {
                count.put(sid, count.get(sid) + 1);
            } else {
                count.put(sid, 1);
                usefulWorts.add(barcode);
            }
        }
        for (Barcode barcode : usefulWorts) {
            DateTime dt = MiscUtil.getDateTime(barcode.getDate(), barcode.getTime());
            String teilanl = rezTyp + barcode.getFermenter();
            logger.info("teilanl: {}, dt: {}", teilanl, dt);
            Brau33 ut_Filling = brau33Repo.findTop1ByRezTypAndTeilanlAndGopNameAndStartTsGreaterThanOrderByStartTsAsc(
                    rezTyp, teilanl, "Filling", BigInteger.valueOf(dt.getMillis() / 1000));
            if (ut_Filling != null) {
                Brau33 fillingUT = brau33Repo
                        .findTop1ByRezTypAndSwDfm1AndStartTsGreaterThanEqualAndEndTsLessThanOrderByStartTsAsc(
                                "1.FillingUT", teilanl, ut_Filling.getStartTs(), ut_Filling.getEndTs());
                // add BH search
                if (fillingUT != null) {
                    List<Integer> chargNrList = new ArrayList<>();
                    for (int i = 0; i < count.get(barcode.getHid()); i++) {
                        chargNrList.add(fillingUT.getChargNr() + i);
                    }
                    result.addAll(brau31Repo.findByAuftrNrAndChargNrInAndTeilanlStartingWith(fillingUT.getAuftrNr(),
                            chargNrList, "Rice Cooker"));
                }
            }
        }
        return generateReport(result.stream().collect(Collectors.toList()));
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(CodeInfo code) {
        Barcode barcode = barcodeRepo.findTop1ByPackagingLineAndDateAndTimeLessThanOrderByDateDescTimeDesc(
                code.getLine(), code.getDate(), code.getTime());
        if (barcode == null) {
            return generateReport(Collections.emptyList());
        }
        List<Barcode> wortList = null;
        if (barcode.getSid() != null) {
            wortList = barcodeRepo.findByEnglishAndLikeHid("Wort", barcode.getSid());
        } else {
            wortList = barcodeRepo.findByHid(barcode.getHid());
        }
        return getReport(wortList);
    }

    @Override
    public ReportTemplate<Map<String, String>> getReport(String barcode) {
        Barcode record = barcodeRepo.findOneByBarcode(barcode);
        if (record == null) {
            return generateReport(Collections.emptyList());
        }
        List<Barcode> wortList = null;
        if (record.getSid() != null) {
            wortList = barcodeRepo.findByEnglishAndLikeHid("Wort", record.getSid());
        } else {
            wortList = barcodeRepo.findByHid(record.getHid());
        }
        return getReport(wortList);
    }

}
