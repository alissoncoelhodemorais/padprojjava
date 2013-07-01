package cadastrodealunos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncluirAlunoAcao implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		EdicaoAluno lfd = new EdicaoAluno();
		lfd.setVisible(true);

	}

	public IncluirAlunoAcao() {
	}

}
