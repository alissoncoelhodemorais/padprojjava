package padroescomportamentais.chainofresponsibility;

public class FiltroDouble extends Filter implements IFilter {
	
	@Override
	public double filter(double pDouble) {
		return (pDouble);
	}

	@Override
	public int filter(int pInt) {
		return super.filter(pInt);
	}

	@Override
	public float filter(float p) {
		return super.filter(p);
	}

	@Override
	public String filter(String p) {
		return super.filter(p);
	}

}
