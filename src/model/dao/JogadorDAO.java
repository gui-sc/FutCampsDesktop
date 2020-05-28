package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Campeonato;
import model.bean.Jogador;
import model.bean.ConnectionFactory;
import model.bean.Time;

public class JogadorDAO {

    public void inserir(Jogador jogador) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO jogador (nome,  apelido,time, gols, ca, suspenso,dataNasc,pendurado) "
                    + "VALUES (?,?,?, default, default, default,?,default)");
            pstmt.setString(1, jogador.getNome());
            pstmt.setString(2, jogador.getApelido());
            pstmt.setInt(3, jogador.getTime().getId());
            pstmt.setDate(4, jogador.getDataNasc());

            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Jogador cadastrado com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void excluir(int documento) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM jogador " + "WHERE id = ?");
            pstmt.setInt(1, documento);
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Jogador excluído com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void alterar(Jogador jogador) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE jogador set nome=?,apelido=?"
                    + " WHERE id = ?");
            pstmt.setString(1, jogador.getNome());
            pstmt.setString(2, jogador.getApelido());
            pstmt.setInt(3, jogador.getId());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Jogador alterado com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Jogador buscar(int documento) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM jogador " + "WHERE id = ?");
            pstmt.setInt(1, documento);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Jogador selJogador = new Jogador();
                selJogador.setId(rs.getInt("id"));
                selJogador.setNome(rs.getString("nome"));
                selJogador.setApelido(rs.getString("apelido"));
                selJogador.setGols(rs.getInt("gols"));
                selJogador.setId(rs.getInt("id"));
                selJogador.setCa(rs.getInt("ca"));
                selJogador.setCv(rs.getInt("cv"));
                return selJogador;
            }
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        return null;
    }

    public Jogador buscarPorNome(Jogador jogador) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM jogador " + "WHERE apelido = ?");
            pstmt.setString(1, jogador.getApelido());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Jogador selJogador = new Jogador();
                TimeDAO timeDAO = new TimeDAO();
                selJogador.setTime(timeDAO.buscar(rs.getInt("time")));
                selJogador.setNome(rs.getString("nome"));
                selJogador.setApelido(rs.getString("apelido"));
                selJogador.setId(rs.getInt("id"));
                selJogador.setCa(rs.getInt("ca"));
                selJogador.setCv(rs.getInt("cv"));
                return selJogador;
            }
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        return null;
    }

    public List<Jogador> listarArtilheiros(Campeonato camp) { // quem fez gol ta aqui
        Connection conn = null;
        List<Jogador> jogadores = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT distinct jogador.apelido, jogador.gols, times.id as 'time' ,times.campeonato \n"
                    + " from jogador \n"
                    + " inner join times \n"
                    + " on jogador.time = times.id \n"
                    + " inner join campeonato \n"
                    + " on times.campeonato = ?"
                    + " where gols!=0 \n"
                    + " order by gols desc");
            pstmt.setInt(1, camp.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Jogador jogador = new Jogador();
                jogador.setApelido(rs.getString("apelido"));
                jogador.setGols(rs.getInt("gols"));
                TimeDAO timeDAO = new TimeDAO();
                jogador.setTime(timeDAO.buscar(rs.getInt("time")));
                jogadores.add(jogador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return jogadores;
    }
    public Jogador artilheiro(Campeonato camp){
        Connection conn = null;
        Jogador jogador = new Jogador();
        try{
            conn=new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT distinct jogador.apelido, jogador.gols, times.id as 'time' ,times.campeonato \n"
                    + " from jogador \n"
                    + " inner join times \n"
                    + " on jogador.time = times.id \n"
                    + " inner join campeonato \n"
                    + " on times.campeonato = ?"
                    + " order by gols desc"
                    + " limit 1");
            pstmt.setInt(1, camp.getId());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                
                jogador.setApelido(rs.getString("apelido"));
                jogador.setGols(rs.getInt("gols"));
                TimeDAO timeDAO = new TimeDAO();
                jogador.setTime(timeDAO.buscar(rs.getInt("time")));
                
            }
        }catch(SQLException ex){
            
        }
        return jogador;
    }

    public List<Jogador> listarPendurados(Campeonato camp) { // quem ta pendurado ta aqui
        Connection conn = null;
        List<Jogador> jogadores = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT distinct jogador.apelido, jogador.ca, times.id as 'time' ,times.campeonato \n"
                    + " from jogador \n"
                    + " inner join times \n"
                    + " on jogador.time = times.id \n"
                    + " inner join campeonato \n"
                    + " on times.campeonato = ?"
                    + " where ca=1");
            pstmt.setInt(1, camp.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Jogador jogador = new Jogador();
                jogador.setApelido(rs.getString("apelido"));

                TimeDAO timeDAO = new TimeDAO();
                jogador.setTime(timeDAO.buscar(rs.getInt("time")));
                jogadores.add(jogador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return jogadores;
    }

    public List<Jogador> listarPorTime(Time time) { // quem faz parte do time tá aqui
        Connection conn = null;
        List<Jogador> jogadores = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM jogador"
                    + " WHERE time = ?");
            pstmt.setInt(1, time.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Jogador jogador = new Jogador();
                jogador.setId(rs.getInt("id"));
                jogador.setNome(rs.getString("nome"));
                jogador.setApelido(rs.getString("apelido"));
                jogadores.add(jogador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return jogadores;
    }

    public List<Jogador> listarSuspensosTime(Time time) { // os suspensos do time
        Connection conn = null;
        List<Jogador> jogadores = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM jogador"
                    + " WHERE (time = ?) and (suspenso=1) ");
            pstmt.setInt(1, time.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Jogador jogador = new Jogador();
                jogador.setId(rs.getInt("id"));
                jogador.setNome(rs.getString("nome"));
                jogador.setApelido(rs.getString("apelido"));
                jogador.setSuspenso(rs.getBoolean("suspenso"));
                jogadores.add(jogador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return jogadores;
    }

    public List<Jogador> listarSuspensosCamp(Campeonato camp) { // suspensos de todo o camp
        Connection conn = null;
        List<Jogador> jogadores = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT distinct jogador.apelido, jogador.ca, times.id as 'time' ,times.campeonato \n"
                    + "from jogador\n"
                    + "inner join times\n"
                    + "on jogador.time = times.id\n"
                    + "inner join campeonato\n"
                    + "on times.campeonato = ?\n"
                    + "where suspenso=1");
            pstmt.setInt(1, camp.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Jogador jogador = new Jogador();
                jogador.setApelido(rs.getString("apelido"));
                TimeDAO timeDAO = new TimeDAO();
                jogador.setTime(timeDAO.buscar(rs.getInt("time")));
                jogadores.add(jogador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return jogadores;
    }

    public List<Jogador> listarNaoSuspensos(Time time) {
        Connection conn = null;
        List<Jogador> jogadores = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM jogador"
                    + " WHERE (time = ?) and (suspenso=0) ");
            pstmt.setInt(1, time.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Jogador jogador = new Jogador();
                jogador.setId(rs.getInt("id"));
                jogador.setNome(rs.getString("nome"));
                jogador.setApelido(rs.getString("apelido"));
                jogador.setSuspenso(rs.getBoolean("suspenso"));
                jogador.setCa(rs.getInt("ca"));
                jogadores.add(jogador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return jogadores;
    }

    public void atualizar(Jogador jogador, Campeonato camp) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("update jogador\n"
                    + " inner join times on jogador.time = times.id\n"
                    + " inner join campeonato on times.campeonato = campeonato.id\n"
                    + " set jogador.gols = gols+?, jogador.ca = ca+?,jogador.cv = cv+?\n"
                    + " where (apelido = ?) and (campeonato=?)");
            pstmt.setInt(1, jogador.getGols());
            pstmt.setInt(2, jogador.getCa());
            pstmt.setInt(3, jogador.getCv());
            pstmt.setString(4, jogador.getApelido());
            pstmt.setInt(5, camp.getId());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void suspenso(Jogador jogador, Campeonato camp) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("update jogador\n"
                    + " inner join times on jogador.time = times.id\n"
                    + " inner join campeonato on times.campeonato = campeonato.id\n"
                    + " set jogador.suspenso=1, jogador.ca= 0\n"
                    + " where (apelido = ?) and (campeonato=?)");
            pstmt.setString(1, jogador.getApelido());
            pstmt.setInt(2, camp.getId());
            pstmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void cumpriuSuspensao(Jogador jogador, Campeonato camp) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("update jogador\n"
                    + " inner join times on jogador.time = times.id\n"
                    + " inner join campeonato on times.campeonato = campeonato.id\n"
                    + " set jogador.suspenso=0\n"
                    + " where (apelido = ?) and (campeonato=?)");
            pstmt.setString(1, jogador.getApelido());
            pstmt.setInt(2, camp.getId());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void zerarCartoes(Campeonato camp) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("update jogador\n"
                    + " inner join times on jogador.time = times.id\n"
                    + " inner join campeonato on times.campeonato = campeonato.id\n"
                    + " set jogador.ca = 0\n"
                    + " where campeonato=?");
            pstmt.setInt(1, camp.getId());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
