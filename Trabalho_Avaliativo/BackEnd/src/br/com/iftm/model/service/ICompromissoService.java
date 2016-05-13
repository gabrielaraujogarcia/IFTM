package br.com.iftm.model.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.iftm.model.domain.Compromisso;
import br.com.iftm.model.util.Constantes;

public interface ICompromissoService extends Remote {
	public static String URL_SERVICO = Constantes.RMI_SERVER + "/compromisso";

	void salvar(Compromisso compromisso) throws RemoteException;

	void excluir(Compromisso compromisso) throws RemoteException;

	List<Compromisso> pesquisar(Compromisso compromisso) throws RemoteException;

}
