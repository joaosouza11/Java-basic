package br.com.dio.metodos.ex01;

// Classe principal da Aula de Métodos - exercício 01

public class Main {

    public static void main(String[] args) {

        //Calculadora
        System.out.println("Exercício calculadora");
        Calculadora.soma(5,2);
        Calculadora.subtracao(5.5,2.4);
        Calculadora.multiplicacao(5,2);
        Calculadora.divisao(5,2);

        //Mensagem
        System.out.println("\nExercício de mensagem");
        Mensagem.obterMensagem(8);
        Mensagem.obterMensagem(14);
        Mensagem.obterMensagem(21);
        Mensagem.obterMensagem(25);

        //Empréstimo
        System.out.println("\nExercício de empréstimo");
        Emprestimo.calcular(1000, Emprestimo.getDuasParcelas());
        Emprestimo.calcular(1000, Emprestimo.getTresParcelas());
        Emprestimo.calcular(1000,2);
        Emprestimo.calcular(1000,7);

    }

}
