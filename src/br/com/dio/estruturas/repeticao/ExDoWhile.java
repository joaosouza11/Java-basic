package br.com.dio.estruturas.repeticao;
import java.util.Random;

public class ExDoWhile {

    public static void main(String[] args) {
        System.out.println("Discando...");
        do {
            System.out.println("Telefone tocando");
        }while(tocando());

        System.out.println("Alôô");
    }

    private static boolean tocando() {
        boolean atendeu = new Random().nextInt(10) == 1;
        System.out.println("Atendeu? " + atendeu);
        //Não continuar tocando
        return ! atendeu;
    }
}
