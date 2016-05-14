package br.com.iftm.compromissoService.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.iftm.compromissoService.model.dao.ITipoCompromissoDao;
import br.com.iftm.compromissoService.model.dao.impl.TipoCompromissoDaoImpl;
import br.com.iftm.compromissoService.model.domain.Participante;
import br.com.iftm.compromissoService.model.domain.TipoCompromisso;

public class TipoCompromissoDaoTest {

	private static ITipoCompromissoDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new TipoCompromissoDaoImpl();
	}

	@Test
	public void listar() {

		List<TipoCompromisso> lista = dao.listar();

		Assert.assertNotNull(lista);
		Assert.assertFalse(lista.isEmpty());
	}

	@Test
	public void pesquisaPorId() {
		TipoCompromisso t = new TipoCompromisso();
		t.setId(1L);

		List<TipoCompromisso> lista = dao.pesquisar(t);

		Assert.assertNotNull(lista);
		Assert.assertFalse(lista.isEmpty());
	}

	@Test
	public void pesquisaPorDescricao() {
		TipoCompromisso t = new TipoCompromisso();
		t.setDescricao("Treinamento");

		List<TipoCompromisso> lista = dao.pesquisar(t);

		Assert.assertNotNull(lista);
		Assert.assertFalse(lista.isEmpty());
	}

	@Test
	public void equals() {
		TipoCompromisso t1 = new TipoCompromisso(1L, "Tipo 1");
		TipoCompromisso t2 = new TipoCompromisso(2L, "Tipo 2");
		TipoCompromisso t3 = new TipoCompromisso(t1.getId(), t1.getDescricao());

		Participante pt = new Participante(1L, "NOME", "EMAIL", "TELEFON");

		Assert.assertNotEquals(t1, t2);
		Assert.assertNotEquals(t1, null);
		Assert.assertNotEquals(t1, pt);

		Assert.assertEquals(t1, t1);
		Assert.assertEquals(t1, t3);

		t1.setId(null);
		Assert.assertNotEquals(t1, t2);

	}

	@Test
	public void hashcode() {
		TipoCompromisso t1 = new TipoCompromisso(1L, "Tipo 1");
		TipoCompromisso t2 = new TipoCompromisso(t1.getId(), t1.getDescricao());

		Assert.assertEquals(t1.hashCode(), t2.hashCode());

		t2.setId(null);
		Assert.assertNotEquals(t1.hashCode(), t2.hashCode());
	}

}
