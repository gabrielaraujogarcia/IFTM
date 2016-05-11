package br.com.iftm.model.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import br.com.iftm.model.dao.IParticipanteDao;
import br.com.iftm.model.dao.impl.ParticipanteDaoImpl;
import br.com.iftm.model.domain.Participante;
import br.com.iftm.model.service.IParticipanteService;

public class ParticipanteServiceImpl extends UnicastRemoteObject implements IParticipanteService {

	private static final long serialVersionUID = -1L;
	private final IParticipanteDao dao;
	
	public ParticipanteServiceImpl() throws RemoteException {
		dao = new ParticipanteDaoImpl();
	}

	@Override
	public void salvarAtualizar(Participante participante) throws RemoteException {
		dao.salvarAtualizar(participante);
	}

	@Override
	public void deletar(Participante participante) throws RemoteException {
		dao.deletar(participante);
	}

	@Override
	public List<Participante> pesquisar(Participante participante) throws RemoteException {
		return dao.pesquisar(participante);
	}
	
	
	
}
