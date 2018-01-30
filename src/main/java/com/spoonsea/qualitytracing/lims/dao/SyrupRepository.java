package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spoonsea.qualitytracing.lims.model.Syrup;

public interface SyrupRepository extends JpaRepository<Syrup, String> {

	List<Syrup> findByIdIn(Set<String> idSet);

}
