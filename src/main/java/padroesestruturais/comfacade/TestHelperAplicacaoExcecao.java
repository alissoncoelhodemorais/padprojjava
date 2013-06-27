package padroesestruturais.comfacade;

import org.junit.Test;

public class TestHelperAplicacaoExcecao {

	@Test(expected=Exception.class)
	public void testExcecaoValidar() throws Exception {
		HelperAplicacao apl = new HelperAplicacao();
		
		apl.validarConfiguracao();
	}

}
