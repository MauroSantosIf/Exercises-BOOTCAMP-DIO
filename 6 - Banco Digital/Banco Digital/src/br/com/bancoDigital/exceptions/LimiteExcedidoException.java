package br.com.bancoDigital.exceptions;

public class LimiteExcedidoException extends RuntimeException {
    
    // Construtor básico
    public LimiteExcedidoException(String message) {
        super(message);  // Chama o construtor da classe pai (RuntimeException)
    }
    
    // Construtor com informações adicionais (opcional)
    public LimiteExcedidoException(String tipoLimite, double limite, double valorTentado) {
        super(String.format("Limite de %s excedido! Limite: R$%.2f | Valor tentado: R$%.2f", 
              tipoLimite, limite, valorTentado));
    }
}