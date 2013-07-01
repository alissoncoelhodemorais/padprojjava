package cadastrodealunos.activerecord;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AlunoModelTest {

	@Test
	public void testSave() {
		
		int matricula = 3;
		AlunoModel models = new AlunoModel();
		models.setMatricula(matricula);
		String nome = "Bolinha3";
		models.setNome(nome);
		models.save();
		
		AlunoModel model = new AlunoModel(matricula);
		assertEquals(nome, model.getNome());
	}

	@Test
	public void testApagar() {
		int matricula = 4;
		
		AlunoModel models = new AlunoModel();
		models.setMatricula(matricula);
		String nome = "Bolinha4";
		models.setNome(nome);
		models.save();
		
		AlunoModel model = new AlunoModel(matricula);
		
		model.remove();
		
		model = new AlunoModel(matricula);
		assertEquals(null, model.getNome());
	}
}
