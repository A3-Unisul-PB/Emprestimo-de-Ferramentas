package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Ferramenta;

public class FerramentaDAO {

    public ArrayList<Ferramenta> minhaLista = new ArrayList<>();
    
    private DatabaseConnection db;

    public FerramentaDAO() {
        this.db = new DatabaseConnection();
    }
    
    public ArrayList<Ferramenta> getMinhaLista() {
        minhaLista.clear();
        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas");
            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                double preco = res.getDouble("preco");

                Ferramenta objeto = new Ferramenta(id, nome, marca, preco);
                minhaLista.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return minhaLista;
    }

    public void setMinhaLista(ArrayList<Ferramenta> minhaLista) {
        this.minhaLista = minhaLista;
    }

    public int maiorID() {
        int maiorID = 0;
        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_ferramentas");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return maiorID;
    }

    public boolean insertFerramentaBD(Ferramenta objeto) {
        String sql = "INSERT INTO tb_ferramentas(id,ferramenta,marca,preco) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = db.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getMarca());
            stmt.setDouble(4, objeto.getPreco());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    public boolean deleteFerramentaBD(int id) {
        try {
            Statement stmt = db.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_ferramentas WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return true;
    }

    public boolean updateFerramentaBD(Ferramenta objeto) {
        String sql = "UPDATE tb_ferramentas set ferramenta = ?, marca = ?, preco = ? WHERE id = ?";

        try {
            PreparedStatement stmt = db.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getMarca());
            stmt.setDouble(3, objeto.getPreco());
            stmt.setInt(4, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    public Ferramenta carregaFerramenta(int id) {
        Ferramenta objeto = new Ferramenta();
        objeto.setId(id);
        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("ferramenta"));
            objeto.setMarca(res.getString("marca"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }
}
