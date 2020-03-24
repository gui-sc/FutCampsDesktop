package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Campeonato;
import model.bean.Time;
import model.bean.ConnectionFactory;

public class TimeDAO {

    public int inserir(Time time) {
        Connection conn = null;
        int codigoInserido = 0;
        try {
            conn = new ConnectionFactory().getConnection();

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO times (nome, dirigente, cidade, campeonato, pontos, eliminado,cabecaDeChave,escudo) "
                    + "VALUES (?,?,?,?, 0,0,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, time.getNome());
            pstmt.setString(2, time.getDirigente());
            pstmt.setString(3, time.getCidade());
            pstmt.setInt(4, time.getCampeonato().getId());
            pstmt.setBoolean(5, time.isCabecaDeChave());
            pstmt.setBytes(6, time.getEscudo());
            pstmt.execute();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                codigoInserido = rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Time cadastrado com sucesso!");
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return codigoInserido;
    }

    public void excluir(Time time) {
        Connection conn = null;

        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM times " + "WHERE id = ?");
            pstmt.setInt(1, time.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "time excluído com sucesso");

        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }

    public void alterar(Time time) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE times set nome=?,dirigente=?,cidade=?"
                    + " WHERE id = ?");
            pstmt.setString(1, time.getNome());
            pstmt.setString(2, time.getDirigente());
            pstmt.setString(3, time.getCidade());
            pstmt.setInt(4, time.getId());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "time alterado com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Time buscar(int id) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM times " + "WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Time selTime = new Time();
                selTime.setNome(rs.getString("nome"));
                CampeonatoDAO campDAO = new CampeonatoDAO();
                selTime.setCampeonato(campDAO.buscar(rs.getInt("id")));
                selTime.setCidade(rs.getString("cidade"));
                selTime.setDirigente(rs.getString("dirigente"));
                selTime.setId(rs.getInt("id"));
                selTime.setPontos(rs.getInt("pontos"));
                selTime.setGrupo(rs.getInt("grupo"));
                selTime.setEliminado(rs.getBoolean("eliminado"));
                selTime.setCabecaDeChave(rs.getBoolean("cabecaDeChave"));
                selTime.setEscudo(rs.getBytes("escudo"));
                return selTime;
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return null;
    }

    public Time buscarPorNome(String nome) {
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM times " + "WHERE nome = ?");
            pstmt.setString(1, nome);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Time selTime = new Time();
                selTime.setNome(rs.getString("nome"));
                CampeonatoDAO campDAO = new CampeonatoDAO();
                selTime.setCampeonato(campDAO.buscar(rs.getInt("id")));
                selTime.setCidade(rs.getString("cidade"));
                selTime.setDirigente(rs.getString("dirigente"));
                selTime.setId(rs.getInt("id"));
                selTime.setPontos(rs.getInt("pontos"));
                selTime.setGrupo(rs.getInt("grupo"));
                selTime.setEliminado(rs.getBoolean("eliminado"));
                selTime.setCabecaDeChave(rs.getBoolean("cabecaDeChave"));
                return selTime;
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return null;
    }

    public void numGrupo(Time time) { // cadastra o número do grupo no BD
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE times SET"
                    + " grupo = ?"
                    + " WHERE id = ?");
            pstmt.setInt(1, time.getGrupo());
            pstmt.setInt(2, time.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void vitoria(Time time) {//+3 pontos
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE times SET"
                    + " pontos = ?"
                    + " WHERE id = ?");
            pstmt.setInt(1, time.getPontos());
            pstmt.setInt(2, time.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void empate(Time time) { // +1 ponto
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE times SET"
                    + " pontos = ?"
                    + " WHERE id = ?");
            pstmt.setInt(1, time.getPontos());
            pstmt.setInt(2, time.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void eliminar(Time time, Campeonato camp) { // ativa o campo eliminado
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("update times\n"
                    + " inner join campeonato on times.campeonato = campeonato.id\n"
                    + " set eliminado =1\n"
                    + " where (times.nome = ?) and (campeonato=?)");

            pstmt.setString(1, time.getNome());
            pstmt.setInt(2, camp.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void primeiro(Time time, Campeonato camp) { // ativa o campo primeiro
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("update times\n"
                    + " inner join campeonato on times.campeonato = campeonato.id\n"
                    + " set primeiro =1\n"
                    + " where (times.nome = ?) and (campeonato=?)");

            pstmt.setString(1, time.getNome());
            pstmt.setInt(2, camp.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Time> listar() { // todos os times no banco de dados,não é usado
        Connection conn = null;
        List<Time> times = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM times");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Time clube = new Time();
                clube.setId(rs.getInt("id"));
                clube.setNome(rs.getString("nome"));
                clube.setDirigente(rs.getString("dirigente"));
                clube.setCidade(rs.getString("cidade"));
                clube.setPontos(rs.getInt("pontos"));
                times.add(clube);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return times;
    }

    public List<Time> listarGrupoSemCC(int grupo, Campeonato camp) { // quem ta no grupo tá aqui
        Connection conn = null;
        List<Time> times = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM times"
                    + " WHERE (grupo = ?) and (campeonato = ?) and (cabecaDeChave = 0)"
                    + " order by pontos desc");
            pstmt.setInt(1, grupo);
            pstmt.setInt(2, camp.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Time clube = new Time();

                clube.setNome(rs.getString("nome"));
                clube.setPontos(rs.getInt("pontos"));
                times.add(clube);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return times;
    }

    public List<Time> listarGrupoComCC(int grupo, Campeonato camp) { // quem ta no grupo tá aqui
        Connection conn = null;
        List<Time> times = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM times"
                    + " WHERE (grupo = ?) and (campeonato = ?)"
                    + " order by pontos desc");
            pstmt.setInt(1, grupo);
            pstmt.setInt(2, camp.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Time clube = new Time();
                clube.setId(rs.getInt("id"));
                clube.setNome(rs.getString("nome"));
                clube.setPontos(rs.getInt("pontos"));
                times.add(clube);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return times;
    }

    public List<Time> listarPorCamp(Campeonato camp) { // quem ta ou tava no campeonato tá aqui
        Connection conn = null;
        List<Time> times = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM times"
                    + " WHERE campeonato = ?");
            pstmt.setInt(1, camp.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Time clube = new Time();
                CampeonatoDAO campDAO = new CampeonatoDAO();
                clube.setId(rs.getInt("id"));
                clube.setNome(rs.getString("nome"));
                clube.setDirigente(rs.getString("dirigente"));
                clube.setCidade(rs.getString("cidade"));
                clube.setCampeonato(campDAO.buscar(rs.getInt("campeonato")));
                clube.setGrupo(rs.getInt("grupo"));
                clube.setPontos(rs.getInt("pontos"));
                clube.setEliminado(rs.getBoolean("eliminado"));

                times.add(clube);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return times;
    }

    public List<Time> listarClassificados(Campeonato camp) { // quem não foi eliminado tá aqui
        Connection conn = null;
        List<Time> times = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM times"
                    + " WHERE (campeonato = ?) and (eliminado = 0)");
            pstmt.setInt(1, camp.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Time time = new Time();
                CampeonatoDAO campDAO = new CampeonatoDAO();
                time.setCampeonato(campDAO.buscar(rs.getInt("campeonato")));
                time.setNome(rs.getString("nome"));
                time.setCidade(rs.getString("cidade"));
                time.setDirigente(rs.getString("dirigente"));
                time.setId(rs.getInt("id"));
                time.setGrupo(rs.getInt("grupo"));
                time.setPontos(rs.getInt("pontos"));
                time.setPrimeiro(rs.getBoolean("primeiro"));
                times.add(time);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return times;
    }

    public List<Time> listar2e3(Campeonato camp) { // quem não foi eliminado nem é primeiro ta aqui
        Connection conn = null;
        List<Time> times = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM times"
                    + " WHERE (campeonato = ?) and (eliminado = 0) and (primeiro=0)");
            pstmt.setInt(1, camp.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Time clube = new Time();
                CampeonatoDAO campDAO = new CampeonatoDAO();
                clube.setCampeonato(campDAO.buscar(rs.getInt("campeonato")));
                clube.setNome(rs.getString("nome"));
                clube.setCidade(rs.getString("cidade"));
                clube.setDirigente(rs.getString("dirigente"));
                clube.setId(rs.getInt("id"));
                clube.setGrupo(rs.getInt("grupo"));
                clube.setPontos(rs.getInt("pontos"));
                clube.setEscudo(rs.getBytes("escudo"));
                times.add(clube);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return times;
    }

    public List<Time> listarPrimeiros(Campeonato camp) { // quem não foi eliminado nem é primeiro ta aqui
        Connection conn = null;
        List<Time> times = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM times"
                    + " WHERE (campeonato = ?) and (eliminado = 0) and (primeiro=1)");
            pstmt.setInt(1, camp.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Time clube = new Time();
                CampeonatoDAO campDAO = new CampeonatoDAO();
                clube.setCampeonato(campDAO.buscar(rs.getInt("campeonato")));
                clube.setNome(rs.getString("nome"));
                clube.setCidade(rs.getString("cidade"));
                clube.setDirigente(rs.getString("dirigente"));
                clube.setId(rs.getInt("id"));
                clube.setGrupo(rs.getInt("grupo"));
                clube.setPontos(rs.getInt("pontos"));
                clube.setEscudo(rs.getBytes("escudo"));
                times.add(clube);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return times;
    }

    public List<Time> listarCabecasDeChave(Campeonato camp) {
        Connection conn = null;
        List<Time> times = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM times"
                    + " WHERE campeonato = ? and cabecaDeChave = 1");
            pstmt.setInt(1, camp.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Time time = new Time();
                CampeonatoDAO campDAO = new CampeonatoDAO();
                time.setCampeonato(campDAO.buscar(rs.getInt("campeonato")));
                time.setNome(rs.getString("nome"));
                time.setCidade(rs.getString("cidade"));
                time.setDirigente(rs.getString("dirigente"));
                time.setId(rs.getInt("id"));
                time.setGrupo(rs.getInt("grupo"));
                time.setPontos(rs.getInt("pontos"));
                times.add(time);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no sql");
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(null, "erro ao conectar com o banco de dados");
        }
        return times;
    }

    public List<Time> listarNaoCabecasDeChave(Campeonato camp) {
        Connection conn = null;
        List<Time> times = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM times"
                    + " WHERE campeonato = ? and cabecaDeChave = 0");
            pstmt.setInt(1, camp.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Time time = new Time();
                CampeonatoDAO campDAO = new CampeonatoDAO();
                time.setCampeonato(campDAO.buscar(rs.getInt("campeonato")));
                time.setNome(rs.getString("nome"));
                time.setCidade(rs.getString("cidade"));
                time.setDirigente(rs.getString("dirigente"));
                time.setId(rs.getInt("id"));
                time.setGrupo(rs.getInt("grupo"));
                time.setPontos(rs.getInt("pontos"));
                times.add(time);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no sql");
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(null, "erro ao conectar com o banco de dados");
        }
        return times;
    }

    public List<Time> listarTimesSemCamp() {
        Connection conn;
        List<Time> times = new ArrayList();
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT times.id,times.nome,times.cabecaDeChave,times.cidade, times.dirigente,times.eliminado,times.escudo,times.grupo,times.pontos,times.primeiro,times.campeonato,campeonato.finalizado\n"
                    + "from times\n"
                    + "left join campeonato\n"
                    + "on times.campeonato=campeonato.id\n"
                    + "where (campeonato.finalizado=1) or (times.campeonato IS NULL)");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Time time = new Time();
                time.setCabecaDeChave(rs.getBoolean("cabecaDeChave"));
                time.setCidade(rs.getString("cidade"));
                time.setDirigente(rs.getString("dirigente"));
                time.setEscudo(rs.getBytes("escudo"));
                time.setId(rs.getInt("id"));
                time.setNome(rs.getString("nome"));
                times.add(time);
            }
        } catch (SQLException ex) {

        }
        return times;
    }

    public void adicionarNoCamp(Time time) {
        Connection conn;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE times set"
                    + " campeonato = ?, cabecaDeChave=?"
                    + " WHERE id = ?");
            pstmt.setInt(1, time.getCampeonato().getId());
            pstmt.setBoolean(2, time.isCabecaDeChave());
            pstmt.setInt(3, time.getId());
            pstmt.execute();
        } catch (SQLException ex) {

        }
    }

    public void removerDoCamp(Time time) {
        Connection conn;
        try {
            conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE times set"
                    + " campeonato = null, grupo=null, pontos=0,eliminado=0,primeiro=0"
                    + " where id=?");
            pstmt.setInt(1, time.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Time removido com Sucesso");
        } catch (SQLException ex) {

        }
    }
}
