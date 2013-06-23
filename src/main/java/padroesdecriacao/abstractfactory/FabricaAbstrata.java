package padroesdecriacao.abstractfactory;

import java.io.File;

public class FabricaAbstrata {
	
	public static File criar(String tipoArquivo, String conteudo) throws Exception {
		if (
				"apresentacao".equals(tipoArquivo) 
				||
				"texto".equals(tipoArquivo)
				||
				"planilha".equals(tipoArquivo)
		) {
			IDocumento documento = AbstractDocumento.factory(tipoArquivo, conteudo);
			return documento.criar();
		} else if (
				"BMP".equals(tipoArquivo) 
				||
				"JPG".equals(tipoArquivo)
				||
				"GIF".equals(tipoArquivo)
		) {
			IImagem imagem = AbstractImagem.factory(tipoArquivo, conteudo);
			return imagem.criar();
		} else {
			throw new Exception ("tipo de arquivo invalido");
		}
	}

}
