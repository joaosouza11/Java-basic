package br.com.dio.collection.map;

import java.util.*;

/*
Faça um programa que simule um lançamento de dados. Lance o dado 100 vezes e armazene.
Depois, mostre quantas vezes cada valor foi conseguido.
 */

public class Ex02 {
    public static void main(String[] args) {

        int quantLancamentos = 100;

        List<Integer> valores = new ArrayList<>();
        Random geradorDeLancamento = new Random();
        for (int i = 0; i < quantLancamentos; i++) {
            int number = geradorDeLancamento.nextInt(6) + 1;
            valores.add(number);
        }

        Map<Integer, Integer> lancamentos = new HashMap<>();
        for (Integer resultado : valores) {
            if (lancamentos.containsKey(resultado)) {
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1));
            }
            else lancamentos.put(resultado, 1);
        }

        System.out.println("Jogando");
        //Conteúdo do for + try/catch - Totalmente Opcional
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(2000);
                System.out.println(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nValor " + " Quant. de vezes");
        for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()) {
            System.out.printf("%2d %10d", entry.getKey(), entry.getValue());
        }

    }
}
