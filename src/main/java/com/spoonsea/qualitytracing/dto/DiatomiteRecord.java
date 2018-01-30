package com.spoonsea.qualitytracing.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spoonsea.qualitytracing.util.BigDecimalSerializer;


@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class DiatomiteRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String Date;
    private String sample;
    private String Factory;
    private String batch;
    private String Lot;
    private String ProductionDate;
    private String ArrivalDate;
    private String SubmissionDate;
    private String Tasting;
    private String conclusion;
    private String Remark;
    private String Detecting_human;
    private String Reviewer;

    public DiatomiteRecord(String id, String date, String sample, String factory, String batch, String lot,
			String productionDate, String arrivalDate, String submissionDate, String tasting, String conclusion,
			String remark, String detecting_human, String reviewer) {
		super();
		this.id = id;
		Date = date;
		this.sample = sample;
		Factory = factory;
		this.batch = batch;
		Lot = lot;
		ProductionDate = productionDate;
		ArrivalDate = arrivalDate;
		SubmissionDate = submissionDate;
		Tasting = tasting;
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

	public String getSample() {
		return sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}

	public String getFactory() {
		return Factory;
	}

	public void setFactory(String factory) {
		Factory = factory;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getLot() {
		return Lot;
	}

	public void setLot(String lot) {
		Lot = lot;
	}

	public String getProductionDate() {
		return ProductionDate;
	}

	public void setProductionDate(String productionDate) {
		ProductionDate = productionDate;
	}

	public String getArrivalDate() {
		return ArrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		ArrivalDate = arrivalDate;
	}

	public String getSubmissionDate() {
		return SubmissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		SubmissionDate = submissionDate;
	}

	public String getTasting() {
		return Tasting;
	}

	public void setTasting(String tasting) {
		Tasting = tasting;
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
        DiatomiteRecord other = (DiatomiteRecord) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}