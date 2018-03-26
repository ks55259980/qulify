package com.spoonsea.qualitytracing.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spoonsea.qualitytracing.util.BigDecimalSerializer;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class SakeLabCheckRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ID;
    private String Date;
    private String Fermentation;
    private String SakeTank;
    private String Variety;
    private String Quantity;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal CO2;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal DO;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal OG;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal AE;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal RDF;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Alcohol;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Turbidity90;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Turbidity25;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal PH;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Colour;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal IBU;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Polyphenols;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Fe;
    private String conclusion;
    private String Remark;
    private String Detecting_human;

    public SakeLabCheckRecord(String iD, String date, String fermentation, String sakeTank, String variety,
            String quantity, BigDecimal cO2, BigDecimal dO, BigDecimal oG, BigDecimal aE, BigDecimal rDF,
            BigDecimal alcohol, BigDecimal turbidity90, BigDecimal turbidity25, BigDecimal pH, BigDecimal colour,
            String conclusion, String remark, String detecting_human, BigDecimal iBU, BigDecimal polyphenols,
            BigDecimal fe) {
        super();
        ID = iD;
        Date = date;
        Fermentation = fermentation;
        SakeTank = sakeTank;
        Variety = variety;
        Quantity = quantity;
        CO2 = cO2;
        DO = dO;
        OG = oG;
        AE = aE;
        RDF = rDF;
        Alcohol = alcohol;
        Turbidity90 = turbidity90;
        Turbidity25 = turbidity25;
        PH = pH;
        Colour = colour;
        this.conclusion = conclusion;
        Remark = remark;
        Detecting_human = detecting_human;
        IBU = iBU;
        Polyphenols = polyphenols;
        Fe = fe;
    }

    public SakeLabCheckRecord(String iD, String date, String fermentation, String sakeTank, String variety,
            String quantity, BigDecimal cO2, BigDecimal dO, BigDecimal oG, BigDecimal aE, BigDecimal rDF,
            BigDecimal alcohol, BigDecimal turbidity90, BigDecimal turbidity25, BigDecimal pH, BigDecimal colour,
            BigDecimal iBU, BigDecimal polyphenols, BigDecimal fe, String conclusion, String remark,
            String detecting_human) {
        super();
        ID = iD;
        Date = date;
        Fermentation = fermentation;
        SakeTank = sakeTank;
        Variety = variety;
        Quantity = quantity;
        CO2 = cO2;
        DO = dO;
        OG = oG;
        AE = aE;
        RDF = rDF;
        Alcohol = alcohol;
        Turbidity90 = turbidity90;
        Turbidity25 = turbidity25;
        PH = pH;
        Colour = colour;
        IBU = iBU;
        Polyphenols = polyphenols;
        Fe = fe;
        this.conclusion = conclusion;
        Remark = remark;
        Detecting_human = detecting_human;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getFermentation() {
        return Fermentation;
    }

    public void setFermentation(String fermentation) {
        Fermentation = fermentation;
    }

    public String getSakeTank() {
        return SakeTank;
    }

    public void setSakeTank(String sakeTank) {
        SakeTank = sakeTank;
    }

    public String getVariety() {
        return Variety;
    }

    public void setVariety(String variety) {
        Variety = variety;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public BigDecimal getCO2() {
        return CO2;
    }

    public void setCO2(BigDecimal cO2) {
        CO2 = cO2;
    }

    public BigDecimal getDO() {
        return DO;
    }

    public void setDO(BigDecimal dO) {
        DO = dO;
    }

    public BigDecimal getOG() {
        return OG;
    }

    public void setOG(BigDecimal oG) {
        OG = oG;
    }

    public BigDecimal getAE() {
        return AE;
    }

    public void setAE(BigDecimal aE) {
        AE = aE;
    }

    public BigDecimal getRDF() {
        return RDF;
    }

    public void setRDF(BigDecimal rDF) {
        RDF = rDF;
    }

    public BigDecimal getAlcohol() {
        return Alcohol;
    }

    public void setAlcohol(BigDecimal alcohol) {
        Alcohol = alcohol;
    }

    public BigDecimal getTurbidity90() {
        return Turbidity90;
    }

    public void setTurbidity90(BigDecimal turbidity90) {
        Turbidity90 = turbidity90;
    }

    public BigDecimal getTurbidity25() {
        return Turbidity25;
    }

    public void setTurbidity25(BigDecimal turbidity25) {
        Turbidity25 = turbidity25;
    }

    public BigDecimal getPH() {
        return PH;
    }

    public void setPH(BigDecimal pH) {
        PH = pH;
    }

    public BigDecimal getColour() {
        return Colour;
    }

    public void setColour(BigDecimal colour) {
        Colour = colour;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getDetecting_human() {
        return Detecting_human;
    }

    public void setDetecting_human(String detecting_human) {
        Detecting_human = detecting_human;
    }

    public BigDecimal getIBU() {
        return IBU;
    }

    public void setIBU(BigDecimal iBU) {
        IBU = iBU;
    }

    public BigDecimal getPolyphenols() {
        return Polyphenols;
    }

    public void setPolyphenols(BigDecimal polyphenols) {
        Polyphenols = polyphenols;
    }

    public BigDecimal getFe() {
        return Fe;
    }

    public void setFe(BigDecimal fe) {
        Fe = fe;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ID == null) ? 0 : ID.hashCode());
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
        SakeLabCheckRecord other = (SakeLabCheckRecord) obj;
        if (ID == null) {
            if (other.ID != null)
                return false;
        } else if (!ID.equals(other.ID))
            return false;
        return true;
    }

}
