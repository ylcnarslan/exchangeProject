package com.ylcn.exchange.exchangeRate.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ylcn.exchange.exchangeRate.model.ExchangeRateModel;

@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRateModel, Long>{
	
	@Query(value = "select value from EXCHANGE_RATE e where e.source = :source and e.rate = :rate", nativeQuery = true)
    String findBySourceAndRate(@Param("source") String source, @Param("rate") String rate);
	
}
