package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spoonsea.qualitytracing.lims.model.Report_Detail;

public interface Report_DetailRepository extends JpaRepository<Report_Detail, Integer> {

    List<Report_Detail> findByPacket(Object packet);

}
