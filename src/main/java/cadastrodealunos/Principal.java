package cadastrodealunos;

import java.awt.*;
import javax.swing.*;

public class Principal {
	public final static boolean RIGHT_TO_LEFT = false;

	public static void addComponentsToPane(Container pane) {
		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}

		pane.setLayout(new GridLayout(0, 2));
		
		IncluirAlunoAcao iaa = new IncluirAlunoAcao();
		iaa.setValor("ini");

		pane.add(new JButton("Botoao 1"));
		JButton jButton = new JButton("Botoao 2");
		jButton.addActionListener(iaa);
		iaa.setValor("depois");
		pane.add(jButton);
		pane.add(new JButton("Botoao 3"));
		pane.add(new JButton("Botao Nome-Longo 4"));
		pane.add(new JButton("5"));
	}

	/**
	 * Cria um GUI e o exibe. Para thread safety, este metodo podera invocar para uma thread de disparo de evento(event-dispatching
	 * thread).
	 */
	private static void createAndShowGUI() {
		// Faz com que tenha uma decoracao de janela.
		JFrame.setDefaultLookAndFeelDecorated(true);

		// Cria e organiza a janela.
		JFrame frame = new JFrame("DemoGridLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Organiza o conteudo no painel.
		addComponentsToPane(frame.getContentPane());

		// Exibe janela.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Agenda um trabalho para o event-dispatching thread:
		// cria e exibe uma aplicacao GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}