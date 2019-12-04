package com.ylcn.exchange.conversion.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ylcn.exchange.conversion.model.CurrencyModel;

@Repository
public interface CurrencyRepository extends CrudRepository<CurrencyModel, Long>{

}
