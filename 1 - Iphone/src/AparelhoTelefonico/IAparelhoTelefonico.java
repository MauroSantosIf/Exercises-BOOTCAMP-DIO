package AparelhoTelefonico;

public interface IAparelhoTelefonico {

    void ligar(String numero) throws IllegalArgumentException;
    void atender();
    void correioVoz(String mensagem);
    
}
