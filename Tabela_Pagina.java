
//vou tentar abstrair
import java.util.ArrayList;

public class Tabela_Pagina {
  ArrayList<Pagina_Virtual> Tabela_das_Paginas = new ArrayList<Pagina_Virtual>();// o arraylist entra na questao para fazer a tabela das paginas


  // CRUDzinho base
  public void adicionar(Pagina_Virtual x) {// vai ser chamado quando precisar adicionar uma nova pagina, acredito que um
                                           // crud aqui na tabela seja essencial
    Tabela_das_Paginas.add(x);
  }

  public void remover(Pagina_Virtual y) {
    Tabela_das_Paginas.remove(y);
  }

  // com esse procurar acredito que da para la tanto atualizar, como so
  // procurar mesmo
  public Pagina_Virtual procurar(Pagina_Virtual z) {
    int posicao = Tabela_das_Paginas.indexOf(z);
    return Tabela_das_Paginas.get(posicao);

  }
  //atualizar depois

}
