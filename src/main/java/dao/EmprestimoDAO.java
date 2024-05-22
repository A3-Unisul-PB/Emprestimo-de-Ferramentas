package dao;

import model.Emprestimo;
import java.sql.*;
import java.util.ArrayList;

public class EmprestimoDAO {

    private ArrayList<Emprestimo> minhaLista = new ArrayList<>();
    private DatabaseConnection db;

    public EmprestimoDAO() {
        this.db = new DatabaseConnection();
    }

    public ArrayList<Emprestimo> getMinhaLista() {
        minhaLista.clear();

        String query = "SELECT e.id, e.id_amigo, e.id_ferramenta, e.data_limite, e.concluido " +
               "FROM tb_emprestimos e " +
               "JOIN tb_amigos a ON e.id_amigo = a.id " +
               "JOIN tb_ferramentas f ON e.id_ferramenta = f.id";


        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery(query);

            while (res.next()) {
                int id = res.getInt("id");
                int idAmigo = res.getInt("id_amigo");
                int idFerramenta = res.getInt("id_ferramenta");
                Date dataLimite = res.getDate("data_limite");
                boolean concluido = res.getBoolean("concluido");

                Emprestimo objeto = new Emprestimo(id, idAmigo, idFerramenta, dataLimite, concluido);
                minhaLista.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return minhaLista;
    }

    public void setMinhaLista(ArrayList<Emprestimo> minhaLista) {
        this.minhaLista = minhaLista;
    }

    public int maiorID() {
        int maiorID = 0;
        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_emprestimos");
            if (res.next()) {
                maiorID = res.getInt("id");
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return maiorID;
    }

    public boolean insertEmprestimoBD(Emprestimo objeto) {
        String sql = "INSERT INTO tb_emprestimos(id, id_amigo, id_ferramenta, data_limite) VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement stmt = db.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setInt(2, objeto.getIdAmigo());
            stmt.setInt(3, objeto.getIdFerramenta());
            stmt.setDate(4, objeto.getDataLimite());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    public boolean deleteEmprestimoBD(int id) {
        try {
            Statement stmt = db.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_emprestimos WHERE id = " + id);
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            return false;
        }
        return true;
    }

    public boolean updateEmprestimoBD(Emprestimo objeto) {
        String sql = "UPDATE tb_emprestimos SET id_amigo = ?, id_ferramenta = ?, data_limite = ? WHERE id = ?";

        try {
            PreparedStatement stmt = db.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getIdAmigo());
            stmt.setInt(2, objeto.getIdFerramenta());
            stmt.setDate(3, objeto.getDataLimite());
            stmt.setInt(4, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    public Emprestimo carregaEmprestimo(int id) {
        Emprestimo objeto = new Emprestimo();

        String query = "SELECT e.id, e.id_amigo, e.id_ferramenta, e.data_limite, e.concluido " +
                       "FROM tb_emprestimos e WHERE e.id = " + id;

        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery(query);

            if (res.next()) {
                objeto.setId(res.getInt("id"));
                objeto.setIdAmigo(res.getInt("id_amigo"));
                objeto.setIdFerramenta(res.getInt("id_ferramenta"));
                objeto.setDataLimite(res.getDate("data_limite"));
            }
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }
    
    public String getUserById(int id) {
        String nomeAmigo = null;

        String query = "SELECT a.nome " +
                   "FROM tb_emprestimos e " +
                   "JOIN tb_amigos a ON e.id_amigo = a.id " +
                   "WHERE e.id = " + id;

        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery(query);
        
            if (res.next()) {
                nomeAmigo = res.getString("nome");
            }
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return nomeAmigo;
    }
    
    public String getFerramentaById(int id) {
        String nomeFerramenta = null;

        String query = "SELECT a.nome " +
                   "FROM tb_emprestimos e " +
                   "JOIN tb_ferramentas a ON e.id_ferramenta = a.id " +
                   "WHERE e.id = " + id;

        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery(query);
        
            if (res.next()) {
                nomeFerramenta = res.getString("nome");
            }
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return nomeFerramenta;
    }
}
