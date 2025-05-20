package br.com.bancoDigital.exceptions;

public class ValorInvalidoException extends RuntimeException{
    public ValorInvalidoException(String mensagem){
        super(mensagem);
    }
}
