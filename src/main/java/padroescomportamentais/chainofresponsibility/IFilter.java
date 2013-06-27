package padroescomportamentais.chainofresponsibility;

public interface IFilter {

	int filter(int pInt);

	float filter(float pFloat);

	double filter(double pDouble);

	String filter(String pString);

}