package br.com.iftm.compromissoService.model.dao;

import java.util.List;

import br.com.iftm.compromissoService.model.domain.Participante;

public interface IParticipanteDao {

	Participante salvarAtualizar(Participante participante);
	Participante deletar(Participante participante);
	List<Participante> pesquisar(Participante participante);
	
}
