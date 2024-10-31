package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Endereco;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class BuscaApiCep {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite um cep para busca: ");
        String cep = leitura.nextLine();

        String endereco = "https://viacep.com.br/ws/" + cep + "/json/";
        //viacep.com.br/ws/12051660/json/

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        String json = response.body();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Endereco endereco1 = gson.fromJson(json, Endereco.class);

        FileWriter escrita = new FileWriter("endereco.json");
        escrita.write(gson.toJson(endereco1));
        escrita.close();

        System.out.println(endereco1);
    }
}
