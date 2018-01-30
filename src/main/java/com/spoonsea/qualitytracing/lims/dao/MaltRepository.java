package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spoonsea.qualitytracing.lims.model.Malt;

public interface MaltRepository extends JpaRepository<Malt, String> {

	List<Malt> findByIdIn(Set<String> idSet);

}
