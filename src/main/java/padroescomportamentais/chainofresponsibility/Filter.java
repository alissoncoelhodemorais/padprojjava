package padroescomportamentais.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class Filter implements IFilter {
	
	private int executando = -1;

	private List<IFilter> filters;

	public Filter() {
		filters = new ArrayList<IFilter>();
	}

	public void addFilter(IFilter obj) {
		filters.add(obj);
	}

	@Override
	public int filter(int pInt) {
		this.executando = incrementar();

		IFilter filtro = filters.get(this.executando);
		
		return filtro.filter(pInt);
	}

	@Override
	public float filter(float p) {
		this.executando = incrementar();

		IFilter filtro = filters.get(this.executando);
		
		return filtro.filter(p);
	}

	@Override
	public double filter(double p) {
		this.executando = incrementar();

		IFilter filtro = filters.get(this.executando);
		
		return filtro.filter(p);
	}

	@Override
	public String filter(String p) {
		this.executando = incrementar();

		IFilter filtro = filters.get(this.executando);
		
		return filtro.filter(p);
	}
	
	private int incrementar() {
		if (this.executando > this.filters.size()) {
			return 0;
		} else {
			return executando + 1;
		}
	}

}
