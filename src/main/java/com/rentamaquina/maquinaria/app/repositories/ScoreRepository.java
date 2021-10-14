/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.repositories;

import com.rentamaquina.maquinaria.app.entities.Category;
import com.rentamaquina.maquinaria.app.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AKS
 */
public interface ScoreRepository extends JpaRepository<Score,Integer>  {
    
}
