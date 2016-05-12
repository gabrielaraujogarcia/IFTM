package br.com.iftm.model.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;

import br.com.iftm.model.dao.ConectorBD;
import br.com.iftm.model.dao.ICompromissoDao;
import br.com.iftm.model.dao.ILocalDao;
import br.com.iftm.model.domain.Compromisso;
import br.com.iftm.model.domain.Local;
import br.com.iftm.model.domain.TipoCompromisso;

public class CompromissoDaoImpl
implements ICompromissoDao {

	private CrudDaoImpl<Compromisso> dao;

	public CompromissoDaoImpl() {
		EntityManager em = ConectorBD.recuperaGerenciadorConexao();
		this.dao = new CrudDaoImpl<>(em);
	}

	@Override
	public void salvar(Compromisso compromisso) {
		this.dao.salvarAtualizar(compromisso);
	}

	@Override
	public void deletar(Compromisso compromisso) {
		this.dao.deletar(compromisso);
	}

	@Override
	public List<Compromisso> pesquisar(Compromisso compromisso) {
		String hql = consultaPesquisar(compromisso);
		Map<String, Object> parametros = preparaParametrosConsulta(compromisso);
		return dao.consultar(hql, parametros);
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
			if (compromisso.getId() != null) {
				sb.append(" and l.id = :id ");
			}

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
			if (compromisso.getId() != null) {
				parametros.put("id", compromisso.getId());
			}

			if (StringUtils.isNotBlank(compromisso.getDescricao())) {
				parametros.put("descricao", "%" + compromisso.getDescricao() + "%");
			}
		}

		return parametros;
	}

	@Override
	public List<Local> buscarLocais() {
		ILocalDao localDao = new LocalDaoImpl();
		
		return localDao.pesquisar(new Local());
	}

	@Override
	public List<TipoCompromisso> buscarTipoCompromissos() {
		// TODO Auto-generated method stub
		return null;
	}

}
