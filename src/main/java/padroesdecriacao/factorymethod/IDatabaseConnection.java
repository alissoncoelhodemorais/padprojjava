package padroesdecriacao.factorymethod;


public interface IDatabaseConnection {
	public void connect(String username, String password, String dbname,
			String host, String port);

	public void insert(Model model);

	public void update(Model model);

	public void delete(Model model);

	public RecordSet select(Criteria criteria);

}