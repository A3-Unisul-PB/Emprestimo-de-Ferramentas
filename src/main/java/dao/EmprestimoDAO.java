package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Emprestimo;

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
    
    public ArrayList<Emprestimo> ListaEmprestimosPendentes = new ArrayList<>();


    /**
     * Conexão com o banco de dados
     */
    private ConexaoBancoDeDados connect;

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
                int id = res.getInt("id_emprestimo");
                int idAmg = res.getInt("id_amigo");
                Date dataEmprestimo = res.getDate("data_emprestimo");
                Date dataDevolucao = res.getDate("data_devolucao");
                boolean entregue = res.getBoolean("entregue");

                /**
                 * Cria um objeto Emprestimo com os dados obtidos e o adiciona à
                 * lista
                 */
                Emprestimo objeto = new Emprestimo(dataEmprestimo, dataDevolucao, entregue, id, idAmg);
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
            ResultSet res = stmt.executeQuery("SELECT MAX(id_emprestimo) id FROM tb_emprestimos");
            res.next();
            maiorId = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorId;
    }

    /**
     * Método para inserir um novo empréstimo no banco de dados
     *
     * @param objeto
     * @return
     */
    public boolean inserirEmprestimoBD(Emprestimo objeto) {
        /**
         * SQL para inserção de um novo empréstimo
         */
        String sql = "INSERT INTO tb_emprestimos(id_emprestimo,id_amigo,data_emprestimo, data_devolucao, entregue) VALUES(?,?,?,?,?)";
        try {
            /**
             * Prepara o statement com a consulta SQL
             */
            PreparedStatement stmt = connect.getConexao().prepareStatement(sql);

            /**
             * Define os parâmetros da consulta com os dados do empréstimo
             */
            stmt.setInt(1, objeto.getId());
            stmt.setInt(2, objeto.getIdAmg());
            stmt.setDate(3, objeto.getDataEmprestimo());
            stmt.setDate(4, objeto.getDataDevolucao());
            stmt.setBoolean(5, objeto.isEntregue());

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

    /**
     * Método para apagar um empréstimo do banco de dados
     *
     * @param id
     * @return
     */
    public boolean apagarEmprestimoBD(int id) {
        try {
            /**
             * Cria um statement para executar a consulta
             */
            Statement stmt = connect.getConexao().createStatement();

            /**
             * Executa a consulta SQL para apagar o empréstimo com o ID
             * especificado
             */
            stmt.executeUpdate("DELETE FROM tb_emprestimos WHERE id_emprestimo = " + id);

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return true;
    }

    /**
     * Método para alterar os dados de um empréstimo no banco de dados
     *
     * @param objeto
     * @return
     */
    public boolean alterarEmprestimoBD(Emprestimo objeto) {
        /**
         * SQL para atualizar os dados de um empréstimo
         */
        String sql = "UPDATE tb_emprestimos set data_devolucao = ?, entregue = ? WHERE id_emprestimo = ?";
        try {
            /**
             * Prepara o statement com a consulta SQL
             */
            PreparedStatement stmt = connect.getConexao().prepareStatement(sql);

            /**
             * Define os parâmetros da consulta com os dados atualizados do
             * empréstimo
             */
            stmt.setDate(1, objeto.getDataDevolucao());
            stmt.setBoolean(2, objeto.isEntregue());
            stmt.setInt(3, objeto.getId());

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

    /**
     * Método para carregar os dados de um empréstimo do banco de dados
     *
     * @param id
     * @return
     */
    public Emprestimo carregarEmprestimoBD(int id) {
        /**
         * Cria um objeto Emprestimo para armazenar os dados carregados
         */
        Emprestimo objeto = new Emprestimo();
        objeto.setId(id);
        try {
            /**
             * Cria um statement para executar a consulta
             */
            Statement stmt = connect.getConexao().createStatement();

            /**
             * Executa a consulta SQL para obter os dados do empréstimo com o ID
             * especificado
             */
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos WHERE id_emprestimo = " + id);
            res.next();

            /**
             * Preenche o objeto Emprestimo com os dados obtidos do banco de
             * dados
             */
            objeto.setIdAmg(res.getInt("id_amigo"));
            objeto.setDataEmprestimo(res.getDate("data_emprestimo"));
            objeto.setDataDevolucao(res.getDate("data_devolucao"));
            objeto.setEntregue(res.getBoolean("entregue"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }

    /**
     * Método para obter a lista de empréstimos ativos
     *
     * @return
     */
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
             * foram entregues
             */
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos WHERE entregue is false");
            /**
             * Itera sobre o resultado da consulta
             */
            while (res.next()) {

                /**
                 * Obtém os dados de cada empréstimo do resultado
                 */
                int id = res.getInt("id_emprestimo");
                Date data_emp = res.getDate("data_emprestimo");
                Date data_dev = res.getDate("data_devolucao");
                boolean entregue = res.getBoolean("entregue");
                int idEmp = res.getInt("id_amigo");

                /**
                 * Cria um objeto Emprestimo com os dados obtidos e o adiciona à
                 * lista de empréstimos ativos
                 */
                Emprestimo objeto = new Emprestimo(data_emp, data_dev, entregue, id, idEmp);
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
            ResultSet res = stmt.executeQuery("select id_emprestimo, entregue from tb_emprestimos;");
            /**
             * Itera sobre o resultado da consulta
             */
            while (res.next()) {

                /**
                 * Obtém os dados de cada empréstimo do resultado
                 */
                int idEmp = res.getInt("id_emprestimo");
                boolean entregue = res.getBoolean("entregue");

                /**
                 * Verifica se o empréstimo com o ID especificado ainda não foi
                 * entregue
                 */
                if (idEmp == id && entregue == false) {
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
        String sql = "UPDATE tb_ferramentas SET id_emprestimo = null WHERE id_emprestimo = ?";
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
    
    public ArrayList<Emprestimo> getEmprestimosPendentes() {

        /**
         * Limpa a lista atual antes de preenchê-la
         */
        ListaEmprestimosPendentes.clear();

        try {
            /**
             * Cria um statement para executar a consulta
             */
            Statement stmt = connect.getConexao().createStatement();
            /**
             * Executa a consulta SQL para obter os empréstimos que ainda não
             * foram entregues
             */
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos WHERE entregue is false AND data_devolucao <  NOW()");
            /**
             * Itera sobre o resultado da consulta
             */
            while (res.next()) {

                /**
                 * Obtém os dados de cada empréstimo do resultado
                 */
                int id = res.getInt("id_emprestimo");
                Date data_emp = res.getDate("data_emprestimo");
                Date data_dev = res.getDate("data_devolucao");
                boolean entregue = res.getBoolean("entregue");
                int idEmp = res.getInt("id_amigo");

                /**
                 * Cria um objeto Emprestimo com os dados obtidos e o adiciona à
                 * lista de empréstimos ativos
                 */
                Emprestimo objeto = new Emprestimo(data_emp, data_dev, entregue, id, idEmp);
                ListaEmprestimosPendentes.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return ListaEmprestimosPendentes;
    }
}
