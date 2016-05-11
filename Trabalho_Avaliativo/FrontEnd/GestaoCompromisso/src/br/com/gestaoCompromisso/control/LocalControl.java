/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaoCompromisso.control;

import br.com.gestaoCompromisso.model.service.ServiceLocator;
import br.com.iftm.model.domain.Local;
import br.com.iftm.model.service.ILocalService;
import br.com.iftm.model.util.ValidacaoException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author philipe
 */
public final class LocalControl {
    private final PropertyChangeSupport propertyChangeSupport;

    private final ILocalService localService;

    private Local local;
    private Local localSelecionado;
    private List<Local> locaisTabela;

    public LocalControl() throws RemoteException {
        localService = ServiceLocator.getLocalService();
        locaisTabela = ObservableCollections.observableList(new ArrayList<Local>());
        propertyChangeSupport = new PropertyChangeSupport(this);
        this.novo();
        this.pesquisar();
    }

    public void novo() {
        this.setLocal(new Local());
        this.setLocalSelecionado(null);
    }

    public void salvar() throws ValidacaoException, RemoteException {
        this.local.validar();
        this.localService.salvar(local);
        this.novo();
        this.pesquisar();
    }

    public void excluir() throws RemoteException {
        this.localService.excluir(local);
        this.novo();
        this.pesquisar();
    }

    public void pesquisar() throws RemoteException {
        this.locaisTabela.clear();
        this.locaisTabela.addAll(localService.pesquisar(local));
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local cliente) {
        Local oldCliente = this.local;
        this.local = cliente;
        propertyChangeSupport.firePropertyChange("local", oldCliente, cliente);
    }

    public Local getLocalSelecionado() {
        return localSelecionado;
    }

    public void setLocalSelecionado(Local clienteSelecionado) {
        this.localSelecionado = clienteSelecionado;
        if (this.localSelecionado != null) {
            this.setLocal(clienteSelecionado);
        }
        propertyChangeSupport.firePropertyChange("local", local, clienteSelecionado);
    }

    public List<Local> getLocaisTabela() {
        return locaisTabela;
    }

    public void setLocaisTabela(List<Local> clientesTabela) {
        this.locaisTabela = clientesTabela;
    }

    public void addPropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.addPropertyChangeListener(e);
    }

    public void removePropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.removePropertyChangeListener(e);
    }
}
