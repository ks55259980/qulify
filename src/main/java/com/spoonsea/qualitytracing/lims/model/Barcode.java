package com.spoonsea.qualitytracing.lims.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Barcode database table.
 * 
 */
@Entity
@NamedQuery(name="Barcode.findAll", query="SELECT b FROM Barcode b")
public class Barcode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;

	@Column(name="Age")
	private String age;

	@Column(name="Barcode")
	private String barcode;

	@Column(name="BottleType")
	private String bottleType;

	private String caption;

	@Column(name="CID")
	private String cid;

	@Column(name="Comment")
	private String comment;

	private String date;

	@Column(name="English")
	private String english;

	@Column(name="Fermenter")
	private String fermenter;

	@Column(name="HID")
	private String hid;

	@Column(name="KpiMark")
	private String kpiMark;

	private String mark;

	@Column(name="Name")
	private String name;

	@Column(name="PackagingLine")
	private String packagingLine;

	@Column(name="PotNumber")
	private String potNumber;

	@Column(name="Quantity")
	private String quantity;

	@Column(name="Reviewer")
	private String reviewer;

	@Column(name="SakeTank")
	private String sakeTank;

	@Column(name="SID")
	private String sid;

	private String time;

	@Column(name="Variety")
	private String variety;

	@Column(name="WineID")
	private String wineID;

	@Column(name="WineValve")
	private String wineValve;

	public Barcode() {
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

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getBottleType() {
		return this.bottleType;
	}

	public void setBottleType(String bottleType) {
		this.bottleType = bottleType;
	}

	public String getCaption() {
		return this.caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
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

	public String getEnglish() {
		return this.english;
	}

	public void setEnglish(String english) {
		this.english = english;
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

	public String getKpiMark() {
		return this.kpiMark;
	}

	public void setKpiMark(String kpiMark) {
		this.kpiMark = kpiMark;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPackagingLine() {
		return this.packagingLine;
	}

	public void setPackagingLine(String packagingLine) {
		this.packagingLine = packagingLine;
	}

	public String getPotNumber() {
		return this.potNumber;
	}

	public void setPotNumber(String potNumber) {
		this.potNumber = potNumber;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getReviewer() {
		return this.reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
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

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public String getWineValve() {
		return this.wineValve;
	}

	public void setWineValve(String wineValve) {
		this.wineValve = wineValve;
	}

}