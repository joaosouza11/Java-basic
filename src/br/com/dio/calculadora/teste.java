package br.com.dio.calculadora;

import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        int num = Integer.parseInt(new Scanner(System.in).nextLine());
        var count = 0;

        for (var i = 1; i <= num; i++) {
            var strNum = String.valueOf(i);
            if (strNum.length() == 1)
            {
                if (i % 2 == 0)
                {
                    count++;
                }
                continue;
            }

            char[] vs = strNum.toCharArray();
            var sum = 0;
            for (char v : vs) {
                sum += (int) Character.getNumericValue(v);
            }
            if (sum % 2 == 0)
            {
                count++;
            }
        }
        System.out.println(count);

        }
    }