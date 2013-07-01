package padroesbasicos.registry;
 
import java.util.HashMap;
 
public class Registry {
	private static Registry instance = null;
	private HashMap<String, Object>  registry = new HashMap<String, Object>(); 
 
	private Registry(){};
 
	public static Registry getInstance(){
		if (instance == null)
		{
			instance = new Registry();
		}
		return instance;
	}
 
	public void set(String key, Object value)
	{
		instance.registry.put(key, value);
	}
 
	public Object get(String key)
	{
		return instance.registry.get(key);
	}
 
}