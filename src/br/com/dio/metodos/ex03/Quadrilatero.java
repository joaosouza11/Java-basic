package br.com.dio.metodos.ex03;

//Aula de Métodos - exercício 03

//Retornos
public class Quadrilatero {

    //Quadrado
    public static double area(double lado) {

        return lado * lado;
    }

    //Retângulo
    public static double area(double lado1, double lado2) {

        return lado1 * lado2;
    }

    //Trapézio
    public static double area(double baseMaior, double baseMenor, double altura) {

        return ((baseMaior + baseMenor) * altura) / 2;
    }

}
