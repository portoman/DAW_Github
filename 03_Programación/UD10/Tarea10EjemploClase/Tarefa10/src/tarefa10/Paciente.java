package tarefa10;

import java.time.LocalDate;

public class Paciente {
    private String nome;
    private String tarxeta;
    private LocalDate nacemento;

    public Paciente() {
    }

    public Paciente(String nome, String tarxeta, LocalDate nacemento) {
        this.nome = nome;
        this.tarxeta = tarxeta;
        this.nacemento = nacemento;
    }

    public LocalDate getNacemento() {
        return nacemento;
    }

    public void setNacemento(LocalDate nacemento) {
        this.nacemento = nacemento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTarxeta() {
        return tarxeta;
    }

    public void setTarxeta(String tarxeta) {
        this.tarxeta = tarxeta;
    }

    @Override
    public String toString() {
        return  nome + "-" + tarxeta + "-" + nacemento;
    }
    
    
}
