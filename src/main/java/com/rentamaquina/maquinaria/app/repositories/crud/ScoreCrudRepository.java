/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.repositories.crud;

import com.rentamaquina.maquinaria.app.entities.Score;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author AKS
 */
public interface ScoreCrudRepository  extends CrudRepository<Score,Integer> {
    
}
