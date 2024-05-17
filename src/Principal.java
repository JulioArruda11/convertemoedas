import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        Conversor conversor = new Conversor();
        int opcao = 0;
        while (opcao != 7) {
            System.out.println("*********************************************************************");
            System.out.println("        CONVERSOR DE MOEDAS");
            System.out.println("\n1) Dólar -->> Real Brasileiro");
            System.out.println("2) Dólar -->> Peso Argentino");
            System.out.println("3) Real Brasileiro -->> Peso Chileno ");
            System.out.println("4) Peso Chileno -->> Peso Colombiano");
            System.out.println("5) Peso Argentino -->> Real Brasileiro");
            System.out.println("6) Peso Colombiano -->> Dólar");
            System.out.println("7) SAIR");
            System.out.print("\nEscolha uma opção válida: ");
            opcao = leitura.nextInt();
            conversor.escolhaConversao(opcao);
        }
    }
}
