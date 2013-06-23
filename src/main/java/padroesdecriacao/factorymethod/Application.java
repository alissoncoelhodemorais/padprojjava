package padroesdecriacao.factorymethod;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Application {
	public static void main(String[] args) {
		try {
			File file = new File(".");
			FileInputStream fis = new FileInputStream(file.getAbsolutePath()
					.replace(".", "src/")
					+ Application.class.getName().replace('.', '/')
							.replace("Application", "") + "dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fis);
			String adapter = properties.getProperty("adapter");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			String dbname = properties.getProperty("dbname");
			String host = properties.getProperty("host");
			String port = properties.getProperty("port");

			IDatabaseConnection connection;

			if (adapter.equals("MYSQL")) {
				connection = new MysqlDatabaseConnection(username, password,
						dbname, host, port);
			}
			if (adapter.endsWith("PGSQL")) {
				connection = new PgsqlDatabaseConnection(username, password,
						dbname, host, port);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}