package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.SenhaInvalidaException;

import java.util.Scanner;

public class Desafio02Exception {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);


        System.out.println("Digite a senha do usuario:");
        var senhaDigitada = leitura.next();



        try {
            if (senhaDigitada.length() < 8){
                throw new SenhaInvalidaException("A senha tem que ter pelo menos 8 caracteres");
            }

            System.out.println("logado no sistema!");
        }catch (SenhaInvalidaException e){
            System.out.println(e.getMessage());
        }

        System.out.println("fim do programa!");


    }
}
