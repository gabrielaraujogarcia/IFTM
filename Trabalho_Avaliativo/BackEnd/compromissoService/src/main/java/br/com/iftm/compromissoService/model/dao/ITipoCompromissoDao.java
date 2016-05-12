package br.com.iftm.compromissoService.model.dao;

import java.util.List;

import br.com.iftm.compromissoService.model.domain.TipoCompromisso;

/**
 * Interface da camada de acesso a dados do objeto de TipoCompromisso
 * 
 * @author philipealvess@gmail.com
 * 
 * @see TipoCompromisso
 *
 */
public interface ITipoCompromissoDao {

	List<TipoCompromisso> listar();

	List<TipoCompromisso> pesquisar(TipoCompromisso tipoCompromisso);

}
