package com.spoonsea.qualitytracing.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spoonsea.qualitytracing.service.ReportService;

@Component
public class ReportServiceConfiguration {

    @Autowired
    private ApplicationContext context;

    @Bean("ReportServices")
    public Map<String, ReportService> getReportServices() {
        Map<String, Object> allBeans = context.getBeansWithAnnotation(ReportServiceAnnotation.class);
        Map<String, ReportService> reportServices = new HashMap<String, ReportService>();
        for (Object bean: allBeans.values()) {
            ReportService service = (ReportService) bean;
            ReportServiceAnnotation anno = service.getClass().getAnnotation(ReportServiceAnnotation.class);
            if (anno.enabled()) {
                reportServices.put(anno.id(), service);
            }
        }
        return reportServices;
    }

    @Bean("Reports")
    public Map<String, List<Map<String, Object>>> getReports() {
        Map<String, List<Map<String, Object>>> reports = new HashMap<String, List<Map<String, Object>>>();
        Reflections ref = new Reflections("com.spoonsea.qualitytracing.service.impl");
        for (Class<?> clz: ref.getTypesAnnotatedWith(ReportServiceAnnotation.class)) {
            ReportServiceAnnotation anno = clz.getAnnotation(ReportServiceAnnotation.class);
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("id", anno.id());
            item.put("name", anno.name());
            item.put("enabled", anno.enabled());
            String category = anno.category();
            if (!reports.containsKey(category)) {
                reports.put(category, new ArrayList<Map<String, Object>>());
            }
            reports.get(category).add(item);
        }
        return reports;
    }
}
