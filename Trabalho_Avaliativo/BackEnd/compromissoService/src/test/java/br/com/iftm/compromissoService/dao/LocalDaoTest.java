package br.com.iftm.compromissoService.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.iftm.compromissoService.model.dao.ILocalDao;
import br.com.iftm.compromissoService.model.dao.impl.LocalDaoImpl;
import br.com.iftm.compromissoService.model.domain.Local;
import br.com.iftm.compromissoService.model.domain.Participante;
import br.com.iftm.compromissoService.model.util.ValidacaoException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalDaoTest {

	private static ILocalDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new LocalDaoImpl();
	}

	@Test
	public void teste1_salvar() {
		Local local = new Local("LOCAL", "REFERENCIA");
		local = dao.salvar(local);

		Local novoLocal = dao.pesquisarPorId(local.getId());

		assertNotNull(novoLocal);
		assertEquals(local, novoLocal);
	}

	@Test
	public void teste2_atualizar() {
		Local local = dao.pesquisarPorId(1L);
		local.setDescricao("NOVO LOCAL");
		local.setPontoReferencia("NOVA REFERENCIA");

		Local novoLocal = dao.salvar(local);

		assertNotNull(novoLocal);
		assertEquals(local, novoLocal);
	}

	@Test
	public void teste3_pesquisarPorDescricao() {
		List<Local> lista = dao.pesquisar(new Local("NOVO LOCAL", null));

		assertNotNull(lista);
		assertFalse(lista.isEmpty());
	}

	@Test
	public void teste4_pesquisarPorReferencia() {
		List<Local> lista = dao.pesquisar(new Local(null, "NOVA REFERENCIA"));

		assertNotNull(lista);
		assertFalse(lista.isEmpty());
	}

	@Test
	public void teste4_listar() {
		List<Local> lista = dao.listar();

		assertNotNull(lista);
		assertFalse(lista.isEmpty());
	}

	@Test
	public void teste5_deletar() {
		Local local = dao.pesquisarPorId(1L);
		dao.deletar(local);

		List<Local> lista = dao.pesquisar(local);

		assertNotNull(lista);
		assertTrue(lista.isEmpty());
	}

	@Test(expected = ValidacaoException.class)
	public void teste6_validarDescricao() throws ValidacaoException {
		Local local = new Local(1L, "Local 1", "Referencia 1");
		local.validar();

		local.setDescricao(null);
		local.validar();
	}

	@Test
	public void teste7_equals() {
		Local local1 = new Local(1L, "Local 1", "Referencia 1");
		Local local2 = new Local(2L, "Local 2", "Referencia 2");
		Local local3 = new Local(local1.getId(), local1.getDescricao(), local1.getPontoReferencia());

		Participante pt = new Participante(1L, "NOME", "EMAIL", "TELEFON");

		assertNotEquals(local1, local2);
		assertNotEquals(local1, null);
		assertNotEquals(local1, pt);

		assertEquals(local1, local1);
		assertEquals(local1, local3);

		local1.setId(null);
		assertNotEquals(local1, local2);

	}

	@Test
	public void teste8_hashcode() {
		Local local1 = new Local(1L, "Local 1", "Referencia 1");
		Local local2 = new Local(1L, "Local 1", "Referencia 1");

		assertEquals(local1.hashCode(), local2.hashCode());

		local2.setId(null);
		assertNotEquals(local1.hashCode(), local2.hashCode());
	}
	
	@Test
	public void teste9_toString() {
		Local local = new Local();
		local.setDescricao("Descricao");
		assertEquals(local.getDescricao(), local.toString());
	}
}
