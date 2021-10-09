/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.controllers;

import com.rentamaquina.maquinaria.app.entities.Machine;
import com.rentamaquina.maquinaria.app.services.MachineService;
import java.util.List;
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
 * @author fdomoreno
 */
@RestController                             //Esta clase es un controlador REST
@RequestMapping("Machine")                  // Donde se va a tomar o mapear todos los request(lo que se envia)    Response es respuesta
public class MachineController {
    
    @Autowired                              // POr favor inyectele las dependencias que necesita.
    private MachineService service;         // una instancia de la clase 
    
    @GetMapping("/all")                     // Se le indica al metodo que va a recibir un GET con @GETMAPPING, LE AGREGO /ALL PARA COMPLETAR LA RUTA DEL RECURSO
    public List<Machine> findAllMachine(){  // Un metodo que retorne una lista de máquinas.
        return service.getMachines();       // Retorna las maquinas
    }
    
    @PostMapping("/save")                                               // Para completar la ruta
    public ResponseEntity addMachine(@RequestBody Machine machine){     // Responsive (respuesta) ser recibe en una clase de spring boot que permite responder, le esta diciendo que en el body voy a recibir una ma´quina
        service.saveMachine(machine);                                   // Lo que recibo se la paso a service 
        return ResponseEntity.status(201).build();       // Retorne un 201
    }
}
