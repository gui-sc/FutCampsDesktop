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
import model.bean.CVermelho;
import model.bean.ConnectionFactory;
import model.bean.Jogador;
import model.bean.Partida;

/**
 *
 * @author Cliente
 */
public class CVermelhoDAO {
    public void inserir(Jogador jogador,Partida partida){
        Connection conn;
        try{
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO vermelho (jogador,time,partida)"
                    + " VALUES (?,?,?)");
            pstmt.setInt(1, jogador.getId());
            pstmt.setInt(2, jogador.getTime().getId());
            pstmt.setInt(3, partida.getId());
            
            pstmt.execute();
        }catch(SQLException ex){
            
        }    
    }
    public List<CVermelho> listar(Partida partida){
        Connection conn;
        List<CVermelho> vermelhos = new ArrayList();
        JogadorDAO jogadorDAO = new JogadorDAO();
        TimeDAO timeDAO = new TimeDAO();
        try{
            conn= new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT distinct * FROM c_vermelho"
                    + " WHERE partida=?");
            pstmt.setInt(1, partida.getId());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                CVermelho vermelho = new CVermelho();
                vermelho.setJogador(jogadorDAO.buscar(rs.getInt("jogador")));
                vermelho.setPartida(partida);
                vermelho.setTime(timeDAO.buscar(rs.getInt("time")));
                vermelhos.add(vermelho);
            }
        }catch(SQLException ex){
            
        }
        return vermelhos;
    }
}
