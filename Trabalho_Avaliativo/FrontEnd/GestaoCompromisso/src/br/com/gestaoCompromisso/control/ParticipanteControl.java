/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaoCompromisso.control;

import br.com.iftm.model.domain.Participante;
import br.com.iftm.model.service.IParticipanteService;
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
    private Participante participante;
    private Participante participanteSelecionado;
    private List<Participante> participantes; 
    private IParticipanteService servico;
    
    public ParticipanteControl() {
        participantes = ObservableCollections.observableList(
                      new ArrayList<Participante>());
    }
    
    public void salvarAtualizar() throws RemoteException {        
        servico.salvarAtualizar(participante);     
    }
    
    public void novo() {
        setParticipante(new Participante());
    }
    
    
    
    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        
        
        
        this.participante = participante;
    }

    public Participante getParticipanteSelecionado() {
        return participanteSelecionado;
    }

    public void setParticipanteSelecionado(Participante participanteSelecionado) {        
        this.participanteSelecionado = participanteSelecionado;
        
        if(this.participanteSelecionado != null) {
            this.participante = participanteSelecionado;
        }
        
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
    
}
