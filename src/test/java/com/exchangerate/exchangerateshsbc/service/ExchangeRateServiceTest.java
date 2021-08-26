package com.exchangerate.exchangerateshsbc.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.exchangerate.exchangerateshsbc.domain.ExchangeRate;
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

	URI exchangeUri;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(exchangeRateService, "exchangeRateUrl", "http://localhost:8080");
		exchangeUri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080").build().encode().toUri();
		resEntity = new ResponseEntity<ExchangeRate>(new ExchangeRate(), HttpStatus.OK);

	}

	@Test
	public void saveExchangeRateTest() {
		when(restTemplate.exchange(ArgumentMatchers.eq(exchangeUri), ArgumentMatchers.eq(HttpMethod.GET),
				ArgumentMatchers.eq(null), ArgumentMatchers.eq(ExchangeRate.class))).thenReturn(resEntity);
		assertNull(exchangeRateService.saveExchangeRate());
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
