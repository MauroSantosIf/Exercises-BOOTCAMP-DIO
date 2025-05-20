package ReprodutorMusical;
   /*
    * Contrato para um reprodutor musical básico.
   */
   public interface IReprodutorMusical {
   void tocar();
   void pausar();
   void selecionarMusica(String musica) throws IllegalArgumentException;
}