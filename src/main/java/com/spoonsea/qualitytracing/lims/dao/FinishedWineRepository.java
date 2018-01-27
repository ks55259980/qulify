package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spoonsea.qualitytracing.dto.FinishedWineRecord;
import com.spoonsea.qualitytracing.lims.model.FinishedWine;

public interface FinishedWineRepository extends JpaRepository<FinishedWine, String> {
    
    @Query("select new com.spoonsea.qualitytracing.dto.FinishedWineRecord(id,date,time,workshop,fermentation,sakeTank,"
            + "age,variety,aroma,taste,og,ae,rdf,alcohol,co2,ph,totalAcid,dvalue,pvalues,foam,colour,turbidity90,"
            + "turbidity25,conclusion,remark,detecting_human,reviewer) from FinishedWine where hid=?1 AND workshop=?2")
    List<FinishedWineRecord> findByHidAndWorkshop(String hid, String workshop);

    @Query("select new com.spoonsea.qualitytracing.dto.FinishedWineRecord(id,date,time,workshop,fermentation,sakeTank,"
            + "age,variety,aroma,taste,og,ae,rdf,alcohol,co2,ph,totalAcid,dvalue,pvalues,foam,colour,turbidity90,"
            + "turbidity25,conclusion,remark,detecting_human,reviewer) from FinishedWine where hid=?1")
    List<FinishedWineRecord> findByHid(String hid);

    @Query("select new com.spoonsea.qualitytracing.dto.FinishedWineRecord(id,date,time,workshop,fermentation,sakeTank,"
            + "age,variety,aroma,taste,og,ae,rdf,alcohol,co2,ph,totalAcid,dvalue,pvalues,foam,colour,turbidity90,"
            + "turbidity25,conclusion,remark,detecting_human,reviewer) from FinishedWine where sid like %?1%")
    List<FinishedWineRecord> findBySid(String sid);

}
