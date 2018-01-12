package com.spoonsea.qualitytracing.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.spoonsea.qualitytracing.service.TracingService;


@Service
public class TracingServiceImpl implements TracingService {

    @Override
    public String tracingByBoxCode(String boxCode) throws IOException {
        return IOUtils.toString(new FileInputStream(ResourceUtils.getFile("classpath:data/test-data.json")));
    }

    @Override
    public String tracingByCapCode(String capCode) {
        // TODO Auto-generated method stub
        return null;
    }

}
