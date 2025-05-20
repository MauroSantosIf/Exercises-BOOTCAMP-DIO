package br.com.bancoDigital.exceptions;

public class HorarioInvalidoException extends RuntimeException{
    public HorarioInvalidoException(String mensagem){
        super(mensagem);
    }
}
