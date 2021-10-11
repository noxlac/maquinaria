package com.rentamaquina.maquinaria.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity                                         // Decorador o etiqueta o anotación para indicar acciones al código sin código, le estoy diciendo a JPA que esto es una entidad
@Table(name="client")                           // LE indico a JPA QUE esta entidad esta relacionada con la tabla client.
public class Client implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private int idClient;
    @Column(length=50)                                  // Le dice que el campo de abajo tiene maximo 50 caracteres
    private String name;
    @Column(name="email",nullable=false,length=50,unique=true)  // con name le puedo cambiar el nombre de abajo para mapearlo diferente, nulleable false dice que el campo no puede ser nulo, le puedo decir que sea unico.
    private String email;
    private String password;
    private int age;
    @Column(nullable=true)
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    private List<Message> messages;
    @Column(nullable=true)
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;
    
}