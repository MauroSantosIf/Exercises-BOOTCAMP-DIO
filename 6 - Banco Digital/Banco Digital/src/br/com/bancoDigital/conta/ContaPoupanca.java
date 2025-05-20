package br.com.bancoDigital.conta;

import br.com.bancoDigital.model.cliente.Cliente;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente, TipoConta.CONTA_POUPANCA);
    }

    @Override
    protected void configurarParametrosConta() {
        this.taxaTransferencia = 0.0;
        this.limitePixDiario = 1000.00;
        this.limiteSaqueDiario = 1000.00;
        this.rendimentoMensal = 0.005;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n=== Extrato da Conta Poupança ===");
        
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("Rendimento mensal: " + formatoMoeda.format(this.saldo * this.rendimentoMensal));
        System.out.println("Limite PIX diário: " + formatoMoeda.format(this.limitePixDiario));
        System.out.println("----------------------------------");
        
        System.out.println("\nHistórico de Transações:");
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.historicoTransacoes.forEach(transacao -> 
            System.out.println(
                transacao.getDataHora().format(formatoData) + " - " +
                transacao.getTipo() + ": " + 
                formatoMoeda.format(transacao.getValor())
        ));
    }

    private void imprimirInfosComuns() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimirInfosComuns'");
    }

    public void aplicarRendimentoMensal() {
        double rendimento = this.saldo * this.rendimentoMensal;
        this.saldo += rendimento;
        registrarTransacao("RENDIMENTO", rendimento);
    }
}