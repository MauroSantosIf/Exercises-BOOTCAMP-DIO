package biblioteca.model;

public class Professor extends Usuario{
    

    public Professor(String nome, String cpf, String endereco, String telefone, String email) {
        super(nome, cpf, endereco, telefone, email);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected double calcularMulta(int diasAtraso) {return diasAtraso * 0.50;}

}
