package com.spoonsea.qualitytracing.lims.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the Hops database table.
 * 
 */
@Entity
@Table(name="Hops")
@NamedQuery(name="Hop.findAll", query="SELECT h FROM Hop h")
public class Hop implements Serializable {
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

	@Column(name="KpiMark")
	private String kpiMark;

	private String location;

	private String model;

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

	@Column(name="SubmissionDate")
	private String submissionDate;

	private String supplier;

	@Column(name="TetrahydroisoAcid")
	private BigDecimal tetrahydroisoAcid;

	@Column(name="TetrahydroisoAcid_RedLowerLimit")
	private BigDecimal tetrahydroisoAcid_RedLowerLimit;

	@Column(name="TetrahydroisoAcid_RedUpperLimit")
	private BigDecimal tetrahydroisoAcid_RedUpperLimit;

	@Column(name="TetrahydroisoAcid_YellowLowerLimit")
	private BigDecimal tetrahydroisoAcid_YellowLowerLimit;

	@Column(name="TetrahydroisoAcid_YellowUpperLimit")
	private BigDecimal tetrahydroisoAcid_YellowUpperLimit;

	@Column(name="Yellow")
	private String yellow;

	public Hop() {
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

	public BigDecimal getTetrahydroisoAcid() {
		return this.tetrahydroisoAcid;
	}

	public void setTetrahydroisoAcid(BigDecimal tetrahydroisoAcid) {
		this.tetrahydroisoAcid = tetrahydroisoAcid;
	}

	public BigDecimal getTetrahydroisoAcid_RedLowerLimit() {
		return this.tetrahydroisoAcid_RedLowerLimit;
	}

	public void setTetrahydroisoAcid_RedLowerLimit(BigDecimal tetrahydroisoAcid_RedLowerLimit) {
		this.tetrahydroisoAcid_RedLowerLimit = tetrahydroisoAcid_RedLowerLimit;
	}

	public BigDecimal getTetrahydroisoAcid_RedUpperLimit() {
		return this.tetrahydroisoAcid_RedUpperLimit;
	}

	public void setTetrahydroisoAcid_RedUpperLimit(BigDecimal tetrahydroisoAcid_RedUpperLimit) {
		this.tetrahydroisoAcid_RedUpperLimit = tetrahydroisoAcid_RedUpperLimit;
	}

	public BigDecimal getTetrahydroisoAcid_YellowLowerLimit() {
		return this.tetrahydroisoAcid_YellowLowerLimit;
	}

	public void setTetrahydroisoAcid_YellowLowerLimit(BigDecimal tetrahydroisoAcid_YellowLowerLimit) {
		this.tetrahydroisoAcid_YellowLowerLimit = tetrahydroisoAcid_YellowLowerLimit;
	}

	public BigDecimal getTetrahydroisoAcid_YellowUpperLimit() {
		return this.tetrahydroisoAcid_YellowUpperLimit;
	}

	public void setTetrahydroisoAcid_YellowUpperLimit(BigDecimal tetrahydroisoAcid_YellowUpperLimit) {
		this.tetrahydroisoAcid_YellowUpperLimit = tetrahydroisoAcid_YellowUpperLimit;
	}

	public String getYellow() {
		return this.yellow;
	}

	public void setYellow(String yellow) {
		this.yellow = yellow;
	}

}