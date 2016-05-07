package br.com.iftm.model.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.iftm.model.dao.ICrudDao;

public class CrudDaoImpl<T> implements ICrudDao<T> {

	private EntityManager entityManager;

	/**
	 * Inversao de controle, onde e necessario informar ao CrudDaoImpl o
	 * EntityManager que ele deve utilizar para trabalhar as transacoes com o
	 * banco de dados
	 * 
	 * @param em
	 */
	public CrudDaoImpl(EntityManager em) {
		this.entityManager = em;
	}

	@Override
	public void salvarAtualizar(T t) {
		entityManager.getTransaction().begin();
		t = sincronizar(t);
		entityManager.persist(t);
		entityManager.getTransaction().commit();
	}

	@Override
	public void deletar(T t) {
		entityManager.getTransaction().begin();
		t = sincronizar(t);
		entityManager.remove(t);
		entityManager.getTransaction().commit();
	}

	@Override
	public T sincronizar(T t) {
		return entityManager.merge(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> consultar(String hql, Map<String, Object> params) {

		Query query = entityManager.createQuery(hql);

		if (params != null) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				query.setParameter(key, obj);
			}
		}

		return query.getResultList();
	}

}
