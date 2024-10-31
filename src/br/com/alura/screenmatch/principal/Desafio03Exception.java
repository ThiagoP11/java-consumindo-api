package br.com.alura.screenmatch.principal;


import br.com.alura.screenmatch.excecao.ErroConsultaGitHubException;
import br.com.alura.screenmatch.modelos.Login;
import br.com.alura.screenmatch.modelos.UsuarioGitHub;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Desafio03Exception {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome de usuário do GitHub para consultar informações: ");
        String username = leitura.nextLine();

        String endereco = "https://api.github.com/users/" + username;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .header("Accept", "application/vnd.github.v3+json")
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 404) {
                throw new ErroConsultaGitHubException("Usuário não encontrado no GitHub.");
            }

            String json = response.body();
            System.out.println(json);

            // Adicione aqui o código para processar o JSON e exibir as informações desejadas
            Gson gson = new Gson();

            UsuarioGitHub usuarioGitHub = gson.fromJson(json, UsuarioGitHub.class);

            System.out.println(usuarioGitHub);

            Login login = new Login(usuarioGitHub);

            System.out.println(login.getLogin());


        } catch (IOException | InterruptedException e) {
            System.out.println("Opss… Houve um erro durante a consulta à API do GitHub.");
            e.printStackTrace();
        } catch (ErroConsultaGitHubException e) {
            System.out.println(e.getMessage());
        }
    }
}

