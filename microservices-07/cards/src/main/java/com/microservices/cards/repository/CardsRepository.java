package com.microservices.cards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.microservices.cards.entity.Cards;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {

	Optional<Cards> findByMobileNumber(String mobileNumber);

	Optional<Cards> findByCardNumber(String cardNumber);

}
