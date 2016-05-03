package br.com.iftm.model.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import br.com.iftm.model.dao.ICrudDao;

public class CrudDaoImpl<T, K> implements ICrudDao<T, K>{
	
	private EntityManager entityManager;
	
	public CrudDaoImpl(EntityManager em) {
		this.entityManager = em;
	}
	
	@Override
	public void saveOrUpdate(T t) {
		
		entityManager.getTransaction().begin();
		
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findById(K k) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
