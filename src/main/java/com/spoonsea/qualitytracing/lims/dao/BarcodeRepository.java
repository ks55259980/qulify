package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spoonsea.qualitytracing.lims.model.Barcode;

public interface BarcodeRepository extends JpaRepository<Barcode, Integer> {

    @Query(value="select top(1) * from dbo.barcode where PackagingLine=?1 and date=?2 and time<?3 order by time desc", nativeQuery=true)
    Barcode findTop1ByPackagingLineAndDateAndTimeLessThanOrderByTimeDesc(String packagingline, String date, String time);

	Barcode findOneByBarcode(String barcode);

	List<Barcode> findByHid(String hid);

	List<Barcode> findBySidLike(String sid);

	List<Barcode> findByHidAndEnglish(String hid, String english);
	
	List<Barcode> findBySidLikeAndEnglish(String sid, String english);
	
	@Query(value="select * from dbo.barcode where ?1 like '%' + HID + '%'", nativeQuery=true)
	List<Barcode> findByLikeHid(String sid);

	@Query(value="select * from dbo.barcode where English=?1 and ?2 like '%' + HID + '%'", nativeQuery=true)
	List<Barcode> findByEnglishAndLikeHid(String English, String sid);

//	Barcode findOneBySidLikeOrderByDateAndTimeAsc(String sid);
//
//	Barcode findOneByHidOrderByDateAndTimeAsc(String hid);

}
