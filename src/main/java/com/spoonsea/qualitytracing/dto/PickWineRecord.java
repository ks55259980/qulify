package com.spoonsea.qualitytracing.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spoonsea.qualitytracing.util.BigDecimalSerializer;


@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class PickWineRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String Date;
    private String workshop;
    private String Fermentation;
    private String SakeTank;
    private String Age;
    private String Variety;

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
    private BigDecimal Foam;

    private String conclusion;
    private String Remark;
    private String Detecting_human;
    private String Reviewer;

    
    public PickWineRecord(String id, String date, String workshop, String fermentation, String sakeTank, String age,
            String variety, BigDecimal oG, BigDecimal aE, BigDecimal rDF, BigDecimal alcohol, BigDecimal pH,
            BigDecimal foam, String conclusion, String remark, String detecting_human, String reviewer) {
        super();
        this.id = id;
        this.Date = date;
        this.workshop = workshop;
        this.Fermentation = fermentation;
        this.SakeTank = sakeTank;
        this.Age = age;
        this.Variety = variety;
        OG = oG;
        AE = aE;
        RDF = rDF;
        Alcohol = alcohol;
        PH = pH;
        Foam = foam;
        this.conclusion = conclusion;
        Remark = remark;
        Detecting_human = detecting_human;
        Reviewer = reviewer;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDate() {
        return Date;
    }
    public void setDate(String date) {
        this.Date = date;
    }
    public String getWorkshop() {
        return workshop;
    }
    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }
    public String getFermentation() {
        return Fermentation;
    }
    public void setFermentation(String fermentation) {
        this.Fermentation = fermentation;
    }
    public String getSakeTank() {
        return SakeTank;
    }
    public void setSakeTank(String sakeTank) {
        this.SakeTank = sakeTank;
    }
    public String getAge() {
        return Age;
    }
    public void setAge(String age) {
        this.Age = age;
    }
    public String getVariety() {
        return Variety;
    }
    public void setVariety(String variety) {
        this.Variety = variety;
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
    public BigDecimal getFoam() {
        return Foam;
    }
    public void setFoam(BigDecimal foam) {
        Foam = foam;
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        PickWineRecord other = (PickWineRecord) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}