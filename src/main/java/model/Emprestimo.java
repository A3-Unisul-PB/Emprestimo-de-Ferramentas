/**
 * O pacote model contém a classe Emprestimo.
 */
package model;

// Importação da classe Date do pacote java.sql.
import java.sql.Date;
import java.util.ArrayList;
import dao.EmprestimoDAO;
/**
 * A classe Emprestimo representa um empréstimo no programa.
 * Ela contém informações sobre o empréstimo e métodos para manipular essas informações.
 */
public class Emprestimo {
    private int id;
    private int idAmigo;
    private int idFerramenta;
    private Date dataLimite;
    private boolean concluido;
    
    private EmprestimoDAO dao;

    /**
     * Construtor padrão que inicializa o objeto Emprestimo com valores padrão.
     */

    public Emprestimo() {
        this(0, 0, 0, null, false);
    }
    
    /**
     * Construtor que inicializa o objeto Emprestimo com valores específicos.
     *
     * @param id O id do empréstimo.
     * @param idAmigo O id do amigo associado ao empréstimo.
     * @param idFerramenta O id da ferramenta associada ao empréstimo.
     * @param dataLimite A data limite do empréstimo.
     * @param concluido Status do empréstimo.
     */

    public Emprestimo(int id, int nomeAmigo, int nomeFerramenta, Date dataLimite, boolean concluido) {
        this.id = id;
        this.idAmigo = idAmigo;
        this.idFerramenta = idFerramenta;
        this.dataLimite = dataLimite;
        this.concluido = concluido;
        dao = new EmprestimoDAO();
    }

     // Métodos getter e setter para id, idAmigo, idFerramenta e dataLimite.
     /**
     * Retorna o id do empréstimo.
     *
     * @return O id do empréstimo.
     */
    public int getId() {
        return id;
    }

     /**
     * Define o id do empréstimo.
     *
     * @param id O novo id do empréstimo.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Retorna o id do amigo associado ao empréstimo.
     *
     * @return O id do amigo.
     */
    public int getIdAmigo() {
        return idAmigo;
    }
    
    /**
     * Define o id do amigo associado ao empréstimo.
     *
     * @param idAmigo O novo id do amigo.
     */
    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    /**
     * Retorna o id da ferramenta associada ao empréstimo.
     *
     * @return O id da ferramenta.
     */
    public int getIdFerramenta() {
        return idFerramenta;
    }

    /**
     * Define o id da ferramenta associada ao empréstimo.
     *
     * @param idFerramenta O novo id da ferramenta.
     */
    public void setIdFerramenta(int idFerramenta) {
        this.idFerramenta = idFerramenta;
    }

    /**
     * Retorna a data limite do empréstimo.
     *
     * @return A data limite do empréstimo.
     */
    public Date getDataLimite() {
        return dataLimite;
    }

    /**
     * Define a data limite do empréstimo.
     *
     * @param dataLimite A nova data limite do empréstimo.
     */
    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
    
    public ArrayList<Emprestimo> getMinhaLista() {
        return dao.getMinhaLista();
    }
    
    public String getUserById(int id) {
        return dao.getUserById(id);
    }
    
    public String getFerramentaById(int id) {
        return dao.getFerramentaById(id);
    }
}
