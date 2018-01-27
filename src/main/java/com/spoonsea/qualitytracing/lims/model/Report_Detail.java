package com.spoonsea.qualitytracing.lims.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the Report_Details database table.
 * 
 */
@Entity
@Table(name="Report_Details")
@NamedQuery(name="Report_Detail.findAll", query="SELECT r FROM Report_Detail r")
public class Report_Detail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;

	@Column(name="AberrantSummary")
	private String aberrantSummary;

	@Column(name="Bits")
	private BigDecimal bits;

	@Column(name="Chinese")
	private String chinese;

	@Column(name="English")
	private String english;

	@Column(name="Hide")
	private String hide;

	@Column(name="Length")
	private BigDecimal length;

	@Column(name="NotCollect")
	private String notCollect;

	@Column(name="Number_Type")
	private String number_Type;

	@Column(name="Packet")
	private String packet;

	@Column(name="PacketChin")
	private String packetChin;

	private String pts;

	@Column(name="RID")
	private BigDecimal rid;

	@Column(name="ShartFilter")
	private String shartFilter;

	@Column(name="SIC")
	private String sic;

	private String specification;

	@Column(name="SummaryColumn")
	private String summaryColumn;

	@Column(name="Unit")
	private String unit;

	public Report_Detail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAberrantSummary() {
		return this.aberrantSummary;
	}

	public void setAberrantSummary(String aberrantSummary) {
		this.aberrantSummary = aberrantSummary;
	}

	public BigDecimal getBits() {
		return this.bits;
	}

	public void setBits(BigDecimal bits) {
		this.bits = bits;
	}

	public String getChinese() {
		return this.chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public String getEnglish() {
		return this.english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getHide() {
		return this.hide;
	}

	public void setHide(String hide) {
		this.hide = hide;
	}

	public BigDecimal getLength() {
		return this.length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public String getNotCollect() {
		return this.notCollect;
	}

	public void setNotCollect(String notCollect) {
		this.notCollect = notCollect;
	}

	public String getNumber_Type() {
		return this.number_Type;
	}

	public void setNumber_Type(String number_Type) {
		this.number_Type = number_Type;
	}

	public String getPacket() {
		return this.packet;
	}

	public void setPacket(String packet) {
		this.packet = packet;
	}

	public String getPacketChin() {
		return this.packetChin;
	}

	public void setPacketChin(String packetChin) {
		this.packetChin = packetChin;
	}

	public String getPts() {
		return this.pts;
	}

	public void setPts(String pts) {
		this.pts = pts;
	}

	public BigDecimal getRid() {
		return this.rid;
	}

	public void setRid(BigDecimal rid) {
		this.rid = rid;
	}

	public String getShartFilter() {
		return this.shartFilter;
	}

	public void setShartFilter(String shartFilter) {
		this.shartFilter = shartFilter;
	}

	public String getSic() {
		return this.sic;
	}

	public void setSic(String sic) {
		this.sic = sic;
	}

	public String getSpecification() {
		return this.specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getSummaryColumn() {
		return this.summaryColumn;
	}

	public void setSummaryColumn(String summaryColumn) {
		this.summaryColumn = summaryColumn;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}