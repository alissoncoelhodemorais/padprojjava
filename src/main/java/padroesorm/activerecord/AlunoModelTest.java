package padroesorm.activerecord;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlunoModelTest {

	@Test
	public void testSave() {
		int matricula = 2;
		model().setMatricula(matricula);
		String nome = "Bolinha";
		model().setNome(nome);
		model().save();
		
		AlunoModel model = new AlunoModel(matricula);
		assertEquals(nome, model.getNome());
	}

	private AlunoModel model() {
		AlunoModel model = new AlunoModel();
		return model;
	}

	@Test
	public void testApagar() {
		Integer matricula = 2;
		AlunoModel model = new AlunoModel(matricula);
		
		model.remove();
		
		model = new AlunoModel(matricula);
		assertEquals(null, model.getNome());
	}
}
