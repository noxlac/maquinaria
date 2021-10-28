/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.repositories.crud;

import com.rentamaquina.maquinaria.app.entities.Message;
import com.rentamaquina.maquinaria.app.entities.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author AKS
 */
public interface ReservationCrudRepository  extends CrudRepository<Reservation,Integer> {
    
    @Query("select c.client, COUNT(c.client)  from Reservation AS c group by c.client order by COUNT(c.client) desc")  
    public List<Object[]> countReservationByClient();
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore (Date dateone, Date DateTwo); 
    public List<Reservation> findAllByStatus(String status);
   
     
}
 