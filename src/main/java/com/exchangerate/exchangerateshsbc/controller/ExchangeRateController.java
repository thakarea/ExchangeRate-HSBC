package com.exchangerate.exchangerateshsbc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exchangerate.exchangerateshsbc.domain.ExchangeRate;
import com.exchangerate.exchangerateshsbc.service.ExchangeRateService;

@RestController
@RequestMapping(value = "/exchange/rates")
public class ExchangeRateController {

	@Autowired
	public ExchangeRateService exchangeRateService;

	@PostMapping("/save")
	public ResponseEntity<ExchangeRate> saveExchangeRate() {
		try {
			ExchangeRate exchangeRate = exchangeRateService.saveExchangeRate();
			return new ResponseEntity<>(exchangeRate, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/latest")
	public ResponseEntity<List<ExchangeRate>> getExchangeRates() {
		try {
			List<ExchangeRate> exchangeList = exchangeRateService.retriveExchangeRate();
			return new ResponseEntity<>(exchangeList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/bydate/{date}")
	public ResponseEntity<ExchangeRate> getExchangeRateByDate(@PathVariable("date") String date) {
		try {
			Optional<ExchangeRate> exchange = exchangeRateService.fetchExchangeRateByDate(date);
			if (exchange.isPresent()) {
				return new ResponseEntity<>(exchange.get(), HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/dates/range")
	public ResponseEntity<List<ExchangeRate>> getExchangeRateBetweenDate(@RequestParam("start_date") String startDate,
			@RequestParam("end_date") String endDate) {
		try {
			List<ExchangeRate> exchange = exchangeRateService.fetchExchangeRateByDateRange(startDate, endDate);
			if (!exchange.isEmpty()) {
				return new ResponseEntity<>(exchange, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
