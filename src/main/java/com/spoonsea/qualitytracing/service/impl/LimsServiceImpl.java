package com.spoonsea.qualitytracing.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.lims.dao.BarcodeRepository;
import com.spoonsea.qualitytracing.lims.dao.BrothRepository;
import com.spoonsea.qualitytracing.lims.dao.SakeRepository;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.lims.model.Broth;
import com.spoonsea.qualitytracing.lims.model.Sake;
import com.spoonsea.qualitytracing.service.LimsService;

@Service
public class LimsServiceImpl implements LimsService {

   private static final Logger logger = LoggerFactory.getLogger(LimsServiceImpl.class);

   @Autowired
   private BarcodeRepository barcodeRepo;

   @Autowired
   private SakeRepository sakeRepo;

   @Autowired
   private BrothRepository brothRepo;

   private Barcode getBarcode(CodeInfo code) {
       List<Barcode> barcodeList = barcodeRepo.findTop1ByPackagingLineAndDateAndTimeLessThanOrderByTimeDesc(code.getLine(), code.getDate(), code.getTime());
       if (barcodeList.isEmpty()) {
           logger.warn("barcode not found for: line={}, date={}, time={}", code.getLine(), code.getDate(), code.getTime());
           return null;
       }
       Barcode barcode = barcodeList.get(0);
       logger.info("barcode: hid={}, workshop={}", barcode.getHid(), barcode.getPackagingLine());
       return barcode;
   }

    public List<Sake> getSakeList(CodeInfo code) {
        Barcode barcode = getBarcode(code);
        if (barcode == null) {
            return Arrays.asList();
        }
        List<Sake> sakeList = sakeRepo.findByHid(barcode.getHid());
        return sakeList;
    }

    public List<Broth> getBrothList(CodeInfo code) {
        Barcode barcode = getBarcode(code);
        if (barcode == null) {
            return Arrays.asList();
        }
        List<Broth> sakeList = brothRepo.findByHidLike(barcode.getSid());
        return sakeList;
    }

}
