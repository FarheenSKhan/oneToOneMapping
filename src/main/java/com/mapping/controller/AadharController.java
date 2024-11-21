package com.mapping.controller;


import com.mapping.entity.AadharCard;
import com.mapping.entity.ResponseStructure;
import com.mapping.service.AadharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/AadharCard")
public class AadharController {

    @Autowired
    private AadharService aadharService;

    @PostMapping("/saveAadharCard")
    public ResponseEntity<ResponseStructure<AadharCard>> saveAadharCard (AadharCard aadharCard){
        return  aadharService.saveAadharCard(aadharCard);
    }

    @GetMapping("/GetById")
    public ResponseEntity<ResponseStructure<AadharCard>> findById (Long id){
        return  aadharService.findById(id);
    }

    @GetMapping("/getByAadharNumber")
    public ResponseEntity<ResponseStructure<AadharCard>> findByAadharNumber (String aadharNumber){
        return  aadharService.findByAadharNumber(aadharNumber);
    }
    @GetMapping("/GetByVidNumber")
    public ResponseEntity<ResponseStructure<AadharCard>> findByVidNumber (String vidNumber){
        return  aadharService.findByVidNumber(vidNumber);
    }

    @GetMapping("/GetAllAadharCards")
    public ResponseEntity<ResponseStructure<List<AadharCard>>> findAll(){
        return  aadharService.findAll();
    }


}
