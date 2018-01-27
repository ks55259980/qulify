package com.spoonsea.qualitytracing.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.spoonsea.qualitytracing.util.WorkshopUtil;

public class CodeInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String date;

    private String time;

    private String workshop;

    private String line;

    private String originalCode;

    public CodeInfo(String code) {
        this.originalCode = code;
        this.date = String.format("%s-%s-%s", code.substring(0, 4), code.substring(4, 6), code.substring(6, 8));
        this.time = String.format("%s:00", code.substring(10, 15));
        this.workshop = code.substring(16, 18);
        this.line = WorkshopUtil.getLine(code.substring(8, 9));
    }

    public CodeInfo() {
        
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getOriginalCode() {
        return originalCode;
    }

    public void setOriginalCode(String originalCode) {
        this.originalCode = originalCode;
    }

    @Override
    public String toString() {
        return "CodeInfo [date=" + date + ", time=" + time + ", workshop=" + workshop + ", line=" + line
                + ", originalCode=" + originalCode + "]";
    }

}
