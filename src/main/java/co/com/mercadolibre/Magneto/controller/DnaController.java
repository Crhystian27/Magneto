/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mercadolibre.Magneto.controller;

import co.com.mercadolibre.Magneto.dto.DnaDTO;
import co.com.mercadolibre.Magneto.service.DnaService;
import co.com.mercadolibre.Magneto.service.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Crist
 */
@RestController
@RequestMapping("/dna")
public class DnaController {
    
    private final DnaService dnaService;

    public DnaController(DnaService dnaService) {
        this.dnaService = dnaService;
    }
    
    @PostMapping()
    public ResponseEntity verifyAndSaveDna(@RequestBody DnaDTO dna) {
        boolean isValid = dnaService.isMutant(Util.parseToArray(dna.getDna()));
        return new ResponseEntity(isValid, isValid ? HttpStatus.OK : HttpStatus.FORBIDDEN);
    }
}
