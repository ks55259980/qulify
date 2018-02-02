package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spoonsea.qualitytracing.lims.model.Sake;

public interface SakeRepository extends JpaRepository<Sake, String> {

    List<Sake> findByHidAndWineIDNotNull(String hid);

    List<Sake> findByHid(String hid);

	List<Sake> findByHidIn(Set<String> idSet);

}
