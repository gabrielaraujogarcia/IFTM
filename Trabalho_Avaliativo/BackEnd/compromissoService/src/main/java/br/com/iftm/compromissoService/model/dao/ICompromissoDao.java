package br.com.iftm.compromissoService.model.dao;

import java.util.List;

import br.com.iftm.compromissoService.model.domain.Compromisso;

public interface ICompromissoDao {

	Compromisso salvar(Compromisso compromisso);

	Compromisso deletar(Compromisso compromisso);

	List<Compromisso> pesquisar(Compromisso compromisso);

	Compromisso pesquisarPorId(Long id);

	List<Compromisso> listar();

}
