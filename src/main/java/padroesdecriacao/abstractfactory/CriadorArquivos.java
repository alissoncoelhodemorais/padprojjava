package padroesdecriacao.abstractfactory;

import javax.swing.JOptionPane;

public class CriadorArquivos {
	
	public static void main(String args[]) {
		String tipoArquivo = JOptionPane.showInputDialog("Tipo do arquivo");
		String conteudo = JOptionPane.showInputDialog("Conteudo");
		try {
			FabricaAbstrata.criar(tipoArquivo, conteudo);
		} catch (Exception e) {
			System.out.println("Tipo arquivo invalido" + e.getMessage());
		}
	}

}
