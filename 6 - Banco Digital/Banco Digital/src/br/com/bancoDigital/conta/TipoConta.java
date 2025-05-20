package br.com.bancoDigital.conta;

public enum TipoConta {
    
    CONTA_CORRENTE("Conta Corrente"),
    CONTA_POUPANCA("Conta Poupança"),
    CONTA_EMPRESARIAL("Conta Empresarial");
    
    private final String descricao;
    
    TipoConta(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}