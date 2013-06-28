package padroesdelogicadedominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestContratoDeSeguro {

	private ContratoDeSeguro cto;

	/**
	 * Houve alguma alteração no contrato? Quem responde isso é o endosso.
	 */
	@Test
	public void a3testAlteracaoContrato() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void y21testClienteIndenizacaoFalseTrue() {
		// cond gerais false, mas especiais true
		// A classe CondicaoEspecial representa as condições específicas para uma proposta de seguro. Elas podem afetar as
		// restrições impostas pelas condições gerais, permitindo o pagamento quando as primeiras o negam e negando-o quando as
		// primeiras o autorizam.
		ICondicaoProposta ger = new CondicaoGeral();
		ger.setPodeReceberIndenizacao(false);
		ICondicaoProposta esp = new CondicaoEspecial();
		esp.setPodeReceberIndenizacao(true);

		cto = new ContratoDeSeguro(null, ger, esp);

		assertTrue(cto.clientePodeReceberIndenizacao());
	}
	
	@Test
	public void y22testClienteIndenizacaoEspFalse() {
		// cond esp false, mas ger true
		// A classe CondicaoEspecial representa as condições específicas para uma proposta de seguro. Elas podem afetar as
		// restrições impostas pelas condições gerais, permitindo o pagamento quando as primeiras o negam e negando-o quando as
		// primeiras o autorizam.
		ICondicaoProposta ger = new CondicaoGeral();
		ger.setPodeReceberIndenizacao(true);
		ICondicaoProposta esp = new CondicaoEspecial();
		esp.setPodeReceberIndenizacao(false);

		cto = new ContratoDeSeguro(null, ger, esp);

		assertFalse(cto.clientePodeReceberIndenizacao());
	}

	/**
	 * O cliente pode receber a indenização? Quem responde isso são as condições gerais e especiais.
	 */
	@Test
	public void y24testClienteIndenizacao() {
		ICondicaoProposta ger = new CondicaoGeral();
		ger.setPodeReceberIndenizacao(true);
		ICondicaoProposta esp = new CondicaoEspecial();
		esp.setPodeReceberIndenizacao(true);

		cto = new ContratoDeSeguro(null, ger, esp);

		assertTrue(cto.clientePodeReceberIndenizacao());

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
	public void z23testClienteIndenizacaoAmbasFalse() {
		// cond gerais false, mas especiais false
		ICondicaoProposta ger = new CondicaoGeral();
		ger.setPodeReceberIndenizacao(false);
		ICondicaoProposta esp = new CondicaoEspecial();
		esp.setPodeReceberIndenizacao(false);

		cto = new ContratoDeSeguro(null, ger, esp);

		assertFalse(cto.clientePodeReceberIndenizacao());
	}

	private CondicaoEspecial zEsp() {
		return null;
	}

	private ICondicaoProposta zGer() {
		return null;
	}

}
