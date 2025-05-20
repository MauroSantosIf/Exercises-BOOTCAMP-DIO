package br.com.bancoDigital;

import br.com.bancoDigital.conta.Conta;
import br.com.bancoDigital.conta.ContaCorrente;
import br.com.bancoDigital.conta.ContaPoupanca;
import br.com.bancoDigital.model.cliente.Cliente;

public class App {
    public static void main(String[] args) {

         // 1. Criação de clientes
        Cliente cliente1 = new Cliente("João Silva", "123.456.789-00");
        Cliente cliente2 = new Cliente("Maria Souza", "987.654.321-00");
        Cliente cliente3 = new Cliente("Mauro Santos", "114.740.604-98");
        
        // 2. Criação de contas
        Conta cc = new ContaCorrente(cliente1);
        Conta cp = new ContaPoupanca(cliente2);
        Conta corrente = new ContaCorrente(cliente3);
        
        // 3. Operações bancárias
        cc.depositar(1000);
        cc.transferir(200, cp);
        
        cp.depositar(500);
        ((ContaPoupanca) cp).aplicarRendimentoMensal();
        
        // 4. Gerenciamento de cartão
        ((ContaCorrente) cc).gerenciarCartaoCredito(true);
        
        // 5. Impressão de extratos
        System.out.println("\n=== Movimentações Bancárias ===");
        cc.imprimirExtrato();
        cp.imprimirExtrato();

        corrente.depositar(500);
        corrente.depositar(5000);
        corrente.sacar(2000);

        ((ContaCorrente) corrente).gerenciarCartaoCredito(true);
        corrente.imprimirExtrato();




    }
}
