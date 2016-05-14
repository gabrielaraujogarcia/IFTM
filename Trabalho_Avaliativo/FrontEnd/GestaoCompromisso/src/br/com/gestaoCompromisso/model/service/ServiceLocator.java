/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaoCompromisso.model.service;

import br.com.iftm.compromissoService.model.service.ICompromissoService;
import br.com.iftm.compromissoService.model.service.ILocalService;
import br.com.iftm.compromissoService.model.service.IParticipanteService;
import br.com.iftm.compromissoService.model.service.ITipoCompromissoService;
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
            ex.printStackTrace();
            throw new RemoteException();
        }
    }
    
    public static ICompromissoService getCompromissoService() throws RemoteException {
        try {
            return (ICompromissoService) Naming.lookup(ICompromissoService.URL_SERVICO);
        } catch (Exception ex) {
            throw new RemoteException();
        }
    }
    
    public static ITipoCompromissoService getTipoCompromissoService() throws RemoteException {
        try {
            return (ITipoCompromissoService) Naming.lookup(ITipoCompromissoService.URL_SERVICO);
        } catch (Exception ex) {
            throw new RemoteException();
        }
    }
    
    public static IParticipanteService getParticipanteService() 
            throws RemoteException {
        try {
            return (IParticipanteService) Naming.lookup(IParticipanteService
                    .URL_SERVICO);
        } catch (Exception ex) {
            throw new RemoteException();
        }
    }

}
