package com.microservices.accounts.controller;

import com.microservices.accounts.dto.CustomerDetailsDto;
import com.microservices.accounts.dto.ErrorResponseDto;
import com.microservices.accounts.service.ICustomersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "REST API for Customers in Bank", description = "REST APIs in Bank to FETCH customer details")
@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@Validated
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	private final ICustomersService iCustomersService;

	public CustomerController(ICustomersService iCustomersService) {
		this.iCustomersService = iCustomersService;
	}

	@Operation(summary = "Fetch Customer Details REST API", description = "REST API to fetch Customer details based on a mobile number")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@GetMapping("/fetchCustomerDetails")
	public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(
			@RequestHeader("ridhorezi1212-correlation-id") String correlationId,
			@RequestParam @Pattern(regexp = "(^$|[0-9]{12})", message = "Mobile number must be 12 digits") String mobileNumber) {
		logger.debug("fetchCustomerDetails method start");
		CustomerDetailsDto customerDetailsDto = iCustomersService.fetchCustomerDetails(mobileNumber, correlationId);
		logger.debug("fetchCustomerDetails method end");
		return ResponseEntity.status(HttpStatus.SC_OK).body(customerDetailsDto);

	}

}