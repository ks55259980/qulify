package com.spoonsea.qualitytracing.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(Include.NON_NULL)
public class BarcodeQueryResultDetail {

    @JsonProperty("TYPE")
    private String type;

    @JsonProperty("TIME")
    private String targetTimeString;

    @JsonProperty("NUMBERNO")
    private String numberNo;

    @JsonProperty("CODE")
    private String code;

    @JsonProperty("NAME")
    private String name;

    @JsonProperty("AREA")
    private String area;

    @JsonProperty("BARCODE")
    private String barcode;

    @JsonProperty("STARTTIME")
    private String startTimeString;

    @JsonProperty("ENDTIME")
    private String endTimeString;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTargetTimeString() {
        return targetTimeString;
    }

    public void setTargetTimeString(String targetTimeString) {
        this.targetTimeString = targetTimeString;
    }

    public String getNumberNo() {
        return numberNo;
    }

    public void setNumberNo(String numberNo) {
        this.numberNo = numberNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getStartTimeString() {
        return startTimeString;
    }

    public void setStartTimeString(String startTimeString) {
        this.startTimeString = startTimeString;
    }

    public String getEndTimeString() {
        return endTimeString;
    }

    public void setEndTimeString(String endTimeString) {
        this.endTimeString = endTimeString;
    }

}
