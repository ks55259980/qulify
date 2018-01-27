package com.spoonsea.qualitytracing.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spoonsea.qualitytracing.util.BigDecimalSerializer;


@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class TpoRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String Date;
    private String time;
    private String Workshop;
    private String SakeTank;
    private String Variety;
    private String BottleType;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal WineValve;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal CO2;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal DO;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal TPO;

    private String conclusion;
    private String Remark;
    private String Detecting_human;

    public TpoRecord(String id, String date, String time, String workshop, String sakeTank, String variety,
            String bottleType, BigDecimal wineValue, BigDecimal cO2, BigDecimal dO, BigDecimal tPO, String conclusion,
            String remark, String detecting_human) {
        super();
        this.id = id;
        Date = date;
        this.time = time;
        Workshop = workshop;
        SakeTank = sakeTank;
        Variety = variety;
        BottleType = bottleType;
        WineValve = wineValue;
        CO2 = cO2;
        DO = dO;
        TPO = tPO;
        this.conclusion = conclusion;
        Remark = remark;
        Detecting_human = detecting_human;
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
        return Workshop;
    }

    public void setWorkshop(String workshop) {
        Workshop = workshop;
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

    public String getBottleType() {
        return BottleType;
    }

    public void setBottleType(String bottleType) {
        BottleType = bottleType;
    }

    public BigDecimal getWineValve() {
        return WineValve;
    }

    public void setWineValve(BigDecimal wineValue) {
        WineValve = wineValue;
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

    public BigDecimal getTPO() {
        return TPO;
    }

    public void setTPO(BigDecimal tPO) {
        TPO = tPO;
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
        TpoRecord other = (TpoRecord) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}