package proposto03i;

import java.io.Serializable;

public class Persoa implements Serializable {
    private String nome;
    private int idade;

    public Persoa() {
    }

    public Persoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome + " (" + idade + ")";
    }
    
}