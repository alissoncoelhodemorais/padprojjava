package padroesdecriacao.singleton;

public abstract class Esteril {
	
	public static void main(String[] args) {
		Esteril esteril = new Fertil();
		System.out.println(esteril.getClass().getName());
	}
}