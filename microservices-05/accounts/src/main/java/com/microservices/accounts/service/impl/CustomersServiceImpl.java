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

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomersServiceImpl implements ICustomersService {

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
	 * @param mobileNumber - Input Mobile Number
	 * @return Customer Details based on a given mobileNumber
	 */
	@Override
	public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
		Customer customer = customerRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
				() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));

		CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer,
				new CustomerDetailsDto());
		customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

		ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
		customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

		ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
		customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

		return customerDetailsDto;

	}
}