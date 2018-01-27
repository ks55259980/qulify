package com.spoonsea.qualitytracing.lims.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the Syrup database table.
 * 
 */
@Entity
@NamedQuery(name="Syrup.findAll", query="SELECT s FROM Syrup s")
public class Syrup implements Serializable {
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

	@Column(name="Coliforms")
	private BigDecimal coliforms;

	@Column(name="Coliforms_RedLowerLimit")
	private BigDecimal coliforms_RedLowerLimit;

	@Column(name="Coliforms_RedUpperLimit")
	private BigDecimal coliforms_RedUpperLimit;

	@Column(name="Coliforms_YellowLowerLimit")
	private BigDecimal coliforms_YellowLowerLimit;

	@Column(name="Coliforms_YellowUpperLimit")
	private BigDecimal coliforms_YellowUpperLimit;

	@Column(name="Colony")
	private BigDecimal colony;

	@Column(name="Colony_RedLowerLimit")
	private BigDecimal colony_RedLowerLimit;

	@Column(name="Colony_RedUpperLimit")
	private BigDecimal colony_RedUpperLimit;

	@Column(name="Colony_YellowLowerLimit")
	private BigDecimal colony_YellowLowerLimit;

	@Column(name="Colony_YellowUpperLimit")
	private BigDecimal colony_YellowUpperLimit;

	private String conclusion;

	private String date;

	@Column(name="Detecting_human")
	private String detecting_human;

	@Column(name="DrySolids")
	private BigDecimal drySolids;

	@Column(name="DrySolids_RedLowerLimit")
	private BigDecimal drySolids_RedLowerLimit;

	@Column(name="DrySolids_RedUpperLimit")
	private BigDecimal drySolids_RedUpperLimit;

	@Column(name="DrySolids_YellowLowerLimit")
	private BigDecimal drySolids_YellowLowerLimit;

	@Column(name="DrySolids_YellowUpperLimit")
	private BigDecimal drySolids_YellowUpperLimit;

	@Column(name="Exterior")
	private String exterior;

	@Column(name="Factory")
	private String factory;

	@Column(name="HID")
	private String hid;

	@Column(name="IodineReaction")
	private String iodineReaction;

	@Column(name="KpiMark")
	private String kpiMark;

	private String odor;

	@Column(name="PH")
	private BigDecimal ph;

	private BigDecimal PH_RedLowerLimit;

	private BigDecimal PH_RedUpperLimit;

	private BigDecimal PH_YellowLowerLimit;

	private BigDecimal PH_YellowUpperLimit;

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

	@Column(name="Yellow")
	private String yellow;

	public Syrup() {
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

	public BigDecimal getColiforms() {
		return this.coliforms;
	}

	public void setColiforms(BigDecimal coliforms) {
		this.coliforms = coliforms;
	}

	public BigDecimal getColiforms_RedLowerLimit() {
		return this.coliforms_RedLowerLimit;
	}

	public void setColiforms_RedLowerLimit(BigDecimal coliforms_RedLowerLimit) {
		this.coliforms_RedLowerLimit = coliforms_RedLowerLimit;
	}

	public BigDecimal getColiforms_RedUpperLimit() {
		return this.coliforms_RedUpperLimit;
	}

	public void setColiforms_RedUpperLimit(BigDecimal coliforms_RedUpperLimit) {
		this.coliforms_RedUpperLimit = coliforms_RedUpperLimit;
	}

	public BigDecimal getColiforms_YellowLowerLimit() {
		return this.coliforms_YellowLowerLimit;
	}

	public void setColiforms_YellowLowerLimit(BigDecimal coliforms_YellowLowerLimit) {
		this.coliforms_YellowLowerLimit = coliforms_YellowLowerLimit;
	}

	public BigDecimal getColiforms_YellowUpperLimit() {
		return this.coliforms_YellowUpperLimit;
	}

	public void setColiforms_YellowUpperLimit(BigDecimal coliforms_YellowUpperLimit) {
		this.coliforms_YellowUpperLimit = coliforms_YellowUpperLimit;
	}

	public BigDecimal getColony() {
		return this.colony;
	}

	public void setColony(BigDecimal colony) {
		this.colony = colony;
	}

	public BigDecimal getColony_RedLowerLimit() {
		return this.colony_RedLowerLimit;
	}

	public void setColony_RedLowerLimit(BigDecimal colony_RedLowerLimit) {
		this.colony_RedLowerLimit = colony_RedLowerLimit;
	}

	public BigDecimal getColony_RedUpperLimit() {
		return this.colony_RedUpperLimit;
	}

	public void setColony_RedUpperLimit(BigDecimal colony_RedUpperLimit) {
		this.colony_RedUpperLimit = colony_RedUpperLimit;
	}

	public BigDecimal getColony_YellowLowerLimit() {
		return this.colony_YellowLowerLimit;
	}

	public void setColony_YellowLowerLimit(BigDecimal colony_YellowLowerLimit) {
		this.colony_YellowLowerLimit = colony_YellowLowerLimit;
	}

	public BigDecimal getColony_YellowUpperLimit() {
		return this.colony_YellowUpperLimit;
	}

	public void setColony_YellowUpperLimit(BigDecimal colony_YellowUpperLimit) {
		this.colony_YellowUpperLimit = colony_YellowUpperLimit;
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

	public BigDecimal getDrySolids() {
		return this.drySolids;
	}

	public void setDrySolids(BigDecimal drySolids) {
		this.drySolids = drySolids;
	}

	public BigDecimal getDrySolids_RedLowerLimit() {
		return this.drySolids_RedLowerLimit;
	}

	public void setDrySolids_RedLowerLimit(BigDecimal drySolids_RedLowerLimit) {
		this.drySolids_RedLowerLimit = drySolids_RedLowerLimit;
	}

	public BigDecimal getDrySolids_RedUpperLimit() {
		return this.drySolids_RedUpperLimit;
	}

	public void setDrySolids_RedUpperLimit(BigDecimal drySolids_RedUpperLimit) {
		this.drySolids_RedUpperLimit = drySolids_RedUpperLimit;
	}

	public BigDecimal getDrySolids_YellowLowerLimit() {
		return this.drySolids_YellowLowerLimit;
	}

	public void setDrySolids_YellowLowerLimit(BigDecimal drySolids_YellowLowerLimit) {
		this.drySolids_YellowLowerLimit = drySolids_YellowLowerLimit;
	}

	public BigDecimal getDrySolids_YellowUpperLimit() {
		return this.drySolids_YellowUpperLimit;
	}

	public void setDrySolids_YellowUpperLimit(BigDecimal drySolids_YellowUpperLimit) {
		this.drySolids_YellowUpperLimit = drySolids_YellowUpperLimit;
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

	public String getHid() {
		return this.hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getIodineReaction() {
		return this.iodineReaction;
	}

	public void setIodineReaction(String iodineReaction) {
		this.iodineReaction = iodineReaction;
	}

	public String getKpiMark() {
		return this.kpiMark;
	}

	public void setKpiMark(String kpiMark) {
		this.kpiMark = kpiMark;
	}

	public String getOdor() {
		return this.odor;
	}

	public void setOdor(String odor) {
		this.odor = odor;
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

	public String getYellow() {
		return this.yellow;
	}

	public void setYellow(String yellow) {
		this.yellow = yellow;
	}

}