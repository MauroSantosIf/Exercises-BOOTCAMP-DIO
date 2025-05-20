import AparelhoTelefonico.AparelhoTelefonico;
import NavegadorInternet.NavegadorInternetImpl;
import ReprodutorMusical.ReprodutorMusicalImpl;

public class Iphone {
    public static void main(String[] args) {

        AparelhoTelefonico aparelho = new AparelhoTelefonico();
        NavegadorInternetImpl navegar = new NavegadorInternetImpl();
        ReprodutorMusicalImpl reprodutor = new ReprodutorMusicalImpl();

        // Teste com  o objeto AparelhoTelefonico
        aparelho.ligar("(11) 98765-4321");
        aparelho.atender();
        aparelho.correioVoz("Olá, você ligou para mim!");
        System.out.println("------------------------------------------------------");

        // Teste com o objeto NavegadorInternetImpl
        navegar.abrirUrl("https://www.google.com");
        navegar.abrirUrl("https://www.github.com");
        navegar.fecharAba();
        navegar.fecharTodasAbas();
        navegar.atualizar();
        navegar.abrirUrl("https:.//www.youtube.com");
        System.out.println("------------------------------------------------------");
        

        // Teste com o objeto ReprodutorMusicalImpl
        reprodutor.selecionarMusica("Bastille - Good Grief");
        reprodutor.tocar();
        reprodutor.pausar();

        


    }
    
}
