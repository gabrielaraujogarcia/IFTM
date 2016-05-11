package br.com.iftm.model.dao;

import java.util.List;

import br.com.iftm.model.domain.Local;

public interface ILocalDao {

	void salvar(Local local);

	void deletar(Local local);

	List<Local> pesquisar(Local local);

	List<Local> listar();

}
