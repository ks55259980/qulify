package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spoonsea.qualitytracing.dto.DiatomiteRecord;
import com.spoonsea.qualitytracing.lims.model.AuxiliaryMaterial;

public interface AuxiliaryMaterialRepository extends JpaRepository<AuxiliaryMaterial, String> {

	@Query("select new com.spoonsea.qualitytracing.dto.DiatomiteRecord(id,date,sample,factory,batch,lot,"
			+ "productionDate,arrivalDate,submissionDate,tasting,conclusion,remark,detecting_human,reviewer"
			+ " from AuxiliaryMaterials where id in ?1")
	List<DiatomiteRecord> findDiatomiteById(Set<String> id);

	@Query("select new com.spoonsea.qualitytracing.dto.DiatomiteRecord(id,date,sample,factory,batch,lot,"
			+ "productionDate,arrivalDate,submissionDate,tasting,conclusion,remark,detecting_human,reviewer"
			+ " from AuxiliaryMaterials where id in ?1")
	List<DiatomiteRecord> findBySidLike(Set<String> sid);

}
