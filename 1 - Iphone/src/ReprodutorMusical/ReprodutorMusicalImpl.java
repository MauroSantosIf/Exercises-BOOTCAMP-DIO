//Nossa classe ReprodutorMusicalImpl implementa a interface ReprodutorMusical
package ReprodutorMusical;

public class ReprodutorMusicalImpl implements IReprodutorMusical {

    private String musica;
    private boolean estaTocando = false;

    @Override
    public void tocar() {
        if(musica == null) {
            System.out.println("Erro: Nenhuma Música selecionada.");
            return;
        }
        estaTocando = true;
        System.out.println("> Tocando: " + musica);
    }

    @Override
    public void pausar() {
        if(estaTocando){
            estaTocando = false;
            System.out.println("|| Música pausada");
        } 
    }

    @Override
    public void selecionarMusica(String musica) {
        if(musica == null || musica.isBlank()){
            throw new IllegalArgumentException("Nome da música inválida!");
        } 
        this.musica = musica;
        System.out.println("Música selecionada: " + musica);
    }

}
