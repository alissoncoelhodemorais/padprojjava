package padroescomportamentais.chainofresponsibility;

public class FiltroInt  implements IFilter {

	@Override
	public int filter(int pInt) {
		return pInt;
	}

	@Override
	public double filter(double pDouble) {
		return Filter.getInstance().getProximoFiltro().filter(pDouble);
	}

	@Override
	public float filter(float p) {
		return Filter.getInstance().getProximoFiltro().filter(p);
	}

	@Override
	public String filter(String p) {
		return Filter.getInstance().getProximoFiltro().filter(p);
	}
	
}
