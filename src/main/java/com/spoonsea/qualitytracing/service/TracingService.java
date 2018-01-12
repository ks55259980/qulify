package com.spoonsea.qualitytracing.service;

import java.io.IOException;

public interface TracingService {

    String tracingByBoxCode(String boxCode) throws IOException;
    String tracingByCapCode(String capCode);

}
