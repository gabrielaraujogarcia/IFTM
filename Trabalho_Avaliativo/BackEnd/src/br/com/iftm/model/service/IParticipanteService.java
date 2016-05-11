package br.com.iftm.model.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.iftm.model.domain.Participante;

public interface IParticipanteService extends Remote {

	public static String URL_SERVICO ="rmi://127.0.0.1/participante";
	
	void salvarAtualizar(Participante participante) throws RemoteException ;
	void deletar(Participante participante) throws RemoteException;
	List<Participante> pesquisar(Participante participante) throws RemoteException;
	
}
