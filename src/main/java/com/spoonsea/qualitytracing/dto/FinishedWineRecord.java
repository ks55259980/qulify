package com.spoonsea.qualitytracing.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spoonsea.qualitytracing.util.BigDecimalSerializer;


public class FinishedWineRecord extends ReportRecord implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String id;
    private String Date;
    private String time;
    private String workshop;
    private String Fermentation;
    private String SakeTank;
    private String Age;
    private String Variety;
    private String Aroma;
    private String Taste;
    
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal OG;
    
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal AE;
    
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal RDF;
    
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Alcohol;
    
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal CO2;
    
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal PH;
    
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal TotalAcid;
    
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Dvalue;
    
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Pvalues;
    
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Foam;
    
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Colour;
    
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Turbidity90;
    
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Turbidity25;
    
    private String conclusion;
    
    private String Remark;
    
    private String Detecting_human;
    
    private String Reviewer;

    public FinishedWineRecord(String id, String date, String time, String workshop, String fermentation,
            String sakeTank, String age, String variety, String aroma, String taste, BigDecimal oG, BigDecimal aE,
            BigDecimal rDF, BigDecimal alcohol, BigDecimal cO2, BigDecimal pH, BigDecimal totalAcid, BigDecimal dvalue,
            BigDecimal pvalues, BigDecimal foam, BigDecimal colour, BigDecimal turbidity90, BigDecimal turbidity25,
            String conclusion, String remark, String detecting_human, String reviewer) {
        super();
        this.id = id;
        Date = date;
        this.time = time;
        this.workshop = workshop;
        Fermentation = fermentation;
        SakeTank = sakeTank;
        Age = age;
        Variety = variety;
        Aroma = aroma;
        Taste = taste;
        OG = oG;
        AE = aE;
        RDF = rDF;
        Alcohol = alcohol;
        CO2 = cO2;
        PH = pH;
        TotalAcid = totalAcid;
        Dvalue = dvalue;
        Pvalues = pvalues;
        Foam = foam;
        Colour = colour;
        Turbidity90 = turbidity90;
        Turbidity25 = turbidity25;
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
        Date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
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
        Fermentation = fermentation;
    }
    public String getSakeTank() {
        return SakeTank;
    }
    public void setSakeTank(String sakeTank) {
        SakeTank = sakeTank;
    }
    public String getAge() {
        return Age;
    }
    public void setAge(String age) {
        Age = age;
    }
    public String getVariety() {
        return Variety;
    }
    public void setVariety(String variety) {
        Variety = variety;
    }
    public String getAroma() {
        return Aroma;
    }
    public void setAroma(String aroma) {
        Aroma = aroma;
    }
    public String getTaste() {
        return Taste;
    }
    public void setTaste(String taste) {
        Taste = taste;
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
    public BigDecimal getCO2() {
        return CO2;
    }
    public void setCO2(BigDecimal cO2) {
        CO2 = cO2;
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
    public BigDecimal getDvalue() {
        return Dvalue;
    }
    public void setDvalue(BigDecimal dvalue) {
        Dvalue = dvalue;
    }
    public BigDecimal getPvalues() {
        return Pvalues;
    }
    public void setPvalues(BigDecimal pvalues) {
        Pvalues = pvalues;
    }
    public BigDecimal getFoam() {
        return Foam;
    }
    public void setFoam(BigDecimal foam) {
        Foam = foam;
    }
    public BigDecimal getColour() {
        return Colour;
    }
    public void setColour(BigDecimal colour) {
        Colour = colour;
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
        FinishedWineRecord other = (FinishedWineRecord) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
