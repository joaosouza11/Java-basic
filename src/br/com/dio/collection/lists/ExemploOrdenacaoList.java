package br.com.dio.collection.lists;

/* Dadas as seguintes informações, crie uma lista e ordene exibindo:
(nome - idade - cor);

Gato 1 = nome: Jon, idade: 18, cor: preto
Gato 2 = nome: Simba, idade: 6, cor: tigrado
Gato 3 = nome: Jon, idade: 12, cor: amarelo
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args) {

    List<Gato> meusGatos = new ArrayList<>(){{
        add(new Gato("Jon", 18, "preto"));
        add(new Gato("Simba", 6, "tigrado"));
        add(new Gato("Jon", 12, "amarelo"));
    }};

    System.out.println("Ordem de Inserção");
    System.out.println(meusGatos + "\n");

    System.out.println("Ordem Aleatória");
    Collections.shuffle(meusGatos);
    System.out.println(meusGatos + "\n");

    System.out.println("Ordem Natural (Nome)");
    Collections.sort(meusGatos);
    System.out.println(meusGatos + "\n");

    System.out.println("Ordem Idade");
    Collections.sort(meusGatos, new ComparatorIdade());
    //ou meusGatos.sort(new ComparatorIdade());
    System.out.println(meusGatos + "\n");

    System.out.println("Ordem Cor");
    Collections.sort(meusGatos, new ComparatorCor());
    //ou meusGatos.sort(new ComparatorCor());
    System.out.println(meusGatos + "\n");

    System.out.println("Ordem Nome|Idade|Cor");
    Collections.sort(meusGatos, new ComparatorNomeIdadeCor()); // Critério de desempate
    //ou meusGatos.sort(new ComparatorNomeIdadeCor());
    System.out.println(meusGatos + "\n");


    }
}

class Gato implements Comparable<Gato>{
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
        /*String vai gerar um int, se for:
        -1 - nome tem que ir ANTES do que com o que estou comparando
         0 - nomes IGUAIS
         1 - nome tem que ir DEPOIS do que com o que estou comparando
         */
    }
}

class ComparatorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeIdadeCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        //Se os nomes forem iguais, vai ordenar por idade
        if(nome != 0) return nome;

        int idade = Integer.compare(g1.getIdade(), g2.getIdade());
        //Se as idades forem iguais, vai ordenar por cor
        if(idade !=0) return idade;

        return g1.getCor().compareToIgnoreCase(g2.getCor());

    }
}