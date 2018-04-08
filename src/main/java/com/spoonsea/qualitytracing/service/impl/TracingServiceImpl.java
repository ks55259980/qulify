package com.spoonsea.qualitytracing.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spoonsea.qualitytracing.constant.Constants.LogisticsProcessEnum;
import com.spoonsea.qualitytracing.constant.Constants.ProductionProcessEnum;
import com.spoonsea.qualitytracing.dto.CodeInfo;
import com.spoonsea.qualitytracing.dto.DataNode;
import com.spoonsea.qualitytracing.entity.BarcodeQueryResult;
import com.spoonsea.qualitytracing.entity.BarcodeQueryResultDetail;
import com.spoonsea.qualitytracing.lims.dao.BarcodeBrothRepository;
import com.spoonsea.qualitytracing.lims.dao.BarcodeRepository;
import com.spoonsea.qualitytracing.lims.dao.WortRepository;
import com.spoonsea.qualitytracing.lims.model.Barcode;
import com.spoonsea.qualitytracing.lims.model.BarcodeBroth;
import com.spoonsea.qualitytracing.lims.model.Wort;
import com.spoonsea.qualitytracing.service.BarcodeQueryService;
import com.spoonsea.qualitytracing.service.LimsService;
import com.spoonsea.qualitytracing.service.TracingService;
import com.spoonsea.qualitytracing.util.MiscUtil;
import com.spoonsea.qualitytracing.util.WorkshopUtil;

@Service
public class TracingServiceImpl implements TracingService {

    private static final Logger logger = LoggerFactory.getLogger(TracingServiceImpl.class);

    @Autowired
    private LimsService limsService;

    @Autowired
    private BarcodeQueryService barcodeQueryService;

    @Autowired
    private BarcodeRepository barcodeRepo;

    @Autowired
    private BarcodeBrothRepository barcodeBrothRepo;

    @Autowired
    private WortRepository wortRepo;

    @Override
    public String tracingByBoxCode(String boxCode) throws IOException {
        return IOUtils.toString(new FileInputStream(ResourceUtils.getFile("classpath:data/test-data.json")),
                StandardCharsets.UTF_8.name());
    }

    @Override
    public String tracingByCapCode(String capCode) throws IOException {
        CodeInfo code = new CodeInfo(capCode);
        Map<String, Object> from = getFromData(code);
        Map<String, Object> to = getToData(code);
        Map<String, Object> ret = new HashMap<>();
        ret.put("type", "tree");
        ret.put("from", from);
        ret.put("to", to);
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(ret);
        // return IOUtils.toString(new FileInputStream(ResourceUtils.getFile("classpath:data/tree-data.json")),
        // StandardCharsets.UTF_8.name());
    }

