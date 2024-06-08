package model;

import java.sql.Date;
import java.util.ArrayList;

import dao.EmprestimoDAO;

public class Emprestimo {
    private int id, idAmigo, idFerramenta;
    private EmprestimoDAO dao;
    private Date dataEmprestimo;
    private Date dataLimite;
    private Date dataFinalizado;

    public Emprestimo() {
        this(0, 0, 0, null, null, null);
        this.dao = new EmprestimoDAO();
    }

    public Emprestimo(int id, int idAmigo, int idFerramenta, Date dataEmprestimo, Date dataLimite,
            Date dataFinalizado) {
        this.id = id;
        this.idAmigo = idAmigo;
        this.idFerramenta = idFerramenta;
        this.dataEmprestimo = dataEmprestimo;
        this.dataLimite = dataLimite;
        this.dataFinalizado = dataFinalizado;
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

    public EmprestimoDAO getDao() {
        return dao;
    }

    public void setDao(EmprestimoDAO dao) {
        this.dao = dao;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }

    public Date getDataFinalizado() {
        return dataFinalizado;
    }

    public void setDataFinalizado(Date dataFinalizado) {
        this.dataFinalizado = dataFinalizado;
    }

    public void setAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    public ArrayList<Emprestimo> getListaEmprestimos() {
        return dao.getMinhaLista();
    }

    public boolean inserirEmprestimo(int idAmigo, int idFerramenta, Date dataEmprestimo, Date dataLimite,
            Date dataFinalizado) {
        int id = dao.maiorId() + 1;
        Emprestimo objeto = new Emprestimo(id, idAmigo, idFerramenta, dataEmprestimo, dataLimite, dataFinalizado);
        return dao.inserirEmprestimoBD(objeto);
    }
}