package modelo;

import dao.EmprestimoDAO;
import java.sql.Date;
import java.util.ArrayList;

public class Emprestimo {

    private Date dataEmprestimo;
    /**
     * Data do empréstimo
     */
    private Date dataDevolucao;
    /**
     * Data prevista de devolução
     */
    private boolean entregue;
    /**
     * Indica se o item emprestado foi devolvido
     */
    private int id, idAmg;
    /**
     * Identificadores do empréstimo e do amigo relacionado
     */
    private EmprestimoDAO dao;

    /**
     * Objeto para acessar os métodos da classe EmprestimoDAO
     */

    /**
     * Construtor padrão da classe Emprestimo
     */
    public Emprestimo() {
        this(null, null, false, 0, 0);
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
    public Emprestimo(Date dataEmprestimo, Date dataDevolucao, boolean entregue, int id, int idAmg) {
        this.dataEmprestimo = dataEmprestimo;
        /**
         * Inicializa a data do empréstimo
         */
        this.dataDevolucao = dataDevolucao;
        /**
         * Inicializa a data de devolução
         */
        this.entregue = entregue;
        /**
         * Inicializa o status de entrega
         */
        this.id = id;
        /**
         * Inicializa o ID do empréstimo
         */
        this.idAmg = idAmg;
        /**
         * Inicializa o ID do amigo relacionado
         */
    }

    /**
     * Métodos getters e setters para os atributos da classe Emprestimo
     *
     * @return
     */
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAmg() {
        return idAmg;
    }

    public void setIdAmg(int idAmg) {
        this.idAmg = idAmg;
    }

    /**
     * Método para obter a lista de empréstimos do banco de dados
     *
     * @return
     */
    public ArrayList<Emprestimo> getListaEmprestimos() {
        return dao.getMinhaLista();
    }

    /**
     * Método para inserir um novo empréstimo no banco de dados
     *
     * @param dataEmprestimo
     * @param dataDevolucao
     * @param entregue
     * @param idAmg
     * @return
     */
    public boolean inserirEmprestimo(Date dataEmprestimo, Date dataDevolucao, boolean entregue, int idAmg) {
        id = dao.maiorId() + 1;
        /**
         * Obtém o próximo ID disponível
         */
        Emprestimo objeto = new Emprestimo(dataEmprestimo, dataDevolucao, entregue, id, idAmg);
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

    /**
     * Método para apagar um empréstimo do banco de dados
     */
    public boolean apagarEmprestimo(int id) {
        dao.apagarEmprestimoBD(id);
        /**
         * Apaga o empréstimo do banco de dados
         */
        return true;
        /**
         * Retorna true para indicar sucesso na exclusão
         */
    }

    /**
     * Método para alterar os dados de um empréstimo no banco de dados
     */
    public boolean alterarEmprestimo(Date dataDevolucao, boolean entregue, int id) {
        Emprestimo objeto = new Emprestimo(dataEmprestimo, dataDevolucao, entregue, id, idAmg);
        /**
         * Cria um novo objeto Emprestimo com os dados atualizados
         */
        dao.alterarEmprestimoBD(objeto);
        /**
         * Altera os dados do empréstimo no banco de dados
         */
        return true;
        /**
         * Retorna true para indicar sucesso na alteração
         */
    }

    /**
     * Método para carregar os dados de um empréstimo do banco de dados
     *
     * @param id
     * @return
     */
    public Emprestimo carregarEmprestimo(int id) {
        return dao.carregarEmprestimoBD(id);
        /**
         * Carrega os dados do empréstimo do banco de dados e retorna o objeto
         * Emprestimo correspondente
         */
    }
}
