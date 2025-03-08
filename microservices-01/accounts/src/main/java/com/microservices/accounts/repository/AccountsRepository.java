package com.microservices.accounts.repository;

import java.util.Optional;

import com.microservices.accounts.entity.Accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

/**
 * @author Ridho Suhaebi Arrowi
 */

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Optional<Accounts> findByCustomerId(Long customerId);

    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);

}