package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spoonsea.qualitytracing.dto.BrothQualityRecord;
import com.spoonsea.qualitytracing.lims.model.Broth;

public interface BrothRepository extends JpaRepository<Broth, String> {

    @Query(value = "select * from Broth where ?1 like CONCAT('%',HID,'%')", nativeQuery=true)
    List<Broth> findByLikeHid(String sid);

    @Query("select new com.spoonsea.qualitytracing.dto.BrothQualityRecord(id,date,fermentation,"
            + "variety,age,og,ae,rdf,alcohol,ph,totalAcid,bitterness,colour,conclusion,remark,"
            + "detecting_human,reviewer ) from Broth where ?1 like CONCAT('%',HID,'%')")
    List<BrothQualityRecord> findBrothQualityRecordByLikeHid(String sid);
}
