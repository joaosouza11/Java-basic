package br.com.dio.collection.set;

import java.util.*;

/*
Crie uma conjunto contendo as cores do arco-íris e:
a) Exiba todas as cores o arco-íris uma abaixo da outra;
b) A quantidade de cores que o arco-íris tem;
c) Exiba as cores em ordem alfabética;
d) Exiba as cores na ordem inversa da que foi informada;
e) Exiba todas as cores que começam com a letra ”v”;
f) Remova todas as cores que não começam com a letra “v”;
g) Limpe o conjunto;
h) Confira se o conjunto está vazio;
 */

public class Ex01ArcoIris {
    public static void main(String[] args) {

        //Inicializando
        System.out.println("Cores do Arco-íris: ");
        Set<String> coresArcoIris1 = new HashSet<>();
        coresArcoIris1.add("violeta");
        coresArcoIris1.add("anil");
        coresArcoIris1.add("azul");
        coresArcoIris1.add("verde");
        coresArcoIris1.add("amarelo");
        coresArcoIris1.add("laranja");
        coresArcoIris1.add("vermelho");

        //Cada cor em uma linha
        for (String cor: coresArcoIris1) System.out.println(cor);

        //Quantidade de cores
        System.out.println("\nO arco-íris tem " + coresArcoIris1.size() + " cores");

        //Ordem alfabética
        System.out.println("\nOrdem alfabética: ");
        Set<String> coresArcoIris2 = new TreeSet<>(coresArcoIris1);
        for (String cor: coresArcoIris2) System.out.println(cor);

        //Ordem inversa
        System.out.println("\nOrdem inversa: ");
        Set<String> coresArcoIris3 = new LinkedHashSet<>(
                Arrays.asList("violeta", "anil", "azul", "verde", "amarelo", "laranja", "vermelho"));
        List<String> coresArcoIrisList = new ArrayList<>(coresArcoIris3);
        Collections.reverse(coresArcoIrisList);
        System.out.println(coresArcoIrisList);

        //Exibir cores que começam com "v"
        System.out.println("\nExiba todas as cores que começam com a letra 'v': ");
        for (String cor : coresArcoIris1) {
            if(cor.startsWith("v")) System.out.println(cor);
        }

        //Remover corem que não começam com "v"
        System.out.println("\nRemova todas as cores que não começam com a letra 'v': ");
        Iterator<String> iterator1 = coresArcoIris1.iterator();
        while (iterator1.hasNext()) {
            if (!iterator1.next().startsWith("v")) iterator1.remove();
        }
        //Exibindo em cada linha
        for (String cor: coresArcoIris1) System.out.println(cor);

        //Limpando o conjunto
        System.out.println("\nLimpe o conjunto e confira se está vazio: ");
        coresArcoIris1.clear();
        System.out.println(coresArcoIris1.isEmpty());
    }
}