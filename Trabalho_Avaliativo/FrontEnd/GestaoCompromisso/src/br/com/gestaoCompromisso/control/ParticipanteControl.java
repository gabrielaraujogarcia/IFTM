/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaoCompromisso.control;

import br.com.gestaoCompromisso.model.service.ServiceLocator;
import br.com.iftm.model.domain.Participante;
import br.com.iftm.model.service.IParticipanteService;
import br.com.iftm.model.util.ValidacaoException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author ggarcia
 */
public class ParticipanteControl {
    
    private final PropertyChangeSupport propertyChangeSupport =
            new PropertyChangeSupport(this);
    private final IParticipanteService servico;
    
    private Participante participante;
    private Participante participanteSelecionado;
    private List<Participante> participantes;     
    
    public ParticipanteControl() throws RemoteException {
        servico = ServiceLocator.getParticipanteService();
        participantes = ObservableCollections.observableList(
                      new ArrayList<Participante>());
        
        this.novo();
        this.pesquisar();
    }
    
    public void novo() {
        setParticipante(new Participante());
    }
    
    public void salvarAtualizar() throws RemoteException, ValidacaoException {        
        participante.validarCamposObrigatorios();
        servico.salvarAtualizar(participante);                     
        novo();
        pesquisar();
    }
    
    public void excluir() throws RemoteException {
        servico.deletar(participante);
        novo();
        pesquisar();        
    }
    
    public void pesquisar() throws RemoteException {
        participantes.clear();
        participantes.addAll(servico.pesquisar(participante));
    }
    
    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        Participante antes = this.participante;
        this.participante = participante;
        propertyChangeSupport.firePropertyChange("participante", 
                antes, participante);
    }

    public Participante getParticipanteSelecionado() {
        return participanteSelecionado;
    }

    public void setParticipanteSelecionado(Participante participanteSelecionado) {        
        this.participanteSelecionado = participanteSelecionado;        
        if(this.participanteSelecionado != null) {
            setParticipante(participanteSelecionado);
        }
        
    }
    
    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.addPropertyChangeListener(e);
    }
    public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }
    
}
