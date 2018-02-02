package com.spoonsea.qualitytracing.util;

import java.util.HashMap;
import java.util.Map;


public class WorkshopUtil {

    private static Map<String, String> lineMap;

    public static Map<String, String> getLineMap() {
        if (lineMap == null) {
            lineMap = new HashMap<String, String>();
            lineMap.put("A", "BL01");
            lineMap.put("B", "BL02");
            lineMap.put("C", "BL03");
            lineMap.put("E", "BL05");
            lineMap.put("F", "BL06");
            lineMap.put("X", "CL01");
            lineMap.put("Y", "CL02");
            lineMap.put("Z", "CL03");
            lineMap.put("K", "KL01");
        }
        return lineMap;
    }

    public static String getLine(String code) {
        Map<String, String> lineMap = getLineMap();
        return lineMap.get(code);
    }

    public static String getBarcodeWorkshopCode(String code) {
    		return "CN01";	// PUT
    }
    
    public static String getBarcodeLineCode(String code) {
    		return "70100001";	// BL01
    }
}
