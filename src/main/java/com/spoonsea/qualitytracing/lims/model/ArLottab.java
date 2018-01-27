package com.spoonsea.qualitytracing.lims.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ArLottab database table.
 * 
 */
@Entity
@NamedQuery(name="ArLottab.findAll", query="SELECT a FROM ArLottab a")
public class ArLottab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private String id;

	@Column(name="Accessories")
	private String accessories;

	@Column(name="Barcode")
	private String barcode;

	@Column(name="Factory")
	private String factory;

	@Column(name="Lot")
	private String lot;

	@Column(name="Name")
	private String name;

	@Column(name="TabID")
	private String tabID;

	public ArLottab() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccessories() {
		return this.accessories;
	}

	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getFactory() {
		return this.factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getLot() {
		return this.lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTabID() {
		return this.tabID;
	}

	public void setTabID(String tabID) {
		this.tabID = tabID;
	}

}