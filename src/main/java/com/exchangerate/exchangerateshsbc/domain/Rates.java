package com.exchangerate.exchangerateshsbc.domain;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"GBP",
"USD",
"HKD"
})
@Embeddable
public class Rates {

@JsonProperty("GBP")
private Double gbp;
@JsonProperty("USD")
private Double usd;
@JsonProperty("HKD")
private Double hkd;
public Double getGbp() {
	return gbp;
}
public void setGbp(Double gbp) {
	this.gbp = gbp;
}
public Double getUsd() {
	return usd;
}
public void setUsd(Double usd) {
	this.usd = usd;
}
public Double getHkd() {
	return hkd;
}
public void setHkd(Double hkd) {
	this.hkd = hkd;
}

}