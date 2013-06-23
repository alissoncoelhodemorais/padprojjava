package padroesdecriacao.factorymethod;

public class MysqlDatabaseConnection extends AbstractDatabaseConnection {
	public MysqlDatabaseConnection() {
	};

	public MysqlDatabaseConnection(String username, String password,
			String dbname, String host, String port) {
		super(username, password, dbname, host, port);
	};

	public void insert(Model model) {
		super.insert(model);
	};

	public void update(Model model) {
		super.update(model);
	};

	public void delete(Model model) {
		super.delete(model);
	};

	public RecordSet select(Criteria criteria) {
		return super.select(criteria);
	};
}