package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spoonsea.qualitytracing.lims.model.Wort;

public interface WortRepository extends JpaRepository<Wort, String> {

    List<Wort> findByHid(String hid);

}
