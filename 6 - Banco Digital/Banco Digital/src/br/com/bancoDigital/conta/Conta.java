package br.com.bancoDigital.conta;

import br.com.bancoDigital.exceptions.*;
import br.com.bancoDigital.model.cliente.Cliente;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements Iconta {
    // Constantes
    protected static final int AGENCIA_PADRAO = 1;
    protected static final LocalTime HORARIO_COMERCIAL_INICIO = LocalTime.of(9, 0);
    protected static final LocalTime HORARIO_COMERCIAL_FIM = LocalTime.of(18, 0);
    
    // Atributos básicos
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected TipoConta tipoConta;
    protected List<Transacao> historicoTransacoes;
    
    // Configurações específicas
    protected double taxaTransferencia;
    protected double limitePixDiario;
    protected double limiteSaqueDiario;
    protected double rendimentoMensal;

    public Conta(Cliente cliente, TipoConta tipoConta) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SequenceGenerator.getNext();
        this.cliente = cliente;
        this.tipoConta = tipoConta;
        this.historicoTransacoes = new ArrayList<>();
        configurarParametrosConta();
    }

    protected abstract void configurarParametrosConta();

    // Métodos principais
    @Override
    public void sacar(double valor) {
        validarValor(valor);
        verificarSaldo(valor);
        verificarLimiteSaque(valor);
        
        this.saldo -= valor;
        registrarTransacao("SAQUE", valor);
    }

    @Override
    public void depositar(double valor) {
        validarValor(valor);
        this.saldo += valor;
        registrarTransacao("DEPÓSITO", valor);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        validarValor(valor);
        validarContaDestino(contaDestino);
        verificarSaldo(valor + calcularTaxa(valor));
        
        double valorTotal = valor + calcularTaxa(valor);
        this.saldo -= valorTotal;
        contaDestino.depositar(valor);
        
        registrarTransacao("TRANSFERÊNCIA", valor);
    }

    @Override
    public void pix(double valor, Conta contaDestino) {
        validarValor(valor);
        validarContaDestino(contaDestino);
        verificarSaldo(valor);
        verificarLimitePix(valor);
        
        this.saldo -= valor;
        contaDestino.depositar(valor);
        
        registrarTransacao("PIX", valor);
    }

    // Métodos de validação
    protected void validarValor(double valor) {
        if (valor <= 0) {
            throw new ValorInvalidoException("Valor deve ser positivo");
        }
    }

    protected void verificarSaldo(double valor) {
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
    }

    protected void validarContaDestino(Conta contaDestino) {
        if (contaDestino == null) {
            throw new IllegalArgumentException("Conta destino inválida");
        }
        if (contaDestino.equals(this)) {
            throw new IllegalArgumentException("Não pode transferir para a mesma conta");
        }
    }

    protected void verificarLimitePix(double valor) {
        double totalPixHoje = calcularTotalOperacoesHoje("PIX");
        if (valor + totalPixHoje > limitePixDiario) {
            throw new LimiteExcedidoException("Limite diário de PIX excedido");
        }
    }

    protected void verificarLimiteSaque(double valor) {
        double totalSaquesHoje = calcularTotalOperacoesHoje("SAQUE");
        if (valor + totalSaquesHoje > limiteSaqueDiario) {
            throw new LimiteExcedidoException("Limite diário de saque excedido");
        }
    }

    // Métodos auxiliares
    protected double calcularTaxa(double valor) {
        return !isHorarioComercial() ? valor * taxaTransferencia : 0;
    }

    protected boolean isHorarioComercial() {
        LocalTime agora = LocalTime.now();
        return !agora.isBefore(HORARIO_COMERCIAL_INICIO) && !agora.isAfter(HORARIO_COMERCIAL_FIM);
    }

    protected double calcularTotalOperacoesHoje(String tipo) {
        LocalDateTime hoje = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        return historicoTransacoes.stream()
            .filter(t -> t.getTipo().equals(tipo) && t.getDataHora().isAfter(hoje))
            .mapToDouble(Transacao::getValor)
            .sum();
    }

    protected void registrarTransacao(String tipo, double valor) {
        historicoTransacoes.add(new Transacao(tipo, valor));
    }

    // Getters
    public int getAgencia() { return agencia; }
    public int getNumero() { return numero; }
    public double getSaldo() { return saldo; }
    public TipoConta getTipoConta() { return tipoConta; }
    public List<Transacao> getHistorico() { return new ArrayList<>(historicoTransacoes); }
}

// Classe auxiliar para geração de números sequenciais
class SequenceGenerator {
    private static int SEQUENCIAL = 1;
    public static synchronized int getNext() {
        return SEQUENCIAL++;
    }
}

// Classe para registro de transações
class Transacao {
    private String tipo;
    private double valor;
    private LocalDateTime dataHora;

    public Transacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }

    // Getters
    public String getTipo() { return tipo; }
    public double getValor() { return valor; }
    public LocalDateTime getDataHora() { return dataHora; }
}