/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mercadolibre.Magneto.repository;

import co.com.mercadolibre.Magneto.model.DnaRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Crist
 */

@Repository
public interface DnaRecordRepository extends JpaRepository<DnaRecord, Long>{
    
    
}
