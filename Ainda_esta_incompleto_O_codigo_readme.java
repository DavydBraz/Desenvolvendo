//atencao as informacoes a seguir podem estar faltando algo, sao apenas alguns ponto que eu tava lendo sobre o assunto
//o codigo ainda nao esta funcionando, esta faltando reajustes.

// aqui vou por as principais caracteristicas e suas ligacoes com o codigo eu
// acho, por enquanto vou so ir pondo informacoes relevantes, depois arrumo
// bunitin

// Embora as memórias dos pcs estejão aumentando,os programas estão ficando
// maiores mais rápido do que as memórias.

// A parte do sistema operacional que gerencia (parte da) hierarquia de memórias
// é chamada de gerenciador de memória. Sua função é gerenciar eficientemente a
// memória: controlar quais partes estão sendo usadas, alocar memória para
// processos quando eles precisam dela e liberá-la quando tiverem terminado.

// sobre a questão da leitura das funçoes dos processos, tipo 0-R , 1-W-5, acho
// que da para fazer com posições, pq em tese strings são listas de chars, então
// acho que da para fazer algo assim : if{mem[2]==R}{faça tal coisa},
// if{mem[2]==W}{faça desse outro jeito}

// Como algo bonus, caso eu consiga fazer esse software rodar, seria fazer essa
// questão dos processos terem tamanho distintos e formas de tratamento para
// isso, mas apenas se eu conseguir terminar o restante.
// para o tratamento disso, acredito que aqui seria aquela parte de first fit,
// next fit, best fit, worst fit e quick fit

// tem a questão também de listas encadeadas, vou ver se depois eu implemento
// isso, por enquanto ta de boa não fazer, já que ele não cobrou explicitamente.

// SOBRE O QUE TEM QUE FAZER
// MEMORIA VIRTUAL:A ideia básica é que cada programa tem seu próprio espaço de
// endereçamento, o qual é dividido em blocos chamados de páginas. Cada página é
// uma série contígua de endereços. Elas são mapeadas na memória física, mas nem
// todas precisam estar na memória física ao mesmo tempo para executar o
// programa.

/*
 * A memória virtual funciona bem em um sistema
 * de multiprogramação, com pedaços e partes de muitos
 * programas na memória simultaneamente. Enquanto um
 * programa está esperando que partes de si mesmo sejam
 * lidas, a CPU pode ser dada para outro processo.
 */

/*
 * Esses endereços gerados por computadores são chamados de endereços virtuais e
 * formam o espaço de
 * endereçamento virtual. Em computadores sem memória virtual, o endereço
 * virtual é colocado diretamente no
 * barramento de memória e faz que a palavra de memória
 * física com o mesmo endereço seja lida ou escrita. Quando a memória virtual é
 * usada, os endereços virtuais não
 * vão diretamente para o barramento da memória. Em
 * vez disso, eles vão para uma MMU (Memory Management Unit — unidade de
 * gerenciamento de memória)
 * que mapeia os endereços virtuais em endereços de memória física, como
 * ilustrado na Figura 3.8.
 * 
 * (eu acho que não implementa a MMU, no caso ela é um componente fisico, da
 * para abstrair baseado em sua logica)
 */

/*
 * O espaço de endereçamento virtual consiste em
 * unidades de tamanho fixo chamadas de páginas. As
 * unidades correspondentes na memória física são chamadas de quadros de página.
 * As páginas e os quadros de página são geralmente do mesmo tamanho.
 */

/*
 * Nesse exemplo, elas têm 4 KB, mas tamanhos de página de 512 bytes a um
 * gigabyte foram usadas em sistemas reais. Com 64 KB de espaço de endereçamento
 * virtual e 32 KB de memória física, podemos ter 16
 * páginas virtuais e 8 quadros de páginas. Transferências entre a memória RAM e
 * o disco são sempre em
 * páginas inteiras. Muitos processadores dão suporte a
 * múltiplos tamanhos de páginas que podem ser combinados e casados como o
 * sistema operacional preferir. Por exemplo, a arquitetura x86-64 dá suporte
 * a páginas de 4 KB, 2 MB e 1 GB, então poderíamos
 * usar páginas de 4 KB para aplicações do usuário e
 * uma única página de 1 GB para o núcleo. Veremos
 * mais tarde por que às vezes é melhor usar uma única
 * página maior do que um grande número de páginas
 * pequenas.
 * 
 * A notação na Figura 3.9 é a seguinte: a série marcada
 * 0K−4K significa que os endereços virtuais ou físicos
 * naquela página são 0 a 4095. A série 4K–8K refere-se
 * aos endereços 4096 a 8191, e assim por diante. Cada
 * página contém exatamente 4096 endereços começando
 * com um múltiplo de 4096 e terminando antes de um
 * múltiplo de 4096.
 * Quando o programa tenta acessar o endereço 0, por
 * exemplo, usando a instrução
 * MOV REG,0
 * o endereço virtual 0 é enviado para a MMU. A MMU
 * detecta que esse endereço virtual situa-se na página 0
 * (0 a 4095), que, de acordo com seu mapeamento, corresponde ao quadro de
 * página 2 (8192 a 12287). Ele
 * então transforma o endereço para 8192 e envia o endereço 8192 para o
 * barramento. A memória desconhece
 * completamente a MMU e apenas vê uma solicitação
 * para leitura ou escrita do endereço 8192, a qual ela executa.
 * 
 * 
 * Desse modo, a MMU mapeou efetivamente todos os endereços virtuais de 0 a 4095
 * em endereços físicos localizados de 8192 a 12287.
 * 
 */

// A MMU observa que a página não está mapeada (o que é indicado por um X na
// figura) e faz a CPU desviar para o sistema operacional. Essa interrupção é
// chamada de falta de página (page fault).

