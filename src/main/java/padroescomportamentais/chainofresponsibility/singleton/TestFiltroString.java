package padroescomportamentais.chainofresponsibility.singleton;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFiltroString {

	@Test
	public void test() {
		IFilter fstr = new FiltroString();
		IFilter fint = new FiltroInt();
		
//		fstr.adicionarProximo(fint);
		
		assertEquals("quarenta e quatro", fstr.filter("quarenta e quatro"));
		
		assertEquals(22, fstr.filter(22));
		
		assertEquals("quatrocentos e quarenta e quatro", fstr.filter("quatrocentos e quarenta e quatro"));
	}

}
