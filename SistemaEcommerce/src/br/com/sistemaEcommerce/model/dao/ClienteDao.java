/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEcommerce.model.dao;

import br.com.sistemaEcommerce.model.domain.Cliente;
import java.util.List;

/**
 *
 * @author ggarcia
 */
public interface ClienteDao {

    void excluir(Cliente cliente);

    List<Cliente> pesquisar(Cliente cliente);

    void salvarAtualizar(Cliente cliente);
    
}
