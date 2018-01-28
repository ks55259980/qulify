package com.spoonsea.qualitytracing.service;

import java.util.List;

import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.lims.model.Broth;
import com.spoonsea.qualitytracing.lims.model.Sake;

public interface LimsService {

    List<Sake> getSakeList(CodeInfo code);

    List<Broth> getBrothList(CodeInfo code);

    List<Sake> getSakeListWithWineID(CodeInfo code);

}
