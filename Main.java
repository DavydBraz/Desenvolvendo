public class Main{
  public static void main(String[] args) {
		//EXEMPLO QUE COMO USAR A FABRICA DE ENTRADAS
		//Memoria Virtual Minima = 10
		//Memoria Virtual Maxima = 40
		int tamanhoDaMinhaMemoriaVirtual = 10;
		String SUA_ENTRADA = new FabricaDeEntradas(tamanhoDaMinhaMemoriaVirtual).getNewEntrada();
		System.out.println(SUA_ENTRADA);
	}

}
