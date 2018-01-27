package com.spoonsea.qualitytracing.lims.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the Wort database table.
 * 
 */
@Entity
@NamedQuery(name="Wort.findAll", query="SELECT w FROM Wort w")
public class Wort implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private String id;

	@Column(name="Bitterness")
	private BigDecimal bitterness;

	@Column(name="Bitterness_RedLowerLimit")
	private BigDecimal bitterness_RedLowerLimit;

	@Column(name="Bitterness_RedUpperLimit")
	private BigDecimal bitterness_RedUpperLimit;

	@Column(name="Bitterness_YellowLowerLimit")
	private BigDecimal bitterness_YellowLowerLimit;

	@Column(name="Bitterness_YellowUpperLimit")
	private BigDecimal bitterness_YellowUpperLimit;

	@Column(name="Calcium")
	private BigDecimal calcium;

	@Column(name="Calcium_RedLowerLimit")
	private BigDecimal calcium_RedLowerLimit;

	@Column(name="Calcium_RedUpperLimit")
	private BigDecimal calcium_RedUpperLimit;

	@Column(name="Calcium_YellowLowerLimit")
	private BigDecimal calcium_YellowLowerLimit;

	@Column(name="Calcium_YellowUpperLimit")
	private BigDecimal calcium_YellowUpperLimit;

	@Column(name="Colour")
	private BigDecimal colour;

	@Column(name="Colour_RedLowerLimit")
	private BigDecimal colour_RedLowerLimit;

	@Column(name="Colour_RedUpperLimit")
	private BigDecimal colour_RedUpperLimit;

	@Column(name="Colour_YellowLowerLimit")
	private BigDecimal colour_YellowLowerLimit;

	@Column(name="Colour_YellowUpperLimit")
	private BigDecimal colour_YellowUpperLimit;

	private String conclusion;

	private String date;

	@Column(name="Detecting_human")
	private String detecting_human;

	@Column(name="FAN")
	private BigDecimal fan;

	private BigDecimal FAN_YellowLowerLimit;

	private BigDecimal FAN_YellowUpperLimit;

	@Column(name="Fermentation")
	private String fermentation;

	@Column(name="HID")
	private String hid;

	private String hops;

	@Column(name="KpiMark")
	private String kpiMark;

	private String malt;

	@Column(name="OG")
	private BigDecimal og;

	private BigDecimal OG_RedLowerLimit;

	private BigDecimal OG_RedUpperLimit;

	private BigDecimal OG_YellowLowerLimit;

	private BigDecimal OG_YellowUpperLimit;

	@Column(name="PH")
	private BigDecimal ph;

	private BigDecimal PH_RedLowerLimit;

	private BigDecimal PH_RedUpperLimit;

	private BigDecimal PH_YellowLowerLimit;

	private BigDecimal PH_YellowUpperLimit;

	@Column(name="PotNumber")
	private String potNumber;

	@Column(name="Red")
	private String red;

	@Column(name="Remark")
	private String remark;

	@Column(name="Reviewer")
	private String reviewer;

	@Column(name="Rice")
	private String rice;

	@Column(name="RID")
	private BigDecimal rid;

	@Column(name="SID")
	private String sid;

	@Column(name="Sodium")
	private BigDecimal sodium;

	@Column(name="Sodium_RedLowerLimit")
	private BigDecimal sodium_RedLowerLimit;

	@Column(name="Sodium_RedUpperLimit")
	private BigDecimal sodium_RedUpperLimit;

	@Column(name="Sodium_YellowLowerLimit")
	private BigDecimal sodium_YellowLowerLimit;

	@Column(name="Sodium_YellowUpperLimit")
	private BigDecimal sodium_YellowUpperLimit;

	@Column(name="STID")
	private String stid;

	@Column(name="TotalAcid")
	private BigDecimal totalAcid;

	@Column(name="TotalAcid_RedLowerLimit")
	private BigDecimal totalAcid_RedLowerLimit;

	@Column(name="TotalAcid_RedUpperLimit")
	private BigDecimal totalAcid_RedUpperLimit;

	@Column(name="TotalAcid_YellowLowerLimit")
	private BigDecimal totalAcid_YellowLowerLimit;

	@Column(name="TotalAcid_YellowUpperLimit")
	private BigDecimal totalAcid_YellowUpperLimit;

	@Column(name="Variety")
	private String variety;

	@Column(name="Yellow")
	private String yellow;

	public Wort() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getBitterness() {
		return this.bitterness;
	}

	public void setBitterness(BigDecimal bitterness) {
		this.bitterness = bitterness;
	}

	public BigDecimal getBitterness_RedLowerLimit() {
		return this.bitterness_RedLowerLimit;
	}

	public void setBitterness_RedLowerLimit(BigDecimal bitterness_RedLowerLimit) {
		this.bitterness_RedLowerLimit = bitterness_RedLowerLimit;
	}

	public BigDecimal getBitterness_RedUpperLimit() {
		return this.bitterness_RedUpperLimit;
	}

	public void setBitterness_RedUpperLimit(BigDecimal bitterness_RedUpperLimit) {
		this.bitterness_RedUpperLimit = bitterness_RedUpperLimit;
	}

	public BigDecimal getBitterness_YellowLowerLimit() {
		return this.bitterness_YellowLowerLimit;
	}

	public void setBitterness_YellowLowerLimit(BigDecimal bitterness_YellowLowerLimit) {
		this.bitterness_YellowLowerLimit = bitterness_YellowLowerLimit;
	}

	public BigDecimal getBitterness_YellowUpperLimit() {
		return this.bitterness_YellowUpperLimit;
	}

	public void setBitterness_YellowUpperLimit(BigDecimal bitterness_YellowUpperLimit) {
		this.bitterness_YellowUpperLimit = bitterness_YellowUpperLimit;
	}

	public BigDecimal getCalcium() {
		return this.calcium;
	}

	public void setCalcium(BigDecimal calcium) {
		this.calcium = calcium;
	}

	public BigDecimal getCalcium_RedLowerLimit() {
		return this.calcium_RedLowerLimit;
	}

	public void setCalcium_RedLowerLimit(BigDecimal calcium_RedLowerLimit) {
		this.calcium_RedLowerLimit = calcium_RedLowerLimit;
	}

	public BigDecimal getCalcium_RedUpperLimit() {
		return this.calcium_RedUpperLimit;
	}

	public void setCalcium_RedUpperLimit(BigDecimal calcium_RedUpperLimit) {
		this.calcium_RedUpperLimit = calcium_RedUpperLimit;
	}

	public BigDecimal getCalcium_YellowLowerLimit() {
		return this.calcium_YellowLowerLimit;
	}

	public void setCalcium_YellowLowerLimit(BigDecimal calcium_YellowLowerLimit) {
		this.calcium_YellowLowerLimit = calcium_YellowLowerLimit;
	}

	public BigDecimal getCalcium_YellowUpperLimit() {
		return this.calcium_YellowUpperLimit;
	}

	public void setCalcium_YellowUpperLimit(BigDecimal calcium_YellowUpperLimit) {
		this.calcium_YellowUpperLimit = calcium_YellowUpperLimit;
	}

	public BigDecimal getColour() {
		return this.colour;
	}

	public void setColour(BigDecimal colour) {
		this.colour = colour;
	}

	public BigDecimal getColour_RedLowerLimit() {
		return this.colour_RedLowerLimit;
	}

	public void setColour_RedLowerLimit(BigDecimal colour_RedLowerLimit) {
		this.colour_RedLowerLimit = colour_RedLowerLimit;
	}

	public BigDecimal getColour_RedUpperLimit() {
		return this.colour_RedUpperLimit;
	}

	public void setColour_RedUpperLimit(BigDecimal colour_RedUpperLimit) {
		this.colour_RedUpperLimit = colour_RedUpperLimit;
	}

	public BigDecimal getColour_YellowLowerLimit() {
		return this.colour_YellowLowerLimit;
	}

	public void setColour_YellowLowerLimit(BigDecimal colour_YellowLowerLimit) {
		this.colour_YellowLowerLimit = colour_YellowLowerLimit;
	}

	public BigDecimal getColour_YellowUpperLimit() {
		return this.colour_YellowUpperLimit;
	}

	public void setColour_YellowUpperLimit(BigDecimal colour_YellowUpperLimit) {
		this.colour_YellowUpperLimit = colour_YellowUpperLimit;
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

	public BigDecimal getFan() {
		return this.fan;
	}

	public void setFan(BigDecimal fan) {
		this.fan = fan;
	}

	public BigDecimal getFAN_YellowLowerLimit() {
		return this.FAN_YellowLowerLimit;
	}

	public void setFAN_YellowLowerLimit(BigDecimal FAN_YellowLowerLimit) {
		this.FAN_YellowLowerLimit = FAN_YellowLowerLimit;
	}

	public BigDecimal getFAN_YellowUpperLimit() {
		return this.FAN_YellowUpperLimit;
	}

	public void setFAN_YellowUpperLimit(BigDecimal FAN_YellowUpperLimit) {
		this.FAN_YellowUpperLimit = FAN_YellowUpperLimit;
	}

	public String getFermentation() {
		return this.fermentation;
	}

	public void setFermentation(String fermentation) {
		this.fermentation = fermentation;
	}

	public String getHid() {
		return this.hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getHops() {
		return this.hops;
	}

	public void setHops(String hops) {
		this.hops = hops;
	}

	public String getKpiMark() {
		return this.kpiMark;
	}

	public void setKpiMark(String kpiMark) {
		this.kpiMark = kpiMark;
	}

	public String getMalt() {
		return this.malt;
	}

	public void setMalt(String malt) {
		this.malt = malt;
	}

	public BigDecimal getOg() {
		return this.og;
	}

	public void setOg(BigDecimal og) {
		this.og = og;
	}

	public BigDecimal getOG_RedLowerLimit() {
		return this.OG_RedLowerLimit;
	}

	public void setOG_RedLowerLimit(BigDecimal OG_RedLowerLimit) {
		this.OG_RedLowerLimit = OG_RedLowerLimit;
	}

	public BigDecimal getOG_RedUpperLimit() {
		return this.OG_RedUpperLimit;
	}

	public void setOG_RedUpperLimit(BigDecimal OG_RedUpperLimit) {
		this.OG_RedUpperLimit = OG_RedUpperLimit;
	}

	public BigDecimal getOG_YellowLowerLimit() {
		return this.OG_YellowLowerLimit;
	}

	public void setOG_YellowLowerLimit(BigDecimal OG_YellowLowerLimit) {
		this.OG_YellowLowerLimit = OG_YellowLowerLimit;
	}

	public BigDecimal getOG_YellowUpperLimit() {
		return this.OG_YellowUpperLimit;
	}

	public void setOG_YellowUpperLimit(BigDecimal OG_YellowUpperLimit) {
		this.OG_YellowUpperLimit = OG_YellowUpperLimit;
	}

	public BigDecimal getPh() {
		return this.ph;
	}

	public void setPh(BigDecimal ph) {
		this.ph = ph;
	}

	public BigDecimal getPH_RedLowerLimit() {
		return this.PH_RedLowerLimit;
	}

	public void setPH_RedLowerLimit(BigDecimal PH_RedLowerLimit) {
		this.PH_RedLowerLimit = PH_RedLowerLimit;
	}

	public BigDecimal getPH_RedUpperLimit() {
		return this.PH_RedUpperLimit;
	}

	public void setPH_RedUpperLimit(BigDecimal PH_RedUpperLimit) {
		this.PH_RedUpperLimit = PH_RedUpperLimit;
	}

	public BigDecimal getPH_YellowLowerLimit() {
		return this.PH_YellowLowerLimit;
	}

	public void setPH_YellowLowerLimit(BigDecimal PH_YellowLowerLimit) {
		this.PH_YellowLowerLimit = PH_YellowLowerLimit;
	}

	public BigDecimal getPH_YellowUpperLimit() {
		return this.PH_YellowUpperLimit;
	}

	public void setPH_YellowUpperLimit(BigDecimal PH_YellowUpperLimit) {
		this.PH_YellowUpperLimit = PH_YellowUpperLimit;
	}

	public String getPotNumber() {
		return this.potNumber;
	}

	public void setPotNumber(String potNumber) {
		this.potNumber = potNumber;
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

	public String getRice() {
		return this.rice;
	}

	public void setRice(String rice) {
		this.rice = rice;
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

	public BigDecimal getSodium() {
		return this.sodium;
	}

	public void setSodium(BigDecimal sodium) {
		this.sodium = sodium;
	}

	public BigDecimal getSodium_RedLowerLimit() {
		return this.sodium_RedLowerLimit;
	}

	public void setSodium_RedLowerLimit(BigDecimal sodium_RedLowerLimit) {
		this.sodium_RedLowerLimit = sodium_RedLowerLimit;
	}

	public BigDecimal getSodium_RedUpperLimit() {
		return this.sodium_RedUpperLimit;
	}

	public void setSodium_RedUpperLimit(BigDecimal sodium_RedUpperLimit) {
		this.sodium_RedUpperLimit = sodium_RedUpperLimit;
	}

	public BigDecimal getSodium_YellowLowerLimit() {
		return this.sodium_YellowLowerLimit;
	}

	public void setSodium_YellowLowerLimit(BigDecimal sodium_YellowLowerLimit) {
		this.sodium_YellowLowerLimit = sodium_YellowLowerLimit;
	}

	public BigDecimal getSodium_YellowUpperLimit() {
		return this.sodium_YellowUpperLimit;
	}

	public void setSodium_YellowUpperLimit(BigDecimal sodium_YellowUpperLimit) {
		this.sodium_YellowUpperLimit = sodium_YellowUpperLimit;
	}

	public String getStid() {
		return this.stid;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}

	public BigDecimal getTotalAcid() {
		return this.totalAcid;
	}

	public void setTotalAcid(BigDecimal totalAcid) {
		this.totalAcid = totalAcid;
	}

	public BigDecimal getTotalAcid_RedLowerLimit() {
		return this.totalAcid_RedLowerLimit;
	}

	public void setTotalAcid_RedLowerLimit(BigDecimal totalAcid_RedLowerLimit) {
		this.totalAcid_RedLowerLimit = totalAcid_RedLowerLimit;
	}

	public BigDecimal getTotalAcid_RedUpperLimit() {
		return this.totalAcid_RedUpperLimit;
	}

	public void setTotalAcid_RedUpperLimit(BigDecimal totalAcid_RedUpperLimit) {
		this.totalAcid_RedUpperLimit = totalAcid_RedUpperLimit;
	}

	public BigDecimal getTotalAcid_YellowLowerLimit() {
		return this.totalAcid_YellowLowerLimit;
	}

	public void setTotalAcid_YellowLowerLimit(BigDecimal totalAcid_YellowLowerLimit) {
		this.totalAcid_YellowLowerLimit = totalAcid_YellowLowerLimit;
	}

	public BigDecimal getTotalAcid_YellowUpperLimit() {
		return this.totalAcid_YellowUpperLimit;
	}

	public void setTotalAcid_YellowUpperLimit(BigDecimal totalAcid_YellowUpperLimit) {
		this.totalAcid_YellowUpperLimit = totalAcid_YellowUpperLimit;
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