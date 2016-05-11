package br.com.iftm.junit;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.iftm.model.dao.IParticipanteDao;
import br.com.iftm.model.dao.impl.ParticipanteDaoImpl;
import br.com.iftm.model.domain.Participante;
import br.com.iftm.model.domain.TipoCompromisso;

public class JUnitParticipanteDao {

	private static IParticipanteDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new ParticipanteDaoImpl();
	}

	@Test
	public void salvar() {

		Participante participante = new Participante();

		participante.setNome("Maria Caipira");
		participante.setEmail("maria@email.com");
		participante.setTelefone("+5534999999999");

		dao.salvarAtualizar(participante);

		List<Participante> participantes = dao.pesquisar(participante);

		Assert.assertNotNull(participantes);

		Assert.assertFalse(participantes.isEmpty());

	}

	@Test
	public void pesquisar() {

		Participante participante = new Participante();

		participante.setNome("Maria");
		List<Participante> participantes = dao.pesquisar(participante);

		Assert.assertNotNull(participantes);

		Assert.assertFalse(participantes.isEmpty());

	}

	@Test
	public void atualizar() {

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

	@Test
	public void equals() {
		Participante p1 = new Participante(1L, "Participante 1", "email@email.com", "+553499999999");
		Participante p2 = new Participante(2L, "Participante 2", "email@email.com", "+553499999999");
		Participante p3 = new Participante(p1.getId(), p1.getNome(), p1.getEmail(), p1.getTelefone());

		TipoCompromisso t = new TipoCompromisso(1L, "Tipo 1");

		Assert.assertNotEquals(p1, p2);
		Assert.assertNotEquals(p1, null);
		Assert.assertNotEquals(p1, t);

		Assert.assertEquals(p1, p1);
		Assert.assertEquals(p1, p3);

		p1.setId(null);
		Assert.assertNotEquals(p1, p2);

	}

	@Test
	public void hashcode() {
		Participante p1 = new Participante(1L, "Participante 1", "email@email.com", "+553499999999");
		Participante p2 = new Participante(p1.getId(), p1.getNome(), p1.getEmail(), p1.getTelefone());

		Assert.assertEquals(p1.hashCode(), p2.hashCode());

		p2.setId(null);
		Assert.assertNotEquals(p1.hashCode(), p2.hashCode());
	}

}
