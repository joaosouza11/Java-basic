package br.com.dio.variaveis;

public class tipos {

    public static void main(String[] args) {

        byte b1 = 10; //-128 to 127

        short s1 = 20000; //-32.768 to 32.767

        int i1 = -2000000000; //-2.147.483.648 to 2.147.483.647

        long l1 = -9000000000000000000L; //++9 quintillion

        float f1 = 4.5f; //Real number, 32 bit

        double d1 = 77.71f; //Real number, 64 bit

        char c1 = 'W';
        char c2 = '\u0057';
        String st1 = "Text";

        boolean bo1 = true;

        System.out.println(b1);
        System.out.println(s1);
        System.out.println(i1);
        System.out.println(l1);
        System.out.println(f1);
        System.out.println(d1);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(st1);
        System.out.println(bo1);
    }
}
