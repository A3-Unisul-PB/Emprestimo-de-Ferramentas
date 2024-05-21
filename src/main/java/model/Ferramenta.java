package model;

import dao.FerramentaDAO;
import java.util.ArrayList;

/**
 * Classe Ferramenta que representa uma ferramenta.
 */
public class Ferramenta {

    private int id; // Identificador da ferramenta
    private String nome; // Nome da ferramenta
    private String marca; // Marca da ferramenta
    private double preco; // Preço da ferramenta
    FerramentaDAO dao; // DAO para operações de banco de dados

    /**
     * Construtor padrão.
     */
    public Ferramenta() {
        this(0, "", "", 0.0);
    }

    /**
     * Construtor com parâmetros.
     * @param id O identificador da ferramenta.
     * @param nome O nome da ferramenta.
     * @param marca A marca da ferramenta.
     * @param preco O preço da ferramenta.
     */
    public Ferramenta(int id, String nome, String marca, double preco) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        dao = new FerramentaDAO();
    }

    /**
     * Retorna o ID da ferramenta.
     * @return O ID da ferramenta.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID da ferramenta.
     * @param id O novo ID da ferramenta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome da ferramenta.
     * @return O nome da ferramenta.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da ferramenta.
     * @param nome O novo nome da ferramenta.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a marca da ferramenta.
     * @return A marca da ferramenta.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define a marca da ferramenta.
     * @param marca A nova marca da ferramenta.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Retorna o preço da ferramenta.
     * @return O preço da ferramenta.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço da ferramenta.
     * @param preco O novo preço da ferramenta.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Retorna uma representação em string do objeto Ferramenta.
     * @return Uma representação em string do objeto Ferramenta.
     */
    @Override
    public String toString() {
        return super.toString() + "ferramenta=" + nome + ", marca=" + marca + "preco=" + preco;
    }

    /**
     * Retorna a lista de ferramentas.
     * @return A lista de ferramentas.
     */
    public ArrayList<Ferramenta> getMinhaLista() {
        return dao.getMinhaLista();
    }

    /**
     * Insere uma nova ferramenta no banco de dados.
     * @param ferramenta O nome da nova ferramenta.
     * @param marca A marca da nova ferramenta.
     * @param preco O preço da nova ferramenta.
     * @return Verdadeiro se a inserção foi bem sucedida, falso caso contrário.
     */
    public boolean insertFerramentaBD(String ferramenta, String marca, double preco) {
        int id = this.maiorID() + 1;
        Ferramenta objeto = new Ferramenta(id, ferramenta, marca, preco);
        dao.insertFerramentaBD(objeto);
        return true;
    }

    /**
     * Deleta uma ferramenta do banco de dados.
     * @param id O ID da ferramenta a ser deletada.
     * @return Verdadeiro se a deleção foi bem sucedida, falso caso contrário.
     */
    public boolean deleteFerramentaBD(int id) {
        dao.deleteFerramentaBD(id);
        return true;
    }

    /**
     * Atualiza uma ferramenta no banco de dados.
     * @param id O ID da ferramenta a ser atualizada.
     * @param ferramenta O novo nome da ferramenta.
     * @param marca A nova marca da ferramenta.
     * @param preco O novo preço da ferramenta.
     * @return Verdadeiro se a atualização foi bem sucedida, falso caso contrário.
     */
    public boolean updateFerramentaBD(int id, String ferramenta, String marca, double preco) {
        Ferramenta objeto = new Ferramenta(id, ferramenta, marca, preco);
        dao.updateFerramentaBD(objeto);
        return true;
    }

    /**
     * Carrega uma ferramenta do banco de dados.
     * @param id O ID da ferramenta a ser carregada.
     * @return O objeto Ferramenta carregado do banco de dados.
     */
    public Ferramenta carregaFerramenta(int id) {
        return dao.carregaFerramenta(id);
    }

    /**
     * Retorna o maior ID entre as ferramentas.
     * @return O maior ID entre as ferramentas.
     */
    public int maiorID() {
        return dao.maiorID();
    }
}
