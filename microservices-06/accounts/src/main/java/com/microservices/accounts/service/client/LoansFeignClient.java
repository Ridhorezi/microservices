package com.microservices.accounts.service.client;

import com.microservices.accounts.dto.LoansDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("loans")
public interface LoansFeignClient {

	@GetMapping(value = "/api/fetch", consumes = "application/json")
	public ResponseEntity<LoansDto> fetchLoanDetails(
			@RequestHeader("ridhorezi1212-correlation-id") String correlationId, @RequestParam String mobileNumber);

}