    private Map<String, Object> getFromData(CodeInfo code) {
        Barcode barcode = limsService.getBarcode(code);
        DataNode packNode = new DataNode();

        Map<String, Object> ret = new HashMap<>();
        ret.put("processes", ProductionProcessEnum.getProcessList());
        ret.put("data", packNode);

        if (barcode == null) {
            return ret;
        }

        String format = "%s %s %s";
        packNode.setName(String.format(format, barcode.getDate(), barcode.getTime(), barcode.getPackagingLine()));
        packNode.setValue(code.getOriginalCode());
        packNode.setType(ProductionProcessEnum.PACKAGE.type);
        packNode.setOriginalCode(code.getOriginalCode());

        Barcode sake = barcodeRepo.findTop1ByHidAndEnglishOrderByDateAscTimeAsc(barcode.getHid(), "Sake");
        if (sake == null) {
            DataNode sakeNode = new DataNode();
            DataNode fermentNode = new DataNode();
            DataNode saccharifyNode = new DataNode();
            packNode.addChildren(sakeNode);
            sakeNode.addChildren(fermentNode);
            fermentNode.addChildren(saccharifyNode);
            return ret;
        }
        DataNode sakeNode = new DataNode();
        sakeNode.setName(String.format(format, sake.getDate(), sake.getTime(), "BBT-" + sake.getSakeTank()));
        sakeNode.setValue(sake.getHid());
        sakeNode.setType(ProductionProcessEnum.SAKE.type);
        sakeNode.setOriginalCode(code.getOriginalCode());
        packNode.addChildren(sakeNode);

        List<BarcodeBroth> barcodeBrothList = barcodeBrothRepo.findByHidLike(sake.getSid());
        if (barcodeBrothList.isEmpty()) {
            DataNode fermentNode = new DataNode();
            DataNode saccharifyNode = new DataNode();
            sakeNode.addChildren(fermentNode);
            fermentNode.addChildren(saccharifyNode);
            return ret;
        }
        for (BarcodeBroth broth : barcodeBrothList) {
            DataNode fermentNode = new DataNode();
            fermentNode.setName(String.format(format, broth.getDate(), broth.getTime(), "UT-" + broth.getFermenter()));
            fermentNode.setValue(broth.getHid());
            fermentNode.setType(ProductionProcessEnum.FERMENT.type);
            fermentNode.setOriginalCode(code.getOriginalCode());
            sakeNode.addChildren(fermentNode);

            List<Wort> wortList = wortRepo.findByHid(broth.getHid());
            if (wortList.isEmpty()) {
                DataNode saccharifyNode = new DataNode();
                fermentNode.addChildren(saccharifyNode);
            }
            for (Wort wort : wortList) {
                String hid = wort.getHid();
                String date = String.format("20%s-%s-%s", hid.substring(0, 2), hid.substring(2, 4),
                        hid.substring(4, 6));
                String time = String.format("%s:%s:%s", hid.substring(6, 8), hid.substring(8, 10),
                        hid.substring(10, 12));
                DataNode saccharifyNode = new DataNode();
                saccharifyNode.setName(String.format(format, date, time, "BH-" + wort.getPotNumber()));
                saccharifyNode.setValue(hid);
                saccharifyNode.setType(ProductionProcessEnum.SACCHARIFY.type);
                saccharifyNode.setOriginalCode(code.getOriginalCode());
                fermentNode.addChildren(saccharifyNode);
            }
        }
        return ret;
    }

    private Map<String, Object> getToData(CodeInfo code) {
        DataNode packNode = new DataNode();
        String format = "%s %s %s";
        packNode.setName(String.format(format, code.getDate(), code.getTime(), code.getLine()));
        packNode.setValue(code.getOriginalCode());

        DateTime dt = MiscUtil.getDateTime(code.getDate(), code.getTime());
        Date startTime = dt.toDate();
        Date endTime = dt.plus(120 * 60000).toDate();

        BarcodeQueryResult result = new BarcodeQueryResult(0, "", null, null);
        // FIXME: commented due to unavailable web service
        // try {
        // result = barcodeQueryService.queryByTimeInterval(WorkshopUtil.getBarcodeWorkshopCode(code.getWorkshop()),
        // WorkshopUtil.getBarcodeLineCode(code.getLine()), startTime, endTime);
        // } catch (Exception e) {
        // logger.error("get barcode query result", e);
        // }
        if (result.getCode() == 0 && result.getDetailList() != null) {
            for (BarcodeQueryResultDetail detail : result.getDetailList()) {
                DataNode rollOff = new DataNode();
                rollOff.setName(String.format(format, detail.getStartTimeString(), code.getLine(), detail.getName()));
                rollOff.setValue(detail.getBarcode());
                packNode.addChildren(rollOff);

                DataNode warehouseShipment = new DataNode();
                warehouseShipment.setName(
                        String.format(format, detail.getTargetTimeString(), detail.getArea(), detail.getNumberNo()));
                warehouseShipment.setValue(detail.getBarcode());
                rollOff.addChildren(warehouseShipment);
            }
        } else {
            packNode = new DataNode();
        }
        Map<String, Object> ret = new HashMap<>();
        ret.put("processes", LogisticsProcessEnum.getProcessList());
        ret.put("data", packNode);
        return ret;
    }

}
