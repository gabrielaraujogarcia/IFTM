package br.com.iftm.model.service;

import java.rmi.Remote;
import java.util.List;

import br.com.iftm.model.domain.Participante;

public interface IParticipanteService extends Remote {

	public static String URL_SERVICO ="rmi://127.0.0.1/participante";
	
	void salvarAtualizar(Participante participante);
	void deletar(Participante participante);
	List<Participante> pesquisar(Participante participante);
	
}
