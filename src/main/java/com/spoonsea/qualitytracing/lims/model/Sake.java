package com.spoonsea.qualitytracing.lims.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the Sake database table.
 * 
 */
@Entity
@NamedQuery(name="Sake.findAll", query="SELECT s FROM Sake s")
public class Sake implements Serializable {
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

	@Column(name="CO2")
	private BigDecimal co2;

	private BigDecimal CO2_RedLowerLimit;

	private BigDecimal CO2_RedUpperLimit;

	private BigDecimal CO2_YellowLowerLimit;

	private BigDecimal CO2_YellowUpperLimit;

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

	@Column(name="[DO]")
	private BigDecimal do_;

	private BigDecimal DO_RedUpperLimit;

	private BigDecimal DO_YellowUpperLimit;

	@Column(name="Fe")
	private BigDecimal fe;

	@Column(name="Fe_RedLowerLimit")
	private BigDecimal fe_RedLowerLimit;

	@Column(name="Fe_RedUpperLimit")
	private BigDecimal fe_RedUpperLimit;

	@Column(name="Fe_YellowLowerLimit")
	private BigDecimal fe_YellowLowerLimit;

	@Column(name="Fe_YellowUpperLimit")
	private BigDecimal fe_YellowUpperLimit;

	@Column(name="Fermentation")
	private String fermentation;

	@Column(name="FullTankTime")
	private String fullTankTime;

	@Column(name="HID")
	private String hid;

	@Column(name="IBU")
	private BigDecimal ibu;

	private BigDecimal IBU_RedLowerLimit;

	private BigDecimal IBU_RedUpperLimit;

	private BigDecimal IBU_YellowLowerLimit;

	private BigDecimal IBU_YellowUpperLimit;

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

	@Column(name="Polyphenols")
	private BigDecimal polyphenols;

	@Column(name="Polyphenols_RedLowerLimit")
	private BigDecimal polyphenols_RedLowerLimit;

	@Column(name="Polyphenols_RedUpperLimit")
	private BigDecimal polyphenols_RedUpperLimit;

	@Column(name="Polyphenols_YellowLowerLimit")
	private BigDecimal polyphenols_YellowLowerLimit;

	@Column(name="Polyphenols_YellowUpperLimit")
	private BigDecimal polyphenols_YellowUpperLimit;

	@Column(name="Quantity")
	private String quantity;

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

	@Column(name="Turbidity25")
	private BigDecimal turbidity25;

	@Column(name="Turbidity25_RedLowerLimit")
	private BigDecimal turbidity25_RedLowerLimit;

	@Column(name="Turbidity25_RedUpperLimit")
	private BigDecimal turbidity25_RedUpperLimit;

	@Column(name="Turbidity25_YellowLowerLimit")
	private BigDecimal turbidity25_YellowLowerLimit;

	@Column(name="Turbidity25_YellowUpperLimit")
	private BigDecimal turbidity25_YellowUpperLimit;

	@Column(name="Turbidity90")
	private BigDecimal turbidity90;

	@Column(name="Turbidity90_RedLowerLimit")
	private BigDecimal turbidity90_RedLowerLimit;

	@Column(name="Turbidity90_RedUpperLimit")
	private BigDecimal turbidity90_RedUpperLimit;

	@Column(name="Turbidity90_YellowLowerLimit")
	private BigDecimal turbidity90_YellowLowerLimit;

	@Column(name="Turbidity90_YellowUpperLimit")
	private BigDecimal turbidity90_YellowUpperLimit;

	@Column(name="Variety")
	private String variety;

	@Column(name="WineID")
	private String wineID;

	@Column(name="Yellow")
	private String yellow;

