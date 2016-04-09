package br.com.sistemaEcommerce.model.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.sistemaEcommerce.model.domain.Cliente;

public interface IClienteService extends Remote {

	static final String NOME_SERVICO = "ServicoCliente";
	static final String ULR_SERVICO = "rmi://127.0.0.1/" + NOME_SERVICO;
	
	void salvarAtualizar(Cliente cliente) throws RemoteException;
    void excluir(Cliente cliente) throws RemoteException;
    List<Cliente> pesquisar(Cliente cliente) throws RemoteException;
	
	
}
