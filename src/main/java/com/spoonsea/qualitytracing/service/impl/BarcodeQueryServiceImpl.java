package com.spoonsea.qualitytracing.service.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spoonsea.qualitytracing.entity.BarcodeQueryResult;
import com.spoonsea.qualitytracing.entity.BarcodeQueryResultDetail;
import com.spoonsea.qualitytracing.service.BarcodeQueryService;

import org.tempuri.*;

@Service
public class BarcodeQueryServiceImpl implements BarcodeQueryService {

	private static final Logger logger = LoggerFactory.getLogger(BarcodeQueryServiceImpl.class);

	@Autowired
	private WebServiceTemplate webServiceTemplate;

	@Override
	public String helloWorld() {
		HelloWorld helloworld = new ObjectFactory().createHelloWorld();
		logger.info("Client sending hello world");

		HelloWorldResponse response = (HelloWorldResponse) webServiceTemplate.marshalSendAndReceive(helloworld);

		logger.info("Client received response = '{}'", response.getHelloWorldResult());
		return response.getHelloWorldResult();
	}

	@Override
	public List<BarcodeQueryResultDetail> queryByBoxCode(String boxCode)
			throws JsonParseException, JsonMappingException, IOException {
		BoxCodeTracingQuery query = new ObjectFactory().createBoxCodeTracingQuery();
		query.setSBoxcode(boxCode);
		BoxCodeTracingQueryResponse response = (BoxCodeTracingQueryResponse) webServiceTemplate
				.marshalSendAndReceive(query);
		String resultString = response.getBoxCodeTracingQueryResult();
		logger.info("client received response = '{}'", resultString);
		BarcodeQueryResult result = new ObjectMapper().readValue(resultString, BarcodeQueryResult.class);
		if (result.getCode() != 0) {
			logger.warn("query failed: {}", result.getMsg());
		}
		return result.getDetailList();
	}

}
