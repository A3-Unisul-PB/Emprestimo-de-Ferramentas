package dao;

import dao.DatabaseConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Emprestimo;

public class EmprestimoDAO {

    public ArrayList<String> FerSelect;
    /**
     * Lista de todos os empréstimos
     */
    public static ArrayList<Emprestimo> ListaEmprestimos = new ArrayList<>();

    /**
     * Lista de empréstimos ativos
     */
    public ArrayList<Emprestimo> ListaEmprestimosAtivos = new ArrayList<>();

    /**
     * Conexão com o banco de dados
     */
    private DatabaseConnection connect;

    /**
     * Método para obter a lista completa de empréstimos
     *
     * @return
     */
    public ArrayList<Emprestimo> getMinhaLista() {

        /**
         * Limpa a lista atual antes de preenchê-la
         */
        ListaEmprestimos.clear();

        try {
            /**
             * Cria um statement para executar a consulta
             */
            Statement stmt = connect.getConexao().createStatement();
            /**
             * Executa a consulta SQL para obter todos os empréstimos
             */
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos");
            /**
             * Itera sobre o resultado da consulta
             */
            while (res.next()) {
                /**
                 * Obtém os dados de cada empréstimo do resultado
                 */
                int id = res.getInt("id");
                int idAmigo = res.getInt("id_amigo");
                int idFerramenta = res.getInt("id_ferramenta");
                Date dataEmprestimo = res.getDate("data_emprestimo");
                Date dataLimite = res.getDate("data_limite");
                Date dataFinalizado = res.getDate("data_finalizado");

                /**
                 * Cria um objeto Emprestimo com os dados obtidos e o adiciona à
                 * lista
                 */
                Emprestimo objeto = new Emprestimo(id, idAmigo, idFerramenta, dataEmprestimo, dataLimite, dataFinalizado);
                ListaEmprestimos.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return ListaEmprestimos;
    }

    /**
     * Método para obter o maior ID de empréstimo presente no banco de dados
     *
     * @return
     */
    public int maiorId() {
        int maiorId = 0;
        try {
            /**
             * Cria um statement para executar a consulta
             */
            Statement stmt = connect.getConexao().createStatement();
            /**
             * Executa a consulta SQL para obter o maior ID de empréstimo
             */
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_emprestimos");
            res.next();
            maiorId = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorId;
    }

    public boolean inserirEmprestimoBD(Emprestimo objeto) {
        /**
         * SQL para inserção de um novo empréstimo
         */
        String sql = "INSERT INTO tb_emprestimos(id, id_amigo, id_ferramenta, data_limite) VALUES(?,?,?,?,?)";
        try {
            /**
             * Prepara o statement com a consulta SQL
             */
            PreparedStatement stmt = connect.getConexao().prepareStatement(sql);

            /**
             * Define os parâmetros da consulta com os dados do empréstimo
             */
            stmt.setInt(1, objeto.getId());
            stmt.setInt(2, objeto.getIdAmigo());
            stmt.setInt(3, objeto.getIdFerramenta());
            stmt.setDate(4, objeto.getDataLimite());

            /**
             * Executa a consulta SQL
             */
            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    public boolean concluirEmprestimo(int id) {
        try {
            /**
             * Cria um statement para executar a consulta
             */
            Statement stmt = connect.getConexao().createStatement();

            /**
             * Executa a consulta SQL para apagar o empréstimo com o ID
             * especificado
             */
            stmt.executeUpdate("UPDATE tb_emprestimos\n"
                    + "SET data_finalizado = CURRENT_DATE\n"
                    + "WHERE id = " + id);

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return true;
    }

    public Emprestimo carregarEmprestimoBD() {
        /**
         * Cria um objeto Emprestimo para armazenar os dados carregados
         */
        Emprestimo objeto = new Emprestimo();
        try {
            /**
             * Cria um statement para executar a consulta
             */
            Statement stmt = connect.getConexao().createStatement();

            /**
             * Executa a consulta SQL para obter os dados do empréstimo com o ID
             * especificado
             */
            ResultSet res = stmt.executeQuery("SELECT e.id AS id, a.nome AS nome_amigo, a.telefone, f.nome AS nome_ferramenta, f.preco\n"
                    + "FROM tb_emprestimos e\n"
                    + "JOIN tb_amigos a ON e.id_amigo = a.id\n"
                    + "JOIN tb_ferramentas f ON e.id_ferramenta = f.id ORDER BY id ASC;");
            res.next();

            objeto.setId(res.getInt("id"));
            objeto.setIdAmigo(res.getInt("id_amigo"));
            objeto.setIdFerramenta(res.getInt("id_ferramenta"));
            objeto.setDataEmprestimo(res.getDate("data_emprestimo"));
            objeto.setDataLimite(res.getDate("data_limite"));
            objeto.setDataFinalizado(res.getDate("data_finalizado"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);

        }
        return objeto;
    }

    public ArrayList<Emprestimo> getEmprestimosAtivos() {

        /**
         * Limpa a lista atual antes de preenchê-la
         */
        ListaEmprestimosAtivos.clear();

        try {
            /**
             * Cria um statement para executar a consulta
             */
            Statement stmt = connect.getConexao().createStatement();
            /**
             * Executa a consulta SQL para obter os empréstimos que ainda não
             * foram data_finalizados
             */
            ResultSet res = stmt.executeQuery("SELECT a.nome AS nome_amigo, a.telefone, f.nome AS nome_ferramenta, f.preco\n"
                    + "	FROM tb_emprestimos e\n"
                    + "	JOIN tb_amigos a ON e.id_amigo = a.id\n"
                    + "	JOIN tb_ferramentas f ON e.id_ferramenta = f.id;");
            /**
             * Itera sobre o resultado da consulta
             */
            while (res.next()) {

                /**
                 * Obtém os dados de cada empréstimo do resultado
                 */
                int id = res.getInt("id");
                Date data_emp = res.getDate("data_emprestimo");
                Date data_dev = res.getDate("data_limite");
                boolean data_finalizado = res.getBoolean("data_finalizado");
                int idEmp = res.getInt("id_amigo");

                /**
                 * Cria um objeto Emprestimo com os dados obtidos e o adiciona à
                 * lista de empréstimos ativos
                 */
                Emprestimo objeto = new Emprestimo(data_emp, data_dev, data_finalizado, id, idEmp);
                ListaEmprestimosAtivos.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return ListaEmprestimosAtivos;
    }

    /**
     * Método para verificar se um empréstimo específico ainda está pendente
     *
     * @param id
     * @return
     */
    public boolean verificarPendencia(int id) {

        try {
            /**
             * Cria um statement para executar a consulta
             */
            Statement stmt = connect.getConexao().createStatement();
            /**
             * Executa a consulta SQL para obter os empréstimos
             */
            ResultSet res = stmt.executeQuery("select id, data_finalizado from tb_emprestimos;");
            /**
             * Itera sobre o resultado da consulta
             */
            while (res.next()) {

                /**
                 * Obtém os dados de cada empréstimo do resultado
                 */
                int idEmp = res.getInt("id");
                boolean data_finalizado = res.getBoolean("data_finalizado");

                /**
                 * Verifica se o empréstimo com o ID especificado ainda não foi
                 * data_finalizado
                 */
                if (idEmp == id && data_finalizado == false) {
                    return true;
                    /**
                     * Retorna que o empréstimo ainda está ativo
                     */
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return false;
    }

    /**
     * Método para alterar o ID do empréstimo na tabela de ferramentas
     *
     * @return
     */
    public boolean alterarIdEmpFerramentaPendente(int id) {
        String sql = "UPDATE tb_ferramentas SET id = null WHERE id = ?";
        try {
            PreparedStatement stmt = connect.getConexao().prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.execute();

            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }
}
