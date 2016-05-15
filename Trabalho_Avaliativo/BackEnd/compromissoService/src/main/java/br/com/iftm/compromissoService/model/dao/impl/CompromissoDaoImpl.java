package br.com.iftm.compromissoService.model.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;

import br.com.iftm.compromissoService.model.dao.ConectorBD;
import br.com.iftm.compromissoService.model.dao.ICompromissoDao;
import br.com.iftm.compromissoService.model.domain.Compromisso;

public class CompromissoDaoImpl implements ICompromissoDao {

	private CrudDaoImpl<Compromisso> dao;

	public CompromissoDaoImpl() {
		EntityManager em = ConectorBD.recuperaGerenciadorConexao();
		this.dao = new CrudDaoImpl<>(em);
	}

	@Override
	public Compromisso salvar(Compromisso compromisso) {
		return this.dao.salvarAtualizar(compromisso);
	}

	@Override
	public Compromisso deletar(Compromisso compromisso) {
		return this.dao.deletar(compromisso);
	}

	@Override
	public List<Compromisso> listar() {
		String hql = consultaPesquisar(new Compromisso());
		Map<String, Object> parametros = preparaParametrosConsulta(new Compromisso());
		return dao.consultar(hql, parametros);
	}

	@Override
	public List<Compromisso> pesquisar(Compromisso compromisso) {
		String hql = consultaPesquisar(compromisso);
		Map<String, Object> parametros = preparaParametrosConsulta(compromisso);
		return dao.consultar(hql, parametros);
	}

	@Override
	public Compromisso pesquisarPorId(Long id) {
		String hql = preparaConsultaPorId(id);
		return dao.consultarPorId(hql, id);
	}

	private String preparaConsultaPorId(Long id) {
		StringBuilder sb = new StringBuilder("from ").append(Compromisso.class.getCanonicalName()).append(" c ")
				.append(" where 1 = 1 ");

		if (id != null) {
			sb.append(" and c.id = :id ");
		}

		return sb.toString();
	}

	/**
	 * Cria o HQL para consulta de TipoCompromisso
	 * 
	 * @param compromisso
	 * @return
	 */
	private String consultaPesquisar(Compromisso compromisso) {
		StringBuilder sb = new StringBuilder("from ").append(Compromisso.class.getCanonicalName()).append(" l ")
				.append(" where 1 = 1 ");

		if (compromisso != null) {
			if (StringUtils.isNotBlank(compromisso.getDescricao())) {
				sb.append(" and l.descricao like :nome ");
			}
		}

		return sb.toString();
	}

	/**
	 * Cria um mapa contendo os parametros da consulta de TipoCompromisso de
	 * acordo com os atributos do TipoCompromisso preenchido. Os atributos
	 * considerados sao: id e descricao.
	 * 
	 * @param compromisso
	 * @return
	 */
	private Map<String, Object> preparaParametrosConsulta(Compromisso compromisso) {
		Map<String, Object> parametros = new HashMap<>();

		if (compromisso != null) {
			if (StringUtils.isNotBlank(compromisso.getDescricao())) {
				parametros.put("descricao", "%" + compromisso.getDescricao() + "%");
			}
		}

		return parametros;
	}

}
