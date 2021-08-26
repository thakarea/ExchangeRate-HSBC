package com.exchangerate.exchangerateshsbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exchangerate.exchangerateshsbc.domain.ExchangeRate;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, String> {

	@Query(value = "SELECT * FROM EXCHANGE_RATE WHERE EXCHANGE_DATE BETWEEN :startDate AND :endDate", nativeQuery = true)
	List<ExchangeRate> findReferenceFieldBetween(@Param("startDate")String startDate,@Param("endDate")String endDate);
	
	
}
