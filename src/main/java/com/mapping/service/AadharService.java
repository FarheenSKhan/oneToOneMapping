package com.mapping.service;


import com.mapping.dao.AadharDao;
import com.mapping.entity.AadharCard;
import com.mapping.entity.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AadharService {

    @Autowired
    private AadharDao aadharDao;

    public ResponseEntity<ResponseStructure<AadharCard>> saveAadharCard(AadharCard aadharCard){
        ResponseStructure<AadharCard> responseStructure=new ResponseStructure<>();
        AadharCard aadharCard1= aadharDao.findByAadharNumber(aadharCard.getAadharNumber());
        if(aadharCard1 != null){
            responseStructure.setStatus(HttpStatus.CONFLICT.value());
            responseStructure.setMessage("Aadhar Card already exists");
            responseStructure.setData(null);
            return new ResponseEntity<>(responseStructure, HttpStatus.CONFLICT);
        }else{
            aadharDao.saveAadharCard(aadharCard);
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("Aadhar Card saved successfully");
            responseStructure.setData(aadharCard);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
    }
    public ResponseEntity<ResponseStructure<AadharCard>> findById(Long id){
        ResponseStructure<AadharCard> responseStructure=new ResponseStructure<>();
        AadharCard aadharCard1= aadharDao.findById(id);
        if(aadharCard1 == null){
        responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage("Aadhar Card not found");
        responseStructure.setData(null);
        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }else {
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("Aadhar Card found by id");
            responseStructure.setData(aadharCard1);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
    }

    public ResponseEntity<ResponseStructure<AadharCard>> findByAadharNumber(String aadharNumber){
        ResponseStructure<AadharCard> responseStructure=new ResponseStructure<>();
        AadharCard aadharCard1= aadharDao.findByAadharNumber(aadharNumber);
        if(aadharCard1 == null){
        responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage("Aadhar Card not found");
        responseStructure.setData(null);
        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }else{
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("Aadhar Card found by Aadhar Number");
            responseStructure.setData(aadharCard1);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
    }

    public ResponseEntity<ResponseStructure<AadharCard>> findByVidNumber(String vidNumber){
        ResponseStructure<AadharCard> responseStructure=new ResponseStructure<>();
        AadharCard aadharCard1= aadharDao.findByVidNumber(vidNumber);
        if(aadharCard1 == null){
        responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage("Aadhar Card not found");
        responseStructure.setData(null);
        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }else{
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("Aadhar Card found by Vid Number");
            responseStructure.setData(aadharCard1);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
    }
   public ResponseEntity<ResponseStructure<List<AadharCard>>> findAll(){
        ResponseStructure<List<AadharCard>> responseStructure=new ResponseStructure<>();
        List<AadharCard> aadharCard =aadharDao.findAll();
        if (aadharCard == null){
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("No Aadhar Cards found");
            responseStructure.setData(null);
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }else{
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("All Aadhar Cards found");
            responseStructure.setData(aadharCard);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
   }



}
