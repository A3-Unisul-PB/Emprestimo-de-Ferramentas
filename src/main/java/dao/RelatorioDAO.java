package dao;

import modelo.Relatorio;
import java.sql.*;
import java.util.ArrayList;

/**
 * Classe para manipular os dados de relatórios no banco de dados.
 */
public class RelatorioDAO {
    
    private ArrayList<Relatorio> minhaLista = new ArrayList<>();
    private ConexaoBancoDeDados db;

    /**
     * Construtor da classe RelatorioDAO.
     * Inicializa a conexão com o banco de dados.
     */
    public RelatorioDAO() {
        this.db = new ConexaoBancoDeDados();
    }
    
    /**
     * Método para obter os totais dos relatórios.
     * @return Uma lista de objetos Relatorio com os totais.
     */
    public ArrayList<Relatorio> getTotais(){
        
        String query = "SELECT a.nome AS nome, f.nome AS nome, a.telefone AS telefone_amigo ,f.preco AS preco "+
            "FROM tb_emprestimos e "+
            "JOIN tb_amigos a ON e.id_amigo = a.id "+
            "JOIN tb_ferramentas f ON e.id_ferramenta = f.id "+
            "ORDER BY nome_amigo;";
        getRelatorio(query);
        
        return minhaLista;
    }
    
    /**
     * Método para obter os relatórios atrasados.
     * @return Uma lista de objetos Relatorio com os relatórios atrasados.
     */
    public ArrayList<Relatorio> getAtrasados(){
        
        String query = "SELECT a.nome AS nome_amigo, f.nome AS nome_ferramenta, a.telefone AS telefone_amigo ,f.preco AS preco " +
            "FROM tb_emprestimos e " +
            "JOIN tb_amigos a ON e.id_amigo = a.id " +
            "JOIN tb_ferramentas f ON e.id_ferramenta = f.id " +
            "WHERE e.data_limite < NOW() "+
            "ORDER BY nome_amigo;";
        getRelatorio(query);
            
        return minhaLista;
    }
    
    /**
     * Método para obter os relatórios ativos.
     * @return Uma lista de objetos Relatorio com os relatórios ativos.
     */
    public ArrayList<Relatorio> getAtivos(){
        
        String query = "SELECT a.nome AS nome_amigo, f.nome AS nome_ferramenta, a.telefone AS telefone_amigo,f.preco AS preco " +
            "FROM tb_emprestimos e " +
            "JOIN tb_amigos a ON e.id_amigo = a.id " +
            "JOIN tb_ferramentas f ON e.id_ferramenta = f.id " +
            "WHERE e.data_limite >= NOW() "+
            "ORDER BY nome_amigo;";
        getRelatorio(query);
            
        return minhaLista;
    }
    
    /**
     * Método para obter um relatório com base em uma consulta SQL.
     * @param query A consulta SQL para obter o relatório.
     * @return Uma lista de objetos Relatorio com o relatório.
     */
    public ArrayList<Relatorio> getRelatorio(String query){
        minhaLista.clear();
        
        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery(query);
            
            while(res.next()){
                String amigoNome = res.getString("nome_amigo");
                String ferramentaNome = res.getString("nome_ferramenta");
                String telefone = res.getString("telefone_amigo");
                Double preco = res.getDouble("preco");
                Relatorio objeto = new Relatorio(amigoNome, ferramentaNome,telefone,preco);
                minhaLista.add(objeto);
            }
            stmt.close();
        } catch (SQLException ex){
            System.out.println("Erro: "+ex);
        }
        return minhaLista;
    }
        
}
