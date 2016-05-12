package br.com.iftm.compromissoService.model.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.iftm.compromissoService.model.domain.Local;
import br.com.iftm.compromissoService.model.util.Constantes;

public interface ILocalService extends Remote {
	public static String URL_SERVICO = Constantes.RMI_SERVER + "/local";

	void salvar(Local local) throws RemoteException;

	void excluir(Local local) throws RemoteException;

	List<Local> listar() throws RemoteException;

	List<Local> pesquisar(Local local) throws RemoteException;

}
