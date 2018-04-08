package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spoonsea.qualitytracing.dto.WortQualityRecord;
import com.spoonsea.qualitytracing.lims.model.Wort;

public interface WortRepository extends JpaRepository<Wort, String> {

    List<Wort> findByHid(String hid);

    @Query("select new com.spoonsea.qualitytracing.dto.WortQualityRecord(id,date,fermentation,"
            + "potNumber,variety,og,colour,ph,totalAcid,fan,bitterness,sodium,calcium,conclusion,"
            + "remark,detecting_human,reviewer) from Wort where ?1 like CONCAT('%',HID,'%')")
    List<WortQualityRecord> findWortQualityRecordByLikeHid(String sid);

}
