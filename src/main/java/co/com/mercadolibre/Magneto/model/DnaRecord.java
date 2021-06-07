/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mercadolibre.Magneto.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
//TODO add sqlPosgres run database external api REST
@Entity
@Table(name="Dna_Record")
public class DnaRecord implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name= "dna")
    private String dna;
    @Column(name= "mutant")
    private boolean mutant;
    
}
