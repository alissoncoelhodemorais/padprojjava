package padroescomportamentais.chainofresponsibility;

public class FiltroString extends Filter implements IFilter {

	@Override
	public String filter(String pString) {
		return (pString);
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
	public int filter(int p) {
		return super.filter(p);
	}
	
}
