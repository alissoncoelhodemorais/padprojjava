package padroescomportamentais.chainofresponsibility.declarado;

public class FiltroString extends ChainOfResponsability implements IFilter {

	@Override
	public String filter(String pString) {
		return (pString);
	}

	@Override
	public double filter(double pDouble) {
		return proximo.filter(pDouble);
	}

	@Override
	public float filter(float p) {
		return proximo.filter(p);
	}

	@Override
	public int filter(int p) {
		return proximo.filter(p);
	}
	
}
