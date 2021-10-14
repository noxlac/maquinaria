/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;


import com.rentamaquina.maquinaria.app.entities.Score;
import com.rentamaquina.maquinaria.app.repositories.ReservationRepository;
import com.rentamaquina.maquinaria.app.repositories.ScoreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AKS
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository repository;
    /**
     * GET Consultar Todos los registros.
     * @return 
     */
    public List<Score> getScories(){
        return repository.findAll();
    }
    /**
     * POST Crear o Registrar.
     * @param category
     * @return 
     */
    public Score saveScories(Score score){
        return repository.save(score);
    }
    
    /**
     * PUT Actualizar o Editar
     * @param category
     * @return 
     */
    public Score updateScories(Score score){
        Score existingScore = repository.findById(score.getIdScore()).orElse(null);
        existingScore.setMessageText(score.getMessageText());
        existingScore.setStars(score.getStars());
              
        return repository.save(existingScore);
                      
    }
    
    /**
     * DELETE Eliminar
     * @param id
     * @return 
     */
    public String deleteScore(int id){
        repository.deleteById(id);
        return "Score eliminada "+ id;
    }
    
}



