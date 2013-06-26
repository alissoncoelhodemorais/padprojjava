package padroesdecriacao.singleton;
 
  public class Fertil extends Esteril {
         public static void main(String[] args) {
            Fertil fertil = new Fertil();
            System.out.println(fertil.getClass().getName());
         }
 
}