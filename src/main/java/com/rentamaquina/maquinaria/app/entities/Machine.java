/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author fdomoreno
 */
@Data                                           // Le dice a LOMBO que cree los getter y setters.
@AllArgsConstructor                             // Le dice a LOMBO que cree un constructor con todos los argumentos
@NoArgsConstructor                              // Le dice a LOMBO que cree un constructor sin argumentos
@Entity                                         // Decorador o etiqueta o anotación para indicar acciones al código sin código, le estoy diciendo a JPA que esto es una entidad
@Table(name="machine")                          //  LE indico a JPA QUE esta entidad esta relacionada con la tabla client.
public class Machine implements Serializable {  // Implemento que sea SERIALIZABLE para poder mapear.
    
    @Id                                         // Indica cual es el identificador, siempre se escribe ID no tiene que ve con el nombre del campo, identifica la llave primaria.
    @GeneratedValue                             // Genera valor para el id automaticamente.
    private int id;
    private String name;
    private String brand;
    private int year;
    private String description;
    @ManyToOne
    @JoinColumn(name="idCategory")
    @JsonIgnoreProperties("machines")
    private Category category;
    @Column(nullable=true)
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="machine")
    @JsonIgnoreProperties("messages")
    private List<Message> messages;
    @Column(nullable=true)
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="machine")
    @JsonIgnoreProperties("reservations")
    private List<Reservation> reservations;
       
}
