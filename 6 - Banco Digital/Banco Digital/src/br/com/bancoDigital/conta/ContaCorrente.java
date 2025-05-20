package br.com.bancoDigital.conta;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import br.com.bancoDigital.model.cliente.Cliente;


public class ContaCorrente extends Conta {
    
    private double chequeEspecial;
    private boolean cartaoCreditoAtivo;

    public ContaCorrente(Cliente cliente) {
        super(cliente, TipoConta.CONTA_CORRENTE);
    }

    @Override
    protected void configurarParametrosConta() {
        this.taxaTransferencia = 0.01;
        this.limitePixDiario = 5000.00;
        this.limiteSaqueDiario = 2000.00;
        this.chequeEspecial = 1000.00;
        this.cartaoCreditoAtivo = false; // Valor padrão ao criar conta
    }

    // Método para ativar/desativar cartão
    public void gerenciarCartaoCredito(boolean ativo) {
        this.cartaoCreditoAtivo = ativo;
        registrarTransacao("CARTAO_" + (ativo ? "ATIVADO" : "DESATIVADO"), 0);
    }

    // Método para verificar status
    public boolean isCartaoCreditoAtivo() {
        return cartaoCreditoAtivo;
    }

    @Override
    public void imprimirExtrato() {
    NumberFormat fmt = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    System.out.println("\n══════════════ EXTRATO BANCÁRIO ══════════════");
    System.out.println("┌──────────────────────────────────────────────┐");
    System.out.println("│ " + this.cliente.getNome() + " - " + this.tipoConta.getDescricao() + "       │");
    System.out.println("│ Ag: " + this.agencia + "  C/C: " + this.numero + "               │");
    System.out.println("│ Data: " + LocalDateTime.now().format(dtf) + "    │");
    System.out.println("├──────────────────────────────────────────────┤");
    System.out.println("│ SALDO ATUAL: " + String.format("%28s", fmt.format(this.saldo)) + " │");
    System.out.println("│                                              │");
    System.out.println("│ CARTAÕ CRÉDITO: " + 
        (cartaoCreditoAtivo ? "Ativo " : "Inativo ") + 
        String.format("%" + (25 - (cartaoCreditoAtivo ? 7 : 8)) + "s", "") + "│");
    System.out.println("│ CHEQUE ESPECIAL: " + String.format("%26s", fmt.format(this.chequeEspecial)) + " │");
    System.out.println("│ LIMITE PIX DIÁRIO: " + String.format("%23s", fmt.format(this.limitePixDiario)) + " │");
    System.out.println("└──────────────────────────────────────────────┘");
    
    System.out.println("\nÚLTIMAS TRANSAÇÕES:");
    System.out.println("┌──────────────────────────────┬───────────────┐");
    System.out.println("│ Data/Hora                   │ Valor         │");
    System.out.println("├──────────────────────────────┼───────────────┤");
    
    this.historicoTransacoes.stream()
        .limit(10)
        .forEach(t -> System.out.println(
            "│ " + t.getDataHora().format(dtf) + " │ " + 
            String.format("%13s", fmt.format(t.getValor())) + " │"
        ));
    
    System.out.println("└──────────────────────────────┴───────────────┘");
    System.out.println("═══════════════════════════════════════════════\n");
    }

    // Novo método para cobrar anuidade
    public void cobrarAnuidadeCartao() {
        if (cartaoCreditoAtivo) { // Usando o campo
            double anuidade = 150.00;
            if (this.saldo >= anuidade) {
                this.sacar(anuidade);
                registrarTransacao("ANUIDADE CARTAO", anuidade);
            }
        }
    }
}