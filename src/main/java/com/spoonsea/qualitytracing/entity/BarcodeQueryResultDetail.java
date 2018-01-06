package com.spoonsea.qualitytracing.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;


public class BarcodeQueryResultDetail {
	
	@JsonProperty("TYPE")
	private String type;
	
	@JsonProperty("TIME")
	private Date time;
	
	@JsonProperty("NUMBERNO")
	private String numberNo;
	
	@JsonProperty("CODE")
	private String code;
	
	@JsonProperty("NAME")
	private String name;
	
	@JsonProperty("AREA")
	private String area;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
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

}
