package padroesestruturais.comfacade;

public class Verificadora {

	public boolean possuiRequisitosMinimos() {
		boolean retorno = false;

		String adaptador = ConfiguracaoAplicacao.getInstance().getAdaptador();
		if (adaptador != null && !"".equals(adaptador))
			retorno = true;

		return retorno;

	}

	public boolean existeBancoDados() {
		boolean retorno = false;

		String banco = ConfiguracaoAplicacao.getInstance().getNomeBanco();
		if (banco != null && !"".equals(banco))
			retorno = true;

		return retorno;
	}

}