// O sistema operacional escolhe um quadro de página pouco usado e escreve seu
// conteúdo de volta para o disco (se já não estiver ali). Ele então carrega
// (também do disco) a página recém-referenciada no quadro de página
// recém-liberado, muda o mapa e reinicia a instrução que causou a interrupção.
// Por exemplo, se o sistema operacional decidiu escolher o quadro da página 1
// para ser substituído, ele carregará a página virtual 8 no endereço físico
// 4096 e fará duas mudanças para o mapa da MMU. Primeiro, ele marcará a entrada
// da página 1 virtual como não mapeada, a fim de impedir quaisquer acessos
// futuros aos endereços virtuais entre 4096 e 8191. Então substituirá o X na
// entrada da página virtual 8 com um 1, assim, quando a instrução causadora da
// interrupção for reexecutada, ele mapeará os endereços virtuais 32780 para os
// endereços físicos 4108 (4096 + 12).

// O número da página é usado como um índice para a tabela de páginas,
// resultando no número do quadro de página correspondente àquela página
// virtual. Se o bit Presente/ausente for 0, ocorrerá uma interrupção para o
// sistema operacional. Se o bit for 1, o número do quadro de página encontrado
// na tabela de páginas é copiado para os três bits mais significativos para o
// registrador de saída, junto com o deslocamento de 12 bits, que é copiado sem
// modificações do endereço virtual de entrada. Juntos eles formam um endereço
// físico de 15 bits. O registrador de saída é então colocado no barramento de
// memória como o endereço de memória físico.

/*
 * Em uma implementação simples, o mapeamento de
 * endereços virtuais em endereços físicos pode ser resumido como a seguir: o
 * endereço virtual é dividido em
 * um número de página virtual (bits mais significativos)
 * e um deslocamento (bits menos significativos). Por
 * exemplo, com um endereço de 16 bits e um tamanho
 * de página de 4 KB, os 4 bits superiores poderiam especificar uma das 16
 * páginas virtuais e os 12 bits inferiores especificariam então o deslocamento
 * de bytes (0 a
 * 4095) dentro da página selecionada. No entanto, uma
 * divisão com 3 ou 5 ou algum outro número de bits para
 * 
 * a página também é possível. Divisões diferentes implicam tamanhos de páginas
 * diferentes.
 * O número da página virtual é usado como um índice dentro da tabela de páginas
 * para encontrar a entrada
 * para essa página virtual. A partir da entrada da tabela de
 * páginas, chega-se ao número do quadro (se ele existir).
 * O número do quadro de página é colocado com os bits
 * mais significativos do deslocamento, substituindo o número de página virtual,
 * a fim de formar um endereço
 * físico que pode ser enviado para a memória.
 * Assim, o propósito da tabela de páginas é mapear as
 * páginas virtuais em quadros de páginas. Matematicamente falando, a tabela de
 * páginas é uma função, com
 * o número da página virtual como argumento e o número do quadro físico como
 * resultado. Usando o resultado
 * dessa função, o campo da página virtual em um endereço
 * virtual pode ser substituído por um campo de quadro de
 * página(acredito que da para abstrair esse quadro de pagina como sendo o
 * indice do valor da memoria fisica), desse modo formando um endereço de mem
 * física.
 */

// Quando ocorre uma falta de página, o sistema operacional tem de escolher uma
// página para remover da memória a fim de abrir espaço para a que está
// chegando. Se a página a ser removida foi modificada enquanto estava na
// memória, ela precisa ser reescrita para o disco a fim de atualizar a cópia em
// disco. Se, no entanto, ela não tiver sido modificada (por exemplo, ela contém
// uma página de código), a cópia em disco já está atualizada, portanto não é
// preciso reescrevê-la. A página a ser lida simplesmente sobrescreve a página
// que está sendo removida.

/* O algoritmo de substituição de páginas segunda chance */
// Uma modificação simples para o FIFO que evita o problema de jogar fora uma
// página intensamente usada é inspecionar o bit R da página mais antiga. Se ele
// for 0, a página é velha e pouco utilizada, portanto é substituída
// imediatamente. Se o bit R for 1, o bit é limpo, e a página é colocada no fim
// da lista de páginas, e seu tempo de carregamento é atualizado como se ela
// tivesse recém-chegado na memória. Então a pesquisa continua. A operação desse
// algoritmo, chamada de segunda chance, é mostrada na Figura 3.15. Na Figura
// 3.15(a) vemos as páginas A até H mantidas em uma lista encadeada e divididas
// pelo tempo que elas chegaram na memória. Suponha que uma falta de página
// ocorra no instante 20. A página mais antiga é A, que chegou no instante
// 0,quando o processo foi inicializado. Se o bit R da página A for 0, ele será
// removido da memória, seja sendo escrito para o disco (se ele for sujo), ou
// simplesmente abandonado (se ele for limpo). Por outro lado, se o bit R for 1,
// A será colocado no fim da lista e seu “tempo de carregamento” será atualizado
// para o momento atual (20). O bit R é também colocado em 0. A busca por uma
// página adequada continua com B. O que o algoritmo segunda chance faz é
// procurar por uma página antiga que não esteja referenciada no intervalo de
// relógio mais recente. Se todas as páginas foram referenciadas, a segunda
// chance degenera-se em um FIFO puro. Especificamente, imagine que todas as
// páginas na Figura 3.15(a) têm seus bits R em 1. Uma a uma, o sistema
// operacional as move para o fim da lista, zerando o bit R cada vez que ele
// anexa uma página ao fim da lista. Por fim, a lista volta à página A, que
// agora tem seu bit R zerado. Nesse ponto A é removida. Assim, o algoritmo
// sempre termina.
