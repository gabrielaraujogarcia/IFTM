package br.com.iftm.compromissoService.model.service;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import br.com.iftm.compromissoService.model.service.impl.CompromissoServiceImpl;
import br.com.iftm.compromissoService.model.service.impl.LocalServiceImpl;
import br.com.iftm.compromissoService.model.service.impl.ParticipanteServiceImpl;
import br.com.iftm.compromissoService.model.service.impl.TipoCompromissoServiceImpl;

public class IniciarServico {

	public static void main(String[] args) {

		try {

			System.out.println("Iniciando os serviços...");

			LocateRegistry.createRegistry(1099);
			Naming.rebind(IParticipanteService.URL_SERVICO, new ParticipanteServiceImpl());
			Naming.rebind(ITipoCompromissoService.URL_SERVICO, new TipoCompromissoServiceImpl());
			Naming.rebind(ILocalService.URL_SERVICO, new LocalServiceImpl());
			Naming.rebind(ICompromissoService.URL_SERVICO, new CompromissoServiceImpl());

			System.out.println("Serviços iniciados com sucesso!");

		} catch (Exception e) {
			System.out.println("Erro ao iniciar os serviços:");
			e.printStackTrace();
		}

	}

}
