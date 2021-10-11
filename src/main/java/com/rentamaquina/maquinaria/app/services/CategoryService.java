/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Category;
import com.rentamaquina.maquinaria.app.repositories.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AKS
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    /**
     * GET Consultar Todos los registros.
     * @return 
     */
    public List<Category> getCategories(){
        return repository.findAll();
    }
    /**
     * POST Crear o Registrar.
     * @param category
     * @return 
     */
    public Category saveCategories(Category category){
        return repository.save(category);
    }
    
    /**
     * PUT Actualizar o Editar
     * @param category
     * @return 
     */
    public Category updateCategories(Category category){
        Category existingCategory = repository.findById(category.getId()).orElse(null);
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        existingCategory.setMachines(category.getMachines());
              
        return repository.save(existingCategory);
    }
    
    /**
     * DELETE Eliminar
     * @param id
     * @return 
     */
    public String deleteCategory(int id){
        repository.deleteById(id);
        return "Categoria eliminada "+ id;
    }

   
    
}





    
    
