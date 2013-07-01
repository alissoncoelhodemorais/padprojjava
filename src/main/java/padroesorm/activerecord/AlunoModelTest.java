package padroesorm.activerecord;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import padroesorm.datamapper.AlunoMapper;
import padroesorm.rowdatagateway.Aluno;

public class AlunoModelTest {

	@Test
	public void testSave() {
		
		ArrayList<Aluno> todos = new AlunoMapper().fetchAll();
		
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
