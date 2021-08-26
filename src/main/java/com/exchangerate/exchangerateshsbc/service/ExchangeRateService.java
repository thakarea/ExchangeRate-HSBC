package com.exchangerate.exchangerateshsbc.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.exchangerate.exchangerateshsbc.domain.ExchangeRate;
import com.exchangerate.exchangerateshsbc.repository.ExchangeRateRepository;

@Service
public class ExchangeRateService {

	@Value("${exchange.rate.api}")
	public String exchangeRateUrl;

	@Autowired
	ExchangeRateRepository exchangeRateRepo;

	@Autowired
	RestTemplate restTemplate;

	public ExchangeRate saveExchangeRate() {
		URI exchangeUri = UriComponentsBuilder.fromHttpUrl(exchangeRateUrl).build().encode().toUri();
		ResponseEntity<ExchangeRate> resEntity = restTemplate.exchange(exchangeUri, HttpMethod.GET, null,
				ExchangeRate.class);
		return exchangeRateRepo.save(resEntity.getBody());

	}
	
	public List<ExchangeRate> retriveExchangeRate()
	{
		List<ExchangeRate> exchangeRateList =exchangeRateRepo.findAll();
		return exchangeRateList;
	}
	
	public Optional<ExchangeRate> fetchExchangeRateByDate(String date)
	{
		Optional<ExchangeRate> exchangeRate =exchangeRateRepo.findById(date);
		return exchangeRate;
	}
	
	public List<ExchangeRate> fetchExchangeRateByDateRange(String startDate, String endDate)
	{
		List<ExchangeRate> exchangeRate =exchangeRateRepo.findReferenceFieldBetween(startDate,endDate);
		
		return exchangeRate;
	}

}
