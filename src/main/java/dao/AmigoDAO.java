package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Amigo;

public class AmigoDAO {

    public ArrayList<Amigo> minhaLista = new ArrayList<>();
    private DatabaseConnection db;

    public AmigoDAO() {
        this.db = new DatabaseConnection();
    }

    public ArrayList<Amigo> getMinhaLista() {
        minhaLista.clear();

        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos");
            while (res.next()) {
                int id = res.getInt("id_amigo");
                String nome = res.getString("nome");
                String telefone = res.getString("telefone");

                Amigo objeto = new Amigo(id, nome, telefone);
                minhaLista.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return minhaLista;
    }

    public void setMinhaLista(ArrayList<Amigo> minhaLista) {
        this.minhaLista = minhaLista;
    }

    public int maiorID() {
        int maiorID = 0;
        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id_amigo) id FROM tb_amigos");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return maiorID;
    }

    public boolean insertAmigoBD(Amigo objeto) {
        String sql = "INSERT INTO tb_amigos(id_amigo,nome,telefone) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = db.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getTelefone());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    public boolean deleteAmigoBD(int id) {
        try {
            Statement stmt = db.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_amigos WHERE id_amigo = " + id);
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return true;
    }

    public boolean updateAmigoBD(Amigo objeto) {
        String sql = "UPDATE tb_amigos set nome = ?, telefone = ? WHERE id_amigo = ?";

        try {
            PreparedStatement stmt = db.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getTelefone());
            stmt.setInt(3, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    public Amigo carregaAmigo(int id) {
        Amigo objeto = new Amigo();
        objeto.setId(id);
        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos WHERE id_amigo = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setTelefone(res.getString("telefone"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }
    public static int getIdPeloNome(String nome) {
        int id = -1;

        try {
            /**
             * Prepara uma consulta SQL para obter o ID do amigo pelo nome
             */
            String query = "SELECT id_amigo FROM tb_amigos WHERE nome = ?";
            PreparedStatement statement = DatabaseConnection.getConexao().prepareStatement(query);
            statement.setString(1, nome);
            ResultSet resultSet = statement.executeQuery();

            /**
             * Se houver um resultado na consulta, obtém o ID
             */
            if (resultSet.next()) {
                id = resultSet.getInt("id_amigo");
            }
        } catch (SQLException ex) {
            /**
             * Em caso de erro, imprime o erro
             */
            System.out.println("Erro:" + ex);
        }

        /**
         * Retorna o ID obtido
         */
        return id;
    }

    public boolean verificarPendencia(int id) {

        try {
            /**
             * Cria um Statement para executar a consulta SQL
             */
            Statement stmt = db.getConexao().createStatement();
            /**
             * Executa a consulta SQL para obter os empréstimos do amigo
             */
            ResultSet res = stmt.executeQuery("select id_amigo, entregue from tb_emprestimos;");
            while (res.next()) {

                /**
                 * Obtém os dados de cada empréstimo
                 */
                int idAmg = res.getInt("id_amigo");
                boolean entregue = res.getBoolean("entregue");

                /**
                 * Verifica se o amigo possui empréstimos pendentes
                 */
                if (idAmg == id && entregue == false) {
                    return true; // retorna que o amigo tem empréstimos pendentes
                }
            }
            /**
             * Fecha o Statement
             */
            stmt.close();

        } catch (SQLException ex) {
            /**
             * Em caso de erro, imprime o erro
             */
            System.out.println("Erro:" + ex);
        }
        /**
         * Retorna falso se não houver pendências
         */
        return false;
    }
}
