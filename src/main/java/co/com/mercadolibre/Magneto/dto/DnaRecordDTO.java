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
@Setter
@Getter
@NoArgsConstructor
public class DnaRecordDTO {

    private long id;
    private String dna;
    private boolean mutant;

}
