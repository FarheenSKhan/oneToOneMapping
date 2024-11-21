package com.mapping.dao;

import ch.qos.logback.classic.util.CopyOnInheritThreadLocal;
import com.mapping.entity.AadharCard;
import com.mapping.repository.AadharCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AadharDao {

    @Autowired
    private AadharCardRepository aadharCardRepository;

    public AadharCard saveAadharCard(AadharCard aadharCard){
        return aadharCardRepository.save(aadharCard);
    }

    public AadharCard findById(Long id){
        Optional<AadharCard> optional=aadharCardRepository.findById(id);
        return optional.orElse(null);
    }

    public AadharCard findByAadharNumber(String aadharNumber){
        Optional<AadharCard> optional=aadharCardRepository.findByAadharNumber(aadharNumber);
        return optional.orElse(null);
    }

    public AadharCard findByVidNumber (String vidNumber){
        Optional<AadharCard> optional =aadharCardRepository.findByVidNumber(vidNumber);
        return optional.orElse(null);
    }

    public List<AadharCard> findAll(){
        return aadharCardRepository.findAll();
    }


}
