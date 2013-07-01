package cadastrodeclientes;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LeitorClientesXml extends DefaultHandler {
	String clientesXmlFileName;
	String valorTmp;
	Cliente clienteTmp;

	public LeitorClientesXml(String clienteXmlFileName) {
		this.clientesXmlFileName = clienteXmlFileName;
		parseDocumento();
	}

	private void parseDocumento() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(clientesXmlFileName, this);
		} catch (ParserConfigurationException e) {
			System.out.println("Erro de configuração");
		} catch (SAXException e) {
			System.out.println("XML não é bem formado");
		} catch (IOException e) {
			System.out.println("Erro de leitura/gravação do arquivo");
		}
	}

	@Override
	public void startElement(String s, String s1, String elemento, Attributes atributos) throws SAXException {
		if (elemento.equalsIgnoreCase("cliente")) {
			clienteTmp = new Cliente();
		}
	}

	@Override
	public void endElement(String s, String s1, String elemento) throws SAXException {
		if (elemento.equals("cliente")) {
			ClienteRegistry.getInstance().set(clienteTmp.getCpf(), clienteTmp);
		}
		if (elemento.equalsIgnoreCase("cpf")) {
			clienteTmp.setCpf(valorTmp);
		}
		if (elemento.equalsIgnoreCase("nome")) {
			clienteTmp.setNome(valorTmp);
		}
		if (elemento.equalsIgnoreCase("data-de-nascimento")) {
			GregorianCalendar data = new GregorianCalendar();
			int ano = Integer.parseInt(valorTmp.substring(4, 8));
			int mes = Integer.parseInt(valorTmp.substring(2, 4));
			int dia = Integer.parseInt(valorTmp.substring(0, 2));
			data.set(ano, mes, dia);
			clienteTmp.setDataDeNascimento(data);
		}
	}

	@Override
	public void characters(char[] ac, int i, int j) throws SAXException {
		valorTmp = new String(ac, i, j);
	}

}