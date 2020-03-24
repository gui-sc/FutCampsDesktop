package model.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Campeonato;
import model.bean.ConnectionFactory;
import model.bean.Jogador;
import model.bean.Time;

public class CampeonatoDAO {

    public int inserir(Campeonato camp) {
        Connection conn = null;
        int codigoInserido = 0 ;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO campeonato (regras, nome, local, ano, premiacao, numTimes, numGrupos, faseDeGrupos,iniciado,cabecasDeChave) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,default)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, camp.getRegras());
            pstmt.setString(2, camp.getNome());
            pstmt.setString(3, camp.getLocal());
            pstmt.setInt(4, (camp.getAno()));
            pstmt.setString(5, camp.getPremiacao());
            pstmt.setInt(6, camp.getNumTimes());
            pstmt.setInt(7, camp.getNumGrupos());
            pstmt.setBoolean(8, camp.isFaseDeGrupos());
            pstmt.setBoolean(9, camp.isIniciado());
            pstmt.execute();
            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                codigoInserido = rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Campeonato cadastrado com sucesso");
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        return codigoInserido;
    }

    public void excluir(Campeonato camp) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM campeonato " + "WHERE id = ?");
            pstmt.setInt(1, camp.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Campeonato excluído com sucesso");

        } catch (SQLException ex) {
            
            ex.printStackTrace();

        }
    }
    
    
    public void finalizar(Campeonato camp){
        Connection conn;
        try{
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE campeonato SET"
                    + " finalizado = 1"
                    + " WHERE id=?");
            pstmt.setInt(1, camp.getId());
            pstmt.execute();
        }catch(SQLException ex){
            
        }
    }
    
    public void alterar(Campeonato camp) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE campeonato SET "
                    + "nome=?, local=?,premiacao=? "
                    + "WHERE id=?");
            pstmt.setString(1, camp.getNome());
            pstmt.setString(2, camp.getLocal());
            pstmt.setString(3, camp.getPremiacao());
            pstmt.setInt(4, camp.getId());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Campeonato alterado com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void campeao(Campeonato camp, Time time){ // cadastra o campeão no BD
        Connection conn = null;
        try{
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE campeonato SET "
                    + "campeao = ? "
                    + "WHERE id = ?");
            pstmt.setInt(1, time.getId());
            pstmt.setInt(2,camp.getId());
            pstmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void viceCampeao(Campeonato camp, Time time){ //cadastra o vice no BD
        Connection conn = null;
        try{
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE campeonato SET "
                    + "viceCampeao = ? "
                    + "WHERE id = ?");
            pstmt.setInt(1, time.getId());
            pstmt.setInt(2,camp.getId());
            pstmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void artilheiro(Campeonato camp, Jogador jogador){
        Connection conn;
        try{
            conn=new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE campeonato SET"
                    + " artilheiro = ?"
                    + " WHERE id=?");
            pstmt.setInt(1, jogador.getDocumento());
            pstmt.setInt(2, camp.getId());
            pstmt.execute();
        }catch(SQLException ex){
            
        }
    }
    public Campeonato buscar(int id) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM campeonato "
                    + "WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Campeonato selCamp = new Campeonato();
                selCamp.setNome(rs.getString("nome"));
                selCamp.setRegras(rs.getString("regras"));
                selCamp.setId(rs.getInt("id"));
                selCamp.setAno(rs.getInt("ano"));
                selCamp.setLocal(rs.getString("local"));
                selCamp.setNumGrupos(rs.getInt("numGrupos"));
                selCamp.setNumTimes(rs.getInt("numTimes"));
                selCamp.setPremiacao(rs.getString("premiacao"));
                selCamp.setFaseDeGrupos(rs.getBoolean("faseDeGrupos"));
                TimeDAO timeDAO = new TimeDAO();
                selCamp.setCampeao(timeDAO.buscar(rs.getInt("campeao")));
                selCamp.setViceCampeao(timeDAO.buscar(rs.getInt("viceCampeao")));
                selCamp.setOitavas(rs.getBoolean("oitavas"));
                selCamp.setQuartas(rs.getBoolean("quartas"));
                selCamp.setSemi(rs.getBoolean("semi"));
                selCamp.setFinal(rs.getBoolean("Final"));
                selCamp.setFinalizado(rs.getBoolean("finalizado"));
                selCamp.setIniciado(rs.getBoolean("iniciado"));
                return selCamp;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Campeonato> listar(){ //todos os campeonatos
        Connection conn = null;
        List<Campeonato> campeonatos = new ArrayList();
        try{
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM campeonato");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Campeonato camp = new Campeonato();
                camp.setId(rs.getInt("id"));
                camp.setRegras(rs.getString("regras"));
                camp.setNome(rs.getString("nome"));
                camp.setLocal(rs.getString("local"));
                camp.setAno(rs.getInt("ano"));
                camp.setPremiacao(rs.getString("premiacao"));
                camp.setNumTimes(rs.getInt("numTimes"));
                camp.setNumGrupos(rs.getInt("numGrupos"));
                camp.setFaseDeGrupos(rs.getBoolean("faseDeGrupos"));
                TimeDAO timeDAO = new TimeDAO();
                camp.setCampeao(timeDAO.buscar(rs.getInt("campeao")));
                camp.setViceCampeao(timeDAO.buscar(rs.getInt("viceCampeao")));
                camp.setCabecasDeChave(rs.getInt("cabecasDeChave"));
                camp.setIniciado(rs.getBoolean("iniciado"));
                JogadorDAO jogadorDAO = new JogadorDAO();
                camp.setArtilheiro(jogadorDAO.buscar(rs.getInt("artilheiro")));
                camp.setFinalizado(rs.getBoolean("finalizado"));
                camp.setOitavas(rs.getBoolean("oitavas"));
                camp.setQuartas(rs.getBoolean("quartas"));
                camp.setSemi(rs.getBoolean("semi"));
                camp.setFinal(rs.getBoolean("Final"));
                campeonatos.add(camp);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return campeonatos;
    }
    public void cabecaDeChaveMais(Campeonato camp){
        Connection conn = null;
        try{
            conn=new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE campeonato SET"
                    + " cabecasDeChave = ?"
                    + " WHERE id=?");
            pstmt.setInt(1, camp.getCabecasDeChave());
            pstmt.setInt(2, camp.getId());
            pstmt.executeUpdate();
        }catch(SQLException ex){
        }
    }
    public void iniciar(Campeonato camp){
        Connection conn = null;
        try{
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE campeonato SET"
                    + " iniciado = 1"
                    + " WHERE id=?");
            pstmt.setInt(1, camp.getId());
            pstmt.executeUpdate();
        }catch(SQLException | NullPointerException ex){
            
        }
    }
    public void passarDeFase(Campeonato camp){
        Connection conn;
        try{
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE campeonato SET"
                    + " faseDeGrupos=?, oitavas=?, quartas=?,semi=?, Final=?"
                    + " WHERE id=?");
            pstmt.setBoolean(1, camp.isFaseDeGrupos());
            pstmt.setBoolean(2, camp.isOitavas());
            pstmt.setBoolean(3, camp.isQuartas());
            pstmt.setBoolean(4, camp.isSemi());
            pstmt.setBoolean(5,camp.isFinal());
            pstmt.setInt(6,camp.getId());
            pstmt.execute();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
