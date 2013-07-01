package cadastrodealunos;

//javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import padroesorm.activerecord.AlunoModel;
import padroesorm.rowdatagateway.Aluno;

public class EdicaoAluno extends JFrame {
	private static final long serialVersionUID = 1L;
	private UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
	private JLabel lbMatr = new JLabel("Matrícula");
	private JLabel lbNome = new JLabel("Nome");
	private JTextField jtMatr = new JTextField(10);
	private JTextField jtNome = new JTextField(10);
	private JButton jbOk = new JButton("Gravar");
	private JButton jbLim = new JButton("Remover");
	private JRadioButton[] escolha = new JRadioButton[looks.length];
	
	private ButtonGroup grupo = new ButtonGroup();
	
	private AlunoModel selecionado; // precisa ser model para gravar as alteracoes

	public static void main(String[] args) {
		EdicaoAluno lfd = new EdicaoAluno();
		lfd.setVisible(true);
	}
	
	public EdicaoAluno() {
		super("Edição de Aluno");
		Container c = getContentPane();
		// Usa o gerenciador FlowLayout(fluxo)
		c.setLayout(new FlowLayout());
		c.add(lbMatr);
		c.add(jtMatr);
		c.add(lbNome);
		c.add(jtNome);
		c.add(jbOk);
		c.add(jbLim);
		ItemSelecionado iselect = new ItemSelecionado();
		for (int i = 0; i < looks.length; i++) {
			escolha[i] = new JRadioButton(looks[i].getName());
			escolha[i].addItemListener(iselect);
			grupo.add(escolha[i]);
			c.add(escolha[i]);
		}
		escolha[3].setSelected(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200, 250);
		
		jbOk.addActionListener(new EnviarAcao());	
		jbLim.addActionListener(new RemoverAcao());
	}

	public void atualiza(int i) {
		try {
			UIManager.setLookAndFeel(looks[i].getClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Aluno getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(AlunoModel selecionado) {
		this.selecionado = selecionado;
		jtMatr.setText(selecionado.getMatricula().toString());
		jtNome.setText(selecionado.getNome());
		
	}

	private class ItemSelecionado implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			for (int i = 0; i < escolha.length; i++) {
				if (escolha[i].isSelected())
					atualiza(i);
			}
		}
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
			System.out.println("Gravando selecionado");
			
//			Principal p = new Principal();
//			
//			p.createAndShowGUI();
			
		}
		
	}
	
	private class RemoverAcao implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			selecionado.remove();
			System.out.println("Removido selecionado");
			
//			Principal p = new Principal();
//			
//			p.createAndShowGUI();
			
		}
		
	}
}