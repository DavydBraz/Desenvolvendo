//aqui vai ser o algoritmo de segunda chance, no caso acho que ele vai pegar da tabela de paginas a pagina virtual, faz mais sentido na minha visao que funcione assim

//alem disso, lembrar que ele so ocorre quando tem falta de pagina(pagefault)
//falta colocar aqui os conceitos
public class Segunda_Chance {//ta incompleto
  
  Tabela_Pagina pagvirtual;

  // so botei esse construtor na doida talvez seja inutil, e talvez precise de um vazio tbm
  public Segunda_Chance(Tabela_Pagina pagvirtual) {
    this.pagvirtual = pagvirtual;
  }

  // mesma coisa pros get e sets
  public void setPagVirtual(Tabela_Pagina pagvirtual) {//serve para atualizar
    this.pagvirtual = pagvirtual;//aqui ta meio confuso, cuidado arrumar
  }
  
  public void Verificar_Algoritmo(Pagina_Virtual pag) {
    if (pagvirtual.procurar(pag).getReferenciada() == 0){
      //aqui tem que verificar a questao de ser sujo ou limpo que o livro menciona para ver o que faz com ele
      pagvirtual.remover(pag);
    }else if(pagvirtual.procurar(pag).getReferenciada()==1){
      pagvirtual.procurar(pag);
      Pagina_Virtual Nov_pos= pagvirtual.remover(pag);
      pagvirtual.adicionar(Nov_pos);
      pagvirtual.procurar(pag).setReferenciada(0);//tem que passar o indice
    }
  }

}
