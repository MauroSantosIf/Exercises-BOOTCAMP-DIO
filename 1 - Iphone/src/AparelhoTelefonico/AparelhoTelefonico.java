package AparelhoTelefonico;

public class AparelhoTelefonico implements IAparelhoTelefonico {

    // Estado interno para saber se está em chamada
    private boolean emChamada = false;

    @Override
    public void ligar(String numero) {
        if (numero == null) {
            throw new IllegalArgumentException("Número não pode ser nulo.");
        }
    
        numero = numero.replaceAll("\\D", ""); // mantém apenas dígitos
    
        if (!numero.matches("\\d{10,11}")) {
            throw new IllegalArgumentException("Número inválido. O número deve conter 10 ou 11 dígitos numéricos.");
        }
    
        System.out.println("Ligando para " + formatarNumero(numero) + "...");
        this.emChamada = true;
    }

    @Override
    public void atender() {
        if (!emChamada) {
            System.out.println("Nenhuma chamada para atender.");
        } else {
            System.out.println("Chamada atendida.");
        }
        this.emChamada = true;
    }

    @Override
    public void correioVoz(String mensagem) {
        if (mensagem == null || mensagem.isBlank()) {
            System.out.println("Mensagem de correio de voz está vazia.");
        } else {
            System.out.println("Mensagem de correio de voz: " + mensagem);
        }
    }

    // Método auxiliar para formatar número no padrão brasileiro
    private String formatarNumero(String numero) {
        String ddd = numero.substring(0, 2);
        String parte1, parte2;

        if (numero.length() == 11) {
            // Formato para celular: (11) 98765-4321
            parte1 = numero.substring(2, 7);
            parte2 = numero.substring(7);
        } else {
            // Formato para telefone fixo: (11) 1234-5678
            parte1 = numero.substring(2, 6);
            parte2 = numero.substring(6);
        }

        return "(" + ddd + ") " + parte1 + "-" + parte2;
    }
}
