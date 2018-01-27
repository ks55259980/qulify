package com.spoonsea.qualitytracing.lims.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the Malt database table.
 * 
 */
@Entity
@NamedQuery(name="Malt.findAll", query="SELECT m FROM Malt m")
public class Malt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private String id;

	@Column(name="BakedTime")
	private String bakedTime;

	private String batch;

	@Column(name="BetaGlucan")
	private BigDecimal betaGlucan;

	@Column(name="BetaGlucan_RedLowerLimit")
	private BigDecimal betaGlucan_RedLowerLimit;

	@Column(name="BetaGlucan_RedUpperLimit")
	private BigDecimal betaGlucan_RedUpperLimit;

	@Column(name="BetaGlucan_YellowLowerLimit")
	private BigDecimal betaGlucan_YellowLowerLimit;

	@Column(name="BetaGlucan_YellowUpperLimit")
	private BigDecimal betaGlucan_YellowUpperLimit;

	private BigDecimal boiled;

	private BigDecimal boiled_RedLowerLimit;

	private BigDecimal boiled_RedUpperLimit;

	private BigDecimal boiled_YellowLowerLimit;

	private BigDecimal boiled_YellowUpperLimit;

	@Column(name="Chroma")
	private BigDecimal chroma;

	@Column(name="Chroma_RedLowerLimit")
	private BigDecimal chroma_RedLowerLimit;

	@Column(name="Chroma_RedUpperLimit")
	private BigDecimal chroma_RedUpperLimit;

	@Column(name="Chroma_YellowLowerLimit")
	private BigDecimal chroma_YellowLowerLimit;

	@Column(name="Chroma_YellowUpperLimit")
	private BigDecimal chroma_YellowUpperLimit;

	@Column(name="Color")
	private String color;

	private String conclusion;

	private String date;

	@Column(name="Dateofinspection")
	private String dateofinspection;

	@Column(name="Dateofpurchase")
	private String dateofpurchase;

	@Column(name="Detecting_human")
	private String detecting_human;

	private BigDecimal difference;

	private BigDecimal difference_RedLowerLimit;

	private BigDecimal difference_RedUpperLimit;

	private BigDecimal difference_YellowLowerLimit;

	private BigDecimal difference_YellowUpperLimit;

	@Column(name="FIN")
	private BigDecimal fin;

	private BigDecimal FIN_RedLowerLimit;

	private BigDecimal FIN_RedUpperLimit;

	private BigDecimal FIN_YellowLowerLimit;

	private BigDecimal FIN_YellowUpperLimit;

	private String fragrance;

	@Column(name="HID")
	private String hid;

	@Column(name="KpiMark")
	private String kpiMark;

	@Column(name="KurbachValue")
	private BigDecimal kurbachValue;

	@Column(name="KurbachValue_RedLowerLimit")
	private BigDecimal kurbachValue_RedLowerLimit;

	@Column(name="KurbachValue_RedUpperLimit")
	private BigDecimal kurbachValue_RedUpperLimit;

	@Column(name="KurbachValue_YellowLowerLimit")
	private BigDecimal kurbachValue_YellowLowerLimit;

	@Column(name="KurbachValue_YellowUpperLimit")
	private BigDecimal kurbachValue_YellowUpperLimit;

	private String location;

	@Column(name="Log")
	private String log;

	@Column(name="Material")
	private String material;

	@Column(name="Moisture")
	private BigDecimal moisture;

	@Column(name="Moisture_RedLowerLimit")
	private BigDecimal moisture_RedLowerLimit;

	@Column(name="Moisture_RedUpperLimit")
	private BigDecimal moisture_RedUpperLimit;

	@Column(name="Moisture_YellowLowerLimit")
	private BigDecimal moisture_YellowLowerLimit;

	@Column(name="Moisture_YellowUpperLimit")
	private BigDecimal moisture_YellowUpperLimit;

	@Column(name="NoWater")
	private BigDecimal noWater;

	@Column(name="NoWater_RedLowerLimit")
	private BigDecimal noWater_RedLowerLimit;

	@Column(name="NoWater_RedUpperLimit")
	private BigDecimal noWater_RedUpperLimit;

	@Column(name="NoWater_YellowLowerLimit")
	private BigDecimal noWater_YellowLowerLimit;

	@Column(name="NoWater_YellowUpperLimit")
	private BigDecimal noWater_YellowUpperLimit;

	@Column(name="Origin")
	private String origin;

	private BigDecimal protein;

	private BigDecimal protein_RedLowerLimit;

	private BigDecimal protein_RedUpperLimit;

	private BigDecimal protein_YellowLowerLimit;

	private BigDecimal protein_YellowUpperLimit;

	@Column(name="Red")
	private String red;

	@Column(name="Remark")
	private String remark;

	@Column(name="Reviewer")
	private String reviewer;

	@Column(name="RID")
	private BigDecimal rid;

	@Column(name="Saccharification")
	private BigDecimal saccharification;

	@Column(name="Saccharification_RedLowerLimit")
	private BigDecimal saccharification_RedLowerLimit;

	@Column(name="Saccharification_RedUpperLimit")
	private BigDecimal saccharification_RedUpperLimit;

	@Column(name="Saccharification_YellowLowerLimit")
	private BigDecimal saccharification_YellowLowerLimit;

	@Column(name="Saccharification_YellowUpperLimit")
	private BigDecimal saccharification_YellowUpperLimit;

	@Column(name="SID")
	private String sid;

	@Column(name="SolubleNitrogen")
	private BigDecimal solubleNitrogen;

	@Column(name="SolubleNitrogen_RedLowerLimit")
	private BigDecimal solubleNitrogen_RedLowerLimit;

	@Column(name="SolubleNitrogen_RedUpperLimit")
	private BigDecimal solubleNitrogen_RedUpperLimit;

	@Column(name="SolubleNitrogen_YellowLowerLimit")
	private BigDecimal solubleNitrogen_YellowLowerLimit;

	@Column(name="SolubleNitrogen_YellowUpperLimit")
	private BigDecimal solubleNitrogen_YellowUpperLimit;

	private String specification;

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

	@Column(name="Viscosity")
	private BigDecimal viscosity;

	@Column(name="Viscosity_RedLowerLimit")
	private BigDecimal viscosity_RedLowerLimit;

	@Column(name="Viscosity_RedUpperLimit")
	private BigDecimal viscosity_RedUpperLimit;

	@Column(name="Viscosity_YellowLowerLimit")
	private BigDecimal viscosity_YellowLowerLimit;

	@Column(name="Viscosity_YellowUpperLimit")
	private BigDecimal viscosity_YellowUpperLimit;

	@Column(name="Water")
	private BigDecimal water;

	@Column(name="Water_RedLowerLimit")
	private BigDecimal water_RedLowerLimit;

	@Column(name="Water_RedUpperLimit")
	private BigDecimal water_RedUpperLimit;

	@Column(name="Water_YellowLowerLimit")
	private BigDecimal water_YellowLowerLimit;

	@Column(name="Water_YellowUpperLimit")
	private BigDecimal water_YellowUpperLimit;

	@Column(name="Yellow")
	private String yellow;

	public Malt() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBakedTime() {
		return this.bakedTime;
	}

	public void setBakedTime(String bakedTime) {
		this.bakedTime = bakedTime;
	}

	public String getBatch() {
		return this.batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public BigDecimal getBetaGlucan() {
		return this.betaGlucan;
	}

	public void setBetaGlucan(BigDecimal betaGlucan) {
		this.betaGlucan = betaGlucan;
	}

	public BigDecimal getBetaGlucan_RedLowerLimit() {
		return this.betaGlucan_RedLowerLimit;
	}

	public void setBetaGlucan_RedLowerLimit(BigDecimal betaGlucan_RedLowerLimit) {
		this.betaGlucan_RedLowerLimit = betaGlucan_RedLowerLimit;
	}

	public BigDecimal getBetaGlucan_RedUpperLimit() {
		return this.betaGlucan_RedUpperLimit;
	}

	public void setBetaGlucan_RedUpperLimit(BigDecimal betaGlucan_RedUpperLimit) {
		this.betaGlucan_RedUpperLimit = betaGlucan_RedUpperLimit;
	}

	public BigDecimal getBetaGlucan_YellowLowerLimit() {
		return this.betaGlucan_YellowLowerLimit;
	}

	public void setBetaGlucan_YellowLowerLimit(BigDecimal betaGlucan_YellowLowerLimit) {
		this.betaGlucan_YellowLowerLimit = betaGlucan_YellowLowerLimit;
	}

	public BigDecimal getBetaGlucan_YellowUpperLimit() {
		return this.betaGlucan_YellowUpperLimit;
	}

	public void setBetaGlucan_YellowUpperLimit(BigDecimal betaGlucan_YellowUpperLimit) {
		this.betaGlucan_YellowUpperLimit = betaGlucan_YellowUpperLimit;
	}

	public BigDecimal getBoiled() {
		return this.boiled;
	}

	public void setBoiled(BigDecimal boiled) {
		this.boiled = boiled;
	}

	public BigDecimal getBoiled_RedLowerLimit() {
		return this.boiled_RedLowerLimit;
	}

	public void setBoiled_RedLowerLimit(BigDecimal boiled_RedLowerLimit) {
		this.boiled_RedLowerLimit = boiled_RedLowerLimit;
	}

	public BigDecimal getBoiled_RedUpperLimit() {
		return this.boiled_RedUpperLimit;
	}

	public void setBoiled_RedUpperLimit(BigDecimal boiled_RedUpperLimit) {
		this.boiled_RedUpperLimit = boiled_RedUpperLimit;
	}

	public BigDecimal getBoiled_YellowLowerLimit() {
		return this.boiled_YellowLowerLimit;
	}

	public void setBoiled_YellowLowerLimit(BigDecimal boiled_YellowLowerLimit) {
		this.boiled_YellowLowerLimit = boiled_YellowLowerLimit;
	}

	public BigDecimal getBoiled_YellowUpperLimit() {
		return this.boiled_YellowUpperLimit;
	}

	public void setBoiled_YellowUpperLimit(BigDecimal boiled_YellowUpperLimit) {
		this.boiled_YellowUpperLimit = boiled_YellowUpperLimit;
	}

	public BigDecimal getChroma() {
		return this.chroma;
	}

	public void setChroma(BigDecimal chroma) {
		this.chroma = chroma;
	}

	public BigDecimal getChroma_RedLowerLimit() {
		return this.chroma_RedLowerLimit;
	}

	public void setChroma_RedLowerLimit(BigDecimal chroma_RedLowerLimit) {
		this.chroma_RedLowerLimit = chroma_RedLowerLimit;
	}

	public BigDecimal getChroma_RedUpperLimit() {
		return this.chroma_RedUpperLimit;
	}

	public void setChroma_RedUpperLimit(BigDecimal chroma_RedUpperLimit) {
		this.chroma_RedUpperLimit = chroma_RedUpperLimit;
	}

	public BigDecimal getChroma_YellowLowerLimit() {
		return this.chroma_YellowLowerLimit;
	}

	public void setChroma_YellowLowerLimit(BigDecimal chroma_YellowLowerLimit) {
		this.chroma_YellowLowerLimit = chroma_YellowLowerLimit;
	}

	public BigDecimal getChroma_YellowUpperLimit() {
		return this.chroma_YellowUpperLimit;
	}

	public void setChroma_YellowUpperLimit(BigDecimal chroma_YellowUpperLimit) {
		this.chroma_YellowUpperLimit = chroma_YellowUpperLimit;
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

	public String getDateofinspection() {
		return this.dateofinspection;
	}

	public void setDateofinspection(String dateofinspection) {
		this.dateofinspection = dateofinspection;
	}

	public String getDateofpurchase() {
		return this.dateofpurchase;
	}

	public void setDateofpurchase(String dateofpurchase) {
		this.dateofpurchase = dateofpurchase;
	}

	public String getDetecting_human() {
		return this.detecting_human;
	}

	public void setDetecting_human(String detecting_human) {
		this.detecting_human = detecting_human;
	}

	public BigDecimal getDifference() {
		return this.difference;
	}

	public void setDifference(BigDecimal difference) {
		this.difference = difference;
	}

	public BigDecimal getDifference_RedLowerLimit() {
		return this.difference_RedLowerLimit;
	}

	public void setDifference_RedLowerLimit(BigDecimal difference_RedLowerLimit) {
		this.difference_RedLowerLimit = difference_RedLowerLimit;
	}

	public BigDecimal getDifference_RedUpperLimit() {
		return this.difference_RedUpperLimit;
	}

	public void setDifference_RedUpperLimit(BigDecimal difference_RedUpperLimit) {
		this.difference_RedUpperLimit = difference_RedUpperLimit;
	}

	public BigDecimal getDifference_YellowLowerLimit() {
		return this.difference_YellowLowerLimit;
	}

	public void setDifference_YellowLowerLimit(BigDecimal difference_YellowLowerLimit) {
		this.difference_YellowLowerLimit = difference_YellowLowerLimit;
	}

	public BigDecimal getDifference_YellowUpperLimit() {
		return this.difference_YellowUpperLimit;
	}

	public void setDifference_YellowUpperLimit(BigDecimal difference_YellowUpperLimit) {
		this.difference_YellowUpperLimit = difference_YellowUpperLimit;
	}

	public BigDecimal getFin() {
		return this.fin;
	}

	public void setFin(BigDecimal fin) {
		this.fin = fin;
	}

	public BigDecimal getFIN_RedLowerLimit() {
		return this.FIN_RedLowerLimit;
	}

	public void setFIN_RedLowerLimit(BigDecimal FIN_RedLowerLimit) {
		this.FIN_RedLowerLimit = FIN_RedLowerLimit;
	}

	public BigDecimal getFIN_RedUpperLimit() {
		return this.FIN_RedUpperLimit;
	}

	public void setFIN_RedUpperLimit(BigDecimal FIN_RedUpperLimit) {
		this.FIN_RedUpperLimit = FIN_RedUpperLimit;
	}

	public BigDecimal getFIN_YellowLowerLimit() {
		return this.FIN_YellowLowerLimit;
	}

	public void setFIN_YellowLowerLimit(BigDecimal FIN_YellowLowerLimit) {
		this.FIN_YellowLowerLimit = FIN_YellowLowerLimit;
	}

	public BigDecimal getFIN_YellowUpperLimit() {
		return this.FIN_YellowUpperLimit;
	}

	public void setFIN_YellowUpperLimit(BigDecimal FIN_YellowUpperLimit) {
		this.FIN_YellowUpperLimit = FIN_YellowUpperLimit;
	}

	public String getFragrance() {
		return this.fragrance;
	}

	public void setFragrance(String fragrance) {
		this.fragrance = fragrance;
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

	public BigDecimal getKurbachValue() {
		return this.kurbachValue;
	}

	public void setKurbachValue(BigDecimal kurbachValue) {
		this.kurbachValue = kurbachValue;
	}

	public BigDecimal getKurbachValue_RedLowerLimit() {
		return this.kurbachValue_RedLowerLimit;
	}

	public void setKurbachValue_RedLowerLimit(BigDecimal kurbachValue_RedLowerLimit) {
		this.kurbachValue_RedLowerLimit = kurbachValue_RedLowerLimit;
	}

	public BigDecimal getKurbachValue_RedUpperLimit() {
		return this.kurbachValue_RedUpperLimit;
	}

	public void setKurbachValue_RedUpperLimit(BigDecimal kurbachValue_RedUpperLimit) {
		this.kurbachValue_RedUpperLimit = kurbachValue_RedUpperLimit;
	}

	public BigDecimal getKurbachValue_YellowLowerLimit() {
		return this.kurbachValue_YellowLowerLimit;
	}

	public void setKurbachValue_YellowLowerLimit(BigDecimal kurbachValue_YellowLowerLimit) {
		this.kurbachValue_YellowLowerLimit = kurbachValue_YellowLowerLimit;
	}

	public BigDecimal getKurbachValue_YellowUpperLimit() {
		return this.kurbachValue_YellowUpperLimit;
	}

	public void setKurbachValue_YellowUpperLimit(BigDecimal kurbachValue_YellowUpperLimit) {
		this.kurbachValue_YellowUpperLimit = kurbachValue_YellowUpperLimit;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLog() {
		return this.log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public BigDecimal getMoisture() {
		return this.moisture;
	}

	public void setMoisture(BigDecimal moisture) {
		this.moisture = moisture;
	}

	public BigDecimal getMoisture_RedLowerLimit() {
		return this.moisture_RedLowerLimit;
	}

	public void setMoisture_RedLowerLimit(BigDecimal moisture_RedLowerLimit) {
		this.moisture_RedLowerLimit = moisture_RedLowerLimit;
	}

	public BigDecimal getMoisture_RedUpperLimit() {
		return this.moisture_RedUpperLimit;
	}

	public void setMoisture_RedUpperLimit(BigDecimal moisture_RedUpperLimit) {
		this.moisture_RedUpperLimit = moisture_RedUpperLimit;
	}

	public BigDecimal getMoisture_YellowLowerLimit() {
		return this.moisture_YellowLowerLimit;
	}

	public void setMoisture_YellowLowerLimit(BigDecimal moisture_YellowLowerLimit) {
		this.moisture_YellowLowerLimit = moisture_YellowLowerLimit;
	}

	public BigDecimal getMoisture_YellowUpperLimit() {
		return this.moisture_YellowUpperLimit;
	}

	public void setMoisture_YellowUpperLimit(BigDecimal moisture_YellowUpperLimit) {
		this.moisture_YellowUpperLimit = moisture_YellowUpperLimit;
	}

	public BigDecimal getNoWater() {
		return this.noWater;
	}

	public void setNoWater(BigDecimal noWater) {
		this.noWater = noWater;
	}

	public BigDecimal getNoWater_RedLowerLimit() {
		return this.noWater_RedLowerLimit;
	}

	public void setNoWater_RedLowerLimit(BigDecimal noWater_RedLowerLimit) {
		this.noWater_RedLowerLimit = noWater_RedLowerLimit;
	}

	public BigDecimal getNoWater_RedUpperLimit() {
		return this.noWater_RedUpperLimit;
	}

	public void setNoWater_RedUpperLimit(BigDecimal noWater_RedUpperLimit) {
		this.noWater_RedUpperLimit = noWater_RedUpperLimit;
	}

	public BigDecimal getNoWater_YellowLowerLimit() {
		return this.noWater_YellowLowerLimit;
	}

	public void setNoWater_YellowLowerLimit(BigDecimal noWater_YellowLowerLimit) {
		this.noWater_YellowLowerLimit = noWater_YellowLowerLimit;
	}

	public BigDecimal getNoWater_YellowUpperLimit() {
		return this.noWater_YellowUpperLimit;
	}

	public void setNoWater_YellowUpperLimit(BigDecimal noWater_YellowUpperLimit) {
		this.noWater_YellowUpperLimit = noWater_YellowUpperLimit;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public BigDecimal getProtein() {
		return this.protein;
	}

	public void setProtein(BigDecimal protein) {
		this.protein = protein;
	}

	public BigDecimal getProtein_RedLowerLimit() {
		return this.protein_RedLowerLimit;
	}

	public void setProtein_RedLowerLimit(BigDecimal protein_RedLowerLimit) {
		this.protein_RedLowerLimit = protein_RedLowerLimit;
	}

	public BigDecimal getProtein_RedUpperLimit() {
		return this.protein_RedUpperLimit;
	}

	public void setProtein_RedUpperLimit(BigDecimal protein_RedUpperLimit) {
		this.protein_RedUpperLimit = protein_RedUpperLimit;
	}

	public BigDecimal getProtein_YellowLowerLimit() {
		return this.protein_YellowLowerLimit;
	}

	public void setProtein_YellowLowerLimit(BigDecimal protein_YellowLowerLimit) {
		this.protein_YellowLowerLimit = protein_YellowLowerLimit;
	}

	public BigDecimal getProtein_YellowUpperLimit() {
		return this.protein_YellowUpperLimit;
	}

	public void setProtein_YellowUpperLimit(BigDecimal protein_YellowUpperLimit) {
		this.protein_YellowUpperLimit = protein_YellowUpperLimit;
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

	public BigDecimal getSaccharification() {
		return this.saccharification;
	}

	public void setSaccharification(BigDecimal saccharification) {
		this.saccharification = saccharification;
	}

	public BigDecimal getSaccharification_RedLowerLimit() {
		return this.saccharification_RedLowerLimit;
	}

	public void setSaccharification_RedLowerLimit(BigDecimal saccharification_RedLowerLimit) {
		this.saccharification_RedLowerLimit = saccharification_RedLowerLimit;
	}

	public BigDecimal getSaccharification_RedUpperLimit() {
		return this.saccharification_RedUpperLimit;
	}

	public void setSaccharification_RedUpperLimit(BigDecimal saccharification_RedUpperLimit) {
		this.saccharification_RedUpperLimit = saccharification_RedUpperLimit;
	}

	public BigDecimal getSaccharification_YellowLowerLimit() {
		return this.saccharification_YellowLowerLimit;
	}

	public void setSaccharification_YellowLowerLimit(BigDecimal saccharification_YellowLowerLimit) {
		this.saccharification_YellowLowerLimit = saccharification_YellowLowerLimit;
	}

	public BigDecimal getSaccharification_YellowUpperLimit() {
		return this.saccharification_YellowUpperLimit;
	}

	public void setSaccharification_YellowUpperLimit(BigDecimal saccharification_YellowUpperLimit) {
		this.saccharification_YellowUpperLimit = saccharification_YellowUpperLimit;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public BigDecimal getSolubleNitrogen() {
		return this.solubleNitrogen;
	}

	public void setSolubleNitrogen(BigDecimal solubleNitrogen) {
		this.solubleNitrogen = solubleNitrogen;
	}

	public BigDecimal getSolubleNitrogen_RedLowerLimit() {
		return this.solubleNitrogen_RedLowerLimit;
	}

	public void setSolubleNitrogen_RedLowerLimit(BigDecimal solubleNitrogen_RedLowerLimit) {
		this.solubleNitrogen_RedLowerLimit = solubleNitrogen_RedLowerLimit;
	}

	public BigDecimal getSolubleNitrogen_RedUpperLimit() {
		return this.solubleNitrogen_RedUpperLimit;
	}

	public void setSolubleNitrogen_RedUpperLimit(BigDecimal solubleNitrogen_RedUpperLimit) {
		this.solubleNitrogen_RedUpperLimit = solubleNitrogen_RedUpperLimit;
	}

	public BigDecimal getSolubleNitrogen_YellowLowerLimit() {
		return this.solubleNitrogen_YellowLowerLimit;
	}

	public void setSolubleNitrogen_YellowLowerLimit(BigDecimal solubleNitrogen_YellowLowerLimit) {
		this.solubleNitrogen_YellowLowerLimit = solubleNitrogen_YellowLowerLimit;
	}

	public BigDecimal getSolubleNitrogen_YellowUpperLimit() {
		return this.solubleNitrogen_YellowUpperLimit;
	}

	public void setSolubleNitrogen_YellowUpperLimit(BigDecimal solubleNitrogen_YellowUpperLimit) {
		this.solubleNitrogen_YellowUpperLimit = solubleNitrogen_YellowUpperLimit;
	}

	public String getSpecification() {
		return this.specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
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

	public BigDecimal getViscosity() {
		return this.viscosity;
	}

	public void setViscosity(BigDecimal viscosity) {
		this.viscosity = viscosity;
	}

	public BigDecimal getViscosity_RedLowerLimit() {
		return this.viscosity_RedLowerLimit;
	}

	public void setViscosity_RedLowerLimit(BigDecimal viscosity_RedLowerLimit) {
		this.viscosity_RedLowerLimit = viscosity_RedLowerLimit;
	}

	public BigDecimal getViscosity_RedUpperLimit() {
		return this.viscosity_RedUpperLimit;
	}

	public void setViscosity_RedUpperLimit(BigDecimal viscosity_RedUpperLimit) {
		this.viscosity_RedUpperLimit = viscosity_RedUpperLimit;
	}

	public BigDecimal getViscosity_YellowLowerLimit() {
		return this.viscosity_YellowLowerLimit;
	}

	public void setViscosity_YellowLowerLimit(BigDecimal viscosity_YellowLowerLimit) {
		this.viscosity_YellowLowerLimit = viscosity_YellowLowerLimit;
	}

	public BigDecimal getViscosity_YellowUpperLimit() {
		return this.viscosity_YellowUpperLimit;
	}

	public void setViscosity_YellowUpperLimit(BigDecimal viscosity_YellowUpperLimit) {
		this.viscosity_YellowUpperLimit = viscosity_YellowUpperLimit;
	}

	public BigDecimal getWater() {
		return this.water;
	}

	public void setWater(BigDecimal water) {
		this.water = water;
	}

	public BigDecimal getWater_RedLowerLimit() {
		return this.water_RedLowerLimit;
	}

	public void setWater_RedLowerLimit(BigDecimal water_RedLowerLimit) {
		this.water_RedLowerLimit = water_RedLowerLimit;
	}

	public BigDecimal getWater_RedUpperLimit() {
		return this.water_RedUpperLimit;
	}

	public void setWater_RedUpperLimit(BigDecimal water_RedUpperLimit) {
		this.water_RedUpperLimit = water_RedUpperLimit;
	}

	public BigDecimal getWater_YellowLowerLimit() {
		return this.water_YellowLowerLimit;
	}

	public void setWater_YellowLowerLimit(BigDecimal water_YellowLowerLimit) {
		this.water_YellowLowerLimit = water_YellowLowerLimit;
	}

	public BigDecimal getWater_YellowUpperLimit() {
		return this.water_YellowUpperLimit;
	}

	public void setWater_YellowUpperLimit(BigDecimal water_YellowUpperLimit) {
		this.water_YellowUpperLimit = water_YellowUpperLimit;
	}

	public String getYellow() {
		return this.yellow;
	}

	public void setYellow(String yellow) {
		this.yellow = yellow;
	}

}