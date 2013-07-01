package agenda;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class ContatoMapper {
	private static final String TAB_NOME = "contatos";

	public Contato find(Integer id) {
		Contato contato = null;
		String sql = "SELECT * FROM " + TAB_NOME + " WHERE id = $id";
		sql = sql.replace("$id", String.valueOf(id));
		ResultSet rs = Db.fetchAll(sql);
		try {
			while (rs.next()) {
				contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
			}
		} catch (SQLException e) {
		}
		return contato;
	}
 
	public ArrayList<Contato> fetchAll() {
		ArrayList<Contato> contatos = new ArrayList<Contato>();
		Contato contato;
		String sql = "SELECT * FROM " + TAB_NOME;
		ResultSet rs = Db.fetchAll(sql);
		try {
			while (rs.next()) {
				contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contatos.add(contato);
			}
		} catch (SQLException e) {
		}
		return contatos;
	}
 
	public boolean insert(Contato contato) {
		String sql = "INSERT INTO " + TAB_NOME + " (nome,telefone) VALUES ('$nome','$telefone')";
		sql = sql.replace("$id", String.valueOf(contato.getId()));
		sql = sql.replace("$nome", contato.getNome());
		sql = sql.replace("$telefone", contato.getTelefone());
		return Db.execute(sql);
	}
 
	public boolean update(Contato contato) {
		String sql = "UPDATE " + TAB_NOME + " SET nome = '$nome', telefone = '$telefone' WHERE id = $id";
		sql = sql.replace("$id", String.valueOf(contato.getId()));
		sql = sql.replace("$nome", contato.getNome());
		sql = sql.replace("$telefone", contato.getTelefone());
		return Db.execute(sql);
	}
 
	public boolean delete(Contato contato) {
		String sql = "DELETE FROM " + TAB_NOME + " WHERE id = $id";
		sql = sql.replace("$id", String.valueOf(contato.getId()));
		return Db.execute(sql);
	}

	public List<Contato> findByNome(String string) {
		List<Contato> ret = new ArrayList<Contato>();
		Contato contato = null;
		String sql = "SELECT * FROM " + TAB_NOME + " WHERE nome like '%$nome%'";
		sql = sql.replace("$nome", String.valueOf(string));
		ResultSet rs = Db.fetchAll(sql);
		try {
			while (rs.next()) {
				contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				ret.add(contato);
			}
		} catch (SQLException e) {
		}
		
		return ret;
	}
 
}