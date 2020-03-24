package model.bean;

public class Partida {

    private int id;
    private int placarMandante;
    private int placarVisitante;
    private String local;
    private String data;
    private Time mandante;
    private Time visitante;
    private Campeonato campeonato;
    private String observacoes;
    private String fase;
    private boolean cadastrada;
    private int penaltisMandante;
    private int penaltisVisitante;

    public int getPenaltisMandante() {
        return penaltisMandante;
    }

    public void setPenaltisMandante(int penaltisMandante) {
        this.penaltisMandante = penaltisMandante;
    }

    public int getPenaltisVisitante() {
        return penaltisVisitante;
    }

    public void setPenaltisVisitante(int penaltisVisitante) {
        this.penaltisVisitante = penaltisVisitante;
    }

    
    public boolean isCadastrada() {
        return cadastrada;
    }

    public void setCadastrada(boolean cadastrada) {
        this.cadastrada = cadastrada;
    }
    
    

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public Partida() {
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Time getMandante() {
        return mandante;
    }

    public void setMandante(Time mandante) {
        this.mandante = mandante;
    }

    public Time getVisitante() {
        return visitante;
    }

    public void setVisitante(Time visitante) {
        this.visitante = visitante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato camp) {
        this.campeonato = camp;
    }

    public int getPlacarMandante() {
        return placarMandante;
    }

    public void setPlacarMandante(int placarMandante) {
        this.placarMandante = placarMandante;
    }

    public int getPlacarVisitante() {
        return placarVisitante;
    }

    public void setPlacarVisitante(int placarVisitante) {
        this.placarVisitante = placarVisitante;
    }

    @Override
    public String toString() {
        return mandante.getNome() + placarMandante + "x" + placarVisitante + visitante.getNome();
    }

}
