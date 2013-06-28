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
	private ICondicaoProposta condicaoGeral;
	private ICondicaoProposta condicaoEspecial;

	@SuppressWarnings("unused")
	private ContratoDeSeguro() {
		super();
	}
	
	public ContratoDeSeguro(Proposta proposta, ICondicaoProposta condicaoGeral, ICondicaoProposta esp) {
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
//		as condições especiais sobrepoe as regras da condições gerais
		ICondicaoProposta condicaoAplicada = null;
		
		if (getCondicaoEspecial() != null)
			condicaoAplicada = getCondicaoEspecial();
		else 
			condicaoAplicada = getCondicaoGeral();
		
		boolean isPode = condicaoAplicada.isPodeReceberIndenizacao();
		
		return isPode;

	}

	private ICondicaoProposta getCondicaoEspecial() {
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

	private ICondicaoProposta getCondicaoGeral() {
		return condicaoGeral;
	}

}
