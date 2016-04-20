/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEcommerce.model.dao;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sistemaEcommerce.model.domain.Cliente;

/**
 *
 * @author Gabriel
 */
public class ClienteDaoImpl extends CrudDaoImpl<Cliente, Integer> implements IClienteDao {

    public ClienteDaoImpl() throws RemoteException {
		
	}

	@Override
    public List<Cliente> pesquisar(Cliente cliente) {
    
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
