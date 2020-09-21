package br.edu.uepb;

public class Turma {
    private int id;
    private String nome;
    private String turno;

    public int getId() {
        return id;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