	public Sake() {
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

	public BigDecimal getDo_() {
		return this.do_;
	}

	public void setDo_(BigDecimal do_) {
		this.do_ = do_;
	}

	public BigDecimal getDO_RedUpperLimit() {
		return this.DO_RedUpperLimit;
	}

	public void setDO_RedUpperLimit(BigDecimal DO_RedUpperLimit) {
		this.DO_RedUpperLimit = DO_RedUpperLimit;
	}

	public BigDecimal getDO_YellowUpperLimit() {
		return this.DO_YellowUpperLimit;
	}

	public void setDO_YellowUpperLimit(BigDecimal DO_YellowUpperLimit) {
		this.DO_YellowUpperLimit = DO_YellowUpperLimit;
	}

	public BigDecimal getFe() {
		return this.fe;
	}

	public void setFe(BigDecimal fe) {
		this.fe = fe;
	}

	public BigDecimal getFe_RedLowerLimit() {
		return this.fe_RedLowerLimit;
	}

	public void setFe_RedLowerLimit(BigDecimal fe_RedLowerLimit) {
		this.fe_RedLowerLimit = fe_RedLowerLimit;
	}

	public BigDecimal getFe_RedUpperLimit() {
		return this.fe_RedUpperLimit;
	}

	public void setFe_RedUpperLimit(BigDecimal fe_RedUpperLimit) {
		this.fe_RedUpperLimit = fe_RedUpperLimit;
	}

	public BigDecimal getFe_YellowLowerLimit() {
		return this.fe_YellowLowerLimit;
	}

	public void setFe_YellowLowerLimit(BigDecimal fe_YellowLowerLimit) {
		this.fe_YellowLowerLimit = fe_YellowLowerLimit;
	}

	public BigDecimal getFe_YellowUpperLimit() {
		return this.fe_YellowUpperLimit;
	}

	public void setFe_YellowUpperLimit(BigDecimal fe_YellowUpperLimit) {
		this.fe_YellowUpperLimit = fe_YellowUpperLimit;
	}

	public String getFermentation() {
		return this.fermentation;
	}

	public void setFermentation(String fermentation) {
		this.fermentation = fermentation;
	}

	public String getFullTankTime() {
		return this.fullTankTime;
	}

	public void setFullTankTime(String fullTankTime) {
		this.fullTankTime = fullTankTime;
	}

	public String getHid() {
		return this.hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public BigDecimal getIbu() {
		return this.ibu;
	}

	public void setIbu(BigDecimal ibu) {
		this.ibu = ibu;
	}

	public BigDecimal getIBU_RedLowerLimit() {
		return this.IBU_RedLowerLimit;
	}

	public void setIBU_RedLowerLimit(BigDecimal IBU_RedLowerLimit) {
		this.IBU_RedLowerLimit = IBU_RedLowerLimit;
	}

	public BigDecimal getIBU_RedUpperLimit() {
		return this.IBU_RedUpperLimit;
	}

	public void setIBU_RedUpperLimit(BigDecimal IBU_RedUpperLimit) {
		this.IBU_RedUpperLimit = IBU_RedUpperLimit;
	}

	public BigDecimal getIBU_YellowLowerLimit() {
		return this.IBU_YellowLowerLimit;
	}

	public void setIBU_YellowLowerLimit(BigDecimal IBU_YellowLowerLimit) {
		this.IBU_YellowLowerLimit = IBU_YellowLowerLimit;
	}

	public BigDecimal getIBU_YellowUpperLimit() {
		return this.IBU_YellowUpperLimit;
	}

	public void setIBU_YellowUpperLimit(BigDecimal IBU_YellowUpperLimit) {
		this.IBU_YellowUpperLimit = IBU_YellowUpperLimit;
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

	public BigDecimal getPolyphenols() {
		return this.polyphenols;
	}

	public void setPolyphenols(BigDecimal polyphenols) {
		this.polyphenols = polyphenols;
	}

	public BigDecimal getPolyphenols_RedLowerLimit() {
		return this.polyphenols_RedLowerLimit;
	}

	public void setPolyphenols_RedLowerLimit(BigDecimal polyphenols_RedLowerLimit) {
		this.polyphenols_RedLowerLimit = polyphenols_RedLowerLimit;
	}

	public BigDecimal getPolyphenols_RedUpperLimit() {
		return this.polyphenols_RedUpperLimit;
	}

	public void setPolyphenols_RedUpperLimit(BigDecimal polyphenols_RedUpperLimit) {
		this.polyphenols_RedUpperLimit = polyphenols_RedUpperLimit;
	}

	public BigDecimal getPolyphenols_YellowLowerLimit() {
		return this.polyphenols_YellowLowerLimit;
	}

	public void setPolyphenols_YellowLowerLimit(BigDecimal polyphenols_YellowLowerLimit) {
		this.polyphenols_YellowLowerLimit = polyphenols_YellowLowerLimit;
	}

	public BigDecimal getPolyphenols_YellowUpperLimit() {
		return this.polyphenols_YellowUpperLimit;
	}

	public void setPolyphenols_YellowUpperLimit(BigDecimal polyphenols_YellowUpperLimit) {
		this.polyphenols_YellowUpperLimit = polyphenols_YellowUpperLimit;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
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

	public BigDecimal getTurbidity25() {
		return this.turbidity25;
	}

	public void setTurbidity25(BigDecimal turbidity25) {
		this.turbidity25 = turbidity25;
	}

	public BigDecimal getTurbidity25_RedLowerLimit() {
		return this.turbidity25_RedLowerLimit;
	}

	public void setTurbidity25_RedLowerLimit(BigDecimal turbidity25_RedLowerLimit) {
		this.turbidity25_RedLowerLimit = turbidity25_RedLowerLimit;
	}

	public BigDecimal getTurbidity25_RedUpperLimit() {
		return this.turbidity25_RedUpperLimit;
	}

	public void setTurbidity25_RedUpperLimit(BigDecimal turbidity25_RedUpperLimit) {
		this.turbidity25_RedUpperLimit = turbidity25_RedUpperLimit;
	}

	public BigDecimal getTurbidity25_YellowLowerLimit() {
		return this.turbidity25_YellowLowerLimit;
	}

	public void setTurbidity25_YellowLowerLimit(BigDecimal turbidity25_YellowLowerLimit) {
		this.turbidity25_YellowLowerLimit = turbidity25_YellowLowerLimit;
	}

	public BigDecimal getTurbidity25_YellowUpperLimit() {
		return this.turbidity25_YellowUpperLimit;
	}

	public void setTurbidity25_YellowUpperLimit(BigDecimal turbidity25_YellowUpperLimit) {
		this.turbidity25_YellowUpperLimit = turbidity25_YellowUpperLimit;
	}

	public BigDecimal getTurbidity90() {
		return this.turbidity90;
	}

	public void setTurbidity90(BigDecimal turbidity90) {
		this.turbidity90 = turbidity90;
	}

	public BigDecimal getTurbidity90_RedLowerLimit() {
		return this.turbidity90_RedLowerLimit;
	}

	public void setTurbidity90_RedLowerLimit(BigDecimal turbidity90_RedLowerLimit) {
		this.turbidity90_RedLowerLimit = turbidity90_RedLowerLimit;
	}

	public BigDecimal getTurbidity90_RedUpperLimit() {
		return this.turbidity90_RedUpperLimit;
	}

	public void setTurbidity90_RedUpperLimit(BigDecimal turbidity90_RedUpperLimit) {
		this.turbidity90_RedUpperLimit = turbidity90_RedUpperLimit;
	}

	public BigDecimal getTurbidity90_YellowLowerLimit() {
		return this.turbidity90_YellowLowerLimit;
	}

	public void setTurbidity90_YellowLowerLimit(BigDecimal turbidity90_YellowLowerLimit) {
		this.turbidity90_YellowLowerLimit = turbidity90_YellowLowerLimit;
	}

	public BigDecimal getTurbidity90_YellowUpperLimit() {
		return this.turbidity90_YellowUpperLimit;
	}

	public void setTurbidity90_YellowUpperLimit(BigDecimal turbidity90_YellowUpperLimit) {
		this.turbidity90_YellowUpperLimit = turbidity90_YellowUpperLimit;
	}

	public String getVariety() {
		return this.variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public String getWineID() {
		return this.wineID;
	}

	public void setWineID(String wineID) {
		this.wineID = wineID;
	}

	public String getYellow() {
		return this.yellow;
	}

	public void setYellow(String yellow) {
		this.yellow = yellow;
	}

}