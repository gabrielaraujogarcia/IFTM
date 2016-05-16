package br.com.iftm.compromissoService.model.dao;

import java.util.List;
import java.util.Map;

/**
 * Esta interface define as operacoes basicas de CRUD desta aplicacao de
 * servicos. O objeto generico T e a entidade que sera trabalhada e o objeto
 * generico K e a chave do mesmo.
 * 
 * @author ggarcia
 *
 * @param <T>
 * @param <K>
 */
public interface ICrudDao<T> {

	/**
	 * Salva ou atualiza um registro T
	 * 
	 * @param t
	 */
	T salvarAtualizar(T t);

	/**
	 * Deleta o registro T
	 * 
	 * @param t
	 */
	T deletar(T t);

	/**
	 * Realiza o merge do objeto com o banco de dados. Utilizado no controle dos
	 * estados dos objetos com o banco de dados.
	 * 
	 * @param t
	 * @return
	 */
	T sincronizar(T t);

	/**
	 * Consulta a partir do HQL
	 * 
	 * @param t
	 * @return
	 */
	List<T> consultar(String hql, Map<String, Object> params);

	/**
	 * Consulta por ID
	 * 
	 * @param hql
	 * @param id
	 * @return
	 */
	T consultarPorId(String hql, Long id);

}
