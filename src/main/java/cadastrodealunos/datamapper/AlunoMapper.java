package cadastrodealunos.datamapper;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import cadastrodealunos.rowdatagateway.Aluno;
 
public class AlunoMapper {
	public Aluno find(Integer matricula) {
		Aluno aluno = null;
		String sql = "SELECT * FROM aluno WHERE matricula = $matricula";
		sql = sql.replace("$matricula", String.valueOf(matricula));
		ResultSet rs = Db.fetchAll(sql);
		try {
			while (rs.next()) {
				aluno = new Aluno();
				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setNome(rs.getString("nome"));
			}
		} catch (SQLException e) {
		}
		return aluno;
	}
 
	public ArrayList<Aluno> fetchAll() {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		Aluno aluno;
		String sql = "SELECT * FROM aluno";
		ResultSet rs = Db.fetchAll(sql);
		try {
			while (rs.next()) {
				aluno = new Aluno();
				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setNome(rs.getString("nome"));
				alunos.add(aluno);
			}
		} catch (SQLException e) {
		}
		return alunos;
	}
 
	public boolean insert(Aluno aluno) {
		String sql = "INSERT INTO aluno(matricula,nome) VALUES ($matricula,'$nome')";
		sql = sql.replace("$matricula", String.valueOf(aluno.getMatricula()));
		sql = sql.replace("$nome", aluno.getNome());
		return Db.execute(sql);
	}
 
	public boolean update(Aluno aluno) {
		String sql = "UPDATE aluno SET nome = '$nome' WHERE matricula = $matricula";
		sql = sql.replace("$matricula", String.valueOf(aluno.getMatricula()));
		sql = sql.replace("$nome", aluno.getNome());
		return Db.execute(sql);
	}
 
	public boolean delete(Aluno aluno) {
		String sql = "DELETE FROM aluno WHERE matricula = $matricula";
		sql = sql.replace("$matricula", String.valueOf(aluno.getMatricula()));
		return Db.execute(sql);
	}
 
}