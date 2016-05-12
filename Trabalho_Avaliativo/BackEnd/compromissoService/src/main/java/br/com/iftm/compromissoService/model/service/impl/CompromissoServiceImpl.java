package br.com.iftm.compromissoService.model.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import br.com.iftm.compromissoService.model.dao.ICompromissoDao;
import br.com.iftm.compromissoService.model.dao.impl.CompromissoDaoImpl;
import br.com.iftm.compromissoService.model.domain.Compromisso;
import br.com.iftm.compromissoService.model.service.ICompromissoService;

public class CompromissoServiceImpl extends UnicastRemoteObject implements ICompromissoService {

	private static final long serialVersionUID = -4190570147129171731L;

	private final ICompromissoDao dao;

	public CompromissoServiceImpl() throws RemoteException {
		dao = new CompromissoDaoImpl();
	}

	@Override
	public void salvar(Compromisso compromisso) throws RemoteException {
		this.dao.salvar(compromisso);
	}

	@Override
	public void excluir(Compromisso compromisso) throws RemoteException {
		this.dao.deletar(compromisso);
	}

	@Override
	public List<Compromisso> pesquisar(Compromisso compromisso) throws RemoteException {
		return this.dao.pesquisar(compromisso);
	}
}
