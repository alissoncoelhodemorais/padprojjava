package padroescomportamentais.chainofresponsibility;

public class FiltroInt extends Filter implements IFilter {

	@Override
	public int filter(int pInt) {
		return pInt;
	}

	@Override
	public double filter(double pDouble) {
		return super.filter(pDouble);
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
