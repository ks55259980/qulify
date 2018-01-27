package com.spoonsea.qualitytracing.lims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spoonsea.qualitytracing.lims.model.Barcode;

public interface BarcodeRepository extends JpaRepository<Barcode, Integer> {

    List<Barcode> findTop1ByPackagingLineAndDateAndTimeLessThanOrderByTimeDesc(String packagingline, String date, String time);

    List<Barcode> findByBarcode(String barcode);

}
