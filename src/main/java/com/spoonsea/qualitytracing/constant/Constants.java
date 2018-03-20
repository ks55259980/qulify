package com.spoonsea.qualitytracing.constant;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public class Category {
        public static final String QA = "QA";
        public static final String Packaging = "包装";
        public static final String TS = "TS";
        public static final String Brewing = "酿造";
        public static final String Logistics = "物流";
        public static final String Original = "原材料";
    }

    public enum ProductionProcess {
        Package("包装", 0), Sake("清酒", 1), Ferment("发酵", 2), Saccharify("糖化", 3);
    
        public String name;
        public int type;
    
        ProductionProcess(String name, int code) {
            this.name = name;
            this.type = code;
        }
    
        public static List<String> getProcessList() {
            List<String> ret = new ArrayList<>();
            for (ProductionProcess p : ProductionProcess.values()) {
                ret.add(p.name);
            }
            return ret;
        }
    }

    public enum LogisticsProcess {
        Package("包装", 0), RollsOff("下线", 1), WarehouseShipment("入库/发运", 2);
    
        public String name;
        public int type;
    
        LogisticsProcess(String name, int code) {
            this.name = name;
            this.type = code;
        }
    
        public static List<String> getProcessList() {
            List<String> ret = new ArrayList<>();
            for (LogisticsProcess p : LogisticsProcess.values()) {
                ret.add(p.name);
            }
            return ret;
        }
    }

}
