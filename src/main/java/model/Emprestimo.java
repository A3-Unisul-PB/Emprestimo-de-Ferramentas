package model;

import dao.EmprestimoDAO;
import java.sql.Date;
import java.util.ArrayList;

public class Emprestimo {

     /**
     * Indica se o item emprestado foi devolvido
     */
    private int id, idAmigo, idFerramenta;
    /**
     * Identificadores do empréstimo e do amigo relacionado
     */
    private EmprestimoDAO dao;
    
    private Date dataEmprestimo;
    /**
     * Data do empréstimo
     */
    private Date dataLimite;
    /**
     * Data prevista de devolução
     */
    private Date dataFinalizado;

    /**
     * Objeto para acessar os métodos da classe EmprestimoDAO
     */

    /**
     * Construtor padrão da classe Emprestimo
     */
    public Emprestimo() {
        this(0, 0, 0, null, null, null);
        /**
         * Chama o construtor sobrecarregado passando valores padrão
         */
        this.dao = new EmprestimoDAO();
        /**
         * Inicializa o objeto EmprestimoDAO para interagir com o banco de dados
         */
    }

    /**
     * Construtor sobrecarregado da classe Emprestimo
     */
    public Emprestimo(int id, int idAmigo, int idFerramenta, Date dataEmprestimo, Date dataLimite, Date dataFinalizado) {
        this.id = id;
        this.idAmigo = idAmigo;
        this.idFerramenta = idFerramenta;
        
        this.dataEmprestimo = dataEmprestimo;
        /**
         * Inicializa a data do empréstimo
         */
        this.dataLimite = dataLimite;
        /**
         * Inicializa a data de devolução
         */
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
    
    

    /**
     * Método para obter a lista de empréstimos do banco de dados
     *
     * @return
     */
    public ArrayList<Emprestimo> getListaEmprestimos() {
        return dao.getMinhaLista();
    }

    
    public boolean inserirEmprestimo(int id, int idAmigo, int idFerramenta, Date dataEmprestimo,Date dataLimite, Date dataFinalizado) {
        id = dao.maiorId() + 1;
        /**
         * Obtém o próximo ID disponível
         */
        Emprestimo objeto = new Emprestimo(id, idAmigo, idFerramenta, dataEmprestimo, dataLimite, dataFinalizado);
        /**
         * Cria um novo objeto Emprestimo
         */
        dao.inserirEmprestimoBD(objeto);
        /**
         * Insere o empréstimo no banco de dados
         */
        return true;
        /**
         * Retorna true para indicar sucesso na inserção
         */
    }
}
