package com.spoonsea.qualitytracing.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spoonsea.qualitytracing.braumat.entity.Brau33;
import com.spoonsea.qualitytracing.configuration.ReportServiceAnnotation;
import com.spoonsea.qualitytracing.dto.ReportTemplate;


public class BaseBraumatReportService {
    
	private static final Logger logger = LoggerFactory.getLogger(BaseBraumatReportService.class);

    public static DateTime getDateTime(String date, String time) {
    		String[] datePart = date.trim().split("-");
    		String[] timePart = time.trim().split(":");
    		int year = Integer.parseInt(datePart[0]);
    		int month = Integer.parseInt(datePart[1]);
    		int day = Integer.parseInt(datePart[2]);
    		int hour = Integer.parseInt(timePart[0]);
    		int minute = timePart.length > 1 ? Integer.parseInt(timePart[1]) : 0;
    		int second = timePart.length > 2 ? Integer.parseInt(timePart[2]) : 0;
    		logger.info("local date time: {}-{}-{} {}:{}:{}", year, month, day, hour, minute, second);
    		DateTime dt = new DateTime(year, month, day, hour, minute, second).withZone(DateTimeZone.UTC);
    		logger.info("local date time in UTC: {}", dt.toString());
        return dt;
    }

    public String getReportId() {
        return this.getClass().getAnnotation(ReportServiceAnnotation.class).id();
    }

    public String getReportName() {
		return this.getClass().getAnnotation(ReportServiceAnnotation.class).name();
	}

	public ReportTemplate<Map<String, String>> generateReport(List<Brau33> records) {
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
                    result.put("param" + i, (String) field.get(rec));
                    field = Brau33.class.getDeclaredField("swDfm" + i);
                    field.setAccessible(true);
                    result.put("paramset" + i, (String) field.get(rec) + dim);
                    field = Brau33.class.getDeclaredField("iwDfm" + i);
                    field.setAccessible(true);
                    result.put("paramval" + i, (String) field.get(rec) + dim);
                    if (columnId.size() < 5 + i * 3) {
                        columnId.add("param" + i);
                        columnId.add("paramset" + i);
                        columnId.add("paramval" + i);
                        columnName.add("参数" + i);
                        columnName.add("参数" + i + "设定值");
                        columnName.add("参数" + i + "实际值");
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

        ReportTemplate<Map<String, String>> report = new ReportTemplate<Map<String, String>>();
        report.setColumnId(columnId);
        report.setColumnName(columnName);
        report.setReportId(this.getReportId());
        report.setReportName(this.getReportName());
        report.setRecords(ret);
        return report;
    }

}
