package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spoonsea.qualitytracing.lims.model.Hop;


public interface HopRepository extends JpaRepository<Hop, String> {

	List<Hop> findByIdIn(Set<String> idSet);

}
