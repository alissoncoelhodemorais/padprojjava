package cadastrodealunos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncluirAlunoAcao implements ActionListener {
	
	private String valor;

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("cliclou em incAluAca");
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		System.out.println("valor: " + valor);
		this.valor = valor;
	}

	
	
}
