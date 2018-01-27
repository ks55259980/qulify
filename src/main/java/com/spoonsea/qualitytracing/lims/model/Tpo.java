package com.spoonsea.qualitytracing.lims.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TPO database table.
 * 
 */
@Entity
@Table(name="TPO")
@NamedQuery(name="Tpo.findAll", query="SELECT t FROM Tpo t")
public class Tpo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private String id;

	@Column(name="BottleType")
	private String bottleType;

	@Column(name="CO2")
	private BigDecimal co2;

	private BigDecimal CO2_RedLowerLimit;

	private BigDecimal CO2_RedUpperLimit;

	private BigDecimal CO2_YellowLowerLimit;

	private BigDecimal CO2_YellowUpperLimit;

	private String conclusion;

	private String date;

	@Column(name="Detecting_human")
	private String detecting_human;

	@Column(name="[DO]")
	private BigDecimal do_;

	@Column(name="HID")
	private String hid;

	@Column(name="KpiMark")
	private String kpiMark;

	@Column(name="Pull")
	private String pull;

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

	@Column(name="TPO")
	private BigDecimal tpo;

	private BigDecimal TPO_RedUpperLimit;

	private BigDecimal TPO_YellowUpperLimit;

	@Column(name="Variety")
	private String variety;

	@Column(name="WineValve")
	private BigDecimal wineValve;

	@Column(name="Workshop")
	private String workshop;

	@Column(name="Yellow")
	private String yellow;

	public Tpo() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBottleType() {
		return this.bottleType;
	}

	public void setBottleType(String bottleType) {
		this.bottleType = bottleType;
	}

	public BigDecimal getCo2() {
		return this.co2;
	}

	public void setCo2(BigDecimal co2) {
		this.co2 = co2;
	}

	public BigDecimal getCO2_RedLowerLimit() {
		return this.CO2_RedLowerLimit;
	}

	public void setCO2_RedLowerLimit(BigDecimal CO2_RedLowerLimit) {
		this.CO2_RedLowerLimit = CO2_RedLowerLimit;
	}

	public BigDecimal getCO2_RedUpperLimit() {
		return this.CO2_RedUpperLimit;
	}

	public void setCO2_RedUpperLimit(BigDecimal CO2_RedUpperLimit) {
		this.CO2_RedUpperLimit = CO2_RedUpperLimit;
	}

	public BigDecimal getCO2_YellowLowerLimit() {
		return this.CO2_YellowLowerLimit;
	}

	public void setCO2_YellowLowerLimit(BigDecimal CO2_YellowLowerLimit) {
		this.CO2_YellowLowerLimit = CO2_YellowLowerLimit;
	}

	public BigDecimal getCO2_YellowUpperLimit() {
		return this.CO2_YellowUpperLimit;
	}

	public void setCO2_YellowUpperLimit(BigDecimal CO2_YellowUpperLimit) {
		this.CO2_YellowUpperLimit = CO2_YellowUpperLimit;
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

	public BigDecimal getDo_() {
		return this.do_;
	}

	public void setDo_(BigDecimal do_) {
		this.do_ = do_;
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

	public String getPull() {
		return this.pull;
	}

	public void setPull(String pull) {
		this.pull = pull;
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

	public BigDecimal getTpo() {
		return this.tpo;
	}

	public void setTpo(BigDecimal tpo) {
		this.tpo = tpo;
	}

	public BigDecimal getTPO_RedUpperLimit() {
		return this.TPO_RedUpperLimit;
	}

	public void setTPO_RedUpperLimit(BigDecimal TPO_RedUpperLimit) {
		this.TPO_RedUpperLimit = TPO_RedUpperLimit;
	}

	public BigDecimal getTPO_YellowUpperLimit() {
		return this.TPO_YellowUpperLimit;
	}

	public void setTPO_YellowUpperLimit(BigDecimal TPO_YellowUpperLimit) {
		this.TPO_YellowUpperLimit = TPO_YellowUpperLimit;
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