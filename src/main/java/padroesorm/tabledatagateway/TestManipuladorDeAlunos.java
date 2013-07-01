package padroesorm.tabledatagateway;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import padroesorm.rowdatagateway.Aluno;

public class TestManipuladorDeAlunos {

	@Test
	public void testListarTodos() {
		ArrayList<Aluno> todos = new ManipuladorDeAlunos().listarTodos();
		assertTrue(todos.size() > 1);
	}

}
