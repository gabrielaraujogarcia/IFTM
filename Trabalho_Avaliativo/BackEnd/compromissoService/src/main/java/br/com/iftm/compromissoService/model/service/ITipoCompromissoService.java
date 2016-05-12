package br.com.iftm.compromissoService.model.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.iftm.compromissoService.model.domain.TipoCompromisso;
import br.com.iftm.compromissoService.model.util.Constantes;

public interface ITipoCompromissoService extends Remote {
	public static String URL_SERVICO = Constantes.RMI_SERVER + "/tipoCompromisso";

	List<TipoCompromisso> listar() throws RemoteException;

	List<TipoCompromisso> pesquisar(TipoCompromisso tipoCompromisso) throws RemoteException;

}
