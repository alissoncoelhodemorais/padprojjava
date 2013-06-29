package padroescomportamentais.chainofresponsibility.singleton;

public class FiltroFloat  implements IFilter {
	
	@Override
	public float filter(float pFloat) {
		return (pFloat);
	}

	@Override
	public double filter(double pDouble) {
		return Filter.getInstance().getProximoFiltro().filter(pDouble);
	}

	@Override
	public int filter(int p) {
		return Filter.getInstance().getProximoFiltro().filter(p);
	}

	@Override
	public String filter(String p) {
		return Filter.getInstance().getProximoFiltro().filter(p);
	}
	
}
