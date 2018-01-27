package com.spoonsea.qualitytracing.lims.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the GranuleHops database table.
 * 
 */
@Entity
@Table(name="GranuleHops")
@NamedQuery(name="GranuleHop.findAll", query="SELECT g FROM GranuleHop g")
public class GranuleHop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private String id;

	private String batch;

	@Column(name="Color")
	private String color;

	private String conclusion;

	private String date;

	@Column(name="Detecting_human")
	private String detecting_human;

	@Column(name="Enterthequantity")
	private String enterthequantity;

	@Column(name="Factory")
	private String factory;

	@Column(name="Fragrance")
	private String fragrance;

	@Column(name="HID")
	private String hid;

	@Column(name="JumpingTime")
	private BigDecimal jumpingTime;

	@Column(name="JumpingTime_RedLowerLimit")
	private BigDecimal jumpingTime_RedLowerLimit;

	@Column(name="JumpingTime_RedUpperLimit")
	private BigDecimal jumpingTime_RedUpperLimit;

	@Column(name="JumpingTime_YellowLowerLimit")
	private BigDecimal jumpingTime_YellowLowerLimit;

	@Column(name="JumpingTime_YellowUpperLimit")
	private BigDecimal jumpingTime_YellowUpperLimit;

	@Column(name="KpiMark")
	private String kpiMark;

	private String location;

	private String model;

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

	@Column(name="Origin")
	private String origin;

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

	private String specification;

	@Column(name="STID")
	private String stid;

	@Column(name="Storage")
	private BigDecimal storage;

	@Column(name="Storage_RedLowerLimit")
	private BigDecimal storage_RedLowerLimit;

	@Column(name="Storage_RedUpperLimit")
	private BigDecimal storage_RedUpperLimit;

	@Column(name="Storage_YellowLowerLimit")
	private BigDecimal storage_YellowLowerLimit;

	@Column(name="Storage_YellowUpperLimit")
	private BigDecimal storage_YellowUpperLimit;

	@Column(name="SubmissionDate")
	private String submissionDate;

	private String supplier;

	@Column(name="Yellow")
	private String yellow;

	private BigDecimal β_Acid;

	private BigDecimal β_Acid_RedLowerLimit;

	private BigDecimal β_Acid_RedUpperLimit;

	private BigDecimal β_Acid_YellowLowerLimit;

	private BigDecimal β_Acid_YellowUpperLimit;

	private BigDecimal а_Acid;

	private BigDecimal а_Acid_RedLowerLimit;

	private BigDecimal а_Acid_RedUpperLimit;

	private BigDecimal а_Acid_YellowLowerLimit;

	private BigDecimal а_Acid_YellowUpperLimit;

	public GranuleHop() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBatch() {
		return this.batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
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

	public String getEnterthequantity() {
		return this.enterthequantity;
	}

	public void setEnterthequantity(String enterthequantity) {
		this.enterthequantity = enterthequantity;
	}

	public String getFactory() {
		return this.factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
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

	public BigDecimal getJumpingTime() {
		return this.jumpingTime;
	}

	public void setJumpingTime(BigDecimal jumpingTime) {
		this.jumpingTime = jumpingTime;
	}

	public BigDecimal getJumpingTime_RedLowerLimit() {
		return this.jumpingTime_RedLowerLimit;
	}

	public void setJumpingTime_RedLowerLimit(BigDecimal jumpingTime_RedLowerLimit) {
		this.jumpingTime_RedLowerLimit = jumpingTime_RedLowerLimit;
	}

	public BigDecimal getJumpingTime_RedUpperLimit() {
		return this.jumpingTime_RedUpperLimit;
	}

	public void setJumpingTime_RedUpperLimit(BigDecimal jumpingTime_RedUpperLimit) {
		this.jumpingTime_RedUpperLimit = jumpingTime_RedUpperLimit;
	}

	public BigDecimal getJumpingTime_YellowLowerLimit() {
		return this.jumpingTime_YellowLowerLimit;
	}

	public void setJumpingTime_YellowLowerLimit(BigDecimal jumpingTime_YellowLowerLimit) {
		this.jumpingTime_YellowLowerLimit = jumpingTime_YellowLowerLimit;
	}

	public BigDecimal getJumpingTime_YellowUpperLimit() {
		return this.jumpingTime_YellowUpperLimit;
	}

	public void setJumpingTime_YellowUpperLimit(BigDecimal jumpingTime_YellowUpperLimit) {
		this.jumpingTime_YellowUpperLimit = jumpingTime_YellowUpperLimit;
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

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
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

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
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

	public BigDecimal getStorage() {
		return this.storage;
	}

	public void setStorage(BigDecimal storage) {
		this.storage = storage;
	}

	public BigDecimal getStorage_RedLowerLimit() {
		return this.storage_RedLowerLimit;
	}

	public void setStorage_RedLowerLimit(BigDecimal storage_RedLowerLimit) {
		this.storage_RedLowerLimit = storage_RedLowerLimit;
	}

	public BigDecimal getStorage_RedUpperLimit() {
		return this.storage_RedUpperLimit;
	}

	public void setStorage_RedUpperLimit(BigDecimal storage_RedUpperLimit) {
		this.storage_RedUpperLimit = storage_RedUpperLimit;
	}

	public BigDecimal getStorage_YellowLowerLimit() {
		return this.storage_YellowLowerLimit;
	}

	public void setStorage_YellowLowerLimit(BigDecimal storage_YellowLowerLimit) {
		this.storage_YellowLowerLimit = storage_YellowLowerLimit;
	}

	public BigDecimal getStorage_YellowUpperLimit() {
		return this.storage_YellowUpperLimit;
	}

	public void setStorage_YellowUpperLimit(BigDecimal storage_YellowUpperLimit) {
		this.storage_YellowUpperLimit = storage_YellowUpperLimit;
	}

	public String getSubmissionDate() {
		return this.submissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getSupplier() {
		return this.supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getYellow() {
		return this.yellow;
	}

	public void setYellow(String yellow) {
		this.yellow = yellow;
	}

	public BigDecimal getΒ_Acid() {
		return this.β_Acid;
	}

	public void setΒ_Acid(BigDecimal β_Acid) {
		this.β_Acid = β_Acid;
	}

	public BigDecimal getΒ_Acid_RedLowerLimit() {
		return this.β_Acid_RedLowerLimit;
	}

	public void setΒ_Acid_RedLowerLimit(BigDecimal β_Acid_RedLowerLimit) {
		this.β_Acid_RedLowerLimit = β_Acid_RedLowerLimit;
	}

	public BigDecimal getΒ_Acid_RedUpperLimit() {
		return this.β_Acid_RedUpperLimit;
	}

	public void setΒ_Acid_RedUpperLimit(BigDecimal β_Acid_RedUpperLimit) {
		this.β_Acid_RedUpperLimit = β_Acid_RedUpperLimit;
	}

	public BigDecimal getΒ_Acid_YellowLowerLimit() {
		return this.β_Acid_YellowLowerLimit;
	}

	public void setΒ_Acid_YellowLowerLimit(BigDecimal β_Acid_YellowLowerLimit) {
		this.β_Acid_YellowLowerLimit = β_Acid_YellowLowerLimit;
	}

	public BigDecimal getΒ_Acid_YellowUpperLimit() {
		return this.β_Acid_YellowUpperLimit;
	}

	public void setΒ_Acid_YellowUpperLimit(BigDecimal β_Acid_YellowUpperLimit) {
		this.β_Acid_YellowUpperLimit = β_Acid_YellowUpperLimit;
	}

	public BigDecimal getА_Acid() {
		return this.а_Acid;
	}

	public void setА_Acid(BigDecimal а_Acid) {
		this.а_Acid = а_Acid;
	}

	public BigDecimal getА_Acid_RedLowerLimit() {
		return this.а_Acid_RedLowerLimit;
	}

	public void setА_Acid_RedLowerLimit(BigDecimal а_Acid_RedLowerLimit) {
		this.а_Acid_RedLowerLimit = а_Acid_RedLowerLimit;
	}

	public BigDecimal getА_Acid_RedUpperLimit() {
		return this.а_Acid_RedUpperLimit;
	}

	public void setА_Acid_RedUpperLimit(BigDecimal а_Acid_RedUpperLimit) {
		this.а_Acid_RedUpperLimit = а_Acid_RedUpperLimit;
	}

	public BigDecimal getА_Acid_YellowLowerLimit() {
		return this.а_Acid_YellowLowerLimit;
	}

	public void setА_Acid_YellowLowerLimit(BigDecimal а_Acid_YellowLowerLimit) {
		this.а_Acid_YellowLowerLimit = а_Acid_YellowLowerLimit;
	}

	public BigDecimal getА_Acid_YellowUpperLimit() {
		return this.а_Acid_YellowUpperLimit;
	}

	public void setА_Acid_YellowUpperLimit(BigDecimal а_Acid_YellowUpperLimit) {
		this.а_Acid_YellowUpperLimit = а_Acid_YellowUpperLimit;
	}

}