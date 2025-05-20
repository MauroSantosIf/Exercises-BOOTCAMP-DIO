package NavegadorInternet;

public interface InavegadorInternet {
    /*
     * Contraato para operações de um navegador de internet.
     */

    public void abrirUrl(String url) throws IllegalArgumentException;
    /*Exibe a página com a url fornecida. 
     * @param url Endereço da página (deve começar com "http://" ou "https://").
     * @throws IllegalArgumentException Se a URL for inválida.
    */

    public void novaAba();// Abre uma nova aba no navegador
    public void atualizar();// Atualiza a página atual do navegador

}
