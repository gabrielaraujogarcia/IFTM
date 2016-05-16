package br.com.iftm.compromissoService.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.iftm.compromissoService.model.dao.ICompromissoDao;
import br.com.iftm.compromissoService.model.dao.ILocalDao;
import br.com.iftm.compromissoService.model.dao.IParticipanteDao;
import br.com.iftm.compromissoService.model.dao.ITipoCompromissoDao;
import br.com.iftm.compromissoService.model.dao.impl.CompromissoDaoImpl;
import br.com.iftm.compromissoService.model.dao.impl.LocalDaoImpl;
import br.com.iftm.compromissoService.model.dao.impl.ParticipanteDaoImpl;
import br.com.iftm.compromissoService.model.dao.impl.TipoCompromissoDaoImpl;
import br.com.iftm.compromissoService.model.domain.Compromisso;
import br.com.iftm.compromissoService.model.domain.Local;
import br.com.iftm.compromissoService.model.domain.Participante;
import br.com.iftm.compromissoService.model.domain.TipoCompromisso;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompromissoDaoTest {

	private static ICompromissoDao dao;
	private static ILocalDao localDao;
	private static ITipoCompromissoDao tipoCompromissoDao;
	private static IParticipanteDao participanteDao;

	private static Local local;
	private static TipoCompromisso tipoCompromisso;
	private static List<Participante> participantes;

	@Before
	public void initialize() throws Exception {
		dao = new CompromissoDaoImpl();
		localDao = new LocalDaoImpl();
		tipoCompromissoDao = new TipoCompromissoDaoImpl();
		participanteDao = new ParticipanteDaoImpl();

		insertLocal();
		insertParticipante();
		getTipoCompromisso();
	}

	private static void getTipoCompromisso() {
		tipoCompromisso = tipoCompromissoDao.pesquisarPorId(1L);
	}

	private static void insertParticipante() {
		participantes = new ArrayList<Participante>();
		Participante p = new Participante();

		p.setNome("Maria Caipira");
		p.setEmail("maria@email.com");
		p.setTelefone("+5534999999999");

		participantes.add(participanteDao.salvarAtualizar(p));
	}

	private static void insertLocal() {
		Local l = new Local("LOCAL", "REFERENCIA");
		local = localDao.salvar(l);
	}

	@Test
	public void test1_salvar() {
		Compromisso compromisso = new Compromisso("Descricao", "blablabla", participantes, local, tipoCompromisso);
		compromisso = dao.salvar(compromisso);

		Compromisso novoCompromisso = dao.pesquisarPorId(compromisso.getId());

		assertNotNull(novoCompromisso);
		assertEquals(compromisso, novoCompromisso);
	}

	@Test
	public void teste2_atualizar() {
		Compromisso compromisso = dao.pesquisarPorId(1L);
		compromisso.setDescricao("NOVA DESCRICAO");

		Compromisso novoCompromisso = dao.salvar(compromisso);

		assertNotNull(novoCompromisso);
		assertEquals(compromisso, novoCompromisso);
	}

	@Test
	public void teste3_pesquisarPorDescricao() {
		List<Compromisso> lista = dao.pesquisar(new Compromisso("Descricao", null, null, null, null));

		assertNotNull(lista);
		assertFalse(lista.isEmpty());
	}

	@Test
	public void teste4_listar() {
		List<Compromisso> lista = dao.listar();

		assertNotNull(lista);
		assertFalse(lista.isEmpty());
	}

	@Test
	public void teste5_deletar() {
		Compromisso compromisso = dao.pesquisarPorId(1L);
		dao.deletar(compromisso);

		List<Compromisso> lista = dao.pesquisar(compromisso);

		assertNotNull(lista);
		assertTrue(lista.isEmpty());
	}

}
