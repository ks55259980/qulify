package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spoonsea.qualitytracing.lims.model.Broth;

public interface BrothRepository extends JpaRepository<Broth, String> {

    @Query(value = "select * from dbo.Broth where ?1 like '%' + HID + '%'", nativeQuery=true)
    List<Broth> findByHidLike(String sid);

}
