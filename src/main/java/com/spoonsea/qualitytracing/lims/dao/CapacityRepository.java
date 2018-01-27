package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spoonsea.qualitytracing.dto.CapacityRecord;
import com.spoonsea.qualitytracing.lims.model.CapacityTba;

public interface CapacityRepository extends JpaRepository<CapacityTba, String> {

    @Query("select new com.spoonsea.qualitytracing.dto.CapacityRecord(id, date,time,sakeTank,workshop,"
            + "variety,bottleType,wineValve,capacity,conclusion,remark) from CapacityTba where"
            + " hid=?1 AND workshop=?2")
    List<CapacityRecord> findByHidAndWorkshop(String hid, String workshop);

    @Query("select new com.spoonsea.qualitytracing.dto.CapacityRecord(id, date,time,sakeTank,workshop,"
            + "variety,bottleType,wineValve,capacity,conclusion,remark) from CapacityTba where hid=?1")
    List<CapacityRecord> findByHid(String hid);
    
    @Query("select new com.spoonsea.qualitytracing.dto.CapacityRecord(id, date,time,sakeTank,workshop,"
            + "variety,bottleType,wineValve,capacity,conclusion,remark) from CapacityTba where sid like %?1%")
    List<CapacityRecord> findBySid(String sid);

}
