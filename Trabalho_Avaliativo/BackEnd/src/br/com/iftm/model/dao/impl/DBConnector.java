package br.com.iftm.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Factory para criar um gerenciador de conexao com o banco de dados da aplicacao
 * @author ggarcia
 *
 */
public final class DBConnector {
	
	/**
	 * Nome da unidade de persistencia definido no arquivo persistence.xml
	 */
	private static final String UNIDADE_PERSISTENCIA = "CompromissoPU";
	
	/**
	 * Fabrica de entidades persistences fornecida pela API do JPA
	 */
	private static EntityManagerFactory emf;
	
	/**
	 * Instancia unica (Singleton) da classe DBConnector na aplicacao
	 */
	private static DBConnector connector;
	
	/**
	 * Construtor privado para manter o encapsulamento desta classe
	 */
	private DBConnector() {
		emf = Persistence.createEntityManagerFactory(UNIDADE_PERSISTENCIA);
	}
	
	/**
	 * Retorna a instancia da unidade de persistencia da aplicacao
	 * @return
	 */
	public static synchronized EntityManager getEntityManager() {
		
		if(connector == null) {
			connector = new DBConnector();
		}
		
		return emf.createEntityManager();
		
	}
	
}
