package cadastrodealunos.activerecord;
 
public class Dominador {
	public static void main(String[] args) {
		AlunoModel model = new AlunoModel(); 
 
		model.setMatricula(2);
		model.setNome("Bolinha");
		model.save();
	}
}