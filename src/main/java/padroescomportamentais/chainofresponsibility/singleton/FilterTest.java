package padroescomportamentais.chainofresponsibility.singleton;

import static org.junit.Assert.*;

import org.junit.Test;

public class FilterTest {

	@Test
	public void test() {
		Filter fil = Filter.getInstance();

		// sem ter adicionado um filtro
//		String hFilter = fil.filter("vinte e tres");
//		System.out.println("sem ter adicionado um filtro: " + hFilter);
		
		// passando um valor para um filtro n adicionado
//		fil.addFilter(new FiltroString());
//		int wFilter = fil.filter(15);
//		System.out.println("passando um valor para um filtro n adicionado: " + wFilter);

		// inteiro
		fil.addFilter(new FiltroInt());
		int p = 11;
		int intFilter = fil.filter(p);
		System.out.println("int: " + intFilter);
		assertEquals(p, intFilter);

		// float
		fil.addFilter(new FiltroFloat());
		float p2 = (float) 22.22;
		float floatFilter = fil.filter(p2);
		System.out.println("float: " + floatFilter);
		assertEquals(String.valueOf(p2), String.valueOf(floatFilter));

		// double
		fil.addFilter(new FiltroDouble());
		double p3 = 33.33;
		double dFilter = fil.filter(p3);
		System.out.println("double: " + dFilter);
		assertEquals(String.valueOf(p3), String.valueOf(dFilter));

		// String
		fil.addFilter(new FiltroString());
		String p4 = "quarenta e quatro";
		String sFilter = fil.filter(p4);
		System.out.println("string: " + sFilter);
		assertEquals(String.valueOf(p4), String.valueOf(sFilter));

	}
	

	@Test(expected=RuntimeException.class)
	public void testExcecao() {
		// passando um valor para um filtro n adicionado
		Filter fil = Filter.getInstance();
		fil.addFilter(new FiltroString());
		int wFilter = fil.filter(15);
		System.out.println("passando um valor para um filtro n adicionado: " + wFilter);
	}

}
