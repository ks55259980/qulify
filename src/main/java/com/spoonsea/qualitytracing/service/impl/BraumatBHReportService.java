package com.spoonsea.qualitytracing.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
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
import com.spoonsea.qualitytracing.braumat.dao.BraumatRepository;
import com.spoonsea.qualitytracing.braumat.entity.Brau31;
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
@ReportServiceAnnotation(name = BraumatBHReportService.reportName, id = "BraumatBHReport", category = Category.Brewing, enabled = false)
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
			Brau33 record = brau33Repo.findOneByRezTypAndTeilanlAndStartTsLessThanEqualAndEndTsGreaterThanEqual(rezTyp,
					teilanl, BigInteger.valueOf(dt.getMillis() / 1000), BigInteger.valueOf(dt.getMillis() / 1000));
			if (record != null) {
				Brau33 filling = brau33Repo.findOneByRezTypAndTeilanlAndAuftrNrAndChargNrAndGopName(rezTyp, teilanl,
						record.getAuftrNr(), record.getChargNr(), "Filling");
				Brau33 fillingUT = brau33Repo.findOneByRezTypAndSwDfm1AndStartTs("1.FillingUT", teilanl,
						filling.getStartTs());
				// add BH search
				for (int i = 0; i < count.get(barcode.getHid()); i++) {
					result.addAll(brau31Repo.findByTeilanlAndAuftrNrAndChargNr("Rice Cook", fillingUT.getAuftrNr(),
							fillingUT.getChargNr() + i));
				}
			}
		}
		return generateReport(result.stream().collect(Collectors.toList()));
	}

	@Override
	public ReportTemplate<Map<String, String>> getReport(CodeInfo code) {
		Barcode barcode = barcodeRepo.findTop1ByPackagingLineAndDateAndTimeLessThanOrderByTimeDesc(code.getLine(),
				code.getDate(), code.getTime());
		List<Barcode> wortList = barcodeRepo.findByEnglishAndLikeHid("Wort", barcode.getSid());
		return getReport(wortList);
	}

	@Override
	public ReportTemplate<Map<String, String>> getReport(String barcode) {
		Barcode record = barcodeRepo.findOneByBarcode(barcode);
		List<Barcode> wortList = null;
		if (record.getSid() != null) {
			wortList = barcodeRepo.findByEnglishAndLikeHid("Wort", record.getSid());
		} else {
			wortList = barcodeRepo.findByHid(record.getHid());
		}
		return getReport(wortList);
	}

}
