package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Ferramenta;

/**
 * Classe responsável pela manipulação de dados das ferramentas no banco de
 * dados.
 *
 * @author Thuysa.
 */
public class FerramentaDAO {

    /**
     * Lista de ferramentas.
     */
    public ArrayList<Ferramenta> minhaLista = new ArrayList<>();
    public ArrayList<Ferramenta> ListaFerramentasDisponiveis = new ArrayList<>();

    private DatabaseConnection db;

    /**
     * Construtor da classe FerramentaDAO. Inicializa a conexão com o banco de
     * dados.
     */
    public FerramentaDAO() {
        this.db = new DatabaseConnection();
    }

    /**
     * Retorna a lista de ferramentas do banco de dados.
     *
     * @return - Retorna a lista de ferramentas.
     */
    public ArrayList<Ferramenta> getMinhaLista() {
        /**
         * Limpa nosso ArrayList.
         */
        minhaLista.clear();

        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas");
            while (res.next()) {

                int id = res.getInt("id_ferramenta");
                int idEmprestimo = res.getInt("id_emprestimo");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                double preco = res.getDouble("preco");

                Ferramenta objeto = new Ferramenta(id, idEmprestimo, nome, marca, preco);

                minhaLista.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return minhaLista;
    }

    /**
     * Define a lista de ferramentas.
     *
     * @param minhaLista - Lista de ferramentas a ser definida.
     */
    public void setMinhaLista(ArrayList<Ferramenta> minhaLista) {
        this.minhaLista = minhaLista;
    }

    /**
     * Retorna o maior ID de ferramenta presente no banco de dados.
     *
     * @return - Retorna o maior ID de ferramenta.
     */
    public int maiorID() {
        int maiorID = 0;
        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id_ferramenta) id FROM tb_ferramentas");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return maiorID;
    }

    /**
     * Insere uma nova ferramenta no banco de dados.
     *
     * @param objeto - A ferramenta a ser inserida.
     * @return - Verdadeiro se a inserção foi bem-sucedida, falso caso
     *         contrário.
     */
    public boolean insertFerramentaBD(Ferramenta objeto) {
        String sql = "INSERT INTO tb_ferramentas(id_ferramenta,nome,marca,preco) VALUES(?,?,?,?)";
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

    /**
     * Remove uma ferramenta do banco de dados com base em seu ID.
     *
     * @param id - O ID da ferramenta a ser removida.
     * @return - Verdadeiro se a remoção foi bem-sucedida, falso caso contrário.
     */
    public boolean deleteFerramentaBD(int id) {
        try {
            Statement stmt = db.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_emprestimos WHERE id_ferramenta = " + id);
            stmt.executeUpdate("DELETE FROM tb_ferramentas WHERE id_ferramenta = " + id);
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return true;
    }

    /**
     * Atualiza os dados de uma ferramenta no banco de dados.
     *
     * @param objeto - A ferramenta com os dados atualizados.
     * @return - Verdadeiro se a atualização foi bem-sucedida, falso caso
     *         contrário.
     */
    public boolean updateFerramentaBD(Ferramenta objeto) {

        String sql = "UPDATE tb_ferramentas set nome = ? ,marca = ? ,preco = ? WHERE id_ferramenta = ?";

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

    /**
     * Carrega uma ferramenta do banco de dados com base em seu ID.
     *
     * @param id - O ID da ferramenta a ser carregada.
     * @return - Retorna a ferramenta carregada do banco de dados.
     */
    public Ferramenta carregaFerramenta(int id) {
        Ferramenta objeto = new Ferramenta();
        objeto.setId(id);
        try {
            Statement stmt = db.getConexao().createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas WHERE id_ferramenta = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setMarca(res.getString("marca"));
            objeto.setPreco(res.getDouble("preco"));
            objeto.setIdEmprestimo(res.getInt("id_emprestimo"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }

    public ArrayList<Ferramenta> getFerramentasDisponiveis() {

        ListaFerramentasDisponiveis.clear();

        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas WHERE id_emprestimo is null");
            while (res.next()) {

                int id = res.getInt("id_ferramenta");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                double preco = Double.parseDouble(res.getString("preco"));
                int idEmprestimo = res.getInt("id_emprestimo");

                Ferramenta objeto = new Ferramenta(id, idEmprestimo, nome, marca, preco);

                ListaFerramentasDisponiveis.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return ListaFerramentasDisponiveis;
    }

    public boolean verificarPendencia(int id) {

        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("select id_ferramenta, id_emprestimo from tb_ferramentas;");
            while (res.next()) {

                int idFer = res.getInt("id_ferramenta");
                int idEmp = res.getInt("id_emprestimo");

                if (idFer == id && idEmp != 0) {
                    return true;
                    /**
                     * retorna que a ferramenta está emprestada
                     */
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);

        }
        return false;
    }

    public String valorTotal() {
        double soma = 0;

        try {
            String query = "SELECT SUM(preco) FROM tb_ferramentas";
            PreparedStatement statement = DatabaseConnection.getConexao().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                soma = resultSet.getDouble(1);
            }
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        String format = String.format("%.2f", soma);
        return format;
    }
}
