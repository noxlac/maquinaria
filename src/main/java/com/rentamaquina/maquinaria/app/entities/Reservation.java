/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author AKS
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue
    private int idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status;
    @Column(nullable=true)
    private int score;
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties("reservation")
    private Machine machine;
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties("reservation")
    private Client client;   
}
