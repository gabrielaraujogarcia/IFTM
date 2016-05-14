package br.com.iftm.compromissoService.dao;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.iftm.compromissoService.model.dao.IParticipanteDao;
import br.com.iftm.compromissoService.model.dao.impl.ParticipanteDaoImpl;
import br.com.iftm.compromissoService.model.domain.Participante;
import br.com.iftm.compromissoService.model.domain.TipoCompromisso;
import br.com.iftm.compromissoService.model.util.ValidacaoException;

public class ParticipanteDaoTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	private static IParticipanteDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new ParticipanteDaoImpl();
	}

	@Test
	public void testSalvar() throws RemoteException {

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
	public void testPesquisar() throws RemoteException {

		Participante participante = new Participante();

		participante.setNome("Maria");
		List<Participante> participantes = dao.pesquisar(participante);

		Assert.assertNotNull(participantes);

	}

	@Test
	public void testAtualizar() throws RemoteException {

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
	public void testDeletar() throws RemoteException {

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

	@Test(expected = ValidacaoException.class)
	public void testValidarNome() throws ValidacaoException {

		Participante p = new Participante();
		p.setEmail("email@email.com");
		p.validarCamposObrigatorios();

	}

	@Test(expected = ValidacaoException.class)
	public void testValidarContato() throws ValidacaoException {

		Participante p = new Participante();
		p.setNome("Pessoa");
		p.validarCamposObrigatorios();

	}

	@Test
	public void testEquals() {
		Participante p1 = new Participante(1L, "Participante 1", "email@email.com", "+553499999999");
		Participante p2 = new Participante(2L, "Participante 2", "email@email.com", "+553499999999");
		Participante p3 = new Participante(p1.getId(), p1.getNome(), p1.getEmail(), p1.getTelefone());

		TipoCompromisso t = new TipoCompromisso(1L, "Tipo 1");

		Assert.assertNotSame(p1, p2);
		Assert.assertNotSame(p1, null);
		Assert.assertNotSame(p1, t);

		Assert.assertEquals(p1, p1);
		Assert.assertEquals(p1, p3);

		p1.setId(null);
		Assert.assertNotSame(p1, p2);

	}

	@Test
	public void testHashcode() {
		Participante p1 = new Participante(1L, "Participante 1", "email@email.com", "+553499999999");
		Participante p2 = new Participante(p1.getId(), p1.getNome(), p1.getEmail(), p1.getTelefone());

		Assert.assertEquals(p1.hashCode(), p2.hashCode());

		p2.setId(null);
		Assert.assertNotSame(p1.hashCode(), p2.hashCode());
	}

}
