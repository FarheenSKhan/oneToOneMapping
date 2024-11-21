package com.mapping.service;

import com.mapping.dao.PanDao;
import com.mapping.entity.PanCard;
import com.mapping.entity.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class PanService {

    @Autowired
    private PanDao panDao;

    public ResponseEntity<ResponseStructure<PanCard>> savePanCard(PanCard panCard){
        ResponseStructure<PanCard> responseStructure=new ResponseStructure<>();
        PanCard panCard1=panDao.findByPanNumber(panCard.getPanNumber());
        if(panCard1 != null){
            responseStructure.setStatus(HttpStatus.CONFLICT.value());
            responseStructure.setMessage("PanCard is already saved");
            responseStructure.setData(null);
            return new ResponseEntity<>(responseStructure, HttpStatus.CONFLICT);
        }else{
            panDao.savePanCard(panCard);
            responseStructure.setStatus(HttpStatus.CREATED.value());
            responseStructure.setMessage("PanCard saved successfully");
            responseStructure.setData(panCard);
            return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<ResponseStructure<PanCard>> findById(Long id){
        ResponseStructure<PanCard> responseStructure=new ResponseStructure<>();
        PanCard panCard1=panDao.findById(id);
        if(panCard1 == null){
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("PanCard not found");
            responseStructure.setData(null);
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }else{
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("PanCard found by id");
            responseStructure.setData(panCard1);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
    }

    public ResponseEntity<ResponseStructure<PanCard>> findByPanNumber(String panNumber){
        ResponseStructure<PanCard> responseStructure=new ResponseStructure<>();
        PanCard panCard1=panDao.findByPanNumber(panNumber);
        if(panCard1 == null){
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("PanCard not found");
            responseStructure.setData(null);
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }else{
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("PanCard found by PanNumber");
            responseStructure.setData(panCard1);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
    }
    public ResponseEntity<ResponseStructure<List<PanCard>>> findAll(){
        ResponseStructure<List<PanCard>> responseStructure =new ResponseStructure<>();
        List<PanCard> panCard = panDao.findAll();
        if(panCard == null){
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("PanCard not found");
            responseStructure.setData(null);
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }else{
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("Found all PanCards");
            responseStructure.setData(panCard);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
    }
}

