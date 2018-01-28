package com.spoonsea.qualitytracing.braumat.entity;

import java.io.Serializable;
import java.math.BigInteger;


public class BraumatKey implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private BigInteger startTs;
    private BigInteger endTs;
    private int        gopNr;
    private int        teilanlNr;
}
