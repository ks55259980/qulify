package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spoonsea.qualitytracing.lims.model.BarcodeBroth;

public interface BarcodeBrothRepository extends JpaRepository<BarcodeBroth, Integer> {

	@Query(value = "select * from BarcodeBroth where ?1 like CONCAT('%',HID,'%')", nativeQuery=true)
	List<BarcodeBroth> findByHidLike(String sid);

    List<BarcodeBroth> findByHid(String sid);

}
