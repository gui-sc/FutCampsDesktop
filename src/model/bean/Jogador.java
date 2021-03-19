package model.bean;

import java.sql.Date;

public class Jogador {

    private int id;
    private String nome;
    private Time time;
    private String apelido;
    private int gols;
    private int ca;
    private int cv;
    private boolean suspenso;
    private Date dataNasc;
    private boolean pendurado;

    public Jogador() {
    }

    public Jogador(String nome, String posicao) {
        this.nome = nome;
        this.apelido = posicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public boolean isPendurado() {
        return pendurado;
    }

    public void setPendurado(boolean pendurado) {
        this.pendurado = pendurado;
    }

    
    
    public boolean isSuspenso() {
        return suspenso;
    }

    public void setSuspenso(boolean suspenso) {
        this.suspenso = suspenso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return apelido;
    }

}
