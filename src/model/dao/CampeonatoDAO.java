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
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO campeonato (formato, nome, cidade, ano,classificados,"
                    + " premiacao, numTimes, numGrupos, faseDeGrupos,oitavas,quartas,semi,Final,cabecasDeChave,iniciado,finalizado"
                    + "zerarCartoesOitavas,zerarCartoesQuartas,zerarCartoesSemi,cartoesPendurado) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, camp.getFormato());
            pstmt.setString(2, camp.getNome());
            pstmt.setString(3, camp.getCidade());
            pstmt.setInt(4, (camp.getAno()));
            pstmt.setInt(5, camp.getClassificados());
            pstmt.setString(6, camp.getPremiacao());
            pstmt.setInt(7, camp.getNumTimes());
            pstmt.setInt(8, camp.getNumGrupos());
            pstmt.setBoolean(9, camp.isFaseDeGrupos());
            pstmt.setBoolean(10,camp.isOitavas());
            pstmt.setBoolean(11,camp.isQuartas());
            pstmt.setBoolean(12,camp.isSemi());
            pstmt.setBoolean(13,camp.isFinal());
            pstmt.setBoolean(14, camp.isIniciado());
            pstmt.setBoolean(15,camp.isZerarCartoesOitavas());
            pstmt.setBoolean(16,camp.isZerarCartoesQuartas());
            pstmt.setBoolean(17,camp.isZerarCartoesSemi());
            pstmt.setInt(18,camp.getCartoesPendurado());
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
                    + " Final = 0"
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
                    + "nome=?, cidade=?,premiacao=? "
                    + "WHERE id=?");
            pstmt.setString(1, camp.getNome());
            pstmt.setString(2, camp.getCidade());
            pstmt.setString(3, camp.getPremiacao());
            pstmt.setInt(4, camp.getId());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Campeonato alterado com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
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
                selCamp.setFormato(rs.getString("formato"));
                selCamp.setId(rs.getInt("id"));
                selCamp.setAno(rs.getInt("ano"));
                selCamp.setCidade(rs.getString("cidade"));
                selCamp.setNumGrupos(rs.getInt("numGrupos"));
                selCamp.setNumTimes(rs.getInt("numTimes"));
                selCamp.setPremiacao(rs.getString("premiacao"));
                selCamp.setFaseDeGrupos(rs.getBoolean("faseDeGrupos"));
                selCamp.setOitavas(rs.getBoolean("oitavas"));
                selCamp.setQuartas(rs.getBoolean("quartas"));
                selCamp.setSemi(rs.getBoolean("semi"));
                selCamp.setFinal(rs.getBoolean("Final"));
                selCamp.setFinalizado(rs.getBoolean("finalizado"));
                selCamp.setIniciado(rs.getBoolean("iniciado"));
                selCamp.setCartoesPendurado(rs.getInt("cartoesPendurado"));
                selCamp.setClassificados(rs.getInt("classificados"));
                selCamp.setZerarCartoesOitavas(rs.getBoolean("zerarCartoesOitavas"));
                selCamp.setZerarCartoesQuartas(rs.getBoolean("zerarCartoesQuartas"));
                selCamp.setZerarCartoesSemi(rs.getBoolean("zerarCartoesSemi"));
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
               Campeonato selCamp = new Campeonato();
                selCamp.setNome(rs.getString("nome"));
                selCamp.setFormato(rs.getString("formato"));
                selCamp.setId(rs.getInt("id"));
                selCamp.setAno(rs.getInt("ano"));
                selCamp.setCidade(rs.getString("cidade"));
                selCamp.setNumGrupos(rs.getInt("numGrupos"));
                selCamp.setNumTimes(rs.getInt("numTimes"));
                selCamp.setPremiacao(rs.getString("premiacao"));
                selCamp.setFaseDeGrupos(rs.getBoolean("faseDeGrupos"));
                selCamp.setOitavas(rs.getBoolean("oitavas"));
                selCamp.setQuartas(rs.getBoolean("quartas"));
                selCamp.setSemi(rs.getBoolean("semi"));
                selCamp.setFinal(rs.getBoolean("Final"));
                selCamp.setFinalizado(rs.getBoolean("finalizado"));
                selCamp.setIniciado(rs.getBoolean("iniciado"));
                selCamp.setCartoesPendurado(rs.getInt("cartoesPendurado"));
                selCamp.setClassificados(rs.getInt("classificados"));
                selCamp.setZerarCartoesOitavas(rs.getBoolean("zerarCartoesOitavas"));
                selCamp.setZerarCartoesQuartas(rs.getBoolean("zerarCartoesQuartas"));
                selCamp.setZerarCartoesSemi(rs.getBoolean("zerarCartoesSemi"));
                campeonatos.add(selCamp);
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
