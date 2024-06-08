package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Emprestimo;

public class EmprestimoDAO {

    public static ArrayList<Emprestimo> ListaEmprestimos = new ArrayList<>();
    public ArrayList<Emprestimo> ListaEmprestimosAtivos = new ArrayList<>();
    private DatabaseConnection connect;

    public EmprestimoDAO() {
        this.connect = new DatabaseConnection();
    }

    public ArrayList<Emprestimo> getMinhaLista() {
        ListaEmprestimos.clear();

        try (Statement stmt = connect.getConexao().createStatement()) {
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos");
            while (res.next()) {
                int id = res.getInt("id");
                int idAmigo = res.getInt("id_amigo");
                int idFerramenta = res.getInt("id_ferramenta");
                Date dataEmprestimo = res.getDate("data_emprestimo");
                Date dataLimite = res.getDate("data_limite");
                Date dataFinalizado = res.getDate("data_finalizado");

                Emprestimo objeto = new Emprestimo(id, idAmigo, idFerramenta, dataEmprestimo, dataLimite,
                        dataFinalizado);
                ListaEmprestimos.add(objeto);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return ListaEmprestimos;
    }

    public int maiorId() {
        int maiorId = 0;
        try (Statement stmt = connect.getConexao().createStatement()) {
            ResultSet res = stmt.executeQuery("SELECT MAX(id) AS id FROM tb_emprestimos");
            if (res.next()) {
                maiorId = res.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorId;
    }

    public boolean inserirEmprestimoBD(Emprestimo objeto) {
        String sql = "INSERT INTO tb_emprestimos(id, id_amigo, id_ferramenta, data_emprestimo, data_limite, data_finalizado) VALUES(?,?,?,?,?,?)";
        try (PreparedStatement stmt = connect.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, objeto.getId());
            stmt.setInt(2, objeto.getIdAmigo());
            stmt.setInt(3, objeto.getIdFerramenta());
            stmt.setDate(4, objeto.getDataEmprestimo());
            stmt.setDate(5, objeto.getDataLimite());
            stmt.setDate(6, objeto.getDataFinalizado());

            stmt.execute();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    public boolean concluirEmprestimo(int id) {
        String sql = "UPDATE tb_emprestimos SET data_finalizado = CURRENT_DATE WHERE id = ?";
        try (PreparedStatement stmt = connect.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    public Emprestimo carregarEmprestimoBD(int id) {
        Emprestimo objeto = new Emprestimo();
        String sql = "SELECT e.id, e.id_amigo, e.id_ferramenta, e.data_emprestimo, e.data_limite, e.data_finalizado " +
                "FROM tb_emprestimos e WHERE e.id = ?";
        try (PreparedStatement stmt = connect.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                objeto.setId(res.getInt("id"));
                objeto.setIdAmigo(res.getInt("id_amigo"));
                objeto.setIdFerramenta(res.getInt("id_ferramenta"));
                objeto.setDataEmprestimo(res.getDate("data_emprestimo"));
                objeto.setDataLimite(res.getDate("data_limite"));
                objeto.setDataFinalizado(res.getDate("data_finalizado"));
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return objeto;
    }

    public ArrayList<Emprestimo> getEmprestimosAtivos() {
        ListaEmprestimosAtivos.clear();
        String sql = "SELECT e.id, e.id_amigo, e.id_ferramenta, e.data_emprestimo, e.data_limite " +
                "FROM tb_emprestimos e WHERE e.data_finalizado IS NULL";
        try (Statement stmt = connect.getConexao().createStatement()) {
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                int id = res.getInt("id");
                int idAmigo = res.getInt("id_amigo");
                int idFerramenta = res.getInt("id_ferramenta");
                Date dataEmprestimo = res.getDate("data_emprestimo");
                Date dataLimite = res.getDate("data_limite");

                Emprestimo objeto = new Emprestimo(id, idAmigo, idFerramenta, dataEmprestimo, dataLimite, null);
                ListaEmprestimosAtivos.add(objeto);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return ListaEmprestimosAtivos;
    }

    public boolean verificarPendencia(int id) {
        String sql = "SELECT data_finalizado FROM tb_emprestimos WHERE id = ?";
        try (PreparedStatement stmt = connect.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                return res.getDate("data_finalizado") == null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return false;
    }

    public boolean alterarIdEmpFerramentaPendente(int id) {
        String sql = "UPDATE tb_ferramentas SET id = NULL WHERE id = ?";
        try (PreparedStatement stmt = connect.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }
}
