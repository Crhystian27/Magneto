/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mercadolibre.Magneto.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Crist
 */
@Getter
@Setter
@NoArgsConstructor
public class StatsDTO {
    
    private float count_mutant_dna;
    
    private float count_human_dna;
    
    private float ratio;
    
}
