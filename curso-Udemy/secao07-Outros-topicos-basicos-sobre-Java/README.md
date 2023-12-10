# seção 07: Outros Tópicos Básicos sobre Java

## Aula 01 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Outros tópicos básicos sobre Java!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    07-outros-topicos-basicos(para-anotacoes).pdf
    07-outros-topicos-basicos.pdf

## Aula 02 - Restrições e convenções para nomes:
Restrições para nomes de variáveis

• Não pode começar com dígito: use uma letra ou _ 

• Não usar acentos ou til

• Não pode ter espaço em branco

• Sugestão: use nomes que tenham um significado

## Aula 03 - Operadores bitwise:
Os operadores bitwise são os operadores que realizam operações lógicas bit a bit. São eles

    & - Operação "E" bit a bit
    | - Operação "OU" bit a bit
    ^ - Operação "Ou-Exclusivo" bit a bit

No caso, o uso dela não foge da lógica proposicional.

Um exemplo de utilização de bitwise seria o seguinte

    int n1 = 89;
    int n2 = 60;
    System.out.println(n1 & n2);
    System.out.println(n1 | n2);
    System.out.println(n1 ^ n2);

Basicamente, o que está acontecendo acima é que quando realizamos alguma comparação lógica entre dois números inteiros usando o bitwise, automaticamente, é convertido os números inteiros acima em binários e, consequentemente, eles comparam cada 0 e 1 que aparecem em cada uma dos binários e realizam a comparação definindo 0 como false e 1 como true. Então, levando em conta essa lógica e usando os operadores bitwise ficaria algo como seguinte

- &:

    0 & 1 => 0

    1 & 1 => 1

    0 & 0 => 0

- |:

    0 | 1 => 1

    1 | 1 => 1

    0 | 0 => 0

- ^:

    0 ^ 1 => 1

    1 ^ 1 => 0

    0 ^ 0 => 0

Logo, quando realizamos a comparação binária entre dois números inteiros usando o bitwise, será retornado um outro binário que, por sua vez, é um outro inteiro. Como, por exemplo, 

    89 => 0101 1001
                    => 0 <-> 0, 1 <-> 0, 0 <-> 1, 1 <-> 1, 1 <-> 1, 0 <-> 1, 0 <-> 0, 1 <-> 0
    60 => 0011 1100

Comparando de forma bijetora canônica, cada 0 e 1 que aparecem nos binários dos números inteiros 89 e 60, usando os operadores lógicos de bitwise, será retornado 0 ou 1 e isso irá formar um outro binário.

Bom, aqui está um outro exemplo dessa aplicação

    import java.util.Scanner;
    public class Program {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int mask = 0b100000;
            int n = sc.nextInt();
            if ((n & mask) != 0) {
                System.out.println("6th bit is true!");
            }
            else {
                System.out.println("6th bit is false");
            }
            sc.close();
        }
    }

No caso, o exemplo acima é para verificar se o sexto bit é um número 1 ou não, ou seja, 0000 0100, representado na forma 0b100000. No caso, colocado um número inteiro n, ele converterá no binário e irá comparar com o binário mask para verificar se esse número inteiro, o sexto bit dele tbm é um número 1.

## Aula 04 - Comentários em Java (básico):
É o mesmo do JavaScript, // e /* */.

## Aula 05 - Funções (sintaxe):
• Representam um processamento que possui um significado• Math.sqrt(double)

• System.out.println(string)

• Principais vantagens: modularização, delegação e reaproveitamento

• Dados de entrada e saída

    • Funções podem receber dados de entrada (parâmetros ou argumentos)
    • Funções podem ou não retornar uma saída

• Em orientação a objetos, funções em classes recebem o nome de "métodos"

Bom, o exemplo disso seria o seguinte

    import java.util.Scanner;
    public class Program {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter three numbers:");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a > b && a > c) {
                System.out.println("Higher = " + a);
            } else if (b > c) {
                System.out.println("Higher = " + b);
            } else {
                System.out.println("Higher = " + c);
            }
            sc.close();
        }
    }

Um outro exemplo

    import java.util.Scanner;
    public class Program {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter three numbers:");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int higher = max(a, b, c);
            showResult(higher);
            sc.close();
        }

        public static int max(int x, int y, int z) {
            int aux;
            if (x > y && x > z) {
                aux = x;
            } else if (y > z) {
                aux = y;
            } else {
                aux = z;
            }
            return aux;
        }

        public static void showResult(int value) {
            System.out.println("Higher = " + value);
        }
    }

Bom, o jeito acima aqui foi para criar várias funções e ficar chamando em cada lugar. Note que, aqui, quando criamos a função max, foi necessário declarar uma variável e retornar ela atribuindo dentro dessa variável o valor dos argumentos que foram passados dentro dessa função. A necessidade disso seria pelo mesmo motivo do exemplo que foi mostrado quando estávamos estudando as condicionais. Ou seja, depois que executa essa função, tais variáveis int x, int y e int z que estava sendo mostrado é considerado inexistente, o que torna necessário declarar uma varável dentro dela para retorna-las com essa variável carregado do valor que vc define dentro dessa função usando ou não o argumento atribuído nela.

Além disso, note que, ao definirmos as duas funções max e o showResult acima usamos o int e o void depois do public static. Mas aí qual seria o motivo? Está no fato de se vc irá ou não retornar algo. Note que, na função showResult não foi usado o return e para ela foi usado o void? Pois a finalidade dessa função é apenas printar o conteúdo passado no argumento dela e não tem nenhuma outra finalidade de usar os dados feitos dentro dela depois.
