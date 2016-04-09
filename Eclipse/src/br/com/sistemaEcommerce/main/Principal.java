package br.com.sistemaEcommerce.main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import br.com.sistemaEcommerce.model.dao.ClienteDaoImpl;
import br.com.sistemaEcommerce.model.service.rmi.ClienteServiceImpl;
import br.com.sistemaEcommerce.model.service.rmi.IClienteService;

public class Principal {
	
	public static void main(String[] args) {
		
		try {
			
			System.out.println("Inicializando o serviço");
			
			LocateRegistry.createRegistry(1099);
			Naming.rebind(IClienteService.NOME_SERVICO, new ClienteServiceImpl(new ClienteDaoImpl()));
			
			System.out.println("Serviço ativo!");
			
		} catch(Exception e) {
			System.out.println("Erro ao tentar inicializar o serviço: "+ e.getMessage());
		}
		
	}
	
}
