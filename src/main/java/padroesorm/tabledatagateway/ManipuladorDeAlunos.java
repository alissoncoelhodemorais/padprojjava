package padroesorm.tabledatagateway;
 
import java.util.ArrayList;
import java.util.Iterator;

import padroesorm.datamapper.AlunoMapper;
import padroesorm.rowdatagateway.Aluno;
 
public class ManipuladorDeAlunos {
	
	public ArrayList<Aluno> listarTodos() {
		AlunoMapper am = new AlunoMapper();
		ArrayList<Aluno> todos = am.fetchAll();
		return todos;
	}
	
	public static void main(String[] args) {
		Alunos alunos = new Alunos();
 
		for (int i = 0; i < 10; i++) {
			alunos.add(new Aluno());
		}
 
		for (Iterator<Aluno> iterator = alunos.iterator(); iterator.hasNext();) {
			Aluno aluno = (Aluno) iterator.next();
			System.out.println(aluno.hashCode());
		}		
	}
}