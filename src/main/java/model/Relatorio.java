package model;

import dao.DatabaseConnection;
import dao.RelatorioDAO;
import java.sql.Date;
import java.util.ArrayList;

public class Relatorio {
    
   public String amigoNome;
   public String FerramentaNome;
   public String telefone;
   public Double preco;
   
   private RelatorioDAO dao;

    public Relatorio(String amigoNome, String FerramentaNome, String telefone, Double preco) {
        this.amigoNome = amigoNome;
        this.FerramentaNome = FerramentaNome;
        this.telefone = telefone;
        this.preco = preco;
         dao = new RelatorioDAO();
    }

    public Relatorio() {
        this("","","",0.0);
    }

    public String getAmigoNome() {
        return amigoNome;
    }

    public void setAmigoNome(String amigoNome) {
        this.amigoNome = amigoNome;
    }

    public String getFerramentaNome() {
        return FerramentaNome;
    }

    public void setFerramentaNome(String FerramentaNome) {
        this.FerramentaNome = FerramentaNome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    public ArrayList<Relatorio> getTotais(){
        return dao.getTotais();
    }
    
    public ArrayList<Relatorio> getAtivos(){
        return dao.getAtivos();
    }
    
    public ArrayList<Relatorio> getAtrasados(){
        return dao.getAtrasados();
    }
}
