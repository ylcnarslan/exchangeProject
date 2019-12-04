package com.ylcn.exchange.conversion.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ylcn.exchange.exchangeRate.model.ExchangeRateModel;

@Repository
public interface ConversionCurrencyRepository extends CrudRepository<ExchangeRateModel, Long>{

}
