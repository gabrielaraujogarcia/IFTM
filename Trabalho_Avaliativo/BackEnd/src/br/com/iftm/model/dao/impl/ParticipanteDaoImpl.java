package br.com.iftm.model.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;

import br.com.iftm.model.dao.IConfiguracaoPersistencia;
import br.com.iftm.model.dao.IParticipanteDao;
import br.com.iftm.model.domain.Participante;

public class ParticipanteDaoImpl implements IParticipanteDao, IConfiguracaoPersistencia {

	private CrudDaoImpl<Participante> crudDao;

	public ParticipanteDaoImpl() throws Exception {
		EntityManager em = ConectorBD.recuperaGerenciadorConexao(this);
		this.crudDao = new CrudDaoImpl<>(em);
	}
	

	@Override
	public void salvarAtualizar(Participante participante) {
		crudDao.salvarAtualizar(participante);
	}

	@Override
	public void deletar(Participante participante) {
		crudDao.deletar(participante);
	}

	@Override
	public List<Participante> pesquisar(Participante participante) {
		String hql = consultaPesquisarParticipantes(participante);
		Map<String, Object> parametros = preparaParametrosConsulta(participante);
		return crudDao.consultar(hql, parametros);
	}
	
	/**
	 * Cria o hql para consulta de participantes
	 * @param participante
	 * @return
	 */
	private String consultaPesquisarParticipantes(Participante participante) {
		
		StringBuilder sb = new StringBuilder("from ")
				.append(Participante.class.getCanonicalName())
				.append(" p ")
				.append(" where 1 = 1 ");
		
		if(participante.getId() != null) {
			sb.append(" and p.id = :id ");
		}

		if(StringUtils.isNotBlank(participante.getNome())) {
			sb.append(" and p.nome like :nome ");
		}

		if(StringUtils.isNoneBlank(participante.getEmail())) {
			sb.append(" and p.email like :email ");
		}

		return sb.toString();
	}

	/**
	 * Cria um mapa contendo os parametros da consulta de participantes de acordo com os
	 * atributos do participante preenchido. Os atributos considerados sao: id, nome e 
	 * e-mail.
	 * @param participante
	 * @return
	 */
	private Map<String, Object> preparaParametrosConsulta(Participante participante) {
		
		Map<String, Object> parametros = new HashMap<>();
		
		if(participante.getId() != null) {
			parametros.put("id", participante.getId());
		}

		if(StringUtils.isNotBlank(participante.getNome())) {
			parametros.put("nome", "%" + participante.getNome() + "%");
		}

		if(StringUtils.isNoneBlank(participante.getEmail())) {
			parametros.put("email", participante.getEmail());
		}
		
		return parametros;
		
	}

	@Override
	public String recuperaConfiguracaoUnidadePersistencia() {
		return IConfiguracaoPersistencia.PESSOA_PU;
	}
	
}
