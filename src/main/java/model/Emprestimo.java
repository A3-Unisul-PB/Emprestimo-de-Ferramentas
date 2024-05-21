package model;

import java.sql.Date;

public class Emprestimo {
    private int id;
    private int idAmigo;
    private int idFerramenta;
    private Date dataLimite;

    public Emprestimo() {
        this(0, 0, 0, null);
    }
    
    public Emprestimo(int id, int nomeAmigo, int nomeFerramenta, Date dataLimite) {
        this.id = id;
        this.idAmigo = idAmigo;
        this.idFerramenta = idFerramenta;
        this.dataLimite = dataLimite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    public int getIdFerramenta() {
        return idFerramenta;
    }

    public void setIdFerramenta(int idFerramenta) {
        this.idFerramenta = idFerramenta;
    }

    public Date getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }
}
