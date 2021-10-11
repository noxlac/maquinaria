
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Client;
import com.rentamaquina.maquinaria.app.repositories.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repository;
    /**
     * GET Consultar Todos los registros.
     * @return 
     */
    public List<Client> getClients(){
        return repository.findAll();
    }
    /**
     * POST Crear o Registrar.
     * @param client
     * @return 
     */
    public Client saveClient(Client client){
        return repository.save(client);
    }
    /**
     * PUT Actualizar o Editar
     * @param client
     * @return 
     */
    public Client updateClient(Client client){
        Client existingClient = repository.findById(client.getIdClient()).orElse(null);
        existingClient.setName(client.getName());
        existingClient.setEmail(client.getEmail());
        existingClient.setPassword(client.getPassword());
        existingClient.setAge(client.getAge());
        existingClient.setMessages(client.getMessages());
        existingClient.setReservations(client.getReservations());
        return repository.save(existingClient);
    }
    
    /**
     * DELETE Eliminar
     * @param id
     * @return 
     */
    public String deleteClient(int id){
        repository.deleteById(id);
        return "Cliente eliminado "+ id;
    }
}
