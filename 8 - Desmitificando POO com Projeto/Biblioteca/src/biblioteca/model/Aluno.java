package biblioteca.model;

public class Aluno extends Usuario {

    private String curso;
    private String matricula;

     public Aluno(String nome, String cpf, String endereco, String telefone, String email, String curso, String matricula) {
        super(nome, cpf, endereco, telefone, email); // chama o construtor da classe pai
        this.curso = curso;
        this.matricula = matricula;
    }

    @Override
    protected double calcularMulta(int diasAtraso) {return diasAtraso * 1.0;}

    //getters e setters
    public String getCurso() {return curso;}

    public String getMatricula() {return matricula;}

    public void setCurso(String curso) {this.curso = curso;}
    
    
}
