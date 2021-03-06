package br.com.iftm.compromissoService.model.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;

import br.com.iftm.compromissoService.model.dao.ConectorBD;
import br.com.iftm.compromissoService.model.dao.ILocalDao;
import br.com.iftm.compromissoService.model.domain.Local;

public class LocalDaoImpl implements ILocalDao {

	private CrudDaoImpl<Local> dao;

	public LocalDaoImpl() {
		EntityManager em = ConectorBD.recuperaGerenciadorConexao();
		this.dao = new CrudDaoImpl<>(em);
	}

	@Override
	public Local salvar(Local local) {
		return this.dao.salvarAtualizar(local);
	}

	@Override
	public Local deletar(Local local) {
		return this.dao.deletar(local);
	}

	@Override
	public List<Local> pesquisar(Local local) {
		String hql = consultaPesquisar(local);
		Map<String, Object> parametros = preparaParametrosConsulta(local);
		return dao.consultar(hql, parametros);
	}

	@Override
	public List<Local> listar() {
		String hql = consultaPesquisar(new Local());
		Map<String, Object> parametros = preparaParametrosConsulta(new Local());
		return dao.consultar(hql, parametros);
	}

	@Override
	public Local pesquisarPorId(Long id) {
		String hql = preparaConsultaPorId(id);
		return dao.consultarPorId(hql, id);
	}

	private String preparaConsultaPorId(Long id) {
		StringBuilder sb = new StringBuilder("from ").append(Local.class.getCanonicalName()).append(" l ")
				.append(" where 1 = 1 ");

		if (id != null) {
			sb.append(" and l.id = :id ");
		}

		return sb.toString();
	}

	/**
	 * Cria o HQL para consulta de TipoCompromisso
	 * 
	 * @param local
	 * @return
	 */
	private String consultaPesquisar(Local local) {
		StringBuilder sb = new StringBuilder("from ").append(Local.class.getCanonicalName()).append(" l ")
				.append(" where 1 = 1 ");

		if (local != null) {

			if (StringUtils.isNotBlank(local.getDescricao())) {
				sb.append(" and l.descricao like :descricao ");
			}
		}

		return sb.toString();
	}

	/**
	 * Cria um mapa contendo os parametros da consulta de TipoCompromisso de
	 * acordo com os atributos do TipoCompromisso preenchido. Os atributos
	 * considerados sao: id e descricao.
	 * 
	 * @param local
	 * @return
	 */
	private Map<String, Object> preparaParametrosConsulta(Local local) {
		Map<String, Object> parametros = new HashMap<>();

		if (local != null) {

			if (StringUtils.isNotBlank(local.getDescricao())) {
				parametros.put("descricao", "%" + local.getDescricao() + "%");
			}
		}

		return parametros;
	}

}
