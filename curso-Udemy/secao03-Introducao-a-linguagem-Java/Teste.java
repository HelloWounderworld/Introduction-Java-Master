import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        System.out.println("Hello WounderWordl!!");
        System.out.println(args);
        System.out.println(args[0]);

        Scanner entrada = new Scanner(System.in);

        String valor = entrada.nextLine();

        System.out.println("Valor é " + valor);

        entrada.close();
    }
}