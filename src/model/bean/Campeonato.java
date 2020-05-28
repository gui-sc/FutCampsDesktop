package model.bean;

public class Campeonato {

    private int id;
    private String formato;
    private String nome;
    private String cidade;
    private int ano;
    private int classificados;
    private String premiacao;
    private int numTimes;
    private int numGrupos;
    private boolean faseDeGrupos;
    private boolean oitavas;
    private boolean quartas;
    private boolean semi;
    private boolean Final;
    private int cabecasDeChave;
    private boolean iniciado;
    private boolean finalizado;
    private boolean zerarCartoesOitavas;
    private boolean zerarCartoesQuartas;
    private boolean zerarCartoesSemi;
    private int cartoesPendurado;

    public int getClassificados() {
        return classificados;
    }

    public void setClassificados(int classificados) {
        this.classificados = classificados;
    }

    public boolean isZerarCartoesOitavas() {
        return zerarCartoesOitavas;
    }

    public void setZerarCartoesOitavas(boolean zerarCartoesOitavas) {
        this.zerarCartoesOitavas = zerarCartoesOitavas;
    }

    public boolean isZerarCartoesQuartas() {
        return zerarCartoesQuartas;
    }

    public void setZerarCartoesQuartas(boolean zerarCartoesQuartas) {
        this.zerarCartoesQuartas = zerarCartoesQuartas;
    }

    public boolean isZerarCartoesSemi() {
        return zerarCartoesSemi;
    }

    public void setZerarCartoesSemi(boolean zerarCartoesSemi) {
        this.zerarCartoesSemi = zerarCartoesSemi;
    }

    public int getCartoesPendurado() {
        return cartoesPendurado;
    }

    public void setCartoesPendurado(int cartoesPendurado) {
        this.cartoesPendurado = cartoesPendurado;
    }

    
    
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
        this.formato = regras;
        this.nome = nome;
        this.cidade = local;
        this.premiacao = premiacao;
        this.ano = ano;
        this.numTimes = numTimes;
        this.numGrupos = numGrupos;
        this.faseDeGrupos = faseDeGrupos;
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

    public String getFormato() {
        return formato;
    }

    public void setFormato(String regras) {
        this.formato = regras;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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
        return nome + " " + ano;
    }

}
