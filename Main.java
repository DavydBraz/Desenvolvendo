class Main {
  public static void main(String[] args) {
    String[] HD_Do_Programa = { "0-5", "1-5", "2-4", "3-0", "4-10", "5-2", "6-8", "7-3" };// primeiro valor é o endereço
                                                                                          // e o segundo é o valor

    String[] MemVirtual = { null, null, null, null, null, null, null, null };
    // espaço de endereçamento eu acho, no caso de 8 regioes, as quais a memoria
    // fisica só vai ter 4
    String[] MemFisica = { null, null, null, null };
    // da para abstrair como se os programas ocupassem o mesmo espaço, dessa forma
    // justificaria pq não vou usar especificações de tamanhos e mudanças de formas
    // de aproveitar esse espaço
  }
}
