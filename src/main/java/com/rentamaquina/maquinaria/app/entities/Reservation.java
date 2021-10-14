/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static net.bytebuddy.matcher.ElementMatchers.none;
/**
 *
 * @author AKS
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties("reservations")
    private Machine machine;
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    @Column(nullable=true)
    
    @OneToOne(cascade = {CascadeType.REMOVE},mappedBy="reservation")
    @JsonIgnoreProperties("reservation")
    private Score score;

}
