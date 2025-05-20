package applications;
/**
 * Classe que representa uma conta bancária contendo número da conta, agência,
 * nome do cliente e saldo.
 * 
 * Contém uma sobrescrita do método toString para exibir uma mensagem amigável
 * com os dados cadastrados.
 */

public class ContaBanco {

    public int accountNumber;
    public String agency;
    public String customerName;
    public double balance;

    @Override
    public String toString() {
        return String.format(
            "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque.",
            customerName, agency, accountNumber, balance
        );
    }

}
