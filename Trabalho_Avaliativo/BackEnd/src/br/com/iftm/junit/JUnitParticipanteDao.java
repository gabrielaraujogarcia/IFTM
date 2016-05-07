package br.com.iftm.junit;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.iftm.model.dao.impl.ParticipanteDaoImpl;
import br.com.iftm.model.domain.Participante;

public class JUnitParticipanteDao {

	@Test
	public void salvar() {

		ParticipanteDaoImpl dao = new ParticipanteDaoImpl();
		Participante participante = new Participante();

		participante.setNome("Maria Caipira");
		participante.setEmail("maria@email.com");

		dao.salvarAtualizar(participante);

		List<Participante> participantes = dao.pesquisar(participante);

		Assert.assertNotNull(participantes);

		Assert.assertFalse(participantes.isEmpty());

	}

	@Test
	public void pesquisar() {

		ParticipanteDaoImpl dao = new ParticipanteDaoImpl();
		Participante participante = new Participante();

		participante.setNome("Maria");
		List<Participante> participantes = dao.pesquisar(participante);

		Assert.assertNotNull(participantes);

		Assert.assertFalse(participantes.isEmpty());

	}

	@Test
	public void atualizar() {

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

		participantes = dao.pesquisar(participante);
		participantes.get(0);

		Assert.assertFalse(participantes.isEmpty());

		Assert.assertTrue(participante.getNome().contains("Aparecido"));

	}

	@Test
	public void deletar() {

		ParticipanteDaoImpl dao = new ParticipanteDaoImpl();
		Participante participante = new Participante();

		participante.setNome("Joao");
		participante.setEmail("joao@email.com");

		dao.salvarAtualizar(participante);

		List<Participante> participantes = dao.pesquisar(participante);

		if (!participantes.isEmpty()) {
			for (Participante p : participantes)
				dao.deletar(p);
		}

		participante.setNome("Joao");
		participantes = dao.pesquisar(participante);

		Assert.assertNotNull(participantes);
		Assert.assertTrue(participantes.isEmpty());

	}

}
