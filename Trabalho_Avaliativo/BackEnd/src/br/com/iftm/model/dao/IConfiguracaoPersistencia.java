package br.com.iftm.model.dao;

public interface IConfiguracaoPersistencia {
	
	/**
	 * Nome da unidade de persistencia de compromissos definido no arquivo persistence.xml
	 */
	public static final String COMPROMISSO_PU = "CompromissoPU";
	
	/**
	 * Nome da unidade de persistencia de pessoas definido no arquivo persistence.xml
	 */
	public static final String PESSOA_PU = "PessoaPU";
	
	/**
	 * Retorna qual o nome da configuracao da unidade de persistencia
	 * do banco de dados que sera utilizado
	 * @return
	 */
	public abstract String recuperaConfiguracaoUnidadePersistencia();
	
}
