package com.exchangerate.exchangerateshsbc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.exchangerate.exchangerateshsbc.domain.ExchangeRate;
import com.exchangerate.exchangerateshsbc.service.ExchangeRateService;

@RunWith(MockitoJUnitRunner.class)
public class ExchangeRateControllerTest {

	@InjectMocks
	ExchangeRateController exchangeController;

	@Mock
	ExchangeRateService exchangeRateSevice;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void saveRateTest() {
		when(exchangeRateSevice.saveExchangeRate()).thenReturn(new ExchangeRate());
		ResponseEntity<ExchangeRate> resEntity = exchangeController.saveExchangeRate();
		assertEquals(HttpStatus.CREATED, resEntity.getStatusCode());
	}

	@Test
	public void saveRateExceptionTest() {
		doThrow(RuntimeException.class).when(exchangeRateSevice).saveExchangeRate();
		ResponseEntity<ExchangeRate> resEntity = exchangeController.saveExchangeRate();
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, resEntity.getStatusCode());
	}

	@Test
	public void getExchangeRatesTest() {
		when(exchangeRateSevice.retriveExchangeRate()).thenReturn(new ArrayList<ExchangeRate>());
		ResponseEntity<List<ExchangeRate>> resEntityList = exchangeController.getExchangeRates();
		assertEquals(HttpStatus.OK, resEntityList.getStatusCode());
	}

	@Test
	public void getExchangeRatesExceptionTest() {
		doThrow(RuntimeException.class).when(exchangeRateSevice).retriveExchangeRate();
		ResponseEntity<List<ExchangeRate>> resEntityList = exchangeController.getExchangeRates();
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, resEntityList.getStatusCode());
	}

	@Test
	public void getExchangeRateByDateTest() {
		ResponseEntity<ExchangeRate> resEntity = exchangeController.getExchangeRateByDate("2021-08-25");
		assertEquals(HttpStatus.NOT_FOUND, resEntity.getStatusCode());
	}

	@Test
	public void getExchangeRateBetweenDateTest() {
		ResponseEntity<List<ExchangeRate>> resEntity = exchangeController.getExchangeRateBetweenDate("2021-08-25",
				"2021-08-26");
		assertEquals(HttpStatus.NOT_FOUND, resEntity.getStatusCode());
	}

}
