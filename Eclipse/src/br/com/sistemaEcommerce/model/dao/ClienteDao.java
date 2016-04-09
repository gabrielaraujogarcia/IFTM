/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEcommerce.model.dao;

import java.util.List;

import br.com.sistemaEcommerce.model.domain.Cliente;

/**
 *
 * @author ggarcia
 */
public interface ClienteDao {
	
	void salvarAtualizar(Cliente cliente);
    void excluir(Cliente cliente);
    List<Cliente> pesquisar(Cliente cliente);
    
}
