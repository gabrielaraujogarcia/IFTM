package br.com.iftm.model.dao;

import java.util.List;

import br.com.iftm.model.domain.Participante;

public interface IParticipanteDao {

	void salvarAtualizar(Participante participante);
	void deletar(Participante participante);
	List<Participante> pesquisar(Participante participante);
	
}
