package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spoonsea.qualitytracing.dto.SakeLabCheckRecord;
import com.spoonsea.qualitytracing.lims.model.Sake;

public interface SakeRepository extends JpaRepository<Sake, String> {

    List<Sake> findByHidAndWineIDNotNull(String hid);

    List<Sake> findByHid(String hid);

    List<Sake> findByHidIn(Set<String> idSet);

    // notice that there's a weird param "do_", cause it should be the same(case-sensitive) as Sake's field name "do_"
    // all param names should be the same as Sake's field name
    @Query("select new com.spoonsea.qualitytracing.dto.SakeLabCheckRecord(id, date, fermentation, sakeTank, variety, "
            + "quantity, co2, do_, og, ae, rdf, alcohol, turbidity90, turbidity25, ph, colour, conclusion, remark, "
            + "detecting_human, ibu, polyphenols, fe) from Sake where hid=?1")
    List<SakeLabCheckRecord> findSakeLabCheckRecordByHid(String hid);

    @Query("select new com.spoonsea.qualitytracing.dto.SakeLabCheckRecord(id, date, fermentation, sakeTank, variety,"
            + "quantity, co2, do_, og, ae, rdf, alcohol, turbidity90, turbidity25, ph, colour, conclusion, remark,"
            + "detecting_human, ibu, polyphenols, fe) from Sake where sid like %?1%")
    List<SakeLabCheckRecord> findSakeLabCheckRecordBySidLike(String sid);
}
