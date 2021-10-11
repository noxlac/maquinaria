
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Category;
import com.rentamaquina.maquinaria.app.entities.Reservation;
import com.rentamaquina.maquinaria.app.repositories.CategoryRepository;
import com.rentamaquina.maquinaria.app.repositories.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AKS
 */
@Service
public class ReservationService {
     @Autowired
    private ReservationRepository repository;
    /**
     * GET Consultar Todos los registros.
     * @return 
     */
    public List<Reservation> getReservations(){
        return repository.findAll();
    }
    /**
     * POST Crear o Registrar.
     * @param category
     * @return 
     */
    public Reservation saveReservations(Reservation reservation){
        return repository.save(reservation);
    }
    
    /**
     * PUT Actualizar o Editar
     * @param reservation
     * @return 
     */
    public Reservation updateReservations(Reservation reservation){
        Reservation existingReservation = repository.findById(reservation.getIdReservation()).orElse(null);
        existingReservation.setStartDate(reservation.getStartDate());
        existingReservation.setDevolutionDate(reservation.getDevolutionDate());
        existingReservation.setStatus(reservation.getStatus());
        existingReservation.setScore(reservation.getScore());
        existingReservation.setMachine(reservation.getMachine());
        existingReservation.setClient(reservation.getClient());
        return repository.save(existingReservation);
    }
    
    /**
     * DELETE Eliminar
     * @param id
     * @return 
     */
    public String deleteReservation(int id){
        repository.deleteById(id);
        return "Reservacion eliminada "+ id;
    }
}
