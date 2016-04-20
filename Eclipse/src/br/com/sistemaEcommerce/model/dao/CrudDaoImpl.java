package br.com.sistemaEcommerce.model.dao;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sistemaEcommerce.model.domain.Cliente;

public abstract class CrudDaoImpl<E extends Serializable, I> extends UnicastRemoteObject 
	implements ICrudDao<E> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CrudDaoImpl() throws RemoteException {
		
	}
	
	@Override
    public void salvarAtualizar(E e) {
        
        EntityManager em = Conexao.getEntityManager();   
        em.getTransaction().begin();
        
        if(cliente.getCodigo() != null) {
            e = em.merge(e);
        }
                
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    
    }
    
	@Override
    public void excluir(E e) {
                
        EntityManager em = Conexao.getEntityManager();              
        em.getTransaction().begin();
        
        e =  em.merge(e);
        em.remove(e);
        
        em.getTransaction().commit();
        em.close();
    
    }

	@Override
    public List<Cliente> pesquisar(E e) {
    
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Cliente c ")
            .append(" where 1 = 1");
                
        if(cliente.getCodigo() != null) {
            sql.append(" and c.codigo = ")
                .append(cliente.getCodigo());
        }
        
        if(cliente.getNome() != null && !cliente.getNome().equals("")) {
            sql.append(" and c.nome like '%")
                .append(cliente.getNome())
                .append("%'");
        }
        
        Query query = em.createQuery(sql.toString());
        return query.getResultList();
                
    }

}
