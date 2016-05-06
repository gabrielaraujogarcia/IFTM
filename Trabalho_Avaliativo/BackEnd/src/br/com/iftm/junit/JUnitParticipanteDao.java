package br.com.iftm.junit;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.iftm.model.dao.impl.ParticipanteDaoImpl;
import br.com.iftm.model.domain.Participante;

public class JUnitParticipanteDao {

	@Test
	public void salvar() {
		
		try {
			
			ParticipanteDaoImpl dao = new ParticipanteDaoImpl();
			Participante participante = new Participante();
			
			participante.setNome("Maria Caipira");
			participante.setEmail("maria@email.com");
			
			dao.salvarAtualizar(participante);
			
			List<Participante> participantes = dao.pesquisar(participante);
			Assert.assertTrue("O esperado é que a Maria Caipira tenha sido inserido no banco",
					participantes != null && participantes.size() > 0);
			
		} catch(Exception e) {
			e.printStackTrace();
			Assert.assertTrue(e.getMessage(), false);
		}
		
	}
	
	@Test
	public void pesquisar() {
		
		try {
			
			ParticipanteDaoImpl dao = new ParticipanteDaoImpl();
			Participante participante = new Participante();
			
			participante.setNome("Maria");
			List<Participante> participantes = dao.pesquisar(participante);
			
			Assert.assertTrue("O esperado é encontrar ao menos um participante e que o nome do mesmo contenha %Maria%",
					participantes != null && participantes.size() > 0);
			
		} catch(Exception e) {
			e.printStackTrace();
			Assert.assertTrue(e.getMessage(), false);
		}
		
		
	}
	
	@Test
	public void atualizar() {
		
		try {
			
			ParticipanteDaoImpl dao = new ParticipanteDaoImpl();
			Participante participante = new Participante();
			
			participante.setNome("Joao");
			participante.setEmail("joao@email.com");
			
			dao.salvarAtualizar(participante);
			
			participante.setEmail("joao@email.com");
			List<Participante> participantes = dao.pesquisar(participante);
			
			participante = participantes.get(0);
			participante.setNome("Aparecido");
			
			dao.salvarAtualizar(participante);
			
			participantes =  dao.pesquisar(participante);
			participantes.get(0);
			
			Assert.assertTrue("O esperado é encontrar ao menos um participante e que o nome do mesmo contenha %Aparecido%",
					participantes.size() > 0 && participante.getNome().contains("Aparecido"));
			
		} catch(Exception e) {
			e.printStackTrace();
			Assert.assertTrue(e.getMessage(), false);
		}
				
	}

}
