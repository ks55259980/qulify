package com.spoonsea.qualitytracing.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    // define the report list for each type of the tracing node
    public static final List<String> PACKAGE_REPORTS = Arrays.asList("FinishedWineReport", "CapacityReport",
            "TPOReport");
    public static final List<String> SAKE_REPORTS = Arrays.asList("SakeLabCheckReport", "BraumatBBTReleaseReport",
            "BraumatBBTReport", "BraumatBBTFillingReport");
    public static final List<String> FERMENT_REPORTS = Arrays.asList("BrothQualityReport", "WortQualityReport",
            "BraumatUTReport");
    public static final List<String> SACCHARIFY_REPORTS = Arrays.asList("BraumatLauterTunReport",
            "BraumatMaltIntakeReport");
    public static final List<String> CENTRIFUGAL_FILTRATION_REPORTS = Arrays.asList("BraumatBBTFillingReport",
            "BraumatUTFilterReport", "BraumatPVPPBReport", "AuxiliaryMaterialReport");

    public enum CodeTypeEnum {

        UNDETERMINED(-1, "瓶身码或条码", null),
        CAP_CODE(0, "瓶身码", "^\\d{8}[A-Z]{2}\\d{2}:\\d{2}-\\d{2}$"),
        BARCODE(1, "条码", "^\\d{13}$"),
        HID(2, "HID", "^\\d{13}$"),
        SID(3, "SID", "^\\d{13}?(,\\d{13})*$");

        private int formatType;
        private String description;
        private String regex;

        private CodeTypeEnum(int formatType, String description, String regex) {
            this.formatType = formatType;
            this.description = description;
            this.regex = regex;
        }

        public int getFormatType() {
            return formatType;
        }

        public void setFormatType(int formatType) {
            this.formatType = formatType;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getRegex() {
            return regex;
        }

        public void setRegex(String regex) {
            this.regex = regex;
        }

    }

    public enum ProductionProcessEnum {

        PACKAGE("包装", 0, CodeTypeEnum.UNDETERMINED, PACKAGE_REPORTS),
        SAKE("清酒", 1, CodeTypeEnum.HID, SAKE_REPORTS),
        FERMENT("发酵", 2, CodeTypeEnum.SID, FERMENT_REPORTS),
        SACCHARIFY("糖化", 3, CodeTypeEnum.SID, SACCHARIFY_REPORTS);

        public String name;
        public int type;
        public CodeTypeEnum codeType; // the type of value in the tracing results
        public List<String> reports;

        ProductionProcessEnum(String name, int type, CodeTypeEnum codeType, List<String> reportList) {
            this.name = name;
            this.type = type;
            this.codeType = codeType;
            this.reports = reportList;
        }

        public static List<String> getReportsByType(int type) {
            for (ProductionProcessEnum p : ProductionProcessEnum.values()) {
                if (p.type == type)
                    return p.reports;
            }
            return Collections.emptyList();
        }

        public static List<String> getProcessList() {
            List<String> ret = new ArrayList<>();
            for (ProductionProcessEnum p : ProductionProcessEnum.values()) {
                ret.add(p.name);
            }
            return ret;
        }

        public static boolean queryUsingCapCode(int type, String code) {
            for (ProductionProcessEnum p : ProductionProcessEnum.values()) {
                if (p.type == type)
                    return p.codeType == CodeTypeEnum.UNDETERMINED && code.matches(CodeTypeEnum.CAP_CODE.regex);
            }
            return false;
        }

        public static boolean queryUsingBarcode(int type, String code) {
            for (ProductionProcessEnum p : ProductionProcessEnum.values()) {
                if (p.type == type)
                    return p.codeType == CodeTypeEnum.UNDETERMINED && code.matches(CodeTypeEnum.BARCODE.regex);
            }
            return false;
        }

        public static boolean queryUsingHid(int type) {
            for (ProductionProcessEnum p : ProductionProcessEnum.values()) {
                if (p.type == type)
                    return p.codeType == CodeTypeEnum.HID;
            }
            return false;
        }

        public static boolean queryUsingSid(int type) {
            for (ProductionProcessEnum p : ProductionProcessEnum.values()) {
                if (p.type == type)
                    return p.codeType == CodeTypeEnum.SID;
            }
            return false;
        }

    }

    public enum LogisticsProcessEnum {
        PACKAGE("包装", -1),
        ROLL_OFF("下线", -2),
        WAREHOUSE_SHIPMENT("入库/发运", -3);

        public String name;
        public int type;

        LogisticsProcessEnum(String name, int code) {
            this.name = name;
            this.type = code;
        }

        public static List<String> getProcessList() {
            List<String> ret = new ArrayList<>();
            for (LogisticsProcessEnum p : LogisticsProcessEnum.values()) {
                ret.add(p.name);
            }
            return ret;
        }
    }

}
