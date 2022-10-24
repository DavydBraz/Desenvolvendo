//acho que terminei, so falta por os conceitos
public class Pagina_Virtual {// Estrutura basica da pagina
  
  //a estrutura correspondente da pagina virtual na memoria fisica é o quadro de pagina
  
  private int Referenciada;//botei int e nao boolean pq para comparar apresenta erro que nao da para comparar int com boolean, ai para nao ter que fazer um tratamento so para isso, ai abstrai que fica melhor, referenciada é caso ela tenha sido referenciada, ou seja, usada para leitura ou escrita
  
  private int Modificada;//se foi modificado, ou seja, ta 1, vai ser chamado de bit sujo e deve ser salvo no disco. Se nao foi modificado esta limpa e pode ser abandonada
  private int Presente_Ausente;//se está presente na memoria fisica será 1, caso contrario será 0 e se for 0 no momento que ele for solicitada vai gerar falta de página.
  
  private int Num_Moldura_Pagina;// aqui seria bits, mas da para abstrair e dizer que é um inteiro, afinal depois
                                 // ele seria transformado pelo MMU basicamente

  public Pagina_Virtual(int Referenciada, int Modificada, int Presente_Ausente, int Num_Moldura_Pagina) {// Construtor
    this.Referenciada = Referenciada;
    this.Modificada = Modificada;
    this.Presente_Ausente = Presente_Ausente;
    this.Num_Moldura_Pagina = Num_Moldura_Pagina;
  }

  // gets e sets, existe a chance de precisar de reajuste
  public void setReferenciada(int Referenciada) {
    this.Referenciada = Referenciada;
  }

  public int getReferenciada() {
    return Referenciada;
  }

  public void setModificada(int Modificada) {
    this.Modificada = Modificada;
  }

  public int getModificada() {
    return Modificada;
  }

  public void setPresente_Ausente(int Presente_Ausente) {
    this.Presente_Ausente = Presente_Ausente;
  }

  public int getPresente_Ausente() {
    return Presente_Ausente;
  }

  public void setNum_Moldura_Pagina(int Num_Moldura_Pagina) {
    this.Num_Moldura_Pagina = Num_Moldura_Pagina;
  }

  public int getNum_Moldura_Pagina() {
    return Num_Moldura_Pagina;
  }

}
