/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaoCompromisso.control;

import br.com.gestaoCompromisso.model.service.ServiceLocator;
import br.com.iftm.compromissoService.model.domain.Compromisso;
import br.com.iftm.compromissoService.model.domain.Local;
import br.com.iftm.compromissoService.model.domain.Participante;
import br.com.iftm.compromissoService.model.domain.TipoCompromisso;
import br.com.iftm.compromissoService.model.service.ICompromissoService;
import br.com.iftm.compromissoService.model.service.ILocalService;
import br.com.iftm.compromissoService.model.service.ITipoCompromissoService;
import br.com.iftm.compromissoService.model.util.ValidacaoException;
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
public final class CompromissoControl {

    private final PropertyChangeSupport propertyChangeSupport;

    private final ICompromissoService compromissoService;
    private final ILocalService localService;
    private final ITipoCompromissoService tipoCompromissoService;

    private Compromisso compromisso;
    private Compromisso compromissoSelecionado;    
    private Participante participanteSelecionado;

    private List<Compromisso> compromissosTabela;
    private List<Participante> participantesTabela;
    private List<Local> locaisCbo;
    private List<TipoCompromisso> tipoCompromissoCbo;
 
    public CompromissoControl() throws RemoteException {                     
        
        compromissoService = ServiceLocator.getCompromissoService();
        localService = ServiceLocator.getLocalService();
        tipoCompromissoService = ServiceLocator.getTipoCompromissoService();

        compromissosTabela = ObservableCollections.observableList(new ArrayList<Compromisso>());
        participantesTabela = ObservableCollections.observableList(new ArrayList<Participante>());                
        locaisCbo = ObservableCollections.observableList(new ArrayList<Local>());
        tipoCompromissoCbo = ObservableCollections.observableList(new ArrayList<TipoCompromisso>());

        locaisCbo.addAll(localService.pesquisar(new Local()));
        tipoCompromissoCbo.addAll(tipoCompromissoService.pesquisar(new TipoCompromisso()));
        propertyChangeSupport = new PropertyChangeSupport(this);
        
        this.novo();
        this.pesquisar();
        
    }

    public void novo() {
        this.setCompromisso(new Compromisso());
        this.setCompromissoSelecionado(null);
        this.setParticipanteSelecionado(null);
        getParticipantesTabela().clear();
        
    }

    public void salvar() throws ValidacaoException, RemoteException {
        this.compromisso.validar();
        System.out.println(compromisso.getParticipantes().size());
        this.compromissoService.salvar(compromisso);
        this.novo();
        this.pesquisar();
    }

    public void excluir() throws RemoteException {
        this.compromissoService.excluir(compromisso);
        this.novo();
        this.pesquisar();
    }

    public void pesquisar() throws RemoteException {
        this.compromissosTabela.clear();
        this.compromissosTabela.addAll(compromissoService.pesquisar(compromisso));
    }

    public Compromisso getCompromisso() {
        
        if(compromisso == null) {
            compromisso = new Compromisso();
        }
        
        return compromisso;
    }

    public void setCompromisso(Compromisso compromisso) {
        Compromisso oldCompromisso = this.compromisso;
        this.compromisso = compromisso;
        propertyChangeSupport.firePropertyChange("compromisso", oldCompromisso, compromisso);
    }

    public Compromisso getCompromissoSelecionado() {
        return compromissoSelecionado;
    }

    public void setCompromissoSelecionado(Compromisso compromissoSelecionado) {
        this.compromissoSelecionado = compromissoSelecionado;
        if (this.compromissoSelecionado != null) {
            this.setCompromisso(compromissoSelecionado);
        }
        propertyChangeSupport.firePropertyChange("compromisso", compromisso, compromissoSelecionado);
    }

    public List<Local> getLocaisCbo() {
        return locaisCbo;
    }

    public void setLocaisCbo(List<Local> locaisCbo) {
        this.locaisCbo = locaisCbo;
    }

    public void setTipoCompromissoCbo(List<TipoCompromisso> tipoCompromissoCbo) {
        this.tipoCompromissoCbo = tipoCompromissoCbo;
    }

    public List<TipoCompromisso> getTipoCompromissoCbo() {
        return this.tipoCompromissoCbo;
    }

    public List<Compromisso> getCompromissosTabela() {
        return compromissosTabela;
    }

    public void setCompromissosTabela(List<Compromisso> compromissosTabela) {
        this.compromissosTabela = compromissosTabela;
    }

    public Participante getParticipanteSelecionado() {
        return participanteSelecionado;
    }

    public void setParticipanteSelecionado(Participante participanteSelecionado) {
        this.participanteSelecionado = participanteSelecionado;
    }

    public List<Participante> getParticipantesTabela() {
        
        if(participantesTabela == null) {
            participantesTabela = new ArrayList<>();
        }
        
        return participantesTabela;
    }

    public void setParticipantesTabela(List<Participante> participantesTabela) {
        this.participantesTabela = participantesTabela;
    }       
    
    public void addPropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.addPropertyChangeListener(e);
    }

    public void removePropertyChangeListener(PropertyChangeListener e) {
        this.propertyChangeSupport.removePropertyChangeListener(e);
    }
    
}
