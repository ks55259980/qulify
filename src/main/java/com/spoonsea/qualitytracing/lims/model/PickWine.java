package com.spoonsea.qualitytracing.lims.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PickWine database table.
 * 
 */
@Entity
@NamedQuery(name="PickWine.findAll", query="SELECT p FROM PickWine p")
public class PickWine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private String id;

	@Column(name="AE")
	private BigDecimal ae;

	private BigDecimal AE_RedLowerLimit;

	private BigDecimal AE_RedUpperLimit;

	private BigDecimal AE_YellowLowerLimit;

	private BigDecimal AE_YellowUpperLimit;

	@Column(name="Age")
	private String age;

	@Column(name="Alcohol")
	private BigDecimal alcohol;

	@Column(name="Alcohol_RedLowerLimit")
	private BigDecimal alcohol_RedLowerLimit;

	@Column(name="Alcohol_RedUpperLimit")
	private BigDecimal alcohol_RedUpperLimit;

	@Column(name="Alcohol_YellowLowerLimit")
	private BigDecimal alcohol_YellowLowerLimit;

	@Column(name="Alcohol_YellowUpperLimit")
	private BigDecimal alcohol_YellowUpperLimit;

	private String conclusion;

	private String date;

	@Column(name="Detecting_human")
	private String detecting_human;

	@Column(name="Fermentation")
	private String fermentation;

	@Column(name="Foam")
	private BigDecimal foam;

	@Column(name="Foam_RedLowerLimit")
	private BigDecimal foam_RedLowerLimit;

	@Column(name="Foam_RedUpperLimit")
	private BigDecimal foam_RedUpperLimit;

	@Column(name="Foam_YellowLowerLimit")
	private BigDecimal foam_YellowLowerLimit;

	@Column(name="Foam_YellowUpperLimit")
	private BigDecimal foam_YellowUpperLimit;

	@Column(name="HID")
	private String hid;

	@Column(name="KpiMark")
	private String kpiMark;

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

	@Column(name="RDF")
	private BigDecimal rdf;

	private BigDecimal RDF_RedLowerLimit;

	private BigDecimal RDF_RedUpperLimit;

	private BigDecimal RDF_YellowLowerLimit;

	private BigDecimal RDF_YellowUpperLimit;

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

	@Column(name="Variety")
	private String variety;

	private String workshop;

	@Column(name="Yellow")
	private String yellow;

	public PickWine() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getAe() {
		return this.ae;
	}

	public void setAe(BigDecimal ae) {
		this.ae = ae;
	}

	public BigDecimal getAE_RedLowerLimit() {
		return this.AE_RedLowerLimit;
	}

	public void setAE_RedLowerLimit(BigDecimal AE_RedLowerLimit) {
		this.AE_RedLowerLimit = AE_RedLowerLimit;
	}

	public BigDecimal getAE_RedUpperLimit() {
		return this.AE_RedUpperLimit;
	}

	public void setAE_RedUpperLimit(BigDecimal AE_RedUpperLimit) {
		this.AE_RedUpperLimit = AE_RedUpperLimit;
	}

	public BigDecimal getAE_YellowLowerLimit() {
		return this.AE_YellowLowerLimit;
	}

	public void setAE_YellowLowerLimit(BigDecimal AE_YellowLowerLimit) {
		this.AE_YellowLowerLimit = AE_YellowLowerLimit;
	}

	public BigDecimal getAE_YellowUpperLimit() {
		return this.AE_YellowUpperLimit;
	}

	public void setAE_YellowUpperLimit(BigDecimal AE_YellowUpperLimit) {
		this.AE_YellowUpperLimit = AE_YellowUpperLimit;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public BigDecimal getAlcohol() {
		return this.alcohol;
	}

	public void setAlcohol(BigDecimal alcohol) {
		this.alcohol = alcohol;
	}

	public BigDecimal getAlcohol_RedLowerLimit() {
		return this.alcohol_RedLowerLimit;
	}

	public void setAlcohol_RedLowerLimit(BigDecimal alcohol_RedLowerLimit) {
		this.alcohol_RedLowerLimit = alcohol_RedLowerLimit;
	}

	public BigDecimal getAlcohol_RedUpperLimit() {
		return this.alcohol_RedUpperLimit;
	}

	public void setAlcohol_RedUpperLimit(BigDecimal alcohol_RedUpperLimit) {
		this.alcohol_RedUpperLimit = alcohol_RedUpperLimit;
	}

	public BigDecimal getAlcohol_YellowLowerLimit() {
		return this.alcohol_YellowLowerLimit;
	}

	public void setAlcohol_YellowLowerLimit(BigDecimal alcohol_YellowLowerLimit) {
		this.alcohol_YellowLowerLimit = alcohol_YellowLowerLimit;
	}

	public BigDecimal getAlcohol_YellowUpperLimit() {
		return this.alcohol_YellowUpperLimit;
	}

	public void setAlcohol_YellowUpperLimit(BigDecimal alcohol_YellowUpperLimit) {
		this.alcohol_YellowUpperLimit = alcohol_YellowUpperLimit;
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

	public String getFermentation() {
		return this.fermentation;
	}

	public void setFermentation(String fermentation) {
		this.fermentation = fermentation;
	}

	public BigDecimal getFoam() {
		return this.foam;
	}

	public void setFoam(BigDecimal foam) {
		this.foam = foam;
	}

	public BigDecimal getFoam_RedLowerLimit() {
		return this.foam_RedLowerLimit;
	}

	public void setFoam_RedLowerLimit(BigDecimal foam_RedLowerLimit) {
		this.foam_RedLowerLimit = foam_RedLowerLimit;
	}

	public BigDecimal getFoam_RedUpperLimit() {
		return this.foam_RedUpperLimit;
	}

	public void setFoam_RedUpperLimit(BigDecimal foam_RedUpperLimit) {
		this.foam_RedUpperLimit = foam_RedUpperLimit;
	}

	public BigDecimal getFoam_YellowLowerLimit() {
		return this.foam_YellowLowerLimit;
	}

	public void setFoam_YellowLowerLimit(BigDecimal foam_YellowLowerLimit) {
		this.foam_YellowLowerLimit = foam_YellowLowerLimit;
	}

	public BigDecimal getFoam_YellowUpperLimit() {
		return this.foam_YellowUpperLimit;
	}

	public void setFoam_YellowUpperLimit(BigDecimal foam_YellowUpperLimit) {
		this.foam_YellowUpperLimit = foam_YellowUpperLimit;
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

	public BigDecimal getRdf() {
		return this.rdf;
	}

	public void setRdf(BigDecimal rdf) {
		this.rdf = rdf;
	}

	public BigDecimal getRDF_RedLowerLimit() {
		return this.RDF_RedLowerLimit;
	}

	public void setRDF_RedLowerLimit(BigDecimal RDF_RedLowerLimit) {
		this.RDF_RedLowerLimit = RDF_RedLowerLimit;
	}

	public BigDecimal getRDF_RedUpperLimit() {
		return this.RDF_RedUpperLimit;
	}

	public void setRDF_RedUpperLimit(BigDecimal RDF_RedUpperLimit) {
		this.RDF_RedUpperLimit = RDF_RedUpperLimit;
	}

	public BigDecimal getRDF_YellowLowerLimit() {
		return this.RDF_YellowLowerLimit;
	}

	public void setRDF_YellowLowerLimit(BigDecimal RDF_YellowLowerLimit) {
		this.RDF_YellowLowerLimit = RDF_YellowLowerLimit;
	}

	public BigDecimal getRDF_YellowUpperLimit() {
		return this.RDF_YellowUpperLimit;
	}

	public void setRDF_YellowUpperLimit(BigDecimal RDF_YellowUpperLimit) {
		this.RDF_YellowUpperLimit = RDF_YellowUpperLimit;
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

	public String getVariety() {
		return this.variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
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