package padroesdecriacao.factorymethod;

import java.util.Properties;

import junit.framework.Assert;

public class TesteFactory extends junit.framework.TestCase {

	public void testInstances() {
		Properties properties = new Properties();
		properties.setProperty("adapter", "PGSQL");
		properties.setProperty("username", "x");
		properties.setProperty("password", "x");
		properties.setProperty("dbname", "x");
		properties.setProperty("host", "x");
		properties.setProperty("port", "x");

		IDatabaseConnection c1 = AbstractDatabaseConnection.factory(properties);

		Assert.assertTrue(c1 instanceof PgsqlDatabaseConnection);

		properties.setProperty("adapter", "MYSQL");

		IDatabaseConnection c2 = AbstractDatabaseConnection.factory(properties);

		Assert.assertTrue(c2 instanceof MysqlDatabaseConnection);
	}
}