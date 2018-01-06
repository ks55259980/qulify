package com.spoonsea.qualitytracing.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BarcodeQueryResult {

	@JsonProperty("rncode")
	private Integer code;
	
	@JsonProperty("rnmsg")
	private String msg;
	
	@JsonProperty("DetailList")
	private List<BarcodeQueryResultDetail> detailList;

	public BarcodeQueryResult() {
		
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

	public List<BarcodeQueryResultDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<BarcodeQueryResultDetail> detailList) {
		this.detailList = detailList;
	}

}
