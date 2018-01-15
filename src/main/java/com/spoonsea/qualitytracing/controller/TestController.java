package com.spoonsea.qualitytracing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String queryTest() {
        return "hello world";
    }

    @RequestMapping("/testvideo")
    public String queryTestvideo() {
    		return "test";
    }

}
