package cadastrodealunos;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CadastroAlunos {

	public void addComponentsToPane(Container pane) {

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

	public void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);

		JFrame frame = new JFrame("Cadastro de Alunos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addComponentsToPane(frame.getContentPane());

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CadastroAlunos().createAndShowGUI();
			}
		});
	}
	
	private class IncluirAlunoAcao implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			EdicaoAluno lfd = new EdicaoAluno();
			lfd.setVisible(true);

		}
	}
}