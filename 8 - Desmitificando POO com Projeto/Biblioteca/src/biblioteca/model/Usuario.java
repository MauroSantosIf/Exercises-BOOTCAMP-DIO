package biblioteca.model;

import java.util.function.Function;

public abstract class Usuario {

    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;

    public Usuario(String nome, String cpf, String endereco, String telefone, String email) {
        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new IllegalArgumentException("CPF inválido");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }

        if(!telefone.matches("\\(\\d{2}\\)\\s?9\\d{4}-\\d{4}") && !telefone.matches("\\d{11}")){
            throw new IllegalArgumentException("Telefone inválido");
        }

        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        
    }

    // Métodos abstratos
    protected abstract double calcularMulta(int diasAtraso);
    
    public Function<Integer, Double>getCalculadoraMulta(){
        return this::calcularMulta;
    }

    

    // getters para todos os atributos
    public String getNome() {return nome;}

    public String getCpf() {return cpf;}

    public String getEndereco() {return endereco;}

    public String getTelefone() {return telefone;}

    public String getEmail() {return email;}

    // setters apenas para atributos julgados como mutáveis
    public void setEndereco(String endereco) {this.endereco = endereco;}

    public void setTelefone(String telefone) {this.telefone = telefone;}

    public void setEmail(String email) {this.email = email;}

    

}
