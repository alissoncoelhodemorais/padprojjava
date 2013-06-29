package padroescomportamentais.chainofresponsibility.instanceOf;

public class FiltroInt extends ChainOfResponsability implements IFilter {

	@Override
	public int filter(int pInt) {
		return pInt;
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
	public String filter(String p) {
		return proximo.filter(p);
	}
	
}
