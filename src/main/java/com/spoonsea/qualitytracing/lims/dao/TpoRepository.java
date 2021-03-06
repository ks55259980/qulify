package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spoonsea.qualitytracing.dto.TpoRecord;
import com.spoonsea.qualitytracing.lims.model.Tpo;

public interface TpoRepository extends JpaRepository<Tpo, String> {

    @Query("select new com.spoonsea.qualitytracing.dto.TpoRecord(id, date,time,workshop,sakeTank,"
            + "variety,bottleType,wineValve,co2,do_,tpo,conclusion,remark,detecting_human) from Tpo where"
            + " hid=?1 AND workshop=?2")
//    @Query(value="select id, date, time, workshop, sakeTank,variety,bottleType,wineValve,co2,do as"
//            + " do_,tpo,conclusion,remark,detecting_human from dbo.Tpo where hid=?1 and workshop=?2", nativeQuery=true)
    List<TpoRecord> findByHidAndWorkshop(String hid, String workshop);

    @Query("select new com.spoonsea.qualitytracing.dto.TpoRecord(id, date,time,workshop,sakeTank,"
            + "variety,bottleType,wineValve,co2,do_,tpo,conclusion,remark,detecting_human) from Tpo where"
            + " hid=?1")
//    @Query(value="select id, date, time, workshop, sakeTank,variety,bottleType,wineValve,co2,do as"
//            + " do_,tpo,conclusion,remark,detecting_human from dbo.Tpo where hid=?1", nativeQuery=true)
    List<TpoRecord> findByHid(String hid);
    
    @Query("select new com.spoonsea.qualitytracing.dto.TpoRecord(id, date,time,workshop,sakeTank,"
            + "variety,bottleType,wineValve,co2,do_,tpo,conclusion,remark,detecting_human) from Tpo where sid like %?1%")
//    @Query(value="select id, date, time, workshop, sakeTank,variety,bottleType,wineValve,co2,do as"
//            + " do_,tpo,conclusion,remark,detecting_human from dbo.Tpo where sid like %?1%", nativeQuery=true)
    List<TpoRecord> findBySid(String sid);

}
