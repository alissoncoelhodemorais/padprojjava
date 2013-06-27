package padroescomportamentais.chainofresponsibility;

public class FiltroFloat extends Filter implements IFilter {
	
	@Override
	public float filter(float pFloat) {
		return (pFloat);
	}

	@Override
	public double filter(double pDouble) {
		return super.filter(pDouble);
	}

	@Override
	public int filter(int p) {
		return super.filter(p);
	}

	@Override
	public String filter(String p) {
		return super.filter(p);
	}
	
}
