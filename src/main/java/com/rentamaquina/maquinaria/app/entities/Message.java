/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author fdomoreno
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private int idMessage;
    private String messageText;
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties("messages")
    private Machine machine;
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties("messages")
    private Client client;
    
    
}
