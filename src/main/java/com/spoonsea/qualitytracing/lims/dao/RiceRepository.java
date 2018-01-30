package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spoonsea.qualitytracing.lims.model.Rice;

public interface RiceRepository extends JpaRepository<Rice, String> {

	List<Rice> findByIdIn(Set<String> idSet);

}
