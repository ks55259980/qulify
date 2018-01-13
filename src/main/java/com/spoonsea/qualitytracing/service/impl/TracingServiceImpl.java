package com.spoonsea.qualitytracing.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.spoonsea.qualitytracing.service.TracingService;


@Service
public class TracingServiceImpl implements TracingService {

    @Override
    public String tracingByBoxCode(String boxCode) throws IOException {
        return IOUtils.toString(new FileInputStream(ResourceUtils.getFile("classpath:data/test-data.json")), StandardCharsets.UTF_8.name());
    }

    @Override
    public String tracingByCapCode(String capCode) throws IOException {
        return IOUtils.toString(new FileInputStream(ResourceUtils.getFile("classpath:data/tree-data.json")), StandardCharsets.UTF_8.name());
    }

}
