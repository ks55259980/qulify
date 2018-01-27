package com.spoonsea.qualitytracing.lims.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CapacityTba database table.
 * 
 */
@Entity
@NamedQuery(name="CapacityTba.findAll", query="SELECT c FROM CapacityTba c")
public class CapacityTba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private String id;

	@Column(name="Avalue")
	private BigDecimal avalue;

	@Column(name="Avalue_RedLowerLimit")
	private BigDecimal avalue_RedLowerLimit;

	@Column(name="BottleType")
	private String bottleType;

	@Column(name="Capacity")
	private BigDecimal capacity;

	@Column(name="Capacity_RedLowerLimit")
	private BigDecimal capacity_RedLowerLimit;

	@Column(name="Capacity_YellowLowerLimit")
	private BigDecimal capacity_YellowLowerLimit;

	@Column(name="Capacity_YellowUpperLimit")
	private BigDecimal capacity_YellowUpperLimit;

	private String conclusion;

	private String date;

	@Column(name="Density")
	private BigDecimal density;

	@Column(name="Detecting_human")
	private String detecting_human;

	@Column(name="EmptyBottles")
	private BigDecimal emptyBottles;

	@Column(name="FullBottle")
	private BigDecimal fullBottle;

	@Column(name="HID")
	private String hid;

	@Column(name="KpiMark")
	private String kpiMark;

	@Column(name="Red")
	private String red;

	@Column(name="Remark")
	private String remark;

	@Column(name="Reviewer")
	private String reviewer;

	@Column(name="RID")
	private BigDecimal rid;

	@Column(name="SakeTank")
	private String sakeTank;

	@Column(name="SID")
	private String sid;

	@Column(name="STID")
	private String stid;

	private String time;

	@Column(name="Variety")
	private String variety;

	@Column(name="WineValve")
	private BigDecimal wineValve;

	@Column(name="Workshop")
	private String workshop;

	@Column(name="Yellow")
	private String yellow;

	public CapacityTba() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getAvalue() {
		return this.avalue;
	}

	public void setAvalue(BigDecimal avalue) {
		this.avalue = avalue;
	}

	public BigDecimal getAvalue_RedLowerLimit() {
		return this.avalue_RedLowerLimit;
	}

	public void setAvalue_RedLowerLimit(BigDecimal avalue_RedLowerLimit) {
		this.avalue_RedLowerLimit = avalue_RedLowerLimit;
	}

	public String getBottleType() {
		return this.bottleType;
	}

	public void setBottleType(String bottleType) {
		this.bottleType = bottleType;
	}

	public BigDecimal getCapacity() {
		return this.capacity;
	}

	public void setCapacity(BigDecimal capacity) {
		this.capacity = capacity;
	}

	public BigDecimal getCapacity_RedLowerLimit() {
		return this.capacity_RedLowerLimit;
	}

	public void setCapacity_RedLowerLimit(BigDecimal capacity_RedLowerLimit) {
		this.capacity_RedLowerLimit = capacity_RedLowerLimit;
	}

	public BigDecimal getCapacity_YellowLowerLimit() {
		return this.capacity_YellowLowerLimit;
	}

	public void setCapacity_YellowLowerLimit(BigDecimal capacity_YellowLowerLimit) {
		this.capacity_YellowLowerLimit = capacity_YellowLowerLimit;
	}

	public BigDecimal getCapacity_YellowUpperLimit() {
		return this.capacity_YellowUpperLimit;
	}

	public void setCapacity_YellowUpperLimit(BigDecimal capacity_YellowUpperLimit) {
		this.capacity_YellowUpperLimit = capacity_YellowUpperLimit;
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

	public BigDecimal getDensity() {
		return this.density;
	}

	public void setDensity(BigDecimal density) {
		this.density = density;
	}

	public String getDetecting_human() {
		return this.detecting_human;
	}

	public void setDetecting_human(String detecting_human) {
		this.detecting_human = detecting_human;
	}

	public BigDecimal getEmptyBottles() {
		return this.emptyBottles;
	}

	public void setEmptyBottles(BigDecimal emptyBottles) {
		this.emptyBottles = emptyBottles;
	}

	public BigDecimal getFullBottle() {
		return this.fullBottle;
	}

	public void setFullBottle(BigDecimal fullBottle) {
		this.fullBottle = fullBottle;
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

	public String getSakeTank() {
		return this.sakeTank;
	}

	public void setSakeTank(String sakeTank) {
		this.sakeTank = sakeTank;
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

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVariety() {
		return this.variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public BigDecimal getWineValve() {
		return this.wineValve;
	}

	public void setWineValve(BigDecimal wineValve) {
		this.wineValve = wineValve;
	}

	public String getWorkshop() {
		return this.workshop;
	}

	public void setWorkshop(String workshop) {
		this.workshop = workshop;
	}

	public String getYellow() {
		return this.yellow;
	}

	public void setYellow(String yellow) {
		this.yellow = yellow;
	}

}