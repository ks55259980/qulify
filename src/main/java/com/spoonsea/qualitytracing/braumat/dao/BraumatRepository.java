package com.spoonsea.qualitytracing.braumat.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.spoonsea.qualitytracing.braumat.entity.Braumat;

@NoRepositoryBean
public interface BraumatRepository<T extends Braumat> extends JpaRepository<T, Long> {

    T findTop1ByRezTypAndTeilanlNrAndGopNameAndStartTsGreaterThanEqualOrderByStartTsAsc(String rezTyp, int teilanlNr,
            String gopName, BigInteger startTs);

    T findOneByRezTypAndTeilanlNrAndStartTsLessThanEqualAndEndTsGreaterThanEqual(String rezTyp, int teilanlNr,
            BigInteger startTs, BigInteger endTs);

    T findOneByTeilanlAndStartTsLessThanEqualAndEndTsGreaterThan(int teilanl, BigInteger startTs, BigInteger endTs);

    T findOneByTeilanlAndStartTsLessThanEqualAndEndTsGreaterThanEqual(String teilanl, BigInteger startTs,
            BigInteger endTs);

    List<T> findByTeilanlAndStartTsGreaterThanAndEndTsLessThan(String teilanl, BigInteger endTs, BigInteger startTs);

    T findTop1ByTeilanlAndGopNameAndEndTsLessThanOrderByStartTsDesc(String teilanl, String string, BigInteger startTs);

    T findTop1ByTeilanlAndGopNameAndStartTsGreaterThanOrderByStartTsAsc(String teilanl, String string,
            BigInteger endTs);

    T findTop1ByRezTypAndTeilanlNrAndGopNameAndEndTsLessThanOrderByStartTsDesc(String rezTyp, int bbtNo, String string,
            BigInteger startTs);

    T findTop1ByRezTypAndTeilanlNrAndGopNameAndStartTsGreaterThanOrderByStartTsAsc(String rezTyp, int bbtNo,
            String string, BigInteger endTs);

    List<T> findByRezTypAndTeilanlNrAndStartTsGreaterThanAndEndTsLessThan(String rezTyp, int bbtNo, BigInteger endTs,
            BigInteger startTs);

    List<T> findByAuftrNrAndChargNrInAndTeilanlIn(int auftrNr, List<Integer> chargNrList, List<String> teilanlList);

    T findOneByRezTypAndTeilanlAndStartTsLessThanEqualAndEndTsGreaterThanEqual(String rezTyp, String teilanl,
            BigInteger valueOf, BigInteger valueOf2);

    List<T> findByRezTypAndTeilanlAndAuftrNrAndChargNr(String rezTyp, String teilanl, int auftrNr, int chargNr);

    T findOneByRezTypAndTeilanlAndAuftrNrAndChargNrAndGopName(String rezTyp, String teilanl, int auftrNr, int chargNr,
            String gopName);

    T findOneByRezTypAndSwDfm1AndStartTs(String string, String teilanl, BigInteger startTs);

    T findTop1ByTeilanlAndAuftrNrAndChargNrOrderByStartTsAsc(String teilanl, int AuftrNr, int ChargNr);

    T findTop1ByTeilanlAndAuftrNrAndChargNrOrderByStartTsDesc(String teilanl, int AuftrNr, int ChargNr);

    T findTop1ByRezTypAndStartTsGreaterThanAndEndTsLessThanOrderByStartTsAsc(String rezTyp, BigInteger startTs,
            BigInteger endTs);

    T findTop1ByRezTypAndTeilanlNrAndGopNameAndAuftrNrAndChargNrAndEndTsLessThanEqualOrderByStartTsDesc(String rezTyp,
            int bbtNo, String gopName, int auftrNr, int chargNr, BigInteger EndTs);

    T findTop1ByRezTypAndStartTsGreaterThanEqualAndEndTsLessThanEqualOrderByStartTs(String rezType, BigInteger startTs,
            BigInteger endTs);

    T findTop1ByRezTypAndTeilanlAndGopNameAndStartTsGreaterThanOrderByStartTsAsc(String rezTyp, String teilanl,
            String gopName, BigInteger wortTs);

    T findTop1ByRezTypAndSwDfm1AndStartTsGreaterThanEqualAndEndTsLessThanOrderByStartTsAsc(String rezType,
            String teilanl, BigInteger startTs, BigInteger endTs);

    T findTop1ByRezTypAndTeilanlLikeAndStartTsGreaterThanEqualOrderByStartTsAsc(String rezTyp, String teilanl,
            BigInteger valueOf);

    List<T> findByAuftrNrAndChargNrInAndTeilanlStartingWith(int auftrNr, List<Integer> chargNrList, String teilanl);

    T findTop1ByTeilanlAndIwDfm2AndStartTsLessThanOrderByStartTsDesc(String teilanl, String silo, BigInteger startTs);

    T findTop1ByAuftrNrAndChargNrAndTeilanlAndGopNameAndStartTsLessThanEqualOrderByStartTsDesc(int auftrNr, int chargNr,
            String teilanl, String gopName, BigInteger startTs);

    T findTop1ByAuftrNrAndChargNrAndTeilanlAndGopNameAndStartTsGreaterThanEqualOrderByStartTsAsc(int auftrNr,
            int chargNr, String teilanl, String gopName, BigInteger startTs);

    List<T> findByAuftrNrAndChargNrAndTeilanlAndStartTsGreaterThanEqualAndEndTsLessThanEqual(int auftrNr, int chargNr,
            String teilanl, BigInteger startTs, BigInteger endTs);

    T findTop1ByRezTypAndTeilanlStartingWithAndSwDfm1AndEndTsGreaterThanEqualOrderByStartTsAsc(String rezTyp,
            String line, String iwDfm1, BigInteger endTs);

    T findTop1ByRezTypAndIwDfm1AndEndTsLessThanEqualOrderByStartTsDesc(String rezTyp, String iwDfm1,
            BigInteger startTs);

    T findTop1ByRezTypAndIwDfm1AndStartTsLessThanEqualOrderByStartTsDesc(String rezTyp, String iwDfm1,
            BigInteger StartTs);

    T findTop1ByTeilanlLikeAndIwDfm1StartingWithAndStartTsLessThanOrderByStartTsDesc(String teilanl, String iwDfm1,
            BigInteger startTs);

    List<T> findByTeilanlAndAuftrNrAndChargNr(String teilanl, int auftrNr, int chargNr);
}
