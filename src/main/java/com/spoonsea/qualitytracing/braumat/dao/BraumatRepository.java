package com.spoonsea.qualitytracing.braumat.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spoonsea.qualitytracing.braumat.entity.Brau33;
import com.spoonsea.qualitytracing.braumat.entity.BraumatKey;


public interface BraumatRepository extends JpaRepository<Brau33, BraumatKey> {
    
    Brau33 findOneByRezTypAndTeilanlNrAndStartTsLessThanEqualAndEndTsGreaterThan(String rezTyp, int teilanlNr, BigInteger startTs, BigInteger endTs);

    Brau33 findOneByRezTypAndTeilanlNrAndStartTsLessThanEqualAndEndTsGreaterThanEqual(String rezTyp, int teilanlNr, BigInteger startTs, BigInteger endTs);

    Brau33 findOneByTeilanlAndStartTsLessThanEqualAndEndTsGreaterThan(int teilanl, BigInteger startTs, BigInteger endTs);

    Brau33 findOneByTeilanlAndStartTsLessThanEqualAndEndTsGreaterThanEqual(String teilanl, BigInteger startTs, BigInteger endTs);

    List<Brau33> findByTeilanlAndStartTsGreaterThanAndEndTsLessThan(String teilanl, BigInteger endTs,
            BigInteger startTs);

    Brau33 findTop1ByTeilanlAndGopNameAndEndTsLessThanOrderByStartTsDesc(String teilanl, String string,
            BigInteger startTs);

    Brau33 findTop1ByTeilanlAndGopNameAndStartTsGreaterThanOrderByStartTsAsc(String teilanl, String string,
            BigInteger endTs);

	Brau33 findTop1ByRezTypAndTeilanlNrAndGopNameAndEndTsLessThanOrderByStartTsDesc(String rezTyp, int bbtNo,
			String string, BigInteger startTs);

	Brau33 findTop1ByRezTypAndTeilanlNrAndGopNameAndStartTsGreaterThanOrderByStartTsAsc(String rezTyp, int bbtNo,
			String string, BigInteger endTs);

	List<Brau33> findByRezTypAndTeilanlNrAndStartTsGreaterThanAndEndTsLessThan(String rezTyp, int bbtNo,
			BigInteger endTs, BigInteger startTs);

	List<Brau33> findByTeilanlAndAuftrNrAndChargNr(String teilanl, int auftrNr, int chargNr);

	Brau33 findOneByRezTypAndTeilanlAndStartTsLessThanEqualAndEndTsGreaterThanEqual(String rezTyp, String teilanl,
			BigInteger valueOf, BigInteger valueOf2);

	List<Brau33> findByRezTypAndTeilanlAndAuftrNrAndChargNr(String rezTyp, String teilanl, int auftrNr, int chargNr);

}
