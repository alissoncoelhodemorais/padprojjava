package agenda;


public class ContatoModel extends Contato {
	private ContatoMapper dmContato = new ContatoMapper();

	public ContatoModel() {
	}

	public ContatoModel(Integer id) {
		Contato contato = dmContato.find(id);
		if (contato != null) {
			this.id = contato.getId();
			this.setNome(contato.getNome());
			this.setTelefone(contato.getTelefone());
		}
	}

	public void save() {
		Contato contato = dmContato.find(this.getId());
		if (contato == null) {
			dmContato.insert(this);
		} else {
			dmContato.update(this);
		}
	}

	public void remove() {
		dmContato.delete(this);
		this.id = null;
		this.setNome(null);
		this.setTelefone(null);
	}
}