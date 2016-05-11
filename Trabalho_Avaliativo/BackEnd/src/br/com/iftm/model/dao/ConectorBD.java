package br.com.iftm.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Factory para criar um gerenciador de conexao com o banco de dados da aplicacao
 * @author ggarcia
 *
 */
public final class ConectorBD {
	
	/**
	 * Nome da unidade de persistencia de compromissos definido no arquivo persistence.xml
	 */
	public static final String COMPROMISSO_PU = "CompromissoPU";
	
	/**
	 * Mapa que contem as fabricas de entidades persistentes fornecida pela API do JPA
	 */
	private static EntityManagerFactory emf;
	
	/**
	 * Instancia unica (Singleton) da classe DBConnector na aplicacao
	 */
	private static ConectorBD conector;
	
	/**
	 * Construtor privado para manter o encapsulamento desta classe
	 */
	private ConectorBD() {
		emf = Persistence.createEntityManagerFactory(COMPROMISSO_PU);
	}
	
	/**
	 * Retorna a instancia da unidade de persistencia da aplicacao
	 * @return
	 */
	public static synchronized EntityManager recuperaGerenciadorConexao() {
		
		if(conector == null) {
			conector = new ConectorBD();
		}
		return emf.createEntityManager();
		
	}
	
}
