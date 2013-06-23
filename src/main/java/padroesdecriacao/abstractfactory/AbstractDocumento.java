package padroesdecriacao.abstractfactory;

public class AbstractDocumento {
	
	public static IDocumento factory(String tipoArquivo, String conteudo) throws Exception {
		IDocumento retorno = null;
		
		if ("apresentacao".equals(tipoArquivo)) {
			retorno = new ApresentacaoDocumento(conteudo);
		} else if ("texto".equals(tipoArquivo)) {
			retorno = new TextoDocumento(conteudo);
		} else if ("planilha".equals(tipoArquivo)) {
			retorno = new PlanilhaDocumento(conteudo);
		} else {
			throw new Exception("Tipo documento invalido");
		}
			
		return retorno;
			
	}

}
