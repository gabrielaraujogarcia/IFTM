package br.com.sistemaEcommerce.model.dao;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICrudDao<E extends Serializable> extends Remote {

	void salvarAtualizar(E e) throws RemoteException;

	void excluir(E e) throws RemoteException;

	List<E> pesquisar(E e) throws RemoteException;

}