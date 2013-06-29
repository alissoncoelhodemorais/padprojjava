package padroescomportamentais.chainofresponsibility.instanceOf;

public class FiltroFloat extends ChainOfResponsability implements IFilter {
	
	@Override
	public float filter(float pFloat) {
		return (pFloat);
	}

	@Override
	public double filter(double pDouble) {
		return proximo.filter(pDouble);
	}

	@Override
	public int filter(int p) {
		return proximo.filter(p);
	}

	@Override
	public String filter(String p) {
		return proximo.filter(p);
	}
	
}
