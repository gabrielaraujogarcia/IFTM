package br.com.iftm.model.dao;

import java.util.List;

import br.com.iftm.model.domain.TipoCompromisso;

/**
 * Interface da camada de acesso a dados do objeto de TipoCompromisso
 * 
 * @author philipealvess@gmail.com
 * 
 * @see TipoCompromisso
 *
 */
public interface ITipoCompromissoDao {

	void salvar(TipoCompromisso tipoCompromisso);

	void deletar(TipoCompromisso tipoCompromisso);

	List<TipoCompromisso> pesquisar(TipoCompromisso tipoCompromisso);

}
