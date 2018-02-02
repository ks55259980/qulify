package com.spoonsea.qualitytracing.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiscUtil {

	private final static Logger logger = LoggerFactory.getLogger(MiscUtil.class);

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

}