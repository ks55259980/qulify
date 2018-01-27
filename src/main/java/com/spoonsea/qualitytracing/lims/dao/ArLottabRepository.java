package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spoonsea.qualitytracing.lims.model.ArLottab;

public interface ArLottabRepository extends JpaRepository<ArLottab, String> {

    // use hid for '清酒' and sid for others
    List<ArLottab> findByNameAndBarcode(String name, String hidOrSid);

}
