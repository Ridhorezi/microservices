package com.microservices.accounts.service.impl;

import com.microservices.accounts.dto.AccountsDto;
import com.microservices.accounts.dto.CardsDto;
import com.microservices.accounts.dto.CustomerDetailsDto;
import com.microservices.accounts.dto.LoansDto;
import com.microservices.accounts.entity.Accounts;
import com.microservices.accounts.entity.Customer;
import com.microservices.accounts.exception.ResourceNotFoundException;
import com.microservices.accounts.mapper.AccountsMapper;
import com.microservices.accounts.mapper.CustomerMapper;
import com.microservices.accounts.repository.AccountsRepository;
import com.microservices.accounts.repository.CustomerRepository;
import com.microservices.accounts.service.ICustomersService;
import com.microservices.accounts.service.client.CardsFeignClient;
import com.microservices.accounts.service.client.LoansFeignClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomersServiceImpl implements ICustomersService {

	private static final Logger logger = LoggerFactory.getLogger(CustomersServiceImpl.class);

	private AccountsRepository accountsRepository;
	private CustomerRepository customerRepository;
	private CardsFeignClient cardsFeignClient;
	private LoansFeignClient loansFeignClient;

	public CustomersServiceImpl(AccountsRepository accountsRepository, CustomerRepository customerRepository,
			CardsFeignClient cardsFeignClient, LoansFeignClient loansFeignClient) {
		this.accountsRepository = accountsRepository;
		this.customerRepository = customerRepository;
		this.cardsFeignClient = cardsFeignClient;
		this.loansFeignClient = loansFeignClient;
	}

	/**
	 * @param mobileNumber  - Input Mobile Number
	 * @param correlationId - Correlation ID value generated at Edge server
	 * @return Customer Details based on a given mobileNumber
	 */
	@Override
	public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
		// 1. Log input parameters
		logger.debug("=== START fetchCustomerDetails ===");
		logger.debug("Input mobileNumber: {}", mobileNumber);
		logger.debug("Input correlationId: {}", correlationId);

		// 2. Trace customer lookup
		logger.debug("Looking up customer with mobileNumber: {}", mobileNumber);
		Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> {
			logger.error("Customer not found with mobileNumber: {}", mobileNumber);
			return new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber);
		});
		logger.debug("Found customer - ID: {}, Name: {}, Mobile: {}", customer.getCustomerId(), customer.getName(),
				customer.getMobileNumber());

		// 3. Trace accounts lookup
		logger.debug("Looking up accounts for customer ID: {}", customer.getCustomerId());
		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(() -> {
			logger.error("Account not found for customer ID: {}", customer.getCustomerId());
			return new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString());
		});
		logger.debug("Found account - ID: {}, Number: {}", accounts.getAccountNumber(), accounts.getAccountNumber());

		// 4. Trace DTO mapping
		logger.debug("Mapping customer and account to DTOs");
		CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer,
				new CustomerDetailsDto());
		customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

		// 5. Trace loans service call
		logger.debug("Calling loansFeignClient.fetchLoanDetails(correlationId={}, mobileNumber={})", correlationId,
				mobileNumber);
		ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId,
				mobileNumber);
		logger.debug("Loans service response - Status: {}, Body: {}", loansDtoResponseEntity.getStatusCode(),
				loansDtoResponseEntity.getBody());
		customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

		// 6. Trace cards service call
		logger.debug("Calling cardsFeignClient.fetchCardDetails(correlationId={}, mobileNumber={})", correlationId,
				mobileNumber);
		ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId,
				mobileNumber);
		logger.debug("Cards service response - Status: {}, Body: {}", cardsDtoResponseEntity.getStatusCode(),
				cardsDtoResponseEntity.getBody());
		customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

		// 7. Final debug output
		logger.debug("Returning customerDetailsDto with data:");
		logger.debug("- Customer: {}", customerDetailsDto.getName());
		logger.debug("- Email: {}", customerDetailsDto.getEmail());
		logger.debug("- Mobile: {}", customerDetailsDto.getMobileNumber());
		logger.debug("- Accounts: {}", customerDetailsDto.getAccountsDto() != null);
		logger.debug("- Loans: {}", customerDetailsDto.getLoansDto() != null);
		logger.debug("- Cards: {}", customerDetailsDto.getCardsDto() != null);
		logger.debug("=== END fetchCustomerDetails ===");

		return customerDetailsDto;
	}
}