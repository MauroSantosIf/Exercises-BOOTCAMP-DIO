package NavegadorInternet;

public class NavegadorInternetImpl implements InavegadorInternet {

    // Estado interno para controle de abas abertas
    private int numeroAbasAbertas = 0;


    @Override
    public void abrirUrl(String url) {
        if(url == null || url.isBlank()){
            throw new IllegalArgumentException("URL inválida. A URL não pode ser nula ou vazia.");
        }
        System.out.println("Abrindo URL: " + url);
        novaAba();
    }

    @Override
    public void novaAba() {
        numeroAbasAbertas++;
        System.out.println("Abrindo nova aba. Total de abas abertas: " + numeroAbasAbertas);
    }

    @Override
    public void atualizar() {
        System.out.println("Atualizando página.");
    }

    // Método para fechar uma aba
    public void fecharAba() {
        if (numeroAbasAbertas > 0) {
            numeroAbasAbertas--;
            System.out.println("Fechando aba. Total de abas abertas: " + numeroAbasAbertas);
        } else {
            System.out.println("Nenhuma aba aberta para fechar.");
        }
    }

    public void fecharTodasAbas() {
        numeroAbasAbertas = 0;
        System.out.println("Todas as abas foram fechadas.");
    }
    
}
