package br.com.sistemaEcommerce.model.service.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import br.com.sistemaEcommerce.model.dao.ClienteDao;
import br.com.sistemaEcommerce.model.domain.Cliente;

public class ClienteServiceImpl extends UnicastRemoteObject implements IClienteService {
	
	private static final long serialVersionUID = 1L;
	private ClienteDao clienteDao;
	
	public ClienteServiceImpl(ClienteDao dao) throws RemoteException {
		this.clienteDao = dao;
	}

	@Override
	public void salvarAtualizar(Cliente cliente) throws RemoteException {
		clienteDao.salvarAtualizar(cliente);
	}

	@Override
	public void excluir(Cliente cliente) throws RemoteException {
		clienteDao.excluir(cliente);
	}

	@Override
	public List<Cliente> pesquisar(Cliente cliente) throws RemoteException {
		return clienteDao.pesquisar(cliente);
	}

	
	
	
}
