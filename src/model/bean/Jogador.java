package model.bean;

public class Jogador {

    private int documento;
    private String nome;
    private Time time;
    private String apelido;
    private int gols;
    private int ca;
    private int cv;
    private boolean suspenso;

    public Jogador() {
    }

    public Jogador(String nome, int rg, String posicao) {
        this.nome = nome;
        this.documento = rg;
        this.apelido = posicao;
    }

    public boolean isSuspenso() {
        return suspenso;
    }

    public void setSuspenso(boolean suspenso) {
        this.suspenso = suspenso;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
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
