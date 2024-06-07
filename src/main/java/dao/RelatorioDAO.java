package dao;

import model.Relatorio;
import java.sql.*;
import java.util.ArrayList;

public class RelatorioDAO {

    private ArrayList<Relatorio> minhaLista = new ArrayList<>();
    private DatabaseConnection db;
    
    public RelatorioDAO() {
        this.db = new DatabaseConnection();
    }

    public ArrayList<Relatorio> getTotais() {

        String query = "SELECT a.nome AS nome_amigo, f.nome AS nome_ferramenta, a.telefone AS telefone_amigo ,f.preco AS preco "
                + "FROM tb_emprestimos e "
                + "JOIN tb_amigos a ON e.id_amigo = a.id_amigo "
                + "JOIN tb_ferramentas f ON e.id_ferramenta = f.id_ferramenta "
                + "ORDER BY nome_amigo;";
        getRelatorio(query);

        return minhaLista;
    }

    public ArrayList<Relatorio> getAtrasados() {

        String query = "SELECT a.nome AS nome_amigo, f.nome AS nome_ferramenta, a.telefone AS telefone_amigo ,f.preco AS preco "
                + "FROM tb_emprestimos e "
                + "JOIN tb_amigos a ON e.id_amigo = a.id_amigo "
                + "JOIN tb_ferramentas f ON e.id_ferramenta = f.id_ferramenta "
                + "WHERE e.data_devolucao < NOW() "
                + "ORDER BY nome_amigo;";
        getRelatorio(query);

        return minhaLista;
    }

    public ArrayList<Relatorio> getAtivos() {

        String query = "SELECT a.nome AS nome_amigo, f.nome AS nome_ferramenta, a.telefone AS telefone_amigo,f.preco AS preco "
                + "FROM tb_emprestimos e "
                + "JOIN tb_amigos a ON e.id_amigo = a.id_amigo "
                + "JOIN tb_ferramentas f ON e.id_ferramenta = f.id_ferramenta "
                + "WHERE e.data_devolucao >= NOW() "
                + "ORDER BY nome_amigo;";
        getRelatorio(query);

        return minhaLista;
    }

    public ArrayList<Relatorio> getRelatorio(String query) {
        minhaLista.clear();

        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery(query);

            while (res.next()) {
                String amigoNome = res.getString("nome_amigo");
                String ferramentaNome = res.getString("nome_ferramenta");
                String telefone = res.getString("telefone_amigo");
                Double preco = res.getDouble("preco");
                Relatorio objeto = new Relatorio(amigoNome, ferramentaNome, telefone, preco);
                minhaLista.add(objeto);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return minhaLista;
    }
    
    public String valorTotal() {
        double preco = 0;
        try {
            String query = "SELECT SUM(preco) FROM tb_ferramentas";
            PreparedStatement statement = DatabaseConnection.getConexao().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                preco = resultSet.getDouble(1);
            }
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        String format = String.format("%.2f", preco);
        return format;
    }
}