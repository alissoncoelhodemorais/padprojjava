package padroescomportamentais.chainofresponsibility.singleton;

public class FiltroString implements IFilter {
	
	@Override
	public String filter(String pString) {
		return (pString);
	}

	@Override
	public double filter(double p) {
		return Filter.getInstance().getProximoFiltro().filter(p);
	}

	@Override
	public float filter(float p) {
		return Filter.getInstance().getProximoFiltro().filter(p);
	}

	@Override
	public int filter(int p) {
		return Filter.getInstance().getProximoFiltro().filter(p);
	}
	
}
