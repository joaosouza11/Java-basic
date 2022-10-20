package br.com.dio.poo.estrutura;

class Carro {

    String cor;
    String modelo;
    int capacidadeTanque;


    //Construtor

    Carro() {

    }

    Carro(String cor, String modelo, Integer capacidadeTanque) {
        this.cor = cor;
        this.modelo = modelo;
        this.capacidadeTanque = capacidadeTanque;
    }

    //Get & Set

    String getCor() {
        return cor;
    }

    void setCor(String cor) {
        this.cor = cor;
    }

    String getModelo() {
        return modelo;
    }

    void setModelo(String modelo) {
        this.modelo = modelo;
    }

    Integer getCapacidadeTanque() {
        return capacidadeTanque;
    }

    void setCapacidadeTanque(Integer capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    //Método para encher o tanque

    double totalValorTanque(double valorCombustivel) {
        return capacidadeTanque * valorCombustivel;
    }

}
