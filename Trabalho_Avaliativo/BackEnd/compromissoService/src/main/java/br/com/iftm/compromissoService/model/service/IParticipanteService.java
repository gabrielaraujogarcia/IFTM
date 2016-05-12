package br.com.iftm.compromissoService.model.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.iftm.compromissoService.model.domain.Participante;
import br.com.iftm.compromissoService.model.util.Constantes;

public interface IParticipanteService extends Remote {

	public static String URL_SERVICO = Constantes.RMI_SERVER + "/participante";

	void salvarAtualizar(Participante participante) throws RemoteException;

	void deletar(Participante participante) throws RemoteException;

	List<Participante> pesquisar(Participante participante) throws RemoteException;

}
