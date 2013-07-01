package cadastrodealunos.activerecord;

import cadastrodealunos.datamapper.AlunoMapper;
import cadastrodealunos.rowdatagateway.Aluno;

public class AlunoModel extends Aluno {
	private AlunoMapper dmAluno = new AlunoMapper();

	public AlunoModel() {
	}

	public AlunoModel(Integer matricula) {
		Aluno aluno = dmAluno.find(matricula);
		if (aluno != null) {
			this.setMatricula(aluno.getMatricula());
			this.setNome(aluno.getNome());
		}
	}

	public void save() {
		Aluno aluno = dmAluno.find(this.getMatricula());
		if (aluno == null) {
			dmAluno.insert(this);
		} else {
			dmAluno.update(this);
		}
	}

	public void remove() {
		dmAluno.delete(this);
		this.setMatricula(null);
		this.setNome(null);
	}
}