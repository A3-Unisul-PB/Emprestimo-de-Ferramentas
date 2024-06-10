package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

/**
 * Classe Amigo que representa um amigo.
 */
public class Amigo {

    private int id; // Identificador do amigo
    private String nome; // Nome do amigo
    private String telefone; // Telefone do amigo
    AmigoDAO dao; // DAO para operações de banco de dados

    /**
     * Construtor padrão.
     */
    public Amigo() {
        this(0, "", "");
    }

    /**
     * Construtor com parâmetros.
     * @param id O identificador do amigo.
     * @param nome O nome do amigo.
     * @param telefone O telefone do amigo.
     */
    public Amigo (int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        dao = new AmigoDAO();
    }

    /**
     * Retorna o ID do amigo.
     * @return O ID do amigo.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do amigo.
     * @param id O novo ID do amigo.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Retorna o nome do amigo.
     * @return O nome do amigo.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do amigo.
     * @param nome O novo nome do amigo.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Retorna o telefone do amigo.
     * @return O telefone do amigo.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do amigo.
     * @param telefone O novo telefone do amigo.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna uma representação em string do objeto Amigo.
     * @return Uma representação em string do objeto Amigo.
     */
    @Override
    public String toString() {
        return super.toString() + "nome=" + nome + ", Telfone=" + telefone;
    }

    /**
     * Retorna a lista de amigos.
     * @return A lista de amigos.
     */
    public ArrayList<Amigo> getMinhaLista() {
        return dao.getMinhaLista();
    }

    /**
     * Insere um novo amigo no banco de dados.
     * @param nome O nome do novo amigo.
     * @param telefone O telefone do novo amigo.
     * @return Verdadeiro se a inserção foi bem sucedida, falso caso contrário.
     */
    public boolean insertAmigoBD(String nome, String telefone) {
        int id = this.maiorID() + 1;
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.insertAmigoBD(objeto);
        return true;
    }

    /**
     * Deleta um amigo do banco de dados.
     * @param id O ID do amigo a ser deletado.
     * @return Verdadeiro se a deleção foi bem sucedida, falso caso contrário.
     */
    public boolean deleteAmigoBD(int id) {
        dao.deleteAmigoBD(id);
        return true;
    }

    /**
     * Atualiza um amigo no banco de dados.
     * @param id O ID do amigo a ser atualizado.
     * @param nome O novo nome do amigo.
     * @param telefone O novo telefone do amigo.
     * @return Verdadeiro se a atualização foi bem sucedida, falso caso contrário.
     */
    public boolean updateAmigoBD(int id, String nome, String telefone) {
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.updateAmigoBD(objeto);
        return true;
    }

    /**
     * Carrega um amigo do banco de dados.
     * @param id O ID do amigo a ser carregado.
     * @return O objeto Amigo carregado do banco de dados.
     */
    public Amigo carregaAmigo(int id) {
        return dao.carregaAmigo(id);
    }

    /**
     * Retorna o maior ID entre os amigos.
     * @return O maior ID entre os amigos.
     */
    public int maiorID() {
        return dao.maiorID();
    }
}
