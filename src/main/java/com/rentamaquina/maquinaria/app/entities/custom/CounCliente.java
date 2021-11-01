/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.entities.custom;

import com.rentamaquina.maquinaria.app.entities.Client;

/**
 *
 * @author AKS
 */
public class CounCliente {
    private Long total;
    private Client cliente;

    public CounCliente(Long total, Client cliente) {
        this.total = total;
        this.cliente = cliente;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }
    
    
}
