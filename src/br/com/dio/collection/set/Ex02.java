package br.com.dio.collection.set;

import java.util.*;

/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção;
b) Ordem natural(nome);
c) IDE;
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
*/


public class Ex02 {
    public static void main(String[] args) {
        Set<LinguagemFavorita> minhasLinguagens1 = new HashSet<>();
        minhasLinguagens1.add(new LinguagemFavorita("Python", 1991, "Pycharm"));
        minhasLinguagens1.add(new LinguagemFavorita("JavaScript", 1995, "IntelliJ"));
        minhasLinguagens1.add(new LinguagemFavorita("Java", 1991, "Visual Studio Code"));

        //Ordem Inserção
        System.out.println("Ordem de inserção");
        Set<LinguagemFavorita> minhasLinguagens2 = new LinkedHashSet<>(
                Arrays.asList(
                        new LinguagemFavorita("Python", 1991, "Pycharm"),
                        new LinguagemFavorita("JavaScript", 1995, "IntelliJ"),
                        new LinguagemFavorita("Java", 1991, "Visual Studio Code")
                )
        );
        //Mostrar em cada linha
        for (LinguagemFavorita linguagem : minhasLinguagens2) System.out.println(linguagem);

        //Ordem Natural: Nome
        System.out.println("\nOrdem Natural: Nome");
        Set<LinguagemFavorita> minhasLinguagens3 = new TreeSet<>(minhasLinguagens1);
        for (LinguagemFavorita linguagem : minhasLinguagens3) System.out.println(linguagem);

        //Ordem IDE
        System.out.println("\nOrdem IDE");
        Set<LinguagemFavorita> minhasLinguagens4 = new TreeSet<LinguagemFavorita> (new ComparatorIDE());
        minhasLinguagens4.addAll(minhasLinguagens1);
        for (LinguagemFavorita linguagem : minhasLinguagens4) System.out.println(linguagem);


        //Ordem Ano de Criação | Nome
        System.out.println("\nOrdem Ano de Criação e Nome");
        Set<LinguagemFavorita> minhasLinguagens5 = new TreeSet<LinguagemFavorita>(new ComparatorAnoDeCriacaoENome());
        minhasLinguagens5.addAll(minhasLinguagens1);
        for (LinguagemFavorita linguagem : minhasLinguagens5) System.out.println(linguagem);

        //Ordem Nome | Ano de Criação | IDE
        System.out.println("\nOrdem Nome | Ano de Criação | IDE");
        Set<LinguagemFavorita> minhasLinguagens6 = new TreeSet<LinguagemFavorita>(new ComparatorNomeAnoDeCriacaoIde());
        minhasLinguagens6.addAll(minhasLinguagens1);
        for (LinguagemFavorita linguagem : minhasLinguagens6) System.out.println(linguagem);


    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita> {

    public String nome;
    public Integer anoDeCriacao;
    public String ide;

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    @Override
    public int compareTo(LinguagemFavorita linguagemFavorita) {
        return this.nome.compareTo(linguagemFavorita.nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return nome.equals(that.nome) && anoDeCriacao.equals(that.anoDeCriacao) && ide.equals(that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, ide);
    }
}

//Ordem IDE
class ComparatorIDE implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        return l1.ide.compareToIgnoreCase(l2.ide);
    }
}

//Ordem Ano de Criação | Nome
class ComparatorAnoDeCriacaoENome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int anoDeCriacao = Integer.compare(l1.anoDeCriacao, l2.anoDeCriacao);
        if (anoDeCriacao != 0) return anoDeCriacao;
        return l1.nome.compareToIgnoreCase(l2.nome);
    }
}

//Ordem Nome | Ano de Criação | IDE
class ComparatorNomeAnoDeCriacaoIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int nome = l1.nome.compareToIgnoreCase(l2.nome);
        int anoDeCriacao = Integer.compare(l1.anoDeCriacao, l2.anoDeCriacao);
        if (nome != 0) return nome;
        if (anoDeCriacao != 0) return anoDeCriacao;
        return l1.ide.compareToIgnoreCase(l2.ide);
    }
}
