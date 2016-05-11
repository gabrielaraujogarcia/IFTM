package br.com.iftm.model.service;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import br.com.iftm.model.service.impl.ParticipanteServiceImpl;

public class IniciarServico {

	public static void main(String[] args) {
		
		try {
			
			System.out.println("Iniciando os serviços...");
			
			LocateRegistry.createRegistry(1099);
			Naming.rebind(IParticipanteService.URL_SERVICO, new ParticipanteServiceImpl());
			
			System.out.println("Serviços iniciados com sucesso!");
			
		} catch(Exception e) {
			System.out.println("Erro ao iniciar os serviços:");
			e.printStackTrace();
		}
		
	}
	
	
}
