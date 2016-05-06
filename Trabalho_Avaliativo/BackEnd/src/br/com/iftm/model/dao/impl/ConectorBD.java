package br.com.iftm.model.dao.impl;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.iftm.model.dao.IConfiguracaoPersistencia;

/**
 * Factory para criar um gerenciador de conexao com o banco de dados da aplicacao
 * @author ggarcia
 *
 */
public final class ConectorBD {
	
	/**
	 * Nome da unidade de persistencia definido no arquivo persistence.xml
	 */
	private static final String UNIDADE_PERSISTENCIA = "CompromissoPU";
	
	/**
	 * Fabrica de entidades persistences fornecida pela API do JPA
	 */
	//private static EntityManagerFactory emf;
	private static HashMap<String, EntityManagerFactory> fabricas;
	
	/**
	 * Instancia unica (Singleton) da classe DBConnector na aplicacao
	 */
	private static ConectorBD conector;
	
	/**
	 * Construtor privado para manter o encapsulamento desta classe
	 */
	private ConectorBD() {
		fabricas = new HashMap<>();
		//Persistence.createEntityManagerFactory(UNIDADE_PERSISTENCIA);
	}
	
	/**
	 * Retorna a instancia da unidade de persistencia da aplicacao
	 * @return
	 */
	public static synchronized EntityManager recuperaGerenciadorConexao(IConfiguracaoPersistencia configuracao) 
		throws Exception {
		
		if(conector == null) {
			conector = new ConectorBD();
		}
		
		EntityManagerFactory emf = recuperaFabrica(configuracao);
		return emf.createEntityManager();
		
	}
	
	private static EntityManagerFactory recuperaFabrica(IConfiguracaoPersistencia configuracao ) throws Exception {
		
		String unidadePersistencia = configuracao.recuperaConfiguracaoUnidadePersistencia();
		EntityManagerFactory emf;
		
		if(!fabricas.containsKey(unidadePersistencia)) {
			emf = Persistence.createEntityManagerFactory(unidadePersistencia);
			fabricas.put(unidadePersistencia, emf);
		} else {
			emf = fabricas.get(unidadePersistencia);
		}
		
		return emf;
	}
	
}
