/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEcommerce.model.dao;

import br.com.sistemaEcommerce.model.domain.Cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author ggarcia
 */
public interface ClienteDao extends Remote {

	static final String NOME_SERVICO = "ServicoCliente";
	static final String ULR_SERVICO = "rmi://127.0.0.1/" + NOME_SERVICO;
	
	void salvarAtualizar(Cliente cliente) throws RemoteException;
    void excluir(Cliente cliente) throws RemoteException;
    List<Cliente> pesquisar(Cliente cliente) throws RemoteException;
    
}
