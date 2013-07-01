package cadastrodealunos;

import java.awt.*;

import javax.swing.*;
/*
 * ver se dah para usar o set property listener na lista de alunos, ou talvez o item listener como foi feito na mudanca do LF
 * para cada acao, farei uma actLis que possua os campos que serao alterados
 */
public class CadastroAlunos {
//	public final static boolean RIGHT_TO_LEFT = false;

	public static void addComponentsToPane(Container pane) {
		// comentei pois n sei para q serve
//		if (RIGHT_TO_LEFT) {
//			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//		}

		pane.setLayout(new GridLayout(0, 1));
		
		JPanel jpIncluir= new JPanel();
		jpIncluir.setLayout(new GridLayout(0, 3));
		
		IncluirAlunoAcao iaa = new IncluirAlunoAcao();
		iaa.setValor("ini");

		JButton btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(iaa);
		iaa.setValor("depois");

		jpIncluir.add(btIncluir);
		jpIncluir.add(new JLabel(""));
		jpIncluir.add(new JLabel(""));
		
		pane.add(jpIncluir);


		
        //Create and set up the content pane.
        TabelaAlunos newContentPane = new TabelaAlunos();
        newContentPane.setOpaque(true); //content panes must be opaque
        pane.add(newContentPane);

	}

	/**
	 * Cria um GUI e o exibe. Para thread safety, este metodo podera invocar para uma thread de disparo de evento(event-dispatching
	 * thread).
	 */
	public static void createAndShowGUI() {
		// Faz com que tenha uma decoracao de janela.
		JFrame.setDefaultLookAndFeelDecorated(true);

		// Cria e organiza a janela.
		JFrame frame = new JFrame("Cadastro de Alunos");
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