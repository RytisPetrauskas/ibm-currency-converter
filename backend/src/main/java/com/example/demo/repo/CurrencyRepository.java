package com.example.demo.repo;


import com.example.demo.domain.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {
    @Query(value = "select abv, name from currency", nativeQuery = true)
    List<Object> returnAbvs();

    @Query(value="select abv, rate from currency where abv =:firstAbv OR abv =:secondAbv", nativeQuery=true)
    List<Object> getCurrencyRates(@Param("firstAbv") String firstAbv,@Param("secondAbv") String secondAbv);
}
