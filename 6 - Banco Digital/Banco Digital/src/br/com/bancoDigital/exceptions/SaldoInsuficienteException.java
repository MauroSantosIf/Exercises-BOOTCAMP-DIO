package br.com.bancoDigital.exceptions;

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(String mensagem){
        super(mensagem);
    }
}
