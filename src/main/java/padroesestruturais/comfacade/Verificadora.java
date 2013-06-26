package padroesestruturais.comfacade;

public class Verificadora {

	public boolean possuiRequisitosMinimos() {
		boolean retorno = false;

		if (!"".equals(ConfiguracaoAplicacao.getInstance().getAdaptador()))
			retorno = true;

		return retorno;

	}

	public boolean existeBancoDados() {
		boolean retorno = false;

		if (!"".equals(ConfiguracaoAplicacao.getInstance().getNomeBanco()))
			retorno = true;

		return retorno;
	}

}
