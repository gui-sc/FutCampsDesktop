package model.bean;


public class Time {

    private int id;
    private String nome;
    private String dirigente;
    private String cidade;
    private Campeonato campeonato;
    private int grupo;
    private int pontos;
    private boolean eliminado;
    private boolean primeiro;
    private boolean cabecaDeChave;
    private byte[] escudo;

    public byte[] getEscudo() {
        return escudo;
    }

    public void setEscudo(byte[] escudo) {
        this.escudo = escudo;
    }

    public boolean isCabecaDeChave() {
        return cabecaDeChave;
    }

    public void setCabecaDeChave(boolean cabecaDeChave) {
        this.cabecaDeChave = cabecaDeChave;
    }
    public Time() {
    }

    public boolean isPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(boolean primeiro) {
        this.primeiro = primeiro;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirigente() {
        return dirigente;
    }

    public void setDirigente(String dirigente) {
        this.dirigente = dirigente;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String Cidade) {
        this.cidade = Cidade;
    }

    public Time(String nome, String dirigente, String Cidade) {
        this.nome = nome;
        this.dirigente = dirigente;
        this.cidade = Cidade;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    @Override
    public String toString() {
        return nome;
    }

}
