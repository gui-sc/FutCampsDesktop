
package model.bean;

public class Campeonato {
    private int id;
    private String regras;
    private String nome;
    private String local;
    private int ano;
    private String premiacao;
    private int numTimes;
    private int numGrupos;
    private boolean faseDeGrupos;
    private boolean oitavas;
    private boolean quartas;
    private boolean semi;
    private boolean Final;
    private Time campeao;
    private Time viceCampeao;
    private int cabecasDeChave;
    private boolean iniciado;
    private boolean finalizado;
    private Jogador artilheiro;

    public boolean isOitavas() {
        return oitavas;
    }

    public void setOitavas(boolean oitavas) {
        this.oitavas = oitavas;
    }

    public boolean isQuartas() {
        return quartas;
    }

    public void setQuartas(boolean quartas) {
        this.quartas = quartas;
    }

    public boolean isSemi() {
        return semi;
    }

    public void setSemi(boolean semi) {
        this.semi = semi;
    }

    public boolean isFinal() {
        return Final;
    }

    public void setFinal(boolean Final) {
        this.Final = Final;
    }

    
    
    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Jogador getArtilheiro() {
        return artilheiro;
    }

    public void setArtilheiro(Jogador artilheiro) {
        this.artilheiro = artilheiro;
    }
    
    
    
    public boolean isIniciado() {
        return iniciado;
    }

    public void setIniciado(boolean iniciado) {
        this.iniciado = iniciado;
    }

    public int getCabecasDeChave() {
        return cabecasDeChave;
    }

    public void setCabecasDeChave(int cabecasDeChave) {
        this.cabecasDeChave = cabecasDeChave;
    }
    
    public Campeonato() {
    }

    public Campeonato(String regras, String nome, String local, String premiacao, int ano, int numTimes, int numGrupos, boolean faseDeGrupos) {
        this.regras = regras;
        this.nome = nome;
        this.local = local;
        this.premiacao = premiacao;
        this.ano = ano;
        this.numTimes = numTimes;
        this.numGrupos = numGrupos;
        this.faseDeGrupos = faseDeGrupos;
    }

    public Time getCampeao() {
        return campeao;
    }

    public void setCampeao(Time campeao) {
        this.campeao = campeao;
    }

    public Time getViceCampeao() {
        return viceCampeao;
    }

    public void setViceCampeao(Time viceCampeao) {
        this.viceCampeao = viceCampeao;
    }

    
    
    public boolean isFaseDeGrupos() {
        return faseDeGrupos;
    }

    public void setFaseDeGrupos(boolean faseDeGrupos) {
        this.faseDeGrupos = faseDeGrupos;
    }

    public int getNumGrupos() {
        return numGrupos;
    }

    public void setNumGrupos(int numGrupos) {
        this.numGrupos = numGrupos;
    }



    public int getNumTimes() {
        return numTimes;
    }

    public void setNumTimes(int numTimes) {
        this.numTimes = numTimes;
    }

    public String getRegras() {
        return regras;
    }

    public void setRegras(String regras) {
        this.regras = regras;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String cidade) {
        this.local = cidade;
    }

    public String getPremiacao() {
        return premiacao;
    }

    public void setPremiacao(String premiacao) {
        this.premiacao = premiacao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return nome +" "+ ano;
    }
    
}
