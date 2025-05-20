import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    
    public static void main(String[] argumentos) {
        String[] candidatos = {"João", "Maria", "José", "Ana", "Pedro"};
        for(String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }
    
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            System.out.printf("Tentativa %d de contato com %s\n", tentativasRealizadas, candidato);
            atendeu = atender();
            if (atendeu) {
                System.out.println("O CONSEGUIMOS CONTATO COM " + candidato + " na " + tentativasRealizadas + " tentativa.");
                continuarTentando = false;
            } else {
                System.out.println("O candidato "+ candidato + " não atendeu a ligação.");
                tentativasRealizadas++;
            }
        } while (continuarTentando && tentativasRealizadas < 3);
        
        if (!atendeu) {
            System.out.printf("Não conseguimos contato com %s após %d tentativas\n", candidato, tentativasRealizadas-1);
        }
    }

    // Método Auxiliar
    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados() {
        String[] candidatos = {"João", "Maria", "José", "Ana", "Pedro"};

        for(int indice = 0; indice < candidatos.length; indice++) {
            System.out.printf("O candidato de número %d é %s\n", (indice+1), candidatos[indice]);
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"João", "Maria", "José", "Ana", "Pedro"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.00;
        
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = gerarSalarioPretendido();

            System.out.printf("Candidato: %s - Salário Pretendido: %.2f\n", candidato, salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                candidatosSelecionados++;
                System.out.printf("O candidato %s foi selecionado.\n", candidato);
            }
            candidatosAtual++;
        }
    }

    static double gerarSalarioPretendido() {
        // Gera um salário entre 1000 e 5000
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    // Método para analisar candidatos
    static void analisarCandidatos(double salarioPretendido) {
        double salarioBase = 2000.00;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM OUTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS OUTROS CANDIDATOS");
        }
    }
}