package br.com.dio.collection.map;

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {

        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            //Chave é de valor único
            put("gol", 14.4);
            put("uno", 16.1);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares.toString());

        System.out.println("\nSubstitua o consumo do gol por 15,2 km/l: ");
        //Como só aceita um valor, irei sobrescrever
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);

        //Conferindo se existe determinada key
        System.out.println("\nConfira se o modelo 'tucson' está no dicionário: ");
        System.out.println(carrosPopulares.containsKey("tucson"));

        //Exibindo o que tem dentro da key
        System.out.println("\nExiba o consumo do uno: ");
        System.out.println(carrosPopulares.get("uno"));

        //Exibindo todas as keys
        System.out.println("\nExiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);

        //Exibindo todos os values
        System.out.println("\nExiba os consumos dos carros: ");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);


        //Identificando qual a key com o maior value
        System.out.println("\nExiba o modelo mais eficiente e seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = ""; //Variável de controle

        //Se o valor que está recebendo for igual ao valor max (consumoMaisEficiente), essa key vai entrar para a variável "modeloMaisEficiente"
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEficiente = entry.getKey();
                System.out.println(modeloMaisEficiente + ", " + consumoMaisEficiente);
            }
        }

        //Identificando qual a key com o menor value
        System.out.println("\nExiba o modelo menos eficiente e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";

        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println(modeloMenosEficiente + ", " + consumoMenosEficiente);
            }
        }

        //Soma
        System.out.println("\nExiba a soma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while(iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println(soma);

        //Média
        System.out.println("\nExiba a média dos consumos: ");
        Double media = soma / carrosPopulares.size();
        System.out.println(media);

        //Removendo key com determinado valor
        System.out.println("\nRemova os modelos com o consumo de 15.6 km/l: ");
        System.out.println("Antes: " + carrosPopulares);

        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while(iterator1.hasNext()) {
            if (iterator1.next().equals(15.6)) iterator1.remove();
            }
        System.out.println("Depois: " + carrosPopulares);

        //Ordem de inserção
        System.out.println("\nExiba o dicionário na ordem de inserção: ");
        Map<String, Double> carrosPopulares2 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 16.1);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares2);

        //Ordem de key
        System.out.println("\nExiba o dicionário na ordem de modelo: ");
        Map<String, Double> carrosPopulares3 = new TreeMap<>(carrosPopulares2);
        System.out.println(carrosPopulares3);

        //Apagando o dicionário
        System.out.println("\nApague o dicionário e verifique se está vazio: ");
        carrosPopulares.clear();
        System.out.println(carrosPopulares.isEmpty());
    }
}
