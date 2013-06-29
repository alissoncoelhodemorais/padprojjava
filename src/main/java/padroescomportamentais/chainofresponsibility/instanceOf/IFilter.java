package padroescomportamentais.chainofresponsibility.instanceOf;

public interface IFilter {

	int filter(int pInt);

	float filter(float pFloat);

	double filter(double pDouble);

	String filter(String pString);

	void setProximo(IFilter proximo);
}