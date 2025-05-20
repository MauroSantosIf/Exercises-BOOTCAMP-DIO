package entities;

public class ParametrosInvalidosExcepetion extends Exception {
    @Override
    public String toString() {
        return "O segungo valor deve ser maior que o primeiro.";
    }
}
