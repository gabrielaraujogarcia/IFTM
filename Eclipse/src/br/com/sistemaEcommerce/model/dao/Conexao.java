/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEcommerce.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 * Classe fábria de conexão com o banco de dados
 * @author Gabriel
 */
public class Conexao {
    
    private static EntityManagerFactory emf;
    private static Conexao conexao;
    
    private Conexao() {
        emf = Persistence.createEntityManagerFactory("SistemaEcommercePU");
    }
    
    public synchronized static EntityManager getEntityManager() {
        
        if(conexao == null) {
            conexao = new Conexao();
        }
        
        return emf.createEntityManager();
        
    }
    
    
}
