package br.com.dio.collection.map;

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {

        //Ordem Aleatoria
        System.out.println("--Ordem aleatória: ");
        Map<String, Livro> meusLivros1 = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
        }};
        for(Map.Entry<String, Livro> livro : meusLivros1.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + ", " + livro.getValue().getPaginas());
        }

        //Ordem Inserção
        System.out.println("\n--Ordem de inserção: ");
        Map<String, Livro> meusLivros2 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
        }};
        for(Map.Entry<String, Livro> livro : meusLivros2.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + ", " + livro.getValue().getPaginas());
        };

        //Ordem Autores
        System.out.println("\n--Ordem autores: ");
        Map<String, Livro> meusLivros3 = new TreeMap<>(meusLivros2);
        for(Map.Entry<String, Livro> livro : meusLivros3.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + ", " + livro.getValue().getPaginas());
        };

        //Ordem Livros
        System.out.println("\n--Ordem livros: ");
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
        meusLivros4.addAll(meusLivros1.entrySet());
        for(Map.Entry<String, Livro> livro : meusLivros4) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + ", " + livro.getValue().getPaginas());
        };

        //Ordem Número de Páginas
        System.out.println("\n--Ordem número de páginas: ");
        Set<Map.Entry<String, Livro>> meusLivros5 = new TreeSet<>(new ComparatorNumPaginas());
        meusLivros5.addAll(meusLivros1.entrySet());
        for(Map.Entry<String, Livro> livro : meusLivros5) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + ", " + livro.getValue().getPaginas());
        }

    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareTo(l2.getValue().getNome());
    }
}

class ComparatorNumPaginas implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
    }
}
