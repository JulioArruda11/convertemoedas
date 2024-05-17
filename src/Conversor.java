import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Conversor {
    Scanner leitura = new Scanner(System.in);
    String moedaBase;
    String moedaDesejada;
    Gson gson = new Gson();
    double valorDaMoedaDesejada;
    double valorFinal;
    double valor;
    public void buscaMoeda(String moeda1, String moeda2) throws IOException, InterruptedException {
        String endereco = "https://v6.exchangerate-api.com/v6/5268f0318620148b840148b6/pair/" + moeda1 + "/" + moeda2;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        ValorConversao valorParaConversao = gson.fromJson(json, ValorConversao.class);

        valorDaMoedaDesejada = Double.parseDouble(valorParaConversao.conversion_rate());

    }

    public void menuConverte(){
        System.out.println("Digite o valor que deseja converter: ");
        valor = leitura.nextDouble();
        valorFinal = valor * valorDaMoedaDesejada;
        System.out.println("O valor de " + valor + " [" + moedaBase + "] corresponde ao valor final de " + valorFinal + " ["+moedaDesejada+"]");
    }

    public void escolhaConversao(int op) throws IOException, InterruptedException {

        switch (op){
            case 1:
                System.out.println("\n  ** Dólar para Real Brasileiro **");
                moedaBase = "USD";
                moedaDesejada = "BRL";
                buscaMoeda(moedaBase,moedaDesejada);
                menuConverte();
                break;
            case 2:
                System.out.println("\n  ** Dólar para Peso Argentino **");
                moedaBase = "USD";
                moedaDesejada = "ARS";
                buscaMoeda(moedaBase,moedaDesejada);
                menuConverte();
                break;
            case 3:
                System.out.println("\n  ** Real Brasileiro para Peso Chileno **");
                moedaBase = "BRL";
                moedaDesejada = "CLP";
                buscaMoeda(moedaBase,moedaDesejada);
                menuConverte();
                break;
            case 4:
                System.out.println("\n  ** Peso Chileno para Peso Colombiano **");
                moedaBase = "CLP";
                moedaDesejada = "COP";
                buscaMoeda(moedaBase,moedaDesejada);
                menuConverte();
                break;
            case 5:
                System.out.println("\n  ** Peso Argentino para Real Brasileiro **");
                moedaBase = "ARS";
                moedaDesejada = "BRL";
                buscaMoeda(moedaBase,moedaDesejada);
                menuConverte();
                break;
            case 6:
                System.out.println("\n  ** Peso Colombiano para Dólar **");
                moedaBase = "COP";
                moedaDesejada = "USD";
                buscaMoeda(moedaBase,moedaDesejada);
                menuConverte();
                break;
            case 7:
                System.out.println("Programa Finalizado!");
                break;
            default:
                System.out.println("Opção invalida! Tente novamente");
        }

    }


}
