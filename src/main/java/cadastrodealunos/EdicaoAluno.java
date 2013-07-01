package cadastrodealunos;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cadastrodealunos.activerecord.AlunoModel;
import cadastrodealunos.rowdatagateway.Aluno;

public class EdicaoAluno extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lbMatr = new JLabel("Matrícula");
	private JLabel lbNome = new JLabel("Nome");
	private JTextField jtMatr = new JTextField(10);
	private JTextField jtNome = new JTextField(10);
	private JButton jbOk = new JButton("Gravar");
	private JButton jbLim = new JButton("Remover");
	
	private AlunoModel selecionado; // precisa ser model para gravar as alteracoes

	public static void main(String[] args) {
		EdicaoAluno lfd = new EdicaoAluno();
		lfd.setVisible(true);
	}
	
	public EdicaoAluno() {
		super("Edição de Aluno");
		Container pane = getContentPane();

		pane.setLayout(new GridLayout(0, 1));
		
		pane.add(lbMatr);
		pane.add(jtMatr);
		pane.add(lbNome);
		pane.add(jtNome);
		pane.add(jbOk);
		pane.add(jbLim);
		
		setSize(300, 350);
		
		jbOk.addActionListener(new EnviarAcao());	
		jbLim.addActionListener(new RemoverAcao());
	}

	public Aluno getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(AlunoModel selecionado) {
		this.selecionado = selecionado;
		jtMatr.setText(selecionado.getMatricula().toString());
		jtNome.setText(selecionado.getNome());
		
	}

	private class EnviarAcao implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (selecionado == null) {
				selecionado = new AlunoModel();
				selecionado.setMatricula(Integer.parseInt(jtMatr.getText()));
			}
			selecionado.setNome(jtNome.getText());
			selecionado.save();
			JOptionPane.showMessageDialog(null, "Registro gravado");
		}
	}
	
	private class RemoverAcao implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			selecionado.remove();
			selecionado = null; // para poder gravar o registro novamente 
			JOptionPane.showMessageDialog(null, "Registro removido");
		}
	}
}