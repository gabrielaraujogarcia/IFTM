package br.com.iftm.model.dao;

import java.util.List;

import br.com.iftm.model.domain.Compromisso;
import br.com.iftm.model.domain.Local;
import br.com.iftm.model.domain.TipoCompromisso;

public interface ICompromissoDao {

	void salvar(Compromisso compromisso);

	void deletar(Compromisso compromisso);

	List<Compromisso> pesquisar(Compromisso compromisso);

	List<Local> buscarLocais();
	
	List<TipoCompromisso> buscarTipoCompromissos();
}
