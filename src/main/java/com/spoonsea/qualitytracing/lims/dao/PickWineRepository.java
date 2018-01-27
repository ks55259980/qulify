package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spoonsea.qualitytracing.dto.PickWineRecord;
import com.spoonsea.qualitytracing.lims.model.PickWine;

public interface PickWineRepository extends JpaRepository<PickWine, String> {

    @Query("select new com.spoonsea.qualitytracing.dto.PickWineRecord(id, date,workshop,fermentation,sakeTank,age,"
            + "variety,og,ae,rdf,alcohol,ph,foam,conclusion,remark,detecting_human,reviewer) from PickWine where"
            + " hid=?1 AND workshop=?2")
    List<PickWineRecord> findByHidAndWorkshop(String hid, String workshop);

    @Query("select new com.spoonsea.qualitytracing.dto.PickWineRecord(id, date,workshop,fermentation,sakeTank,age,"
            + "variety,og,ae,rdf,alcohol,ph,foam,conclusion,remark,detecting_human,reviewer) from PickWine where hid=?1")
    List<PickWineRecord> findByHid(String hid);
    
    @Query("select new com.spoonsea.qualitytracing.dto.PickWineRecord(id, date,workshop,fermentation,sakeTank,age,"
            + "variety,og,ae,rdf,alcohol,ph,foam,conclusion,remark,detecting_human,reviewer) from PickWine where sid like %?1%")
    List<PickWineRecord> findBySid(String sid);

}
