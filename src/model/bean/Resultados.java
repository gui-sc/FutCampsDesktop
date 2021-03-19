/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Guilherme
 */
public class Resultados {
    private Campeonato campeonato;
    private Time campeao;
    private Time viceCampeao;
    private Jogador artilheiro;

    public Resultados() {
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public void setCampeao(Time time) {
        campeao = time;
    }

    public void setViceCampeao(Time time) {
        viceCampeao = time;
    }

    public void setArtilheiro(Jogador jogador) {
        artilheiro = jogador;
    }

    public Time getCampeao() {
        return campeao;
    }

    public Time getViceCampeao() {
        return viceCampeao;
    }

    public Jogador getArtilheiro() {
        return artilheiro;
    }
}
