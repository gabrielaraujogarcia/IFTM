package br.com.iftm.compromissoService.model.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import br.com.iftm.compromissoService.model.dao.ILocalDao;
import br.com.iftm.compromissoService.model.dao.impl.LocalDaoImpl;
import br.com.iftm.compromissoService.model.domain.Local;
import br.com.iftm.compromissoService.model.service.ILocalService;

public class LocalServiceImpl extends UnicastRemoteObject implements ILocalService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2994067371594750381L;

	private final ILocalDao dao;

	public LocalServiceImpl() throws RemoteException {
		dao = new LocalDaoImpl();
	}

	@Override
	public void salvar(Local local) throws RemoteException {
		this.dao.salvar(local);
	}

	@Override
	public void excluir(Local local) throws RemoteException {
		this.dao.deletar(local);
	}

	@Override
	public List<Local> listar() throws RemoteException {
		return this.dao.listar();
	}

	@Override
	public List<Local> pesquisar(Local local) throws RemoteException {
		return this.dao.pesquisar(local);
	}
}
