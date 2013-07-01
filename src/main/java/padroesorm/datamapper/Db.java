package padroesorm.datamapper;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Db {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/escola";
	private static final String USER = "postgres";
	private static final String PASSWORD = "1234";
	private static Connection instance = null;
	private static Statement statement = null;
	private static PreparedStatement pst;
 
	private Db()
	{
	}
 
	private static Connection getInstance()
	{
		if (instance == null)
		{
			try {
				Class.forName(DRIVER);
				instance = DriverManager.getConnection(URL, USER, PASSWORD);			
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
 
	public static boolean execute(String sql)
	{
		boolean result= false;
		try {
			statement = getInstance().createStatement();
			result = statement.execute(sql);
			statement.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
 
	public static ResultSet fetchAll(String sql)
	{
		ResultSet result = null;
		try {
			pst = getInstance().prepareStatement(sql);
            result = pst.executeQuery();
//			statement = getInstance().createStatement();
//			result = statement.executeQuery(sql);
//			statement.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			try {
//				pst.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
		return result;
	}
 
 
}