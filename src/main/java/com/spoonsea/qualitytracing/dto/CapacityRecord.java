package com.spoonsea.qualitytracing.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spoonsea.qualitytracing.util.BigDecimalSerializer;


@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class CapacityRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String Date;
    private String time;
    private String SakeTank;
    private String Workshop;
    private String Variety;
    private String BottleType;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal WineValue;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal Capacity;

    private String conclusion;
    private String Remark;

    public CapacityRecord(String id, String date, String time, String sakeTank, String workshop, String variety,
            String bottleType, BigDecimal wineValue, BigDecimal capacity, String conclusion, String remark) {
        super();
        this.id = id;
        Date = date;
        this.time = time;
        SakeTank = sakeTank;
        Workshop = workshop;
        Variety = variety;
        BottleType = bottleType;
        WineValue = wineValue;
        Capacity = capacity;
        this.conclusion = conclusion;
        Remark = remark;
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

    public String getSakeTank() {
        return SakeTank;
    }

    public void setSakeTank(String sakeTank) {
        SakeTank = sakeTank;
    }

    public String getWorkshop() {
        return Workshop;
    }

    public void setWorkshop(String workshop) {
        Workshop = workshop;
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

    public BigDecimal getWineValue() {
        return WineValue;
    }

    public void setWineValue(BigDecimal wineValue) {
        WineValue = wineValue;
    }

    public BigDecimal getCapacity() {
        return Capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        Capacity = capacity;
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
        CapacityRecord other = (CapacityRecord) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}