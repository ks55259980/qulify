package com.spoonsea.qualitytracing.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


public class BarcodeQueryResult {

    @JsonProperty("rncode")
    private Integer code;

    @JsonProperty("rnmsg")
    private String msg;

    @JsonProperty("DetailList")
    private List<BarcodeQueryResultDetail> detailList;

    @JsonProperty("dealerList")
    private List<String> dealerList;

    public BarcodeQueryResult() {

    }

    public BarcodeQueryResult(Integer code, String msg, List<BarcodeQueryResultDetail> detailList,
            List<String> dealerList) {
        this.code = code;
        this.msg = msg;
        this.detailList = detailList;
        this.dealerList = dealerList;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @JsonInclude(Include.NON_NULL)
    public List<BarcodeQueryResultDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<BarcodeQueryResultDetail> detailList) {
        this.detailList = detailList;
    }

    @JsonInclude(Include.NON_NULL)
    public List<String> getDealerList() {
        return dealerList;
    }

    public void setDealerList(List<String> dealerList) {
        this.dealerList = dealerList;
    }

}
