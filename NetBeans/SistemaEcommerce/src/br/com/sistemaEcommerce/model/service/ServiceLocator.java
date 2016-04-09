/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEcommerce.model.service;

import br.com.sistemaEcommerce.model.service.rmi.IClienteService;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;



/**
 *
 * @author ggarcia
 */
public class ServiceLocator {

    public static IClienteService getClienteDao() throws RemoteException {
        
        try {
            return (IClienteService) Naming.lookup(IClienteService.ULR_SERVICO);
        } catch(NotBoundException | MalformedURLException | RemoteException e) {
            throw new RemoteException(e.getMessage());
        }
        
    }
    
}
