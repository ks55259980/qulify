package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spoonsea.qualitytracing.lims.model.GranuleHop;

public interface GranuleHopRepository extends JpaRepository<GranuleHop, String> {

	List<GranuleHop> findByIdIn(Set<String> idSet);

}
