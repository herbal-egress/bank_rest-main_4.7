package com.example.bankcards.repository;

import com.example.bankcards.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    void deleteAllCardsByUserId(Long userId);

    Page<Card> findByUserId(Long userId, Pageable pageable);

    boolean existsByEncryptedCardNumber(String encryptedCardNumber);
}