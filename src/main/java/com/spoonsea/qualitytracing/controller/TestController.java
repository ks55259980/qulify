package com.spoonsea.qualitytracing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @RequestMapping("/test")
    public String queryTest() {
        return "hello world";
    }

}
