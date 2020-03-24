package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Campeonato;
import model.bean.Partida;
import model.bean.ConnectionFactory;

public class PartidaDAO {

    public void cadastrarPrevia(Partida partida) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO partida (mandante, visitante,campeonato,fase) "
                    + "VALUES (?,?,?,?)");
            pstmt.setInt(1, partida.getMandante().getId());
            pstmt.setInt(2, partida.getVisitante().getId());
            pstmt.setInt(3, partida.getCampeonato().getId());
            pstmt.setString(4, partida.getFase());
            
            pstmt.execute();

        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    }
    public void cadastrarCompleto(Partida partida){
        Connection conn=null;
        try{
            conn=new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE partida SET"
                    + " placarMandante = ?, placarVisitante = ?, local=?,data=?,obs=?, penaltisMandante=?,penaltisVisitante=?, cadastrada=1"
                    + " where id = ?");
            pstmt.setInt(1, partida.getPlacarMandante());
            pstmt.setInt(2, partida.getPlacarVisitante());
            pstmt.setString(3, partida.getLocal());
            pstmt.setString(4, partida.getData());
            pstmt.setString(5, partida.getObservacoes());
            pstmt.setInt(6, partida.getPenaltisMandante());
            pstmt.setInt(7, partida.getPenaltisVisitante());
            pstmt.setInt(8, partida.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Partida Cadastrada com Sucesso!");
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void excluir(int id) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM partida " + "WHERE id = ?");
            pstmt.setInt(1, id);
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "partida excluída com sucesso");
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    }

    public Partida buscar(int id) {
        Connection conn = null;
        Partida selPartida = new Partida();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM partida " + "WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                
                TimeDAO time = new TimeDAO();
                CampeonatoDAO campDAO = new CampeonatoDAO();
                selPartida.setMandante(time.buscar(rs.getInt("mandante")));
                selPartida.setVisitante(time.buscar(rs.getInt("visitante")));
                selPartida.setPlacarMandante(rs.getInt("placarMandante"));
                selPartida.setPlacarVisitante(rs.getInt("placarVisitante"));
                selPartida.setPenaltisMandante(rs.getInt("penaltisMandante"));
                selPartida.setPenaltisVisitante(rs.getInt("penaltisVisitante"));
                selPartida.setLocal(rs.getString("local"));
                selPartida.setData(rs.getString("data"));
                selPartida.setId(rs.getInt("id"));
                selPartida.setCadastrada(rs.getBoolean("cadastrada"));
                selPartida.setCampeonato(campDAO.buscar(rs.getInt("campeonato")));
                
            }
        }catch(SQLException ex){
            
            ex.printStackTrace();
        }
        return selPartida;
    }
    
    public List<Partida> listar(Campeonato camp) { // todos os times no banco de dados,não é usado
        Connection conn = null;
        List<Partida> partidas = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM partida"
                    + " WHERE campeonato=?");
            pstmt.setInt(1, camp.getId());
            TimeDAO timeDAO = new TimeDAO();
            CampeonatoDAO campDAO = new CampeonatoDAO();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Partida partida = new Partida();
                partida.setId(rs.getInt("id"));
                partida.setMandante(timeDAO.buscar(rs.getInt("mandante")));
                partida.setPlacarMandante(rs.getInt("placarMandante"));
                partida.setPlacarVisitante(rs.getInt("placarVisitante"));
                partida.setVisitante(timeDAO.buscar(rs.getInt("visitante")));
                partida.setCampeonato(campDAO.buscar(rs.getInt("campeonato")));
                partida.setLocal(rs.getString("local"));
                partida.setData(rs.getString("data"));
                partida.setFase(rs.getString("fase"));
                partida.setCadastrada(rs.getBoolean("cadastrada"));
                partidas.add(partida);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return partidas;
    }
    
    public List<Partida> listarFase(Campeonato camp, String fase){
        Connection conn;
        List<Partida> partidas = new ArrayList();
        try{
            conn= new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM partida"
                    + " WHERE campeonato=? and fase=?");
            pstmt.setInt(1,camp.getId());
            pstmt.setString(2,fase);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Partida partida = new Partida();
                TimeDAO timeDAO = new TimeDAO();
                partida.setCadastrada(rs.getBoolean("cadastrada"));
                partida.setCampeonato(camp);
                partida.setData(rs.getString("data"));
                partida.setFase(fase);
                partida.setId(rs.getInt("id"));
                partida.setLocal(rs.getString("local"));
                partida.setMandante(timeDAO.buscar(rs.getInt("mandante")));
                partida.setObservacoes(rs.getString("obs"));
                partida.setPenaltisMandante(rs.getInt("penaltisMandante"));
                partida.setPenaltisVisitante(rs.getInt("penaltisVisitante"));
                partida.setPlacarMandante(rs.getInt("placarMandante"));
                partida.setPlacarVisitante(rs.getInt("placarVisitante"));
                partida.setVisitante(timeDAO.buscar(rs.getInt("visitante")));
                partidas.add(partida);
            }
        }catch(SQLException ex){
            
        }
        return partidas;
    }
}
