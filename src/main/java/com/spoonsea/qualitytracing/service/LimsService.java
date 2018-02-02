package com.spoonsea.qualitytracing.service;

import java.util.List;

import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.lims.model.ArLottab;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.lims.model.BarcodeBroth;
import com.spoonsea.qualitytracing.lims.model.Broth;
import com.spoonsea.qualitytracing.lims.model.Sake;

public interface LimsService {

    List<Sake> getSakeList(CodeInfo code);

    List<Broth> getBrothList(CodeInfo code);

    List<Sake> getSakeListWithWineID(CodeInfo code);

	List<BarcodeBroth> getBarcodeBrothList(CodeInfo code);

	List<BarcodeBroth> getBarcodeBrothList(String barcode);

	List<Sake> getSakeList(String barcode);

	List<ArLottab> getArLottabList(CodeInfo code);

	List<ArLottab> getArLottabList(String barcode);

	Barcode getPackaging(String barcode);

}
