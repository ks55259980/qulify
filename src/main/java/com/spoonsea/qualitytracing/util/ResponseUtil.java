package com.spoonsea.qualitytracing.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static ResponseEntity<?> makeResponse(int code, String error, Object data) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        if (error != null) {
            result.put("error", error);
        }
        if (data != null) {
            result.put("data", data);
        }
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

    public static ResponseEntity<?> makeResponse(Object data) {
        return makeResponse(0, null, data);
    }

    public static ResponseEntity<?> makeErrorResponse(int code, String error) {
        return makeResponse(code, error, null);
    }

}