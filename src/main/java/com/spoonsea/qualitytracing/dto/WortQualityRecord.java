package com.spoonsea.qualitytracing.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spoonsea.qualitytracing.util.BigDecimalSerializer;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class WortQualityRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ID;
    private String Date;
    private String Fermentation;
    private String PotNumber;
    private String Variety;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal OG;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Colour;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal PH;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal TotalAcid;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal FAN;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Bitterness;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Sodium;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Calcium;
    private String conclusion;
    private String Remark;
    private String Detecting_human;
    private String Reviewer;

    public WortQualityRecord(String iD, String date, String fermentation, String potNumber, String variety,
            BigDecimal oG, BigDecimal colour, BigDecimal pH, BigDecimal totalAcid, BigDecimal fAN,
            BigDecimal bitterness, BigDecimal sodium, BigDecimal calcium, String conclusion, String remark,
            String detecting_human, String reviewer) {
        super();
        ID = iD;
        Date = date;
        Fermentation = fermentation;
        PotNumber = potNumber;
        Variety = variety;
        OG = oG;
        Colour = colour;
        PH = pH;
        TotalAcid = totalAcid;
        FAN = fAN;
        Bitterness = bitterness;
        Sodium = sodium;
        Calcium = calcium;
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

    public String getPotNumber() {
        return PotNumber;
    }

    public void setPotNumber(String potNumber) {
        PotNumber = potNumber;
    }

    public String getVariety() {
        return Variety;
    }

    public void setVariety(String variety) {
        Variety = variety;
    }

    public BigDecimal getOG() {
        return OG;
    }

    public void setOG(BigDecimal oG) {
        OG = oG;
    }

    public BigDecimal getColour() {
        return Colour;
    }

    public void setColour(BigDecimal colour) {
        Colour = colour;
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

    public BigDecimal getFAN() {
        return FAN;
    }

    public void setFAN(BigDecimal fAN) {
        FAN = fAN;
    }

    public BigDecimal getBitterness() {
        return Bitterness;
    }

    public void setBitterness(BigDecimal bitterness) {
        Bitterness = bitterness;
    }

    public BigDecimal getSodium() {
        return Sodium;
    }

    public void setSodium(BigDecimal sodium) {
        Sodium = sodium;
    }

    public BigDecimal getCalcium() {
        return Calcium;
    }

    public void setCalcium(BigDecimal calcium) {
        Calcium = calcium;
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
        WortQualityRecord other = (WortQualityRecord) obj;
        if (ID == null) {
            if (other.ID != null)
                return false;
        } else if (!ID.equals(other.ID))
            return false;
        return true;
    }

}
