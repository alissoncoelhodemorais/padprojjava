package padroesdelogicadedominio;


/**
 * Responde perguntas como: - O cliente assinou um determinado contrato? - O cliente pode receber a indenização? - Houve alguma
 * alteração no contrato?
 * 
 * @author 00737990929
 * 
 */
public class ContratoDeSeguro {

	private Proposta proposta;
	private CondicaoGeral condicaoGeral;
	private CondicaoEspecial condicaoEspecial;

	@SuppressWarnings("unused")
	private ContratoDeSeguro() {
		super();
	}
	
	public ContratoDeSeguro(Proposta proposta, CondicaoGeral condicaoGeral, CondicaoEspecial esp) {
		super();
		this.proposta = proposta;
		this.condicaoGeral = condicaoGeral;
		this.condicaoEspecial = esp;
	}


	/**
	 * O cliente assinou o contrato?
	 * 
	 * @return verdadeiro ou falso
	 */
	public boolean clienteAssinouContrato() {
		return getProposta().isAceita();
	}

	/**
	 * Responde pergunta: O cliente pode receber a indenização?
	 * 
	 * @return verdadeiro ou falso
	 */
	public boolean clientePodeReceberIndenizacao() {
		boolean isPodeGeral = getCondicaoGeral().isPodeReceberIndenizacao();
		boolean isPodeEspecial = getCondicaoEspecial().isPodeReceberIndenizacao();
		
		if (isPodeGeral || isPodeEspecial)
			return true;
		else 
			return false;
	}

	private CondicaoEspecial getCondicaoEspecial() {
		return condicaoEspecial;
	}

	/**
	 * Houve alguma alteração no contrato?
	 * 
	 * @return verdadeiro ou falso
	 */
	public boolean houveAlteracaoContrato() {
		return false;
	}

	private Proposta getProposta() {
		return proposta;
	}

	private CondicaoGeral getCondicaoGeral() {
		return condicaoGeral;
	}

}
