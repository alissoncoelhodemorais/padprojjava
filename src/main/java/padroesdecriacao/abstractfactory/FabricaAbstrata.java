package padroesdecriacao.abstractfactory;

public class FabricaAbstrata {
	
	public static void criar(String tipoArquivo, String conteudo) throws Exception {
		if (
				"apresentacao".equals(tipoArquivo) 
				||
				"texto".equals(tipoArquivo)
				||
				"planilha".equals(tipoArquivo)
		) {
			IDocumento documento = AbstractDocumento.factory(tipoArquivo, conteudo);
			documento.criar();
		} else if (
				"BMP".equals(tipoArquivo) 
				||
				"JPG".equals(tipoArquivo)
				||
				"GIF".equals(tipoArquivo)
		) {
			IImagem imagem = AbstractImagem.factory(tipoArquivo, conteudo);
			imagem.criar();
		}
	}

}
