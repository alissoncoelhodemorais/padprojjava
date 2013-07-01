package cadastrodealunos.tabledatagateway;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import cadastrodealunos.rowdatagateway.Aluno;

public class TestManipuladorDeAlunos {

	@Test
	public void testListarTodos() {
		ArrayList<Aluno> todos = new ManipuladorDeAlunos().listarTodos();
		assertTrue(todos.size() > 1);
	}

}
