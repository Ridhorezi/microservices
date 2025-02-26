package com.microservices.accounts.repository;

import java.util.Optional;

import com.microservices.accounts.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Optional<Customer> findByMobileNumber(String mobileNumber);
}
