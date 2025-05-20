package user;

import entities.ParametrosInvalidosExcepetion;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Contador {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Digite o primeiro número: ");
            int num1 = sc.nextInt();
            System.out.println("Digite o segundo número: ");
            int num2 = sc.nextInt();

            if(num1 > num2){
                throw new ParametrosInvalidosExcepetion();
            }
            int diferenca = num2 - num1;

            for(int i = 1; i <= diferenca; i++){
                System.out.println("Imprimindo o número: " + (i));
            }
            
        } catch (ParametrosInvalidosExcepetion e) {
            System.out.println(e.toString());
        } catch (InputMismatchException e) {
            System.out.println("Erro: Por favor, digite apenas números inteiros válidos.");
        }
        catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getClass().getSimpleName());
        }finally {
            sc.close();
        }


    }
}
