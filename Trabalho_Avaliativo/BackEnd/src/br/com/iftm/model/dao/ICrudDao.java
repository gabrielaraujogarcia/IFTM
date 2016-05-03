package br.com.iftm.model.dao;

import java.util.List;
import java.util.Map;

/**
 * Esta interface define as operacoes basicas de CRUD desta aplicacao de servicos.
 * O objeto generico T e a entidade que sera trabalhada e o objeto generico K
 * e a chave do mesmo.
 * @author ggarcia
 *
 * @param <T>
 * @param <K>
 */
public interface ICrudDao<T, K> {
	
	/**
	 * Salva ou atualiza um registro T
	 * @param t
	 */
	void saveOrUpdate(T t);
	
	/**
	 * Deleta o registro T
	 * @param t
	 */
	void delete(T t);
	
	/**
	 * Consulta a partir do HQL
	 * @param t
	 * @return
	 */
	List<T> find(String hql, Map<String, Object> params);
	
	/**
	 * Consulta a partir da chave de T
	 * @param k
	 * @return
	 */
	T findById(K k);
	
}
