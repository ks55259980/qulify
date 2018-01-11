package com.spoonsea.qualitytracing.service;

import java.io.IOException;
import java.util.Date;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.spoonsea.qualitytracing.entity.BarcodeQueryResult;


public interface BarcodeQueryService {

    String helloWorld();

    BarcodeQueryResult queryByBoxCode(String boxCode) throws JsonParseException, JsonMappingException, IOException;

    BarcodeQueryResult queryByTimeInterval(String factoryCode, String LineCode, Date startTime, Date endTime)
            throws JsonParseException, JsonMappingException, IOException;

    BarcodeQueryResult queryByBarcode(String barcode) throws JsonParseException, JsonMappingException, IOException;

}
