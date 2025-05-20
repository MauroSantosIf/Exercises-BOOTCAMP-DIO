package users;

import java.util.Scanner;
import applications.ContaBanco;
/**
 * <h1>Sistema de Abertura de Conta Bancária</h1>
 * Este sistema simula a criação de uma conta bancária a partir da entrada de dados do usuário.
 * <p>
 * <b>Note:</b> Certifique-se de preencher corretamente as informações solicitadas para garantir
 * que sua conta seja criada com sucesso.
 *
 * @author  Mauro Santos
 * @since   17/04/2025
 */

public class ContaTerminal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ContaBanco account = new ContaBanco();
        
        System.out.println("Please enter your name: ");
        account.customerName = sc.nextLine();

        System.out.println("Please enter your agency: ");
        account.agency = sc.nextLine();

        System.out.println("enter account number: ");
        account.accountNumber = sc.nextInt();
        sc.nextLine();// Consumir o caractere de nova linha deixado por nextInt()

        System.out.println("Please enter your initial balance: ");
        account.balance = sc.nextDouble();
        sc.close();
        System.out.println(account);
    }
}
