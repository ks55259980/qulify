package com.spoonsea.qualitytracing.service;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.spoonsea.qualitytracing.entity.BarcodeQueryResultDetail;

public interface BarcodeQueryService {

	List<BarcodeQueryResultDetail> queryByBoxCode(String boxCode)
			throws JsonParseException, JsonMappingException, IOException;

	String helloWorld();

}
