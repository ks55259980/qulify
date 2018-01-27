package com.spoonsea.qualitytracing.lims.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the Rice database table.
 * 
 */
@Entity
@NamedQuery(name="Rice.findAll", query="SELECT r FROM Rice r")
public class Rice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private String id;

	@Column(name="ArrivalDate")
	private String arrivalDate;

	private String batch;

	@Column(name="Carnumber")
	private String carnumber;

	@Column(name="Color")
	private String color;

	private String conclusion;

	private String date;

	@Column(name="Detecting_human")
	private String detecting_human;

	@Column(name="Exterior")
	private String exterior;

	@Column(name="Factory")
	private String factory;

	@Column(name="Freshness")
	private BigDecimal freshness;

	@Column(name="Freshness_RedLowerLimit")
	private BigDecimal freshness_RedLowerLimit;

	@Column(name="Freshness_RedUpperLimit")
	private BigDecimal freshness_RedUpperLimit;

	@Column(name="Freshness_YellowLowerLimit")
	private BigDecimal freshness_YellowLowerLimit;

	@Column(name="Freshness_YellowUpperLimit")
	private BigDecimal freshness_YellowUpperLimit;

	@Column(name="HID")
	private String hid;

	@Column(name="KpiMark")
	private String kpiMark;

	@Column(name="Location")
	private String location;

	private String odor;

	@Column(name="ProductionDate")
	private String productionDate;

	@Column(name="Red")
	private String red;

	@Column(name="Remark")
	private String remark;

	@Column(name="Reviewer")
	private String reviewer;

	@Column(name="RID")
	private BigDecimal rid;

	@Column(name="SID")
	private String sid;

	@Column(name="STID")
	private String stid;

	@Column(name="Tasting")
	private BigDecimal tasting;

	@Column(name="Tasting_RedLowerLimit")
	private BigDecimal tasting_RedLowerLimit;

	@Column(name="Tasting_RedUpperLimit")
	private BigDecimal tasting_RedUpperLimit;

	@Column(name="Tasting_YellowLowerLimit")
	private BigDecimal tasting_YellowLowerLimit;

	@Column(name="Tasting_YellowUpperLimit")
	private BigDecimal tasting_YellowUpperLimit;

	@Column(name="Variety")
	private String variety;

	@Column(name="Yellow")
	private String yellow;

	public Rice() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArrivalDate() {
		return this.arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getBatch() {
		return this.batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getCarnumber() {
		return this.carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getConclusion() {
		return this.conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDetecting_human() {
		return this.detecting_human;
	}

	public void setDetecting_human(String detecting_human) {
		this.detecting_human = detecting_human;
	}

	public String getExterior() {
		return this.exterior;
	}

	public void setExterior(String exterior) {
		this.exterior = exterior;
	}

	public String getFactory() {
		return this.factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public BigDecimal getFreshness() {
		return this.freshness;
	}

	public void setFreshness(BigDecimal freshness) {
		this.freshness = freshness;
	}

	public BigDecimal getFreshness_RedLowerLimit() {
		return this.freshness_RedLowerLimit;
	}

	public void setFreshness_RedLowerLimit(BigDecimal freshness_RedLowerLimit) {
		this.freshness_RedLowerLimit = freshness_RedLowerLimit;
	}

	public BigDecimal getFreshness_RedUpperLimit() {
		return this.freshness_RedUpperLimit;
	}

	public void setFreshness_RedUpperLimit(BigDecimal freshness_RedUpperLimit) {
		this.freshness_RedUpperLimit = freshness_RedUpperLimit;
	}

	public BigDecimal getFreshness_YellowLowerLimit() {
		return this.freshness_YellowLowerLimit;
	}

	public void setFreshness_YellowLowerLimit(BigDecimal freshness_YellowLowerLimit) {
		this.freshness_YellowLowerLimit = freshness_YellowLowerLimit;
	}

	public BigDecimal getFreshness_YellowUpperLimit() {
		return this.freshness_YellowUpperLimit;
	}

	public void setFreshness_YellowUpperLimit(BigDecimal freshness_YellowUpperLimit) {
		this.freshness_YellowUpperLimit = freshness_YellowUpperLimit;
	}

	public String getHid() {
		return this.hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getKpiMark() {
		return this.kpiMark;
	}

	public void setKpiMark(String kpiMark) {
		this.kpiMark = kpiMark;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOdor() {
		return this.odor;
	}

	public void setOdor(String odor) {
		this.odor = odor;
	}

	public String getProductionDate() {
		return this.productionDate;
	}

	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}

	public String getRed() {
		return this.red;
	}

	public void setRed(String red) {
		this.red = red;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReviewer() {
		return this.reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public BigDecimal getRid() {
		return this.rid;
	}

	public void setRid(BigDecimal rid) {
		this.rid = rid;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getStid() {
		return this.stid;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}

	public BigDecimal getTasting() {
		return this.tasting;
	}

	public void setTasting(BigDecimal tasting) {
		this.tasting = tasting;
	}

	public BigDecimal getTasting_RedLowerLimit() {
		return this.tasting_RedLowerLimit;
	}

	public void setTasting_RedLowerLimit(BigDecimal tasting_RedLowerLimit) {
		this.tasting_RedLowerLimit = tasting_RedLowerLimit;
	}

	public BigDecimal getTasting_RedUpperLimit() {
		return this.tasting_RedUpperLimit;
	}

	public void setTasting_RedUpperLimit(BigDecimal tasting_RedUpperLimit) {
		this.tasting_RedUpperLimit = tasting_RedUpperLimit;
	}

	public BigDecimal getTasting_YellowLowerLimit() {
		return this.tasting_YellowLowerLimit;
	}

	public void setTasting_YellowLowerLimit(BigDecimal tasting_YellowLowerLimit) {
		this.tasting_YellowLowerLimit = tasting_YellowLowerLimit;
	}

	public BigDecimal getTasting_YellowUpperLimit() {
		return this.tasting_YellowUpperLimit;
	}

	public void setTasting_YellowUpperLimit(BigDecimal tasting_YellowUpperLimit) {
		this.tasting_YellowUpperLimit = tasting_YellowUpperLimit;
	}

	public String getVariety() {
		return this.variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public String getYellow() {
		return this.yellow;
	}

	public void setYellow(String yellow) {
		this.yellow = yellow;
	}

}