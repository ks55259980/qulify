package com.spoonsea.qualitytracing.braumat.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spoonsea.qualitytracing.braumat.entity.Brau33;
import com.spoonsea.qualitytracing.braumat.entity.BraumatKey;


public interface BraumatRepository extends JpaRepository<Brau33, BraumatKey> {

    Brau33 findOneBySzJahrAndSzMonatAndSzTagAndSzStundeAndTeilanl(int year, int monthOfYear, int dayOfMonth,
            int hourOfDay, String string);

    List<Brau33> findByTeilanlAndStartTsGreaterThanAndEndTsLessThan(String teilanl, BigInteger endTs,
            BigInteger startTs);

    Brau33 findTop1ByTeilanlAndGopNameAndEndTsLessThanOrderByStartTsDesc(String teilanl, String string,
            BigInteger startTs);

    Brau33 findTop1ByTeilanlAndGopNameAndStartTsGreaterThanOrderByStartTsAsc(String teilanl, String string,
            BigInteger endTs);

}
