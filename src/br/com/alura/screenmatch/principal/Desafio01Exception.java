package br.com.alura.screenmatch.principal;

import java.util.Scanner;

public class Desafio01Exception {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o primeiro numero da divisão:");
        var primeiroNumero = leitura.nextInt();

        System.out.println("Digite o segundo numero da divisão:");
        var segundoNumero = leitura.nextInt();


        try {
            double resultado = (double) primeiroNumero / segundoNumero;
            System.out.println("Resultado da divisão: " + resultado);
        }catch (ArithmeticException e){
            System.out.println("Erro, pois não existe divisão por zero");
        }



    }
}
