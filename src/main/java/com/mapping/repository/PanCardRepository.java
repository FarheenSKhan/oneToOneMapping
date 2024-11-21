package com.mapping.repository;

import com.mapping.entity.PanCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanCardRepository extends JpaRepository<PanCard, Long> {


    public PanCard findByPanNumber(String panNumber);
}