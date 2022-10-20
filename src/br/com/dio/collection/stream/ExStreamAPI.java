package br.com.dio.collection.stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ExStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Mostre todos os elementos dessa lista de String: ");
        //Utilizando Reference Method
        numerosAleatorios.forEach(System.out::println);

        System.out.println("\nPegue os 5 primeiros items e coloque dentro de um Set: ");
        numerosAleatorios.stream()
                        .limit(5)
                        .collect(Collectors.toSet())
                        .forEach(System.out::println);

        System.out.println("\nTransforme esta lista de String em uma lista de números inteiros: ");
        List<Integer> numerosAleatorios1 = new java.util.ArrayList<>(numerosAleatorios.stream()
                        .map(Integer::parseInt)
                        .toList());
        
        System.out.println("\nPegue os números pares e maiores que 2 e coloque em uma lista: ");
        List<Integer> ParMaiorQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .toList();
        System.out.println(ParMaiorQue2);

        System.out.println("\nMostre a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("\nRemova os valores ímpares: ");
        //É um método List (altera), já que um Stream não altera
        numerosAleatorios1.removeIf(Integer -> Integer % 2 != 0);
        System.out.println(numerosAleatorios1);

        System.out.println("\nIgnore os 3 primeiros elementos da lista e imprima o restante:");
        numerosAleatorios1.stream()
                .skip(3)
                .forEach(System.out::println);

        System.out.println("\nRetirando os números repetidos da lista, quantos números ficam? ");
        long countNumerosUnicos = numerosAleatorios.stream()
                .distinct()
                .count();
        System.out.println(numerosAleatorios);
        System.out.println(countNumerosUnicos + " números únicos");

        System.out.print("\nMostre o menor valor da lista: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .min()
                .ifPresent(System.out::println);

        System.out.print("\nMostre o maior valor da lista: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        System.out.println("\nPegue apenas os números pares e some: ");
        int somaNumerosPares = numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2  == 0)
                .sum();
        System.out.println(numerosAleatorios);
        System.out.println(somaNumerosPares);

        System.out.println("\nMostre a lista na ordem númerica: ");
        List<Integer> ordemNatural = new ArrayList<>();
        for (String numeroAleatorio : numerosAleatorios) {
            ordemNatural.add(Integer.valueOf(numeroAleatorio));
        }
        ordemNatural.sort(Comparator.naturalOrder());
        System.out.println(ordemNatural);

        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt).toList();
    }
}
