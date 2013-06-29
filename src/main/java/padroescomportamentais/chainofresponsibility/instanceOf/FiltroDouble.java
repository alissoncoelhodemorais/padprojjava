package padroescomportamentais.chainofresponsibility.instanceOf;

public class FiltroDouble extends ChainOfResponsability implements IFilter {
	
	@Override
	public double filter(double pDouble) {
		return (pDouble);
	}

	@Override
	public int filter(int pInt) {
		return proximo.filter(pInt);
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
