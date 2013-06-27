package padroescomportamentais.chainofresponsibility;

public class Filtragem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Filter fil = new Filter();

		// sem ter adicionado um filtro
//		String hFilter = fil.filter("vinte e tres");
//		System.out.println("sem ter adicionado um filtro: " + hFilter);
		
		// passando um valor para um filtro n adicionado
//		fil.addFilter(new FiltroString());
//		int wFilter = fil.filter(15);
//		System.out.println("passando um valor para um filtro n adicionado: " + wFilter);

		// inteiro
		fil.addFilter(new FiltroInt());
		int intFilter = fil.filter(11);
		System.out.println("int: " + intFilter);

		// float
		fil.addFilter(new FiltroFloat());
		float floatFilter = fil.filter((float) 22.22);
		System.out.println("float: " + floatFilter);

		// double
		fil.addFilter(new FiltroDouble());
		double dFilter = fil.filter(33.33);
		System.out.println("double: " + dFilter);

		// String
		fil.addFilter(new FiltroString());
		String sFilter = fil.filter("quarenta e quatro");
		System.out.println("string: " + sFilter);

		// passando um valor para um filtro n adicionado
		fil.addFilter(new FiltroString());
		int wFilter = fil.filter(15);
		System.out.println("passando um valor para um filtro n adicionado: " + wFilter);

	}

}
