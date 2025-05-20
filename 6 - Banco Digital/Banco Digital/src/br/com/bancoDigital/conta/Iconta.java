package br.com.bancoDigital.conta;

public interface Iconta {

    
    void sacar(double valor);
    void depositar(double valor);
    void transferir(double valor, Conta contaDestino);
    void imprimirExtrato();
     void pix(double valor, Conta contaDestino);

}
