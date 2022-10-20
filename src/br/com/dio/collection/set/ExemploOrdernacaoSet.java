package br.com.dio.collection.set;

import java.util.*;

/*Crie um conjunto e ordene um conjunto exibindo:
* (nome - genero - tempo de episódio);
*
* Série 1 = Nome: got, genero: fantasia, tempoEpisodio: 60
* Série 1 = Nome: dark, genero: drama, tempoEpisodio: 60
* Série 1 = Nome: that '70s show, genero: comédia, tempoEpisodio: 25
* */
public class ExemploOrdernacaoSet {
    public static void main(String[] args) {

        //Ordem Aleatória - HashSet
        System.out.println("Ordem Aleatória");
        Set<Serie> minhasSeries1 = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};
        for (Serie serie: minhasSeries1) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        //Ordem de Inserção - LinkedHashSet
        System.out.println("\nOrdem de Inserção");
        Set<Serie> minhasSeries2 = new LinkedHashSet<>(){{
           add(new Serie("got", "fantasia", 60));
           add(new Serie("dark", "drama", 60));
           add(new Serie("that 70's show", "comedia", 25));
        }};
        for (Serie serie: minhasSeries2) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        //Ordem Natual - TreeSet
        System.out.println("\nOrdem Natural (tempoEpisodio)");
        Set<Serie> minhasSeries3 = new TreeSet<>(minhasSeries2);
        for (Serie serie: minhasSeries3) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        //Ordem Nome/Gênero/TempoEpisodio
        System.out.println("\nOrdem Nome/Gênero/TempoEpisodio");
        Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeries4.addAll(minhasSeries1);

        for (Serie serie: minhasSeries4) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        //Ordem gênero
        System.out.println("\nOrdem Gênero");
        Set<Serie> minhasSeries5 = new TreeSet<>(new ComparatorGenero());
        minhasSeries5.addAll(minhasSeries1);

        for (Serie serie: minhasSeries5) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        //Ordem tempoEpisódio
        System.out.println("\nOrdem Tempo de Episódio");
        Set<Serie> minhasSeries6 = new TreeSet<>(new ComparatorTempoEpisodio());
        minhasSeries6.addAll(minhasSeries1);

        for (Serie serie: minhasSeries6) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }
}

class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        //Critério de desempate caso haja tempoEpisodio iguais
        if (tempoEpisodio != 0) return tempoEpisodio;
        return this.getNome().compareTo(serie.getNome());

    }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}

//Não é uma forma eficiente de codar pois é possivel simplificar bastante e reutilizar código já feito, porém agora estou focando apenas na pratica do conceito estudado
class ComparatorGenero implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}

class ComparatorTempoEpisodio implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int tempoEpisodio = Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
        if (tempoEpisodio != 0) return tempoEpisodio;

        return s1.getNome().compareTo(s2.getNome());
    }
}
