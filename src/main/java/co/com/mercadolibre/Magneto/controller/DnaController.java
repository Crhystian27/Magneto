/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mercadolibre.Magneto.controller;

import co.com.mercadolibre.Magneto.dto.DnaDTO;
import co.com.mercadolibre.Magneto.dto.StatsDTO;
import co.com.mercadolibre.Magneto.model.DnaRecord;
import co.com.mercadolibre.Magneto.repository.DnaRecordRepository;
import co.com.mercadolibre.Magneto.service.DnaService;
import co.com.mercadolibre.Magneto.service.util.Util;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Crist
 */
@RestController
@RequestMapping("/api/v1/")
public class DnaController {
    
    private final DnaService dnaService;
    
    @Autowired
    private DnaRecordRepository repository;

    public DnaController(DnaService dnaService) {
        this.dnaService = dnaService;
    }
    
    @GetMapping("stats")
    public StatsDTO displayStats(){
        StatsDTO stats = new StatsDTO();
        stats.setCountMutantDna(repository.countMutant());
        stats.setCountHumanDna(repository.countHuman());
        stats.setRatio(stats.getCountMutantDna()/stats.getCountHumanDna());
        return stats;
    }
    
    @PostMapping("dna")
    public ResponseEntity verifyAndSaveDna(@RequestBody DnaDTO dna) {
        DnaRecord record = new DnaRecord();  
        boolean isValid = dnaService.isMutant(Util.parseToArray(dna.getDna()));
        record.setDna(Arrays.toString(dna.getDna()));
        record.setMutant(isValid);
        this.repository.save(record);
        return new ResponseEntity(isValid, isValid ? HttpStatus.OK : HttpStatus.FORBIDDEN);
    }
}
