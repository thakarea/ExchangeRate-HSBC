package com.exchangerate.exchangerateshsbc.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.exchangerate.exchangerateshsbc.domain.ExchangeRate;
import com.exchangerate.exchangerateshsbc.domain.Rates;
import com.exchangerate.exchangerateshsbc.repository.ExchangeRateRepository;

@RunWith(MockitoJUnitRunner.class)
public class ExchangeRateServiceTest {

	@InjectMocks
	ExchangeRateService exchangeRateService;

	@Mock
	ExchangeRateRepository exchangeRateRepo;

	@Mock
	RestTemplate restTemplate;

	@Mock
	ResponseEntity<ExchangeRate> resEntity;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void retriveExchangeRateTest() {
		assertNotNull(exchangeRateService.retriveExchangeRate());

	}

	@Test
	public void fetchExchangeRateByDateTest() {
		assertNotNull(exchangeRateService.fetchExchangeRateByDate("2021-08-25"));

	}

	@Test
	public void fetchExchangeRateByDateRangeTest() {
		assertNotNull(exchangeRateService.fetchExchangeRateByDateRange("2021-08-25", "2021-08-26"));

	}

}
