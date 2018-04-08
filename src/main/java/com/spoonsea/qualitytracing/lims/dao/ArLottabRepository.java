package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spoonsea.qualitytracing.lims.model.ArLottab;

public interface ArLottabRepository extends JpaRepository<ArLottab, String> {

	@Query(value = "select * from ArLottab where Barcode=?1 and name like '清酒%'", nativeQuery=true)
	List<ArLottab> findByHid(String hid);

	@Query(value = "select * from ArLottab where ?1 like CONCAT('%',Barcode,'%') and name not like '清酒%'", nativeQuery=true)
	List<ArLottab> findByLikeSid(String sid);

	@Query(value = "select * from ArLottab where Barcode=?1 and name not like '清酒%'", nativeQuery=true)
	List<ArLottab> findBySid(String sid);

}
