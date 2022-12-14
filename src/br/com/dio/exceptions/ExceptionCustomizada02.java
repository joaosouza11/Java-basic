package br.com.dio.exceptions;

import javax.swing.*;

public class ExceptionCustomizada02 {
    public static void main(String[] args) {
     int[] numerador = {4, 5, 8, 10};
     int[] denominador = {2, 4, 0, 2, 8};

     for (int i = 0; i < denominador.length; i++) {
         try {
             if(numerador[i] % 2 != 0)
                 throw new DivisaoNaoExataException("Divisão não exata!", numerador[i], denominador[i]);
             int resultado = numerador[i] / denominador[i];
             System.out.println(resultado);
         } catch (DivisaoNaoExataException e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
             e.printStackTrace();
         } catch (ArithmeticException e) {
             JOptionPane.showMessageDialog(null, "Não é possível realizar a divisão com um denominador 0");
             e.printStackTrace();
         } catch (ArrayIndexOutOfBoundsException e) {
             JOptionPane.showMessageDialog(null, "Error. A quantidade de numeradores é diferente da quantidade de denominadores!");
             e.printStackTrace();
         }
     }

        System.out.println("O programa continua...");
    }
}
