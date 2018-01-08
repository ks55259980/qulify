package com.spoonsea.qualitytracing.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.spoonsea.qualitytracing.entity.BarcodeQueryResultDetail;

public interface BarcodeQueryService {

	List<BarcodeQueryResultDetail> queryByBoxCode(String boxCode)
			throws JsonParseException, JsonMappingException, IOException;

	String helloWorld();

	List<BarcodeQueryResultDetail> queryByTimeInterval(String factoryCode, String LineCode, Date startTime,
			Date endTime) throws JsonParseException, JsonMappingException, IOException;

}
