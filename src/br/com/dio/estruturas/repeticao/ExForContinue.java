package br.com.dio.estruturas.repeticao;

public class ExForContinue {

    public static void main(String[] args){

        for(int numero = 1; numero <=5; numero ++){
            if(numero == 3)
                continue; //Não vai mostrar o 3

            System.out.println(numero);
        }

    }
}
