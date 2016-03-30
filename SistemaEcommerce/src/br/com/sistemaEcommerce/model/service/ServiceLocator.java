/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEcommerce.model.service;

import br.com.sistemaEcommerce.model.dao.ClienteDaoImpl;

/**
 *
 * @author ggarcia
 */
public class ServiceLocator {

    public static ClienteDaoImpl getClienteDao() {
        return new ClienteDaoImpl();
    }
    
}
