package br.com.dio.poo.relacao.ex02;

public class RodarAplicacao {

    public static void main(String[] args) {

        Funcionario funcionario = new Gerente();

        Funcionario gerente = new Gerente();
        Funcionario faxineiro = new Faxineiro();
        Funcionario vendedor = new Vendedor();

        //Downcast
        Vendedor vendedor_ = (Vendedor) new Funcionario();

    }
}
