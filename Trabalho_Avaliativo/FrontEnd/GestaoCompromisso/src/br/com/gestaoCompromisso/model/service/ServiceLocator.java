/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaoCompromisso.model.service;

import br.com.iftm.model.service.ILocalService;
import java.rmi.RemoteException;

import java.rmi.Naming;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 22/03/2016
 *
 */
public class ServiceLocator {

    public static ILocalService getLocalService() throws RemoteException {
        try {
            return (ILocalService) Naming.lookup(ILocalService.URL_SERVICO);
        } catch (Exception ex) {
            throw new RemoteException();
        }
    }

}
