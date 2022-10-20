package br.com.dio.collection.set;

import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {

        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas.toString() + "\n");

        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d)  + "\n");

        System.out.println("Exiba a menor nota: " + Collections.min(notas) + "\n");

        System.out.println("Exiba a menor nota: " + Collections.max(notas) + "\n");

        //Soma
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while(iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma das notas: " + soma + "\n");

        //Média
        System.out.println("Exiba a média das notas: " + (soma / notas.size())  + "\n");

        System.out.println("Remova a nota 0");
        notas.remove(0d);
        System.out.println(notas + "\n");

        System.out.println("Remova as notas menores que 7 e exiba na lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas + "\n");

        System.out.println("Exiba todas as notas na ordem em que foram inforamdo: ");
        //Tem que ser LinkedHashSet
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d); //Não vai adicionar pois é repetido
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2 + "\n");

        //TreeSet default é na ordem crescente
        System.out.println("Exiba todas as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3 + "\n");

        System.out.println("Apague todo o conjunto1\n");
        notas.clear();

        System.out.println("Confira se o conjunto notas1 está vazio: " + notas.isEmpty());

        System.out.println("Confira se o conjunto notas2 está vazio: " + notas2.isEmpty());

    }
}
