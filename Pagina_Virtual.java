public class Pagina_Virtual {// Estrutura basica que ele quer da pagina
  private int Referenciada;//botei int e nao boolean pq para comparar apresenta erro que nao da para comparar int com boolean
  private int Modificada;
  private int Presente_Ausente;
  private int Num_Moldura_Pagina;// aqui seria bits, mas da para abstrair e dizer que é um inteiro, afinal depois
                                 // ele seria transformado pelo MMU basicamente, só to abstraindo essa parte,
                                 // desde que seja justificado acho que ta tranquilo.

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
