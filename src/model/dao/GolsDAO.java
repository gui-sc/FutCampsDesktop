/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.ConnectionFactory;
import model.bean.Gols;
import model.bean.Jogador;
import model.bean.Partida;

/**
 *
 * @author Cliente
 */
public class GolsDAO {

    public void inserir(Jogador jogador, Partida partida) {
        Connection conn;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO gols(jogador,partida,time)"
                    + " VALUES (?,?,?)");
            pstmt.setInt(1, jogador.getDocumento());
            pstmt.setInt(2, partida.getId());
            pstmt.setInt(3, jogador.getTime().getId());
            pstmt.execute();
        } catch (SQLException ex) {

        }
    }
    
    public List<Gols> listar(Partida partida){
        Connection conn;
        List<Gols> gols = new ArrayList();
        JogadorDAO jogadorDAO = new JogadorDAO();
        TimeDAO timeDAO = new TimeDAO();
        try{
            conn=new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT distinct * FROM gols"
                    + " WHERE partida = ?");
            pstmt.setInt(1,partida.getId());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Gols gol = new Gols();
                gol.setJogador(jogadorDAO.buscar(rs.getInt("jogador")));
                gol.setPartida(partida);
                gol.setTime(timeDAO.buscar(rs.getInt("time")));
                gols.add(gol);
            }
        }catch(SQLException ex){
            
        }
        return gols;
    }
}
