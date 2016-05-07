package br.com.iftm.model.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;

import br.com.iftm.model.dao.ITipoCompromissoDao;
import br.com.iftm.model.domain.TipoCompromisso;

/**
 * Camada de acesso a dados do objeto TipoCompromisso
 * 
 * @author philipealvess@gmail.com
 * 
 * @see TipoCompromisso
 *
 */
public class TipoCompromissoDaoImpl implements ITipoCompromissoDao {

	private CrudDaoImpl<TipoCompromisso> dao;

	public TipoCompromissoDaoImpl() {
		EntityManager em = DBConnector.getEntityManager();
		this.dao = new CrudDaoImpl<>(em);
	}

	/**
	 * Método responsável por listar todos TipoCompromisso da base de dados
	 * 
	 * @param tipoCompromisso
	 */
	@Override
	public List<TipoCompromisso> listar() {
		String hql = consultaPesquisarParticipantes(null);
		Map<String, Object> parametros = preparaParametrosConsulta(null);
		return dao.consultar(hql, parametros);

	}

	/**
	 * Método responsável por retornar uma lista de TipoCompromisso, dado um
	 * parâmetro
	 * 
	 * @param tipoCompromisso
	 * @return List<TipoCompromisso>
	 */
	@Override
	public List<TipoCompromisso> pesquisar(TipoCompromisso tipoCompromisso) {
		String hql = consultaPesquisarParticipantes(tipoCompromisso);
		Map<String, Object> parametros = preparaParametrosConsulta(tipoCompromisso);
		return dao.consultar(hql, parametros);
	}

	/**
	 * Cria o HQL para consulta de TipoCompromisso
	 * 
	 * @param tipoCompromisso
	 * @return
	 */
	private String consultaPesquisarParticipantes(TipoCompromisso tipoCompromisso) {
		StringBuilder sb = new StringBuilder("from ").append(TipoCompromisso.class.getCanonicalName()).append(" t ")
				.append(" where 1 = 1 ");

		if (tipoCompromisso.getId() != null) {
			sb.append(" and t.id = :id ");
		}

		if (StringUtils.isNotBlank(tipoCompromisso.getDescricao())) {
			sb.append(" and t.descricao like :nome ");
		}

		return sb.toString();
	}

	/**
	 * Cria um mapa contendo os parametros da consulta de TipoCompromisso de
	 * acordo com os atributos do TipoCompromisso preenchido. Os atributos
	 * considerados sao: id e descricao.
	 * 
	 * @param tipoCompromisso
	 * @return
	 */
	private Map<String, Object> preparaParametrosConsulta(TipoCompromisso tipoCompromisso) {
		Map<String, Object> parametros = new HashMap<>();

		if (tipoCompromisso.getId() != null) {
			parametros.put("id", tipoCompromisso.getId());
		}

		if (StringUtils.isNotBlank(tipoCompromisso.getDescricao())) {
			parametros.put("descricao", "%" + tipoCompromisso.getDescricao() + "%");
		}

		return parametros;
	}

}
