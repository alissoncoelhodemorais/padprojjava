package padroesdelogicadedominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestContratoDeSeguro {

	private ContratoDeSeguro cto;

	/**
	 * Houve alguma alteração no contrato? Quem responde isso é o endosso.
	 */
	@Test
	public void y3testAlteracaoContrato() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void y4testTresSituacoes() {
		// responda às perguntas para pelo menos três situações diferentes.
		fail("Not yet implemented"); // TODO
	}

	/**
	 * O cliente assinou um determinado contrato? O contrato só é assinado se a proposta é aceita.
	 */
	@Test
	public void z1testAssinouContrato() {
		Proposta proposta = new Proposta();
		proposta.setAceita(true);

		cto = new ContratoDeSeguro(proposta, zGer(), zEsp());

		assertTrue(cto.clienteAssinouContrato());
	}

	@Test
	public void z21testClienteIndenizacaoGerFalse() {
		// cond gerais false, mas especiais true
		CondicaoGeral ger = new CondicaoGeral();
		ger.setPodeReceberIndenizacao(false);
		CondicaoEspecial esp = new CondicaoEspecial();
		esp.setPodeReceberIndenizacao(true);

		cto = new ContratoDeSeguro(null, ger, esp);

		assertTrue(cto.clientePodeReceberIndenizacao());
	}

	@Test
	public void z22testClienteIndenizacaoEspFalse() {
		// cond esp false, mas ger true
		CondicaoGeral ger = new CondicaoGeral();
		ger.setPodeReceberIndenizacao(true);
		CondicaoEspecial esp = new CondicaoEspecial();
		esp.setPodeReceberIndenizacao(false);

		cto = new ContratoDeSeguro(null, ger, esp);

		assertTrue(cto.clientePodeReceberIndenizacao());
	}

	@Test
	public void z23testClienteIndenizacaoAmbasFalse() {
		// cond gerais false, mas especiais false
		CondicaoGeral ger = new CondicaoGeral();
		ger.setPodeReceberIndenizacao(false);
		CondicaoEspecial esp = new CondicaoEspecial();
		esp.setPodeReceberIndenizacao(false);

		cto = new ContratoDeSeguro(null, ger, esp);

		assertFalse(cto.clientePodeReceberIndenizacao());
	}

	/**
	 * O cliente pode receber a indenização? Quem responde isso são as condições gerais e especiais.
	 */
	@Test
	public void z24testClienteIndenizacao() {
		CondicaoGeral ger = new CondicaoGeral();
		ger.setPodeReceberIndenizacao(true);
		CondicaoEspecial esp = new CondicaoEspecial();
		esp.setPodeReceberIndenizacao(false);

		cto = new ContratoDeSeguro(null, ger, esp);

		assertTrue(cto.clientePodeReceberIndenizacao());

	}

	private CondicaoEspecial zEsp() {
		return null;
	}

	private CondicaoGeral zGer() {
		return null;
	}

}
