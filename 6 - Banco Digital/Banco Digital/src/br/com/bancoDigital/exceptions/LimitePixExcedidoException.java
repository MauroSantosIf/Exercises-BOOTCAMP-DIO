package br.com.bancoDigital.exceptions;

public class LimitePixExcedidoException extends RuntimeException{
    public LimitePixExcedidoException(String mensagem){
        super(mensagem);
    }
}
