package br.com.dio.collection.map;

import java.util.*;

public class Ex01 {
    public static void main(String[] args) {

        //Criando o dicionário
        System.out.println("Crie um dicionário e relacione os estados e suas populações: ");
        Map<String, Integer> populacaoEstados1 = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(populacaoEstados1);

        //Substindo população do RN
        System.out.println("\nSubstitua a população do estado RN por : 3.534.165");
        populacaoEstados1.put("RN", 3534165);
        System.out.println(populacaoEstados1);

        //Conferindo se PB está no dicionário e adicionando
        System.out.println("\nConfira se o estado da Paraíba (PB) está no dicionário, caso não, adicione: ");
        if (!populacaoEstados1.containsValue("PB")) {
            populacaoEstados1.put("PB",  4039277);
        }
        System.out.println(populacaoEstados1);

        //Exibindo população do PE
        System.out.println("\nExiba a população do estado PE: ");
        System.out.println(populacaoEstados1.get("PE") + " habitantes");

        //Exibindo em ordem de Inserção
        System.out.println("\nExiba todos os estados e suas populaçãos na ordem em que foram informados: ");
        System.out.println(populacaoEstados1);

        //Exibindo em ordem de Alfabética
        System.out.println("\nExiba todos os estados e suas populações na ordem alfabética: ");
        Map<String, Integer> populacaoEstados2 = new TreeMap<>(populacaoEstados1);
        System.out.println(populacaoEstados2);

        //Estados com maior e menor população
        System.out.printf("\nExiba o estado com a maior e a menor população e seu respectivo valor");
        Collection<Integer> populacao = populacaoEstados2.values();
        String estadoMaiorPopulacao = "";
        String estadoMenorPopulacao = "";
        for(Map.Entry<String, Integer> entry : populacaoEstados2.entrySet()) {
            if (entry.getValue().equals(Collections.max(populacao))) estadoMaiorPopulacao = entry.getKey();
            if (entry.getValue().equals(Collections.min(populacao))) estadoMenorPopulacao = entry.getKey();
        }
        System.out.println("\nMaior população: " + estadoMaiorPopulacao + " - " + Collections.max(populacao));
        System.out.println("Menor população: " + estadoMenorPopulacao + " - " + Collections.min(populacao));

        //Soma
        System.out.println("\nExiba a soma das populações desses estados: ");
        int soma = 0;
        Iterator<Integer> iterator = populacaoEstados2.values().iterator();
        while(iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println(soma);

        //Média
        System.out.println("\nExiba a média da população deste dicionário de estados: " + (soma / populacaoEstados2.size()));

        //Exibindo stados com populações maiores que 4.000.000
        System.out.println("\nRemova os estados com a população menor que 4.000.000: ");
        Iterator<Integer> iterator1 = populacaoEstados2.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() <= 4000000) iterator1.remove();
        }
        System.out.println(populacaoEstados2);

        //Esvaziando o dicionário
        System.out.println("\nApague o dicionario de estados com suas respectivas populações estimadas e verifique se o dicionário está vazio: ");
        populacaoEstados2.clear();
        System.out.println(populacaoEstados2.isEmpty());

    }
}

class Estado {
    private String sigla;
    private Integer populacao;

    public Estado(String sigla, Integer populacao) {
        this.sigla = sigla;
        this.populacao = populacao;
    }

    public String getSigla() {
        return sigla;
    }

    public Integer getPopulacao() {
        return populacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return sigla.equals(estado.sigla) && populacao.equals(estado.populacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sigla, populacao);
    }

    @Override
    public String toString() {
        return "Estado{" +
                "sigla='" + sigla + '\'' +
                ", populacao=" + populacao +
                '}';
    }
}
