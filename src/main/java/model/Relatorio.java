package model;

import dao.DatabaseConnection;
import java.sql.Date;
import java.util.ArrayList;

public class Relatorio {
    
   public String amigoNome;
   public String FerramentaNome;   

    public Relatorio(String amigoNome, String FerramentaNome) {
        this.amigoNome = amigoNome;
        this.FerramentaNome = FerramentaNome;
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
    
    
}
