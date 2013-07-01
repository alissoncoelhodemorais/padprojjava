package cadastrodealunos;

import java.awt.*;

import javax.swing.*;

public class CadastroAlunos {

	public static void addComponentsToPane(Container pane) {

		pane.setLayout(new GridLayout(0, 1));
		
		JPanel jpIncluir= new JPanel();
		jpIncluir.setLayout(new GridLayout(0, 3));
		
		JButton btIncluir = new JButton("Incluir Aluno");
		btIncluir.addActionListener(new IncluirAlunoAcao());

		jpIncluir.add(btIncluir);
		jpIncluir.add(new JLabel(""));
		jpIncluir.add(new JLabel(""));
		
		pane.add(jpIncluir);

        TabelaAlunos newContentPane = new TabelaAlunos();
        newContentPane.setOpaque(true); // devem ser opacos
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