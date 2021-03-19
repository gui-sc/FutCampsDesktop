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
import model.bean.CAmarelo;
import model.bean.ConnectionFactory;
import model.bean.Jogador;
import model.bean.Partida;

/**
 *
 * @author Cliente
 */
public class CAmareloDAO {

    public void inserir(Jogador jogador, Partida partida) {
        Connection conn;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO amarelo(jogador,time,partida)"
                    + " VALUES (?,?,?)");
            pstmt.setInt(1, jogador.getId());
            pstmt.setInt(2, jogador.getTime().getId()); 
            pstmt.setInt(3, partida.getId());
            pstmt.execute();
        } catch (SQLException ex) {

        }
    }

    public List<CAmarelo> listar(Partida partida) {
        Connection conn;
        List<CAmarelo> amarelos = new ArrayList();
        JogadorDAO jogadorDAO = new JogadorDAO();
        TimeDAO timeDAO = new TimeDAO();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT distinct * FROM amarelo"
                    + " WHERE partida=?");
            pstmt.setInt(1, partida.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CAmarelo amarelo = new CAmarelo();
                amarelo.setJogador(jogadorDAO.buscar(rs.getInt("jogador")));
                amarelo.setPartida(partida);
                amarelo.setTime(timeDAO.buscar(rs.getInt("time")));
                amarelos.add(amarelo);
            }
        } catch (SQLException ex) {

        }
        return amarelos;
    }
}
