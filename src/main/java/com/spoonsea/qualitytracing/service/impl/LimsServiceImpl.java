package com.spoonsea.qualitytracing.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.lims.dao.ArLottabRepository;
import com.spoonsea.qualitytracing.lims.dao.BarcodeBrothRepository;
import com.spoonsea.qualitytracing.lims.dao.BarcodeRepository;
import com.spoonsea.qualitytracing.lims.dao.BrothRepository;
import com.spoonsea.qualitytracing.lims.dao.SakeRepository;
import com.spoonsea.qualitytracing.lims.model.ArLottab;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.lims.model.BarcodeBroth;
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
    
    @Autowired
    private BarcodeBrothRepository barcodeBrothRepo;

    @Autowired
    private ArLottabRepository arLottabRepo;

    private Barcode getBarcode(CodeInfo code) {
        Barcode barcode = barcodeRepo.findTop1ByPackagingLineAndDateAndTimeLessThanOrderByTimeDesc(
                code.getLine(), code.getDate(), code.getTime());
        if (barcode == null) {
            logger.warn("barcode not found for: line={}, date={}, time={}", code.getLine(), code.getDate(),
                    code.getTime());
            return null;
        }
        logger.info("barcode: hid={}, workshop={}", barcode.getHid(), barcode.getPackagingLine());
        return barcode;
    }

    @Override
    public List<BarcodeBroth> getBarcodeBrothList(CodeInfo code) {
    		Barcode barcode = getBarcode(code);
    		if (barcode == null) {
    			return Arrays.asList();
    		}
    		List<BarcodeBroth> barcodeBrothList = barcodeBrothRepo.findByHidLike(barcode.getSid());
    		return barcodeBrothList;
    }

    @Override
    public List<BarcodeBroth> getBarcodeBrothList(String barcode) {
    		Barcode rec = barcodeRepo.findOneByBarcode(barcode);
    		if (rec == null) {
    			return Arrays.asList();
    		}
    		String sid = rec.getSid() != null ? rec.getSid() : rec.getHid();
        	return barcodeBrothRepo.findByHidLike(sid);
    }

    @Override
    public List<Sake> getSakeList(CodeInfo code) {
        Barcode barcode = getBarcode(code);
        if (barcode == null) {
            return Arrays.asList();
        }
        List<Sake> sakeList = sakeRepo.findByHid(barcode.getHid());
        return sakeList;
    }

    @Override
    public List<Sake> getSakeList(String barcode) {
    		Barcode rec = barcodeRepo.findOneByBarcode(barcode);
    		if (rec == null) {
    			return Arrays.asList();
    		}
    		if (rec.getSid() != null) {
    			return sakeRepo.findByHid(rec.getHid());
    		} else {
    			List<Barcode> barcodes = barcodeRepo.findBySidLike(rec.getHid());
    			return sakeRepo.findByHidIn(barcodes.stream().map(b -> b.getHid()).collect(Collectors.toSet()));
    		}
    }

    @Override
    public List<Broth> getBrothList(CodeInfo code) {
        Barcode barcode = getBarcode(code);
        if (barcode == null) {
            return Arrays.asList();
        }
        List<Broth> sakeList = brothRepo.findByLikeHid(barcode.getSid());
        return sakeList;
    }

    @Override
    public List<Sake> getSakeListWithWineID(CodeInfo code) {
        Barcode barcode = getBarcode(code);
        if (barcode == null) {
            return Arrays.asList();
        }
        List<Sake> sakeList = sakeRepo.findByHidAndWineIDNotNull(barcode.getHid());
        return sakeList;
    }

    @Override
    public List<ArLottab> getArLottabList(CodeInfo code) {
    		Barcode barcode = getBarcode(code);
    		if (barcode == null) {
            return Arrays.asList();
        }
    		List<ArLottab> arLottabList = arLottabRepo.findByLikeSid(barcode.getSid());
    		arLottabList.addAll(arLottabRepo.findByHid(barcode.getHid()));
    		return arLottabList;
    }
    
    @Override
    public List<ArLottab> getArLottabList(String barcode) {
    		Barcode rec = barcodeRepo.findOneByBarcode(barcode);
    		if (rec == null) {
    			return Arrays.asList();
    		}
    		List<ArLottab> arLottabList = new ArrayList<ArLottab>();
    		if (rec.getSid() != null) {
    			arLottabList.addAll(arLottabRepo.findByHid(rec.getHid()));
    			arLottabList.addAll(arLottabRepo.findByLikeSid(rec.getSid()));
    		} else {
    			arLottabList.addAll(arLottabRepo.findBySid(rec.getHid()));
    		}
    		return arLottabList;
    }

	@Override
	public Barcode getPackaging(String barcode) {
		return barcodeRepo.findOneByBarcode(barcode);
//		if (rec.getSid() != null) {
//			return barcodeRepo.findOneByHidOrderByDateAndTimeAsc(rec.getHid());
//		} else {
//			return barcodeRepo.findOneBySidLikeOrderByDateAndTimeAsc(rec.getHid());
//		}
	}

}
