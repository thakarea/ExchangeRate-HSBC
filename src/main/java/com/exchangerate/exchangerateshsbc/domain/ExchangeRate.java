package com.exchangerate.exchangerateshsbc.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "success", "historical", "date", "timestamp", "base", "rates" })
@Entity
@Table(name="exchange_rate")
public class ExchangeRate {

	@Id
	@JsonProperty("date")
	private String exchangeDate;
	@JsonProperty("success")
	private Boolean success;
	@JsonProperty("historical")
	private Boolean historical;
	@JsonProperty("timestamp")
	private Integer timestamp;
	@JsonProperty("base")
	private String base;
	@JsonProperty("rates")
	private Rates rates;

	@JsonProperty("success")
	public Boolean getSuccess() {
		return success;
	}

	@JsonProperty("success")
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@JsonProperty("historical")
	public Boolean getHistorical() {
		return historical;
	}

	@JsonProperty("historical")
	public void setHistorical(Boolean historical) {
		this.historical = historical;
	}

	@JsonProperty("date")
	public String getDate() {
		return exchangeDate;
	}

	@JsonProperty("date")
	public void setDate(String date) {
		this.exchangeDate = date;
	}

	@JsonProperty("timestamp")
	public Integer getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

	@JsonProperty("base")
	public String getBase() {
		return base;
	}

	@JsonProperty("base")
	public void setBase(String base) {
		this.base = base;
	}

	@JsonProperty("rates")
	public Rates getRates() {
		return rates;
	}

	@JsonProperty("rates")
	public void setRates(Rates rates) {
		this.rates = rates;
	}

}