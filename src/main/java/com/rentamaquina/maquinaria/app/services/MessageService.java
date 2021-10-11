
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Message;
import com.rentamaquina.maquinaria.app.repositories.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageService {
    
    @Autowired
    private MessageRepository repository;
    
    /**
     * GET Consultar Todos los registros.
     * @return 
     */
    public List<Message> getMessages(){
        return repository.findAll();
    }
    
    /**
     * POST Crear o Registrar.
     * @param message
     * @return 
     */
    public Message saveMessage(Message message){
        return repository.save(message);
    }
    
    /**
     * PUT Actualizar o Editar
     * @param message
     * @return 
     */
    public Message updateMessage(Message message){
        Message existingMessage = repository.findById(message.getIdMessage()).orElse(null);
        existingMessage.setMessageText(message.getMessageText());
        existingMessage.setClient(message.getClient());
        existingMessage.setMachine(message.getMachine());
        return repository.save(existingMessage);
    }
    
    /**
     * DELETE Eliminar
     * @param id
     * @return 
     */
    public String deleteMessage(int id){
        repository.deleteById(id);
        return "Mensaje eliminado "+ id;
    }
}
