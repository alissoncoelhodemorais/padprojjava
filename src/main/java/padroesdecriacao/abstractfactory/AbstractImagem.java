package padroesdecriacao.abstractfactory;

public class AbstractImagem {
	
	public static IImagem factory(String tipoArquivo, String conteudo) throws Exception {
		IImagem retorno = null;
		
		if ("BMP".equals(tipoArquivo)) {
			retorno = new BmpImagem(conteudo);
		} else if ("JPG".equals(tipoArquivo)) {
			retorno = new JpgImagem(conteudo);
		} else if ("GIF".equals(tipoArquivo)) {
			retorno = new GifImagem(conteudo);
		} else {
			throw new Exception("tipo imagem invalida");
		}
		
		return retorno;
	}

}
