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
    
    public ArrayList<Relatorio> getTotais(){
        minhaLista.clear();
        
        String query = "SELECT a.nome AS nome_amigo, f.nome AS nome_ferramenta "+
                "FROM tb_emprestimos e "+
                "JOIN tb_amigos a ON e.id_amigo = a.id "+
                "JOIN tb_ferramentas f ON e.id_ferramenta = f.id;";
        
        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery(query);
            
            while(res.next()){
                String amigoNome = res.getString("nome_amigo");
                String ferramentaNome = res.getString("nome_ferramenta");
                Relatorio objeto = new Relatorio(amigoNome, ferramentaNome);
                minhaLista.add(objeto);
            }
            stmt.close();
        } catch (SQLException ex){
            System.out.println("Erro: "+ex);
        }
        return minhaLista;
    }
    
        public ArrayList<Relatorio> getAtrasados(){
        minhaLista.clear();
        
        String query = "SELECT a.nome AS nome_amigo, \n" +
            "f.nome AS nome_ferramenta " +
            "FROM tb_emprestimos e " +
            "JOIN tb_amigos a ON e.id_amigo = a.id " +
            "JOIN tb_ferramentas f ON e.id_ferramenta = f.id " +
            "WHERE e.data_limite < NOW();";
        
        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery(query);
            
            while(res.next()){
                String amigoNome = res.getString("nome_amigo");
                String ferramentaNome = res.getString("nome_ferramenta");
                
                
            }
            stmt.close();
        } catch (SQLException ex){
            System.out.println("Erro: "+ex);
        }
        return minhaLista;
    }
}
