//vou tentar abstrair
import java.util.ArrayList;

public class Tabela_Pagina {
  ArrayList<Pagina_Virtual> Tabela_das_Paginas = new ArrayList<Pagina_Virtual>();// o arraylist entra na questao para
                                                                                 // fazer a tabela das paginas
  // CRUDzinho base
  public void adicionar(Pagina_Virtual x) {
    // vai ser chamado quando precisar adicionar uma nova pagina, acredito que
    // um crud aqui na tabela seja essencial
    Tabela_das_Paginas.add(x);// adiciona pagina na tabela de paginas
  }

  public Pagina_Virtual remover(Pagina_Virtual y) {// mudei o metodo para tipo pagina virtual e nao void, porque preciso
                                                   // do retorno ali na outra classe
    Pagina_Virtual ret = y;
    Tabela_das_Paginas.remove(y); // remove uma pagina da tabela de paginas
    return ret;// tem que testar para ver se ta retornando certo mesmo
  }

  // com esse procurar acredito que da para la tanto atualizar, como so
  // procurar mesmo

  public Pagina_Virtual procurar(Pagina_Virtual z) {
    int posicao = Tabela_das_Paginas.indexOf(z);
    return Tabela_das_Paginas.get(posicao);
    // esse daqui serve para retornar uma pagina de dentro da tabela de paginas
  }

  // atualizar depois, talvez nem precise ta aqui, pq ja tem outros jeitos de
  // fazer, mas vou ler conceito para ver se pode
}
