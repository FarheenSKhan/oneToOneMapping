package com.mapping.controller;

import com.mapping.entity.PanCard;
import com.mapping.entity.ResponseStructure;
import com.mapping.service.PanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/panCard")
public class PanController {

    @Autowired
    private PanService panService;

    @PostMapping("/savePanCard")
    public ResponseEntity<ResponseStructure<PanCard>> savePanCard(@RequestBody PanCard panCard){
        return panService.savePanCard(panCard);
    }

    @GetMapping("/GetById")
    public ResponseEntity<ResponseStructure<PanCard>> findById(@RequestParam Long id){
        return panService.findById(id);
    }

    @GetMapping("/GetByPanNumber")
    public ResponseEntity<ResponseStructure<PanCard>> findByPanNumber(@RequestParam String panNumber){
        return panService.findByPanNumber(panNumber);
    }

    @GetMapping("/GetAllPanCards")
    public ResponseEntity<ResponseStructure<List<PanCard>>> findAll (){
        return panService.findAll();
    }
}
