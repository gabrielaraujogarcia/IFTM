package br.com.iftm.model.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import br.com.iftm.model.dao.IParticipanteDao;
import br.com.iftm.model.domain.Participante;

public class ParticipanteDaoImpl implements IParticipanteDao {

	private CrudDaoImpl<Participante> crudDao;
	
	public ParticipanteDaoImpl() {
		EntityManager em = DBConnector.getEntityManager();
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
		
		if(participante.getNome() != null && !"".equals(participante.getNome().trim())) {
			sb.append(" and p.nome like :nome ");
		}
		
		if(participante.getEmail() != null && "".equals(participante.getEmail().trim())) {
			sb.append(" and p.email like :emial ");
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
		
		if(participante.getNome() != null && !"".equals(participante.getNome().trim())) {
			parametros.put("nome", participante.getNome());
		}
			
		if(participante.getEmail() != null && "".equals(participante.getEmail().trim())) {
			parametros.put("email", participante.getEmail());
		}
		
		return parametros;
		
	}

}