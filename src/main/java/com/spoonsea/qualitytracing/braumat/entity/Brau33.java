package com.spoonsea.qualitytracing.braumat.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the brau33 database table.
 * 
 */
@Entity
@IdClass(BraumatKey.class)
@Table(name="brau33")
@NamedQuery(name="Brau33.findAll", query="SELECT b FROM Brau33 b")
public class Brau33 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="AUFTR_NR")
	private int auftrNr;

	@Column(name="CHARG_NR")
	private int chargNr;

	@Column(name="DFM_ANZ")
	private int dfmAnz;

	@Lob
	@Column(name="DIM_DFM1")
	private String dimDfm1;

	@Lob
	@Column(name="DIM_DFM10")
	private String dimDfm10;

	@Lob
	@Column(name="DIM_DFM11")
	private String dimDfm11;

	@Lob
	@Column(name="DIM_DFM12")
	private String dimDfm12;

	@Lob
	@Column(name="DIM_DFM13")
	private String dimDfm13;

	@Lob
	@Column(name="DIM_DFM14")
	private String dimDfm14;

	@Lob
	@Column(name="DIM_DFM15")
	private String dimDfm15;

	@Lob
	@Column(name="DIM_DFM16")
	private String dimDfm16;

	@Lob
	@Column(name="DIM_DFM17")
	private String dimDfm17;

	@Lob
	@Column(name="DIM_DFM18")
	private String dimDfm18;

	@Lob
	@Column(name="DIM_DFM19")
	private String dimDfm19;

	@Lob
	@Column(name="DIM_DFM2")
	private String dimDfm2;

	@Lob
	@Column(name="DIM_DFM20")
	private String dimDfm20;

	@Lob
	@Column(name="DIM_DFM21")
	private String dimDfm21;

	@Lob
	@Column(name="DIM_DFM22")
	private String dimDfm22;

	@Lob
	@Column(name="DIM_DFM23")
	private String dimDfm23;

	@Lob
	@Column(name="DIM_DFM24")
	private String dimDfm24;

	@Lob
	@Column(name="DIM_DFM3")
	private String dimDfm3;

	@Lob
	@Column(name="DIM_DFM4")
	private String dimDfm4;

	@Lob
	@Column(name="DIM_DFM5")
	private String dimDfm5;

	@Lob
	@Column(name="DIM_DFM6")
	private String dimDfm6;

	@Lob
	@Column(name="DIM_DFM7")
	private String dimDfm7;

	@Lob
	@Column(name="DIM_DFM8")
	private String dimDfm8;

	@Lob
	@Column(name="DIM_DFM9")
	private String dimDfm9;

	@Id
	@Column(name="end_ts")
	private BigInteger endTs;

	@Column(name="EZ_JAHR")
	private int ezJahr;

	@Column(name="EZ_MINUTE")
	private int ezMinute;

	@Column(name="EZ_MONAT")
	private int ezMonat;

	@Column(name="EZ_SEKUNDE")
	private int ezSekunde;

	@Column(name="EZ_STUNDE")
	private int ezStunde;

	@Column(name="EZ_TAG")
	private int ezTag;

	@Lob
	@Column(name="GOP_NAME")
	private String gopName;

	@Id
	@Column(name="GOP_NR")
	private int gopNr;

	@Lob
	@Column(name="IW_DFM1")
	private String iwDfm1;

	@Lob
	@Column(name="IW_DFM10")
	private String iwDfm10;

	@Lob
	@Column(name="IW_DFM11")
	private String iwDfm11;

	@Lob
	@Column(name="IW_DFM12")
	private String iwDfm12;

	@Lob
	@Column(name="IW_DFM13")
	private String iwDfm13;

	@Lob
	@Column(name="IW_DFM14")
	private String iwDfm14;

	@Lob
	@Column(name="IW_DFM15")
	private String iwDfm15;

	@Lob
	@Column(name="IW_DFM16")
	private String iwDfm16;

	@Lob
	@Column(name="IW_DFM17")
	private String iwDfm17;

	@Lob
	@Column(name="IW_DFM18")
	private String iwDfm18;

	@Lob
	@Column(name="IW_DFM19")
	private String iwDfm19;

	@Lob
	@Column(name="IW_DFM2")
	private String iwDfm2;

	@Lob
	@Column(name="IW_DFM20")
	private String iwDfm20;

	@Lob
	@Column(name="IW_DFM21")
	private String iwDfm21;

	@Lob
	@Column(name="IW_DFM22")
	private String iwDfm22;

	@Lob
	@Column(name="IW_DFM23")
	private String iwDfm23;

	@Lob
	@Column(name="IW_DFM24")
	private String iwDfm24;

	@Lob
	@Column(name="IW_DFM3")
	private String iwDfm3;

	@Lob
	@Column(name="IW_DFM4")
	private String iwDfm4;

	@Lob
	@Column(name="IW_DFM5")
	private String iwDfm5;

	@Lob
	@Column(name="IW_DFM6")
	private String iwDfm6;

	@Lob
	@Column(name="IW_DFM7")
	private String iwDfm7;

	@Lob
	@Column(name="IW_DFM8")
	private String iwDfm8;

	@Lob
	@Column(name="IW_DFM9")
	private String iwDfm9;

	@Column(name="IW_ZEIT")
	private int iwZeit;

	@Lob
	@Column(name="NAME_DFM1")
	private String nameDfm1;

	@Lob
	@Column(name="NAME_DFM10")
	private String nameDfm10;

	@Lob
	@Column(name="NAME_DFM11")
	private String nameDfm11;

	@Lob
	@Column(name="NAME_DFM12")
	private String nameDfm12;

	@Lob
	@Column(name="NAME_DFM13")
	private String nameDfm13;

	@Lob
	@Column(name="NAME_DFM14")
	private String nameDfm14;

	@Lob
	@Column(name="NAME_DFM15")
	private String nameDfm15;

	@Lob
	@Column(name="NAME_DFM16")
	private String nameDfm16;

	@Lob
	@Column(name="NAME_DFM17")
	private String nameDfm17;

	@Lob
	@Column(name="NAME_DFM18")
	private String nameDfm18;

	@Lob
	@Column(name="NAME_DFM19")
	private String nameDfm19;

	@Lob
	@Column(name="NAME_DFM2")
	private String nameDfm2;

	@Lob
	@Column(name="NAME_DFM20")
	private String nameDfm20;

	@Lob
	@Column(name="NAME_DFM21")
	private String nameDfm21;

	@Lob
	@Column(name="NAME_DFM22")
	private String nameDfm22;

	@Lob
	@Column(name="NAME_DFM23")
	private String nameDfm23;

	@Lob
	@Column(name="NAME_DFM24")
	private String nameDfm24;

	@Lob
	@Column(name="NAME_DFM3")
	private String nameDfm3;

	@Lob
	@Column(name="NAME_DFM4")
	private String nameDfm4;

	@Lob
	@Column(name="NAME_DFM5")
	private String nameDfm5;

	@Lob
	@Column(name="NAME_DFM6")
	private String nameDfm6;

	@Lob
	@Column(name="NAME_DFM7")
	private String nameDfm7;

	@Lob
	@Column(name="NAME_DFM8")
	private String nameDfm8;

	@Lob
	@Column(name="NAME_DFM9")
	private String nameDfm9;

	@Lob
	@Column(name="NR_DFM1")
	private String nrDfm1;

	@Lob
	@Column(name="NR_DFM10")
	private String nrDfm10;

	@Lob
	@Column(name="NR_DFM11")
	private String nrDfm11;

	@Lob
	@Column(name="NR_DFM12")
	private String nrDfm12;

	@Lob
	@Column(name="NR_DFM13")
	private String nrDfm13;

	@Lob
	@Column(name="NR_DFM14")
	private String nrDfm14;

	@Lob
	@Column(name="NR_DFM15")
	private String nrDfm15;

	@Lob
	@Column(name="NR_DFM16")
	private String nrDfm16;

	@Lob
	@Column(name="NR_DFM17")
	private String nrDfm17;

	@Lob
	@Column(name="NR_DFM18")
	private String nrDfm18;

	@Lob
	@Column(name="NR_DFM19")
	private String nrDfm19;

	@Lob
	@Column(name="NR_DFM2")
	private String nrDfm2;

	@Lob
	@Column(name="NR_DFM20")
	private String nrDfm20;

	@Lob
	@Column(name="NR_DFM21")
	private String nrDfm21;

	@Lob
	@Column(name="NR_DFM22")
	private String nrDfm22;

	@Lob
	@Column(name="NR_DFM23")
	private String nrDfm23;

	@Lob
	@Column(name="NR_DFM24")
	private String nrDfm24;

	@Lob
	@Column(name="NR_DFM3")
	private String nrDfm3;

	@Lob
	@Column(name="NR_DFM4")
	private String nrDfm4;

	@Lob
	@Column(name="NR_DFM5")
	private String nrDfm5;

	@Lob
	@Column(name="NR_DFM6")
	private String nrDfm6;

	@Lob
	@Column(name="NR_DFM7")
	private String nrDfm7;

	@Lob
	@Column(name="NR_DFM8")
	private String nrDfm8;

	@Lob
	@Column(name="NR_DFM9")
	private String nrDfm9;

	@Lob
	@Column(name="PCU")
	private String pcu;

	@Column(name="PCU_NR")
	private int pcuNr;

	@Lob
	@Column(name="PRODUCT")
	private String product;

	@Column(name="PRODUCT_ID")
	private int productId;

	@Column(name="RECPROC_NR")
	private int recprocNr;

	@Lob
	@Column(name="REZ_TYP")
	private String rezTyp;

	@Column(name="REZ_TYP_NR")
	private int rezTypNr;

	@Lob
	@Column(name="REZEPT")
	private String rezept;

	@Column(name="REZEPT_NR")
	private int rezeptNr;

	@Column(name="ROP_ID")
	private int ropId;

	@Id
	@Column(name="start_ts")
	private BigInteger startTs;

	@Lob
	@Column(name="SW_DFM1")
	private String swDfm1;

	@Lob
	@Column(name="SW_DFM10")
	private String swDfm10;

	@Lob
	@Column(name="SW_DFM11")
	private String swDfm11;

	@Lob
	@Column(name="SW_DFM12")
	private String swDfm12;

	@Lob
	@Column(name="SW_DFM13")
	private String swDfm13;

	@Lob
	@Column(name="SW_DFM14")
	private String swDfm14;

	@Lob
	@Column(name="SW_DFM15")
	private String swDfm15;

	@Lob
	@Column(name="SW_DFM16")
	private String swDfm16;

	@Lob
	@Column(name="SW_DFM17")
	private String swDfm17;

	@Lob
	@Column(name="SW_DFM18")
	private String swDfm18;

	@Lob
	@Column(name="SW_DFM19")
	private String swDfm19;

	@Lob
	@Column(name="SW_DFM2")
	private String swDfm2;

	@Lob
	@Column(name="SW_DFM20")
	private String swDfm20;

	@Lob
	@Column(name="SW_DFM21")
	private String swDfm21;

	@Lob
	@Column(name="SW_DFM22")
	private String swDfm22;

	@Lob
	@Column(name="SW_DFM23")
	private String swDfm23;

	@Lob
	@Column(name="SW_DFM24")
	private String swDfm24;

	@Lob
	@Column(name="SW_DFM3")
	private String swDfm3;

	@Lob
	@Column(name="SW_DFM4")
	private String swDfm4;

	@Lob
	@Column(name="SW_DFM5")
	private String swDfm5;

	@Lob
	@Column(name="SW_DFM6")
	private String swDfm6;

	@Lob
	@Column(name="SW_DFM7")
	private String swDfm7;

	@Lob
	@Column(name="SW_DFM8")
	private String swDfm8;

	@Lob
	@Column(name="SW_DFM9")
	private String swDfm9;

	@Column(name="SW_ZEIT")
	private int swZeit;

	@Column(name="SZ_JAHR")
	private int szJahr;

	@Column(name="SZ_MINUTE")
	private int szMinute;

	@Column(name="SZ_MONAT")
	private int szMonat;

	@Column(name="SZ_SEKUNDE")
	private int szSekunde;

	@Column(name="SZ_STUNDE")
	private int szStunde;

	@Column(name="SZ_TAG")
	private int szTag;

	@Lob
	@Column(name="TEILANL")
	private String teilanl;

	@Id
	@Column(name="TEILANL_NR")
	private int teilanlNr;

	@Column(name="USRPROT_ID")
	private int usrprotId;

	public Brau33() {
	}

	public int getAuftrNr() {
		return this.auftrNr;
	}

	public void setAuftrNr(int auftrNr) {
		this.auftrNr = auftrNr;
	}

	public int getChargNr() {
		return this.chargNr;
	}

	public void setChargNr(int chargNr) {
		this.chargNr = chargNr;
	}

	public int getDfmAnz() {
		return this.dfmAnz;
	}

	public void setDfmAnz(int dfmAnz) {
		this.dfmAnz = dfmAnz;
	}

	public String getDimDfm1() {
		return this.dimDfm1;
	}

	public void setDimDfm1(String dimDfm1) {
		this.dimDfm1 = dimDfm1;
	}

	public String getDimDfm10() {
		return this.dimDfm10;
	}

	public void setDimDfm10(String dimDfm10) {
		this.dimDfm10 = dimDfm10;
	}

	public String getDimDfm11() {
		return this.dimDfm11;
	}

	public void setDimDfm11(String dimDfm11) {
		this.dimDfm11 = dimDfm11;
	}

	public String getDimDfm12() {
		return this.dimDfm12;
	}

	public void setDimDfm12(String dimDfm12) {
		this.dimDfm12 = dimDfm12;
	}

	public String getDimDfm13() {
		return this.dimDfm13;
	}

	public void setDimDfm13(String dimDfm13) {
		this.dimDfm13 = dimDfm13;
	}

	public String getDimDfm14() {
		return this.dimDfm14;
	}

	public void setDimDfm14(String dimDfm14) {
		this.dimDfm14 = dimDfm14;
	}

	public String getDimDfm15() {
		return this.dimDfm15;
	}

	public void setDimDfm15(String dimDfm15) {
		this.dimDfm15 = dimDfm15;
	}

	public String getDimDfm16() {
		return this.dimDfm16;
	}

	public void setDimDfm16(String dimDfm16) {
		this.dimDfm16 = dimDfm16;
	}

	public String getDimDfm17() {
		return this.dimDfm17;
	}

	public void setDimDfm17(String dimDfm17) {
		this.dimDfm17 = dimDfm17;
	}

	public String getDimDfm18() {
		return this.dimDfm18;
	}

	public void setDimDfm18(String dimDfm18) {
		this.dimDfm18 = dimDfm18;
	}

	public String getDimDfm19() {
		return this.dimDfm19;
	}

	public void setDimDfm19(String dimDfm19) {
		this.dimDfm19 = dimDfm19;
	}

	public String getDimDfm2() {
		return this.dimDfm2;
	}

	public void setDimDfm2(String dimDfm2) {
		this.dimDfm2 = dimDfm2;
	}

	public String getDimDfm20() {
		return this.dimDfm20;
	}

	public void setDimDfm20(String dimDfm20) {
		this.dimDfm20 = dimDfm20;
	}

	public String getDimDfm21() {
		return this.dimDfm21;
	}

	public void setDimDfm21(String dimDfm21) {
		this.dimDfm21 = dimDfm21;
	}

	public String getDimDfm22() {
		return this.dimDfm22;
	}

	public void setDimDfm22(String dimDfm22) {
		this.dimDfm22 = dimDfm22;
	}

	public String getDimDfm23() {
		return this.dimDfm23;
	}

	public void setDimDfm23(String dimDfm23) {
		this.dimDfm23 = dimDfm23;
	}

	public String getDimDfm24() {
		return this.dimDfm24;
	}

	public void setDimDfm24(String dimDfm24) {
		this.dimDfm24 = dimDfm24;
	}

	public String getDimDfm3() {
		return this.dimDfm3;
	}

	public void setDimDfm3(String dimDfm3) {
		this.dimDfm3 = dimDfm3;
	}

	public String getDimDfm4() {
		return this.dimDfm4;
	}

	public void setDimDfm4(String dimDfm4) {
		this.dimDfm4 = dimDfm4;
	}

	public String getDimDfm5() {
		return this.dimDfm5;
	}

	public void setDimDfm5(String dimDfm5) {
		this.dimDfm5 = dimDfm5;
	}

	public String getDimDfm6() {
		return this.dimDfm6;
	}

	public void setDimDfm6(String dimDfm6) {
		this.dimDfm6 = dimDfm6;
	}

	public String getDimDfm7() {
		return this.dimDfm7;
	}

	public void setDimDfm7(String dimDfm7) {
		this.dimDfm7 = dimDfm7;
	}

	public String getDimDfm8() {
		return this.dimDfm8;
	}

	public void setDimDfm8(String dimDfm8) {
		this.dimDfm8 = dimDfm8;
	}

	public String getDimDfm9() {
		return this.dimDfm9;
	}

	public void setDimDfm9(String dimDfm9) {
		this.dimDfm9 = dimDfm9;
	}

	public BigInteger getEndTs() {
		return this.endTs;
	}

	public void setEndTs(BigInteger endTs) {
		this.endTs = endTs;
	}

	public int getEzJahr() {
		return this.ezJahr;
	}

	public void setEzJahr(int ezJahr) {
		this.ezJahr = ezJahr;
	}

	public int getEzMinute() {
		return this.ezMinute;
	}

	public void setEzMinute(int ezMinute) {
		this.ezMinute = ezMinute;
	}

	public int getEzMonat() {
		return this.ezMonat;
	}

	public void setEzMonat(int ezMonat) {
		this.ezMonat = ezMonat;
	}

	public int getEzSekunde() {
		return this.ezSekunde;
	}

	public void setEzSekunde(int ezSekunde) {
		this.ezSekunde = ezSekunde;
	}

	public int getEzStunde() {
		return this.ezStunde;
	}

	public void setEzStunde(int ezStunde) {
		this.ezStunde = ezStunde;
	}

	public int getEzTag() {
		return this.ezTag;
	}

	public void setEzTag(int ezTag) {
		this.ezTag = ezTag;
	}

	public String getGopName() {
		return this.gopName;
	}

	public void setGopName(String gopName) {
		this.gopName = gopName;
	}

	public int getGopNr() {
		return this.gopNr;
	}

	public void setGopNr(int gopNr) {
		this.gopNr = gopNr;
	}

	public String getIwDfm1() {
		return this.iwDfm1;
	}

	public void setIwDfm1(String iwDfm1) {
		this.iwDfm1 = iwDfm1;
	}

	public String getIwDfm10() {
		return this.iwDfm10;
	}

	public void setIwDfm10(String iwDfm10) {
		this.iwDfm10 = iwDfm10;
	}

	public String getIwDfm11() {
		return this.iwDfm11;
	}

	public void setIwDfm11(String iwDfm11) {
		this.iwDfm11 = iwDfm11;
	}

	public String getIwDfm12() {
		return this.iwDfm12;
	}

	public void setIwDfm12(String iwDfm12) {
		this.iwDfm12 = iwDfm12;
	}

	public String getIwDfm13() {
		return this.iwDfm13;
	}

	public void setIwDfm13(String iwDfm13) {
		this.iwDfm13 = iwDfm13;
	}

	public String getIwDfm14() {
		return this.iwDfm14;
	}

	public void setIwDfm14(String iwDfm14) {
		this.iwDfm14 = iwDfm14;
	}

	public String getIwDfm15() {
		return this.iwDfm15;
	}

	public void setIwDfm15(String iwDfm15) {
		this.iwDfm15 = iwDfm15;
	}

	public String getIwDfm16() {
		return this.iwDfm16;
	}

	public void setIwDfm16(String iwDfm16) {
		this.iwDfm16 = iwDfm16;
	}

	public String getIwDfm17() {
		return this.iwDfm17;
	}

	public void setIwDfm17(String iwDfm17) {
		this.iwDfm17 = iwDfm17;
	}

	public String getIwDfm18() {
		return this.iwDfm18;
	}

	public void setIwDfm18(String iwDfm18) {
		this.iwDfm18 = iwDfm18;
	}

	public String getIwDfm19() {
		return this.iwDfm19;
	}

	public void setIwDfm19(String iwDfm19) {
		this.iwDfm19 = iwDfm19;
	}

	public String getIwDfm2() {
		return this.iwDfm2;
	}

	public void setIwDfm2(String iwDfm2) {
		this.iwDfm2 = iwDfm2;
	}

	public String getIwDfm20() {
		return this.iwDfm20;
	}

	public void setIwDfm20(String iwDfm20) {
		this.iwDfm20 = iwDfm20;
	}

	public String getIwDfm21() {
		return this.iwDfm21;
	}

	public void setIwDfm21(String iwDfm21) {
		this.iwDfm21 = iwDfm21;
	}

	public String getIwDfm22() {
		return this.iwDfm22;
	}

	public void setIwDfm22(String iwDfm22) {
		this.iwDfm22 = iwDfm22;
	}

	public String getIwDfm23() {
		return this.iwDfm23;
	}

	public void setIwDfm23(String iwDfm23) {
		this.iwDfm23 = iwDfm23;
	}

	public String getIwDfm24() {
		return this.iwDfm24;
	}

	public void setIwDfm24(String iwDfm24) {
		this.iwDfm24 = iwDfm24;
	}

	public String getIwDfm3() {
		return this.iwDfm3;
	}

	public void setIwDfm3(String iwDfm3) {
		this.iwDfm3 = iwDfm3;
	}

	public String getIwDfm4() {
		return this.iwDfm4;
	}

	public void setIwDfm4(String iwDfm4) {
		this.iwDfm4 = iwDfm4;
	}

	public String getIwDfm5() {
		return this.iwDfm5;
	}

	public void setIwDfm5(String iwDfm5) {
		this.iwDfm5 = iwDfm5;
	}

	public String getIwDfm6() {
		return this.iwDfm6;
	}

	public void setIwDfm6(String iwDfm6) {
		this.iwDfm6 = iwDfm6;
	}

	public String getIwDfm7() {
		return this.iwDfm7;
	}

	public void setIwDfm7(String iwDfm7) {
		this.iwDfm7 = iwDfm7;
	}

	public String getIwDfm8() {
		return this.iwDfm8;
	}

	public void setIwDfm8(String iwDfm8) {
		this.iwDfm8 = iwDfm8;
	}

	public String getIwDfm9() {
		return this.iwDfm9;
	}

	public void setIwDfm9(String iwDfm9) {
		this.iwDfm9 = iwDfm9;
	}

	public int getIwZeit() {
		return this.iwZeit;
	}

	public void setIwZeit(int iwZeit) {
		this.iwZeit = iwZeit;
	}

	public String getNameDfm1() {
		return this.nameDfm1;
	}

	public void setNameDfm1(String nameDfm1) {
		this.nameDfm1 = nameDfm1;
	}

	public String getNameDfm10() {
		return this.nameDfm10;
	}

	public void setNameDfm10(String nameDfm10) {
		this.nameDfm10 = nameDfm10;
	}

	public String getNameDfm11() {
		return this.nameDfm11;
	}

	public void setNameDfm11(String nameDfm11) {
		this.nameDfm11 = nameDfm11;
	}

	public String getNameDfm12() {
		return this.nameDfm12;
	}

	public void setNameDfm12(String nameDfm12) {
		this.nameDfm12 = nameDfm12;
	}

	public String getNameDfm13() {
		return this.nameDfm13;
	}

	public void setNameDfm13(String nameDfm13) {
		this.nameDfm13 = nameDfm13;
	}

	public String getNameDfm14() {
		return this.nameDfm14;
	}

	public void setNameDfm14(String nameDfm14) {
		this.nameDfm14 = nameDfm14;
	}

	public String getNameDfm15() {
		return this.nameDfm15;
	}

	public void setNameDfm15(String nameDfm15) {
		this.nameDfm15 = nameDfm15;
	}

	public String getNameDfm16() {
		return this.nameDfm16;
	}

	public void setNameDfm16(String nameDfm16) {
		this.nameDfm16 = nameDfm16;
	}

	public String getNameDfm17() {
		return this.nameDfm17;
	}

	public void setNameDfm17(String nameDfm17) {
		this.nameDfm17 = nameDfm17;
	}

	public String getNameDfm18() {
		return this.nameDfm18;
	}

	public void setNameDfm18(String nameDfm18) {
		this.nameDfm18 = nameDfm18;
	}

	public String getNameDfm19() {
		return this.nameDfm19;
	}

	public void setNameDfm19(String nameDfm19) {
		this.nameDfm19 = nameDfm19;
	}

	public String getNameDfm2() {
		return this.nameDfm2;
	}

	public void setNameDfm2(String nameDfm2) {
		this.nameDfm2 = nameDfm2;
	}

	public String getNameDfm20() {
		return this.nameDfm20;
	}

	public void setNameDfm20(String nameDfm20) {
		this.nameDfm20 = nameDfm20;
	}

	public String getNameDfm21() {
		return this.nameDfm21;
	}

	public void setNameDfm21(String nameDfm21) {
		this.nameDfm21 = nameDfm21;
	}

	public String getNameDfm22() {
		return this.nameDfm22;
	}

	public void setNameDfm22(String nameDfm22) {
		this.nameDfm22 = nameDfm22;
	}

	public String getNameDfm23() {
		return this.nameDfm23;
	}

	public void setNameDfm23(String nameDfm23) {
		this.nameDfm23 = nameDfm23;
	}

	public String getNameDfm24() {
		return this.nameDfm24;
	}

	public void setNameDfm24(String nameDfm24) {
		this.nameDfm24 = nameDfm24;
	}

	public String getNameDfm3() {
		return this.nameDfm3;
	}

	public void setNameDfm3(String nameDfm3) {
		this.nameDfm3 = nameDfm3;
	}

	public String getNameDfm4() {
		return this.nameDfm4;
	}

	public void setNameDfm4(String nameDfm4) {
		this.nameDfm4 = nameDfm4;
	}

	public String getNameDfm5() {
		return this.nameDfm5;
	}

	public void setNameDfm5(String nameDfm5) {
		this.nameDfm5 = nameDfm5;
	}

	public String getNameDfm6() {
		return this.nameDfm6;
	}

	public void setNameDfm6(String nameDfm6) {
		this.nameDfm6 = nameDfm6;
	}

	public String getNameDfm7() {
		return this.nameDfm7;
	}

	public void setNameDfm7(String nameDfm7) {
		this.nameDfm7 = nameDfm7;
	}

	public String getNameDfm8() {
		return this.nameDfm8;
	}

	public void setNameDfm8(String nameDfm8) {
		this.nameDfm8 = nameDfm8;
	}

	public String getNameDfm9() {
		return this.nameDfm9;
	}

	public void setNameDfm9(String nameDfm9) {
		this.nameDfm9 = nameDfm9;
	}

	public String getNrDfm1() {
		return this.nrDfm1;
	}

	public void setNrDfm1(String nrDfm1) {
		this.nrDfm1 = nrDfm1;
	}

	public String getNrDfm10() {
		return this.nrDfm10;
	}

	public void setNrDfm10(String nrDfm10) {
		this.nrDfm10 = nrDfm10;
	}

	public String getNrDfm11() {
		return this.nrDfm11;
	}

	public void setNrDfm11(String nrDfm11) {
		this.nrDfm11 = nrDfm11;
	}

	public String getNrDfm12() {
		return this.nrDfm12;
	}

	public void setNrDfm12(String nrDfm12) {
		this.nrDfm12 = nrDfm12;
	}

	public String getNrDfm13() {
		return this.nrDfm13;
	}

	public void setNrDfm13(String nrDfm13) {
		this.nrDfm13 = nrDfm13;
	}

	public String getNrDfm14() {
		return this.nrDfm14;
	}

	public void setNrDfm14(String nrDfm14) {
		this.nrDfm14 = nrDfm14;
	}

	public String getNrDfm15() {
		return this.nrDfm15;
	}

	public void setNrDfm15(String nrDfm15) {
		this.nrDfm15 = nrDfm15;
	}

	public String getNrDfm16() {
		return this.nrDfm16;
	}

	public void setNrDfm16(String nrDfm16) {
		this.nrDfm16 = nrDfm16;
	}

	public String getNrDfm17() {
		return this.nrDfm17;
	}

	public void setNrDfm17(String nrDfm17) {
		this.nrDfm17 = nrDfm17;
	}

	public String getNrDfm18() {
		return this.nrDfm18;
	}

	public void setNrDfm18(String nrDfm18) {
		this.nrDfm18 = nrDfm18;
	}

	public String getNrDfm19() {
		return this.nrDfm19;
	}

	public void setNrDfm19(String nrDfm19) {
		this.nrDfm19 = nrDfm19;
	}

	public String getNrDfm2() {
		return this.nrDfm2;
	}

	public void setNrDfm2(String nrDfm2) {
		this.nrDfm2 = nrDfm2;
	}

	public String getNrDfm20() {
		return this.nrDfm20;
	}

	public void setNrDfm20(String nrDfm20) {
		this.nrDfm20 = nrDfm20;
	}

	public String getNrDfm21() {
		return this.nrDfm21;
	}

	public void setNrDfm21(String nrDfm21) {
		this.nrDfm21 = nrDfm21;
	}

	public String getNrDfm22() {
		return this.nrDfm22;
	}

	public void setNrDfm22(String nrDfm22) {
		this.nrDfm22 = nrDfm22;
	}

	public String getNrDfm23() {
		return this.nrDfm23;
	}

	public void setNrDfm23(String nrDfm23) {
		this.nrDfm23 = nrDfm23;
	}

	public String getNrDfm24() {
		return this.nrDfm24;
	}

	public void setNrDfm24(String nrDfm24) {
		this.nrDfm24 = nrDfm24;
	}

	public String getNrDfm3() {
		return this.nrDfm3;
	}

	public void setNrDfm3(String nrDfm3) {
		this.nrDfm3 = nrDfm3;
	}

	public String getNrDfm4() {
		return this.nrDfm4;
	}

	public void setNrDfm4(String nrDfm4) {
		this.nrDfm4 = nrDfm4;
	}

	public String getNrDfm5() {
		return this.nrDfm5;
	}

	public void setNrDfm5(String nrDfm5) {
		this.nrDfm5 = nrDfm5;
	}

	public String getNrDfm6() {
		return this.nrDfm6;
	}

	public void setNrDfm6(String nrDfm6) {
		this.nrDfm6 = nrDfm6;
	}

	public String getNrDfm7() {
		return this.nrDfm7;
	}

	public void setNrDfm7(String nrDfm7) {
		this.nrDfm7 = nrDfm7;
	}

	public String getNrDfm8() {
		return this.nrDfm8;
	}

	public void setNrDfm8(String nrDfm8) {
		this.nrDfm8 = nrDfm8;
	}

	public String getNrDfm9() {
		return this.nrDfm9;
	}

	public void setNrDfm9(String nrDfm9) {
		this.nrDfm9 = nrDfm9;
	}

	public String getPcu() {
		return this.pcu;
	}

	public void setPcu(String pcu) {
		this.pcu = pcu;
	}

	public int getPcuNr() {
		return this.pcuNr;
	}

	public void setPcuNr(int pcuNr) {
		this.pcuNr = pcuNr;
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getRecprocNr() {
		return this.recprocNr;
	}

	public void setRecprocNr(int recprocNr) {
		this.recprocNr = recprocNr;
	}

	public String getRezTyp() {
		return this.rezTyp;
	}

	public void setRezTyp(String rezTyp) {
		this.rezTyp = rezTyp;
	}

	public int getRezTypNr() {
		return this.rezTypNr;
	}

	public void setRezTypNr(int rezTypNr) {
		this.rezTypNr = rezTypNr;
	}

	public String getRezept() {
		return this.rezept;
	}

	public void setRezept(String rezept) {
		this.rezept = rezept;
	}

	public int getRezeptNr() {
		return this.rezeptNr;
	}

	public void setRezeptNr(int rezeptNr) {
		this.rezeptNr = rezeptNr;
	}

	public int getRopId() {
		return this.ropId;
	}

	public void setRopId(int ropId) {
		this.ropId = ropId;
	}

	public BigInteger getStartTs() {
		return this.startTs;
	}

	public void setStartTs(BigInteger startTs) {
		this.startTs = startTs;
	}

	public String getSwDfm1() {
		return this.swDfm1;
	}

	public void setSwDfm1(String swDfm1) {
		this.swDfm1 = swDfm1;
	}

	public String getSwDfm10() {
		return this.swDfm10;
	}

	public void setSwDfm10(String swDfm10) {
		this.swDfm10 = swDfm10;
	}

	public String getSwDfm11() {
		return this.swDfm11;
	}

	public void setSwDfm11(String swDfm11) {
		this.swDfm11 = swDfm11;
	}

	public String getSwDfm12() {
		return this.swDfm12;
	}

	public void setSwDfm12(String swDfm12) {
		this.swDfm12 = swDfm12;
	}

	public String getSwDfm13() {
		return this.swDfm13;
	}

	public void setSwDfm13(String swDfm13) {
		this.swDfm13 = swDfm13;
	}

	public String getSwDfm14() {
		return this.swDfm14;
	}

	public void setSwDfm14(String swDfm14) {
		this.swDfm14 = swDfm14;
	}

	public String getSwDfm15() {
		return this.swDfm15;
	}

	public void setSwDfm15(String swDfm15) {
		this.swDfm15 = swDfm15;
	}

	public String getSwDfm16() {
		return this.swDfm16;
	}

	public void setSwDfm16(String swDfm16) {
		this.swDfm16 = swDfm16;
	}

	public String getSwDfm17() {
		return this.swDfm17;
	}

	public void setSwDfm17(String swDfm17) {
		this.swDfm17 = swDfm17;
	}

	public String getSwDfm18() {
		return this.swDfm18;
	}

	public void setSwDfm18(String swDfm18) {
		this.swDfm18 = swDfm18;
	}

	public String getSwDfm19() {
		return this.swDfm19;
	}

	public void setSwDfm19(String swDfm19) {
		this.swDfm19 = swDfm19;
	}

	public String getSwDfm2() {
		return this.swDfm2;
	}

	public void setSwDfm2(String swDfm2) {
		this.swDfm2 = swDfm2;
	}

	public String getSwDfm20() {
		return this.swDfm20;
	}

	public void setSwDfm20(String swDfm20) {
		this.swDfm20 = swDfm20;
	}

	public String getSwDfm21() {
		return this.swDfm21;
	}

	public void setSwDfm21(String swDfm21) {
		this.swDfm21 = swDfm21;
	}

	public String getSwDfm22() {
		return this.swDfm22;
	}

	public void setSwDfm22(String swDfm22) {
		this.swDfm22 = swDfm22;
	}

	public String getSwDfm23() {
		return this.swDfm23;
	}

	public void setSwDfm23(String swDfm23) {
		this.swDfm23 = swDfm23;
	}

	public String getSwDfm24() {
		return this.swDfm24;
	}

	public void setSwDfm24(String swDfm24) {
		this.swDfm24 = swDfm24;
	}

	public String getSwDfm3() {
		return this.swDfm3;
	}

	public void setSwDfm3(String swDfm3) {
		this.swDfm3 = swDfm3;
	}

	public String getSwDfm4() {
		return this.swDfm4;
	}

	public void setSwDfm4(String swDfm4) {
		this.swDfm4 = swDfm4;
	}

	public String getSwDfm5() {
		return this.swDfm5;
	}

	public void setSwDfm5(String swDfm5) {
		this.swDfm5 = swDfm5;
	}

	public String getSwDfm6() {
		return this.swDfm6;
	}

	public void setSwDfm6(String swDfm6) {
		this.swDfm6 = swDfm6;
	}

	public String getSwDfm7() {
		return this.swDfm7;
	}

	public void setSwDfm7(String swDfm7) {
		this.swDfm7 = swDfm7;
	}

	public String getSwDfm8() {
		return this.swDfm8;
	}

	public void setSwDfm8(String swDfm8) {
		this.swDfm8 = swDfm8;
	}

	public String getSwDfm9() {
		return this.swDfm9;
	}

	public void setSwDfm9(String swDfm9) {
		this.swDfm9 = swDfm9;
	}

	public int getSwZeit() {
		return this.swZeit;
	}

	public void setSwZeit(int swZeit) {
		this.swZeit = swZeit;
	}

	public int getSzJahr() {
		return this.szJahr;
	}

	public void setSzJahr(int szJahr) {
		this.szJahr = szJahr;
	}

	public int getSzMinute() {
		return this.szMinute;
	}

	public void setSzMinute(int szMinute) {
		this.szMinute = szMinute;
	}

	public int getSzMonat() {
		return this.szMonat;
	}

	public void setSzMonat(int szMonat) {
		this.szMonat = szMonat;
	}

	public int getSzSekunde() {
		return this.szSekunde;
	}

	public void setSzSekunde(int szSekunde) {
		this.szSekunde = szSekunde;
	}

	public int getSzStunde() {
		return this.szStunde;
	}

	public void setSzStunde(int szStunde) {
		this.szStunde = szStunde;
	}

	public int getSzTag() {
		return this.szTag;
	}

	public void setSzTag(int szTag) {
		this.szTag = szTag;
	}

	public String getTeilanl() {
		return this.teilanl;
	}

	public void setTeilanl(String teilanl) {
		this.teilanl = teilanl;
	}

	public int getTeilanlNr() {
		return this.teilanlNr;
	}

	public void setTeilanlNr(int teilanlNr) {
		this.teilanlNr = teilanlNr;
	}

	public int getUsrprotId() {
		return this.usrprotId;
	}

	public void setUsrprotId(int usrprotId) {
		this.usrprotId = usrprotId;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((endTs == null) ? 0 : endTs.hashCode());
        result = prime * result + ((gopName == null) ? 0 : gopName.hashCode());
        result = prime * result + ((startTs == null) ? 0 : startTs.hashCode());
        result = prime * result + ((teilanl == null) ? 0 : teilanl.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Brau33 other = (Brau33) obj;
        if (endTs == null) {
            if (other.endTs != null)
                return false;
        } else if (!endTs.equals(other.endTs))
            return false;
        if (gopName == null) {
            if (other.gopName != null)
                return false;
        } else if (!gopName.equals(other.gopName))
            return false;
        if (startTs == null) {
            if (other.startTs != null)
                return false;
        } else if (!startTs.equals(other.startTs))
            return false;
        if (teilanl == null) {
            if (other.teilanl != null)
                return false;
        } else if (!teilanl.equals(other.teilanl))
            return false;
        return true;
    }

}