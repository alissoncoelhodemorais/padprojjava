package padroesdecriacao.factorymethod;
 
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
 
 
public class ApplicationWithFactoryMethod {
	public static void main(String[] args) {
		try {
			File file = new File(".");
			FileInputStream fis = new FileInputStream( file.getAbsolutePath()
                         .replace(".", "src/") + ApplicationWithFactoryMethod.class.getName()
                         .replace('.','/').replace("ApplicationWithFactoryMethod","") 
                         + "dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fis);
 
			IDatabaseConnection connection = AbstractDatabaseConnection.factory(properties);
 
			System.out.println(connection.getClass().getName());
 
		} catch (Exception e) {
			e.printStackTrace();
		}	
 
	}
}