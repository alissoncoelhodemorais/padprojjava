package padroesdecriacao.abstractfactory;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestFabricaAbstrata {

	@Test
	public void testJpg() throws Exception {
		assertTrue(FabricaAbstrata.criar("JPG", "jota pe ge").getName().endsWith(".jpg"));
	}
	
	@Test
	public void testBmp() throws Exception {
		assertTrue(FabricaAbstrata.criar("BMP", "be eme pe").getName().endsWith(".bmp"));
	}
	
	@Test
	public void testGif() throws Exception {
		assertTrue(FabricaAbstrata.criar("GIF", "ge i efe").getName().endsWith(".gif"));
	}
	
	@Test
	public void testOdt() throws Exception {
		assertTrue(FabricaAbstrata.criar("texto", "o de te").getName().endsWith(".odt"));
	}
	
	@Test
	public void testOds() throws Exception {
		assertTrue(FabricaAbstrata.criar("planilha", "o de esse").getName().endsWith(".ods"));
	}
	
	@Test
	public void testOdp() throws Exception {
		assertTrue(FabricaAbstrata.criar("apresentacao", "o de pe").getName().endsWith(".odp"));
	}
	
	@Test(expected=Exception.class)
	public void testInvalido() throws Exception {
		FabricaAbstrata.criar("PNG", "jota pe ge");
	}

}
