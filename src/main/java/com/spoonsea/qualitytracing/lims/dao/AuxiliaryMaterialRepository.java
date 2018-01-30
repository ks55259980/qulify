package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spoonsea.qualitytracing.lims.model.AuxiliaryMaterial;

public interface AuxiliaryMaterialRepository extends JpaRepository<AuxiliaryMaterial, String> {

	List<AuxiliaryMaterial> findByIdIn(Set<String> idSet);

}
