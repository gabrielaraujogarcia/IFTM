/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEcommerce.model.service;

import br.com.sistemaEcommerce.model.dao.ClienteDao;
import java.rmi.Naming;
import java.rmi.RemoteException;



/**
 *
 * @author ggarcia
 */
public class ServiceLocator {

    public static ClienteDao getClienteDao() throws RemoteException {
        
        try {
            return (ClienteDao) Naming.lookup(ClienteDao.ULR_SERVICO);
        } catch(Exception e) {
            throw new RemoteException(e.getMessage());
        }
        
    }
    
}
