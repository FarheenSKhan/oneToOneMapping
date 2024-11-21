package com.mapping.repository;

import com.mapping.entity.AadharCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AadharCardRepository extends JpaRepository<AadharCard, Long> {

    public Optional<AadharCard> findByAadharNumber(String aadharNumber);
    public Optional<AadharCard> findByVidNumber(String vidNumber);


}