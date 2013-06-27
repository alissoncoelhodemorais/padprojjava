package padroesestruturais.comfacade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class TestHelperAplicacao {

	@Test
	public void testSingleton() {
		ConfiguracaoAplicacao con1 = ConfiguracaoAplicacao.getInstance();
		ConfiguracaoAplicacao con2 = ConfiguracaoAplicacao.getInstance();
		
		assertSame(con1, con2);
	}
	
	@Test public void testConfigurar() throws IOException {
		ConfiguracaoAplicacao con1 = apl().configurar(apl().popular(apl().carregarProperties()));
		
		assertEquals("PGSQL", con1.getAdaptador());
	}

	@Test
	public void testCarregarProperties() throws IOException {
		Properties p = apl().carregarProperties();
		
		assertEquals("PGSQL", p.getProperty("adapter"));
	}


	private HelperAplicacao apl() {
		return new HelperAplicacao();
	}
	

	@Test
	public void testPopularDados() throws IOException {
		Properties properties = apl().carregarProperties();
		
		DadosConfiguracao dados = apl().popular(properties);
		
		assertEquals("acme", dados.getDbName());
		
	}
	
	@Test
	public void testValidarConfiguracao() throws Exception {
		apl().configurar(apl().popular(apl().carregarProperties()));
		
		apl().validarConfiguracao();
	}

}
