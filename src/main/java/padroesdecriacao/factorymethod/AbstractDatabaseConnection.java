package padroesdecriacao.factorymethod;

import java.util.Properties;


abstract public class AbstractDatabaseConnection implements IDatabaseConnection {

	public AbstractDatabaseConnection() {

	};

	public void connect(String username, String password, String dbname,
			String host, String port) {

	}

	public AbstractDatabaseConnection(String username, String password,
			String dbname, String host, String port) {
	};

	public void insert(Model model) {
	};

	public void update(Model model) {
	};

	public void delete(Model model) {
	};

	public RecordSet select(Criteria criteria) {
		return null;
	};
	
	public static IDatabaseConnection factory(Properties properties) {
		String adapter = properties.getProperty("adapter");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String dbname = properties.getProperty("dbname");
		String host = properties.getProperty("host");
		String port = properties.getProperty("port");		
 
		IDatabaseConnection connection = null;
 
		String className = adapter;
		className = "padroesdecriacao.factorymethod." 
                      + className.substring(0, 1) + className.substring(1).toLowerCase() 
                      + "DatabaseConnection";		
 
		try {
			connection = (IDatabaseConnection) Class.forName(className).newInstance();
			connection.connect(username, password, dbname, host, port);
		} catch (Exception e) {
			e.printStackTrace();
		}		
 
		return connection;
	};
}