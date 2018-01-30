package com.spoonsea.qualitytracing.dto;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;


@JsonAutoDetect(
		fieldVisibility = Visibility.ANY,
		getterVisibility = Visibility.NONE,
		setterVisibility = Visibility.NONE)
public class MapReport extends ReportTemplate<Map<String, String>> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
}
