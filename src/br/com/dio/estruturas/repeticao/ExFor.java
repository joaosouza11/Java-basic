package br.com.dio.estruturas.repeticao;

public class ExFor {

    public static void main(String[] args) {

        System.out.print("Contando carneirinhos: ");

        for(int carneirinhos = 1; carneirinhos <=20; carneirinhos ++) {
            if (carneirinhos == 1)
                System.out.print(carneirinhos);
            else
                System.out.print("..." + carneirinhos);
        }
    }
}
