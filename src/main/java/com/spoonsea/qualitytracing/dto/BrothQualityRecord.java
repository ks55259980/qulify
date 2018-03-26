package com.spoonsea.qualitytracing.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spoonsea.qualitytracing.util.BigDecimalSerializer;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class BrothQualityRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ID;
    private String Date;
    private String Fermentation;
    private String Variety;
    private String Age;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal OG;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal AE;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal RDF;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Alcohol;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal PH;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal TotalAcid;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Bitterness;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Colour;
    private String conclusion;
    private String Remark;
    private String Detecting_human;
    private String Reviewer;

    public BrothQualityRecord(String iD, String date, String fermentation, String variety, String age, BigDecimal oG,
            BigDecimal aE, BigDecimal rDF, BigDecimal alcohol, BigDecimal pH, BigDecimal totalAcid,
            BigDecimal bitterness, BigDecimal colour, String conclusion, String remark, String detecting_human,
            String reviewer) {
        super();
        ID = iD;
        Date = date;
        Fermentation = fermentation;
        Variety = variety;
        Age = age;
        OG = oG;
        AE = aE;
        RDF = rDF;
        Alcohol = alcohol;
        PH = pH;
        TotalAcid = totalAcid;
        Bitterness = bitterness;
        Colour = colour;
        this.conclusion = conclusion;
        Remark = remark;
        Detecting_human = detecting_human;
        Reviewer = reviewer;
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

    public String getVariety() {
        return Variety;
    }

    public void setVariety(String variety) {
        Variety = variety;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
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

    public BigDecimal getPH() {
        return PH;
    }

    public void setPH(BigDecimal pH) {
        PH = pH;
    }

    public BigDecimal getTotalAcid() {
        return TotalAcid;
    }

    public void setTotalAcid(BigDecimal totalAcid) {
        TotalAcid = totalAcid;
    }

    public BigDecimal getBitterness() {
        return Bitterness;
    }

    public void setBitterness(BigDecimal bitterness) {
        Bitterness = bitterness;
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

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String reviewer) {
        Reviewer = reviewer;
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
        BrothQualityRecord other = (BrothQualityRecord) obj;
        if (ID == null) {
            if (other.ID != null)
                return false;
        } else if (!ID.equals(other.ID))
            return false;
        return true;
    }

}
