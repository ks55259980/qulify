package com.spoonsea.qualitytracing.braumat.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spoonsea.qualitytracing.braumat.entity.Braumat;
import com.spoonsea.qualitytracing.braumat.entity.BraumatKey;


public interface BraumatRepository<T extends Braumat> extends JpaRepository<T, BraumatKey> {
    
    T findOneByRezTypAndTeilanlNrAndStartTsLessThanEqualAndEndTsGreaterThan(String rezTyp, int teilanlNr, BigInteger startTs, BigInteger endTs);

    T findOneByRezTypAndTeilanlNrAndStartTsLessThanEqualAndEndTsGreaterThanEqual(String rezTyp, int teilanlNr, BigInteger startTs, BigInteger endTs);

    T findOneByTeilanlAndStartTsLessThanEqualAndEndTsGreaterThan(int teilanl, BigInteger startTs, BigInteger endTs);

    T findOneByTeilanlAndStartTsLessThanEqualAndEndTsGreaterThanEqual(String teilanl, BigInteger startTs, BigInteger endTs);

    List<T> findByTeilanlAndStartTsGreaterThanAndEndTsLessThan(String teilanl, BigInteger endTs,
            BigInteger startTs);

    T findTop1ByTeilanlAndGopNameAndEndTsLessThanOrderByStartTsDesc(String teilanl, String string,
            BigInteger startTs);

    T findTop1ByTeilanlAndGopNameAndStartTsGreaterThanOrderByStartTsAsc(String teilanl, String string,
            BigInteger endTs);

	T findTop1ByRezTypAndTeilanlNrAndGopNameAndEndTsLessThanOrderByStartTsDesc(String rezTyp, int bbtNo,
			String string, BigInteger startTs);

	T findTop1ByRezTypAndTeilanlNrAndGopNameAndStartTsGreaterThanOrderByStartTsAsc(String rezTyp, int bbtNo,
			String string, BigInteger endTs);

	List<T> findByRezTypAndTeilanlNrAndStartTsGreaterThanAndEndTsLessThan(String rezTyp, int bbtNo,
			BigInteger endTs, BigInteger startTs);

	List<T> findByTeilanlAndAuftrNrAndChargNr(String teilanl, int auftrNr, int chargNr);

	T findOneByRezTypAndTeilanlAndStartTsLessThanEqualAndEndTsGreaterThanEqual(String rezTyp, String teilanl,
			BigInteger valueOf, BigInteger valueOf2);

	List<T> findByRezTypAndTeilanlAndAuftrNrAndChargNr(String rezTyp, String teilanl, int auftrNr, int chargNr);

	T findOneByRezTypAndTeilanlAndAuftrNrAndChargNrAndGopName(String rezTyp, String teilanl, int auftrNr,
			int chargNr, String gopName);

	T findOneByRezTypAndSwDfm1AndStartTs(String string, String teilanl, BigInteger startTs);

}
