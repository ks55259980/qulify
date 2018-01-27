package com.spoonsea.qualitytracing.lims.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ReportName database table.
 * 
 */
@Entity
@NamedQuery(name="ReportName.findAll", query="SELECT r FROM ReportName r")
public class ReportName implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;

	@Column(name="Area")
	private String area;

	@Column(name="Barcode")
	private String barcode;

	@Column(name="Chinese")
	private String chinese;

	@Column(name="Criterion")
	private String criterion;

	@Column(name="Department")
	private String department;

	@Column(name="English")
	private String english;

	@Column(name="Entry")
	private String entry;

	@Column(name="Grouping")
	private String grouping;

	@Column(name="Inquire")
	private String inquire;

	private String modify;

	@Column(name="Packet")
	private String packet;

	@Column(name="PtsColumn")
	private String ptsColumn;

	@Column(name="RID")
	private BigDecimal rid;

	public ReportName() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getChinese() {
		return this.chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public String getCriterion() {
		return this.criterion;
	}

	public void setCriterion(String criterion) {
		this.criterion = criterion;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEnglish() {
		return this.english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getEntry() {
		return this.entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getGrouping() {
		return this.grouping;
	}

	public void setGrouping(String grouping) {
		this.grouping = grouping;
	}

	public String getInquire() {
		return this.inquire;
	}

	public void setInquire(String inquire) {
		this.inquire = inquire;
	}

	public String getModify() {
		return this.modify;
	}

	public void setModify(String modify) {
		this.modify = modify;
	}

	public String getPacket() {
		return this.packet;
	}

	public void setPacket(String packet) {
		this.packet = packet;
	}

	public String getPtsColumn() {
		return this.ptsColumn;
	}

	public void setPtsColumn(String ptsColumn) {
		this.ptsColumn = ptsColumn;
	}

	public BigDecimal getRid() {
		return this.rid;
	}

	public void setRid(BigDecimal rid) {
		this.rid = rid;
	}

}