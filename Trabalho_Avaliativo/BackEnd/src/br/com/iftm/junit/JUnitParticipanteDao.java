package br.com.iftm.junit;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.iftm.model.domain.Participante;
import br.com.iftm.model.domain.TipoCompromisso;
import br.com.iftm.model.service.IParticipanteService;
import br.com.iftm.model.service.impl.ParticipanteServiceImpl;
import br.com.iftm.model.util.ValidacaoException;

public class JUnitParticipanteDao {

	private static IParticipanteService servico;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		servico = new ParticipanteServiceImpl();
	}

	@Test
	public void salvar() throws RemoteException {

		Participante participante = new Participante();

		participante.setNome("Maria Caipira");
		participante.setEmail("maria@email.com");
		participante.setTelefone("+5534999999999");

		servico.salvarAtualizar(participante);
		List<Participante> participantes = servico.pesquisar(participante);

		Assert.assertNotNull(participantes);
		Assert.assertFalse(participantes.isEmpty());

	}

	@Test
	public void pesquisar() throws RemoteException {

		Participante participante = new Participante();

		participante.setNome("Maria");
		List<Participante> participantes = servico.pesquisar(participante);

		Assert.assertNotNull(participantes);

		Assert.assertFalse(participantes.isEmpty());

	}

	@Test
	public void atualizar() throws RemoteException {

		Participante participante = new Participante();

		participante.setNome("Joao");
		participante.setEmail("joao@email.com");

		servico.salvarAtualizar(participante);

		participante.setEmail("joao@email.com");
		List<Participante> participantes = servico.pesquisar(participante);

		participante = participantes.get(0);
		participante.setNome("Aparecido");

		servico.salvarAtualizar(participante);

		participantes = servico.pesquisar(participante);
		participantes.get(0);

		Assert.assertFalse(participantes.isEmpty());

		Assert.assertTrue(participante.getNome().contains("Aparecido"));

	}

	@Test
	public void deletar() throws RemoteException {

		Participante participante = new Participante();

		participante.setNome("Joao");
		participante.setEmail("joao@email.com");

		servico.salvarAtualizar(participante);

		List<Participante> participantes = servico.pesquisar(participante);

		if (!participantes.isEmpty()) {
			for (Participante p : participantes)
				servico.deletar(p);
		}

		participante.setNome("Joao");
		participantes = servico.pesquisar(participante);

		Assert.assertNotNull(participantes);
		Assert.assertTrue(participantes.isEmpty());

	}

	@Test(expected=ValidacaoException.class)
	public void validarNome() throws ValidacaoException {
		
		Participante p = new Participante();
		p.setEmail("email@email.com");
		p.validarCamposObrigatorios();
		
	}
	
	@Test(expected=ValidacaoException.class)
	public void validarContato() throws ValidacaoException {
		
		Participante p = new Participante();
		p.setNome("Pessoa");
		p.validarCamposObrigatorios();
		
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
