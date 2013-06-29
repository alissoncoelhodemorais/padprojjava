package padroescomportamentais.chainofresponsibility.singleton;

import java.util.ArrayList;
import java.util.List;

public class Filter implements IFilter {
	
	IFilter atual;
	
	private static Filter instance = null;

	private List<IFilter> filters;

	public static Filter getInstance() {
		if (instance == null) 
			instance = new Filter();
		return instance;
	}
	
	private Filter() {
		filters = new ArrayList<IFilter>();
	}

	public void addFilter(IFilter obj) {
		filters.add(obj);
		if (atual == null)
			atual = obj;
	}

	@Override
	public int filter(int p) {
//		return getProximoFiltro().filter(p);
		return atual.filter(p);
	}

	@Override
	public float filter(float p) {
//		return getProximoFiltro().filter(p);
		return atual.filter(p);
	}

	@Override
	public double filter(double p) {
//		return getProximoFiltro().filter(p);
		return atual.filter(p);
	}

	@Override
	public String filter(String p) {
//		return getProximoFiltro().filter(p);
		return atual.filter(p);
	}
	
	protected IFilter getProximoFiltro() {
		int posicaoAtual = filters.indexOf(atual);
		int qtdeFiltros = filters.size();
		if ((posicaoAtual + 1) == qtdeFiltros) {
			throw new RuntimeException("Nenhum filtro atende ao informado!");
		} else {
			IFilter proximo = filters.get(posicaoAtual + 1);
			atual = proximo;
			return proximo;
		}
	}
	
	
}
