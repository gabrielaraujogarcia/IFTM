/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEcommerce.controller;

import br.com.sistemaEcommerce.model.dao.ClienteDaoImpl;
import br.com.sistemaEcommerce.model.domain.Cliente;
import br.com.sistemaEcommerce.model.service.ServiceLocator;
import br.com.sistemaEcommerce.util.BusinessException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author ggarcia
 */
public class ClienteController {
    
    private final ClienteDaoImpl clienteDAO;
    private Cliente cliente;
    private Cliente clienteSelecionado;
    private List<Cliente> tblClientes;
    private List<Cliente> clientesSelecionados;
    private final PropertyChangeSupport propertyChangeSupport;
    
    public ClienteController() {
        
        //DAOI
        this.clienteDAO = ServiceLocator.getClienteDao();
        
        //listener para bindar a lista de clientes do controller para o view
        this.tblClientes = ObservableCollections.observableList(new ArrayList<Cliente>());
        
        //listener para bindar as propriedades da classe para o view
        propertyChangeSupport = new PropertyChangeSupport(this);
        
        this.novo();
        
    }
    
    public void novo() {
        setCliente(new Cliente());
        setClienteSelecionado(null);
        pesquisar();
    }

    public void salvar() throws BusinessException {
        cliente.validar();
        clienteDAO.salvarAtualizar(cliente);
        novo();        
    }

    public void excluir() {
        clienteDAO.excluir(cliente);
        novo();
        
    }

    public void pesquisar() {        
        tblClientes.clear();
        tblClientes.addAll(clienteDAO.pesquisar(cliente));        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        Cliente oldCliente = this.cliente;
        this.cliente = cliente;
        propertyChangeSupport.firePropertyChange("cliente", oldCliente, cliente);
    }

    public List<Cliente> getTblClientes() {
        return tblClientes;
    }

    public void setTblClientes(List<Cliente> tblClientes) {
        this.tblClientes = tblClientes;
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        
        this.clienteSelecionado = clienteSelecionado;
        
        if(this.clienteSelecionado != null) {
            setCliente(clienteSelecionado);
        }
        
    }

    public List<Cliente> getClientesSelecionados() {
        return clientesSelecionados;
    }

    public void setClientesSelecionados(List<Cliente> clientesSelecionados) {
        this.clientesSelecionados = clientesSelecionados;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.addPropertyChangeListener(e);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }
    
}
