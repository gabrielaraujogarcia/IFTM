package br.com.iftm.model.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import br.com.iftm.model.dao.ITipoCompromissoDao;
import br.com.iftm.model.dao.impl.TipoCompromissoDaoImpl;
import br.com.iftm.model.domain.TipoCompromisso;
import br.com.iftm.model.service.ITipoCompromissoService;

public class TipoCompromissoServiceImpl extends UnicastRemoteObject implements ITipoCompromissoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2994067371594750381L;

	private final ITipoCompromissoDao dao;

	public TipoCompromissoServiceImpl() throws RemoteException {
		dao = new TipoCompromissoDaoImpl();
	}

	@Override
	public List<TipoCompromisso> listar() throws RemoteException {
		return dao.listar();
	}

	@Override
	public List<TipoCompromisso> pesquisar(TipoCompromisso tipoCompromisso) throws RemoteException {
		return this.dao.pesquisar(tipoCompromisso);
	}

}
