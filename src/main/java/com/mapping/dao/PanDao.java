package com.mapping.dao;

import com.mapping.entity.PanCard;
import com.mapping.repository.PanCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Optional;

@Repository
public class PanDao {

    @Autowired
    private PanCardRepository panCardRepository;

    public PanCard savePanCard(PanCard panCard){
        return  panCardRepository.save(panCard);
    }

    public PanCard findById(Long id){
        Optional<PanCard> optional= panCardRepository.findById(id);
        return optional.orElse(null);
    }

    public PanCard findByPanNumber(String panNumber){
        return  panCardRepository.findByPanNumber(panNumber);
    }
    public List<PanCard> findAll(){
        return panCardRepository.findAll();

    }

}
