package br.com.dio.estruturas.condicionais.composta;

public class ResultadoEscolar {

    public static void main(String[] args) {

        double nota = 4.9;

        if(nota >= 7.0) {
            System.out.println("Aprovado");

        }else if (nota >= 5.0 && nota < 7.0) {
            System.out.println("Recuperação");
            
        } else
            System.out.println("Reprovado");

    }
}
