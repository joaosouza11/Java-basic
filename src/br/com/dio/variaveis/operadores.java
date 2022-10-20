package br.com.dio.variaveis;

public class operadores {

    public static void main(String[] args) {

        System.out.println("PrePos");
        prePos();
        System.out.println("\nAritmético");
        aritmetico();
        System.out.println("\nAtribuição");
        atribuicao();
        System.out.println("\nPrecedencia");
        precendecia();
    }

    private static void prePos() {

        int k = 10;

        int i = ++k;
        int j = k++; //j assume 11 e adiciona 1 no k, totalizando 12
        int x = k;

        System.out.println("i: " + i);
        System.out.println("j: " + j);
        System.out.println("x: " + x);
    }

    private static void aritmetico() {

        int a = 5;
        int b = 2;

        int r1 = a+b;
        int r2 = a-b;
        int r3 = a*b;
        int r4 = a/b;
        int r5 = a%b;

        System.out.println("a+b: " + r1);
        System.out.println("a-b: " + r2);
        System.out.println("a*b: " + r3);
        System.out.println("a/b: " + r4);
        System.out.println("a%b: " + r5);

    }

    private static void atribuicao() {

        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;
        int e = 50;

        a += 5; //a = a + 5
        b -= 4; //b = b - 4
        c *= 2; //c = c * 2
        d /= 4; //d = d / 4
        e %= 5; //e = e % 5

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("d: " + d);
        System.out.println("e: " + e);

    }

    private static void precendecia() {

        int i = 10;
        int j = 20;
        int k = 30;

        int a = i++ + --j * k; // 10 + 19 * 30

        System.out.println("i++ + --j * k: " + a);
        System.out.println("i: " + i); //11

        int b = k / --i % 2 + 1; // 30 / 10 % 2 + 1

        System.out.println("k / --i % 2 + 1: " + b);
        System.out.println("i: " + i); //10
        System.out.println("b: \n" + b);

        b *= i += 5; //b = 2 * i  ->  i = i + 5  ->  i = 10 + 5; i = 15  ->  b = 2 * 15; b = 15
        System.out.println("b *= i += 5: " + b);
    }
}
