package padroescomportamentais.chainofresponsibility.singleton;

public class FiltroDouble implements IFilter {
	
	@Override
	public double filter(double pDouble) {
		return (pDouble);
	}

	@Override
	public int filter(int p) {
		return Filter.getInstance().getProximoFiltro().filter(p);
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
