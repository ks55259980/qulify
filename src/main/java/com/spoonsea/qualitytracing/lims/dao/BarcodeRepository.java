package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spoonsea.qualitytracing.lims.model.Barcode;

public interface BarcodeRepository extends JpaRepository<Barcode, Integer> {

    Barcode findTop1ByPackagingLineAndDateAndTimeLessThanOrderByDateDescTimeDesc(String packagingLine, String date,
            String time);

    Barcode findOneByBarcode(String barcode);

    List<Barcode> findByHid(String hid);

    List<Barcode> findBySidLike(String sid);

    List<Barcode> findByHidAndEnglish(String hid, String english);

    List<Barcode> findBySidLikeAndEnglish(String sid, String english);

    @Query(value = "select * from barcode where ?1 like CONCAT('%',HID,'%')", nativeQuery = true)
    List<Barcode> findByLikeHid(String sid);

    @Query(value = "select * from barcode where English=?1 and ?2 like CONCAT('%',HID,'%')", nativeQuery = true)
    List<Barcode> findByEnglishAndLikeHid(String english, String sid);

    Barcode findOneByHidAndEnglish(String hid, String string);

    Barcode findTop1ByHidAndEnglishOrderByDateAscTimeAsc(String hid, String english);

    Barcode findTop1ByPackagingLineAndHidOrderByDateAscTimeAsc(String line, String hid);

    Barcode findTop1ByPackagingLineAndHidAndDateAndTimeLessThanEqualOrderByDateDescTimeDesc(String line, String hid,
            String date, String time);

    // Barcode findOneBySidLikeOrderByDateAndTimeAsc(String sid);
    //
    // Barcode findOneByHidOrderByDateAndTimeAsc(String hid);

}
