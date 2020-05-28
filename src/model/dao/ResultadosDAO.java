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
import model.bean.Campeonato;
import model.bean.ConnectionFactory;
import model.bean.Resultados;

/**
 *
 * @author Guilherme
 */
public class ResultadosDAO {
    public void inserir(Resultados res){
        Connection conn;
        try{
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO resultados "
                    + " (campeonato,campeao,viceCampeao,artilheiro) "
                    + " VALUES (?,?,?,?)");
            pstmt.setInt(1,res.getCampeonato().getId());
            pstmt.setInt(2,res.getCampeao().getId());
            pstmt.setInt(3,res.getViceCampeao().getId());
            pstmt.setInt(4,res.getArtilheiro().getId());
            pstmt.execute();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public Resultados buscar(Campeonato camp){
        Connection conn;
        try{
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM resultados"
                    + " WHERE campeonato = ?");
            pstmt.setInt(1,camp.getId());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                TimeDAO timeDAO = new TimeDAO();
                JogadorDAO jogadorDAO = new JogadorDAO();
                Resultados res = new Resultados();
                res.setCampeonato(camp);
                res.setCampeao(timeDAO.buscar(rs.getInt("campeao")));
                res.setViceCampeao(timeDAO.buscar(rs.getInt("viceCampeao")));
                res.setArtilheiro(jogadorDAO.buscar(rs.getInt("artilheiro")));
                return res;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
