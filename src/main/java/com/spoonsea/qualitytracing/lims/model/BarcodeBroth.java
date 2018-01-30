package com.spoonsea.qualitytracing.lims.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the BarcodeBroth database table.
 * 
 */
@Entity
@NamedQuery(name="BarcodeBroth.findAll", query="SELECT b FROM BarcodeBroth b")
public class BarcodeBroth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;

	@Column(name="Age")
	private String age;

	@Column(name="AllDate")
	private String allDate;

	@Column(name="Barcode")
	private String barcode;

	@Column(name="Comment")
	private String comment;

	private String date;

	private String DPdate;

	@Column(name="Fermenter")
	private String fermenter;

	@Column(name="HID")
	private String hid;

	@Column(name="Ingredients")
	private String ingredients;

	@Column(name="Reviewer")
	private String reviewer;

	@Column(name="SID")
	private String sid;

	private String time;

	@Column(name="TreatmentTank")
	private String treatmentTank;

	@Column(name="Variety")
	private String variety;

	@Column(name="Yeast")
	private BigDecimal yeast;

	public BarcodeBroth() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAllDate() {
		return this.allDate;
	}

	public void setAllDate(String allDate) {
		this.allDate = allDate;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDPdate() {
		return this.DPdate;
	}

	public void setDPdate(String DPdate) {
		this.DPdate = DPdate;
	}

	public String getFermenter() {
		return this.fermenter;
	}

	public void setFermenter(String fermenter) {
		this.fermenter = fermenter;
	}

	public String getHid() {
		return this.hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getReviewer() {
		return this.reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTreatmentTank() {
		return this.treatmentTank;
	}

	public void setTreatmentTank(String treatmentTank) {
		this.treatmentTank = treatmentTank;
	}

	public String getVariety() {
		return this.variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public BigDecimal getYeast() {
		return this.yeast;
	}

	public void setYeast(BigDecimal yeast) {
		this.yeast = yeast;
	}

}