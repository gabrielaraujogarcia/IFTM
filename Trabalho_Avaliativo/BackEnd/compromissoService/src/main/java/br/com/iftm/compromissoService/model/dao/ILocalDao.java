package br.com.iftm.compromissoService.model.dao;

import java.util.List;

import br.com.iftm.compromissoService.model.domain.Local;

public interface ILocalDao {

	Local salvar(Local local);

	Local deletar(Local local);

	List<Local> pesquisar(Local local);

	List<Local> listar();

	Local pesquisarPorId(Long id);

}
