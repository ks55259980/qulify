package com.spoonsea.qualitytracing.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spoonsea.qualitytracing.braumat.entity.Brau33;
import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.dto.MapReport;
import com.spoonsea.qualitytracing.service.ReportService;


public abstract class BaseBraumatReportService implements ReportService<Map<String, String>> {
    
	private static final Logger logger = LoggerFactory.getLogger(BaseBraumatReportService.class);

	public String getReportId() {
        return this.getClass().getAnnotation(ReportServiceAnnotation.class).id();
    }

    public String getReportName() {
		return this.getClass().getAnnotation(ReportServiceAnnotation.class).name();
	}

	public MapReport generateReport(List<Brau33> records) {
        List<String> columnId = new ArrayList<String>();
        List<String> columnName = new ArrayList<String>();

        columnId.addAll(Arrays.asList("startTs","endTs","teilanl", "gopName", "paramCount"));
        columnName.addAll(Arrays.asList("开始时间","结束时间","工艺单元名称","工艺步骤名称", "参数个数"));
        List<Map<String, String>> ret = new ArrayList<Map<String, String>>();
        for (Brau33 rec: records) {
            Map<String,String> result = new HashMap<String, String>();
            result.put("id", rec.getStartTs().toString() + rec.getEndTs().toString());
            result.put("startTs", new Date(rec.getStartTs().longValue() * 1000).toLocaleString());
            result.put("endTs", new Date(rec.getEndTs().longValue() * 1000).toLocaleString());
            result.put("teilanl", rec.getTeilanl());
            result.put("gopName", rec.getGopName());
            result.put("paramCount", Integer.toString(rec.getDfmAnz()));
            for (int i = 1; i <= rec.getDfmAnz(); i++) {
                try {
                		Field field = Brau33.class.getDeclaredField("dimDfm" + i);
                		field.setAccessible(true);
                    String dim = (String) field.get(rec);
                    field = Brau33.class.getDeclaredField("nameDfm" + i);
                    field.setAccessible(true);
                    String paramName = (String) field.get(rec);
                    //result.put("param" + i, (String) field.get(rec));
                    field = Brau33.class.getDeclaredField("swDfm" + i);
                    field.setAccessible(true);
                    String paramSet = (String) field.get(rec);
                    //result.put("paramset" + i, (String) field.get(rec) + dim);
                    field = Brau33.class.getDeclaredField("iwDfm" + i);
                    field.setAccessible(true);
                    String paramVal = (String) field.get(rec);
                    result.put("param" + i, String.format("%s(%s)\n%s\n%s", paramName, dim, paramSet, paramVal));
                    //result.put("paramval" + i, (String) field.get(rec) + dim);
                    if (columnId.size() < 5 + i) {
                        columnId.add("param" + i);
                        //columnId.add("paramset" + i);
                        //columnId.add("paramval" + i);
                        columnName.add(String.format("参数%d\n设定值\n实际值", i));
                        //columnName.add("参数" + i + "设定值");
                        //columnName.add("参数" + i + "实际值");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    break;
                }
            }
            ret.add(result);
        }

        ret.sort((o1, o2) -> {
			Map<String, String> s1 = (Map<String, String>)o1;
			Map<String, String> s2 = (Map<String, String>)o2;
			return s1.get("id").compareTo(s2.get("id"));
		});

        MapReport report = new MapReport();
        report.setColumnId(columnId);
        report.setColumnName(columnName);
        report.setReportId(this.getReportId());
        report.setReportName(this.getReportName());
        report.setRecords(ret);
        return report;
    }

}
