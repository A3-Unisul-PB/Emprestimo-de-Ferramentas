package model;

import dao.DatabaseConnection;
import dao.RelatorioDAO;
import java.sql.Date;
import java.util.ArrayList;

public class Relatorio {
    
   public String amigoNome;
   public String FerramentaNome;
   
   private RelatorioDAO dao;

    public Relatorio(String amigoNome, String FerramentaNome) {
        this.amigoNome = amigoNome;
        this.FerramentaNome = FerramentaNome;
         dao = new RelatorioDAO();
    }

    public Relatorio() {
        this("","");
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
