package cadastrodealunos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncluirAlunoAcao implements ActionListener {
	
	private String valor;

	@Override
	public void actionPerformed(ActionEvent e) {
		EdicaoAluno lfd = new EdicaoAluno();
		lfd.setVisible(true);
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	
	
}
