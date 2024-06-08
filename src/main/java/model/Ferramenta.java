package model;

import dao.FerramentaDAO;
import java.util.ArrayList;

public class Ferramenta {

    /**
     * Atributos.
     */
    private int id;
    private String nome;
    private String marca;
    private double preco;
    FerramentaDAO dao;

    /**
     * Construtor de Objeto Vazio.
     */
    public Ferramenta() {
        this(0, "", "", 0.0);
    }

    /**
     * Construtor com parâmetro que inicializa os atributos com os valores
     * fornecidos.
     *
     * @param id - Identificador do objeto.
     * @param ferramenta - Ferramenta associada ao objeto.
     * @param marca - Marca da ferramenta.
     * @param preco - Preço da ferramenta.
     */
    public Ferramenta(int id, String nome, String marca, double preco) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        dao = new FerramentaDAO();
    }

    /**
     * Métodos GET e SET.
     *
     * @return - Retorna o valor do atributo.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do objeto.
     *
     * @param id - Identificador do objeto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna a ferramenta associada ao objeto.
     *
     * @return - Retorna a ferramneta associada ao objeto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define a ferramenta associada ao objeto.
     *
     * @param Nome - Ferramenta a ser associada ao objeto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a marca da ferramenta.
     *
     * @return - Retorna a marca da ferramenta.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Difine a marca da ferramenta.
     *
     * @param Marca - Marca da ferramenta.
     */
    public void setMarca(String Marca) {
        this.marca = marca;
    }

    /**
     * Retorna o preço da ferramenta.
     *
     * @return - Retorna o preço da ferramenta.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço da ferramenta.
     *
     * @param preco - Preço da ferramenta.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Representação em string do objeto.
     *
     * @return - Retorna uma representação em string do objeto.
     */
    @Override
    public String toString() {
        return super.toString() + "nome=" + nome + ", marca=" + marca + "preco=" + preco;
    }

    /**
     * Lista de ferramentas.
     *
     * @return - Retorna a lista de ferramentas.
     */
    public ArrayList<Ferramenta> getMinhaLista() {
        return dao.getMinhaLista();
    }

    /**
     * Insere uma ferramenta no banco de dados.
     *
     * @param nome - Ferramenta a ser inserida.
     * @param marca - Marca da ferramenta a ser inserida.
     * @param preco - Preço da ferramenta a ser inserida.
     * @return - Verdadeiro se a inserção for bem-sucedida, falso caso
     * contrário.
     */
    public boolean insertFerramentaBD(String nome, String marca, double preco) {
        int id = this.maiorID() + 1;
        Ferramenta objeto = new Ferramenta(id, nome, marca, preco);
        dao.insertFerramentaBD(objeto);
        return true;

    }

    /**
     * Remove uma ferramenta do banco de dados.
     *
     * @param id - Identificador da ferramenta a ser removida.
     * @return - Vardeiro se a remoção for bem-sucedida, falso caso contrário.
     */
    public boolean deleteFerramentaBD(int id) {
        dao.deleteFerramentaBD(id);
        return true;
    }

    /**
     * Atualiza uma ferramenta no banco de dados.
     *
     * @param id - Identificador da ferramenta a ser atualizada.
     * @param nome - Nova ferramenta a ser associada ao objeto.
     * @param marca - Nova marca da ferramenta.
     * @param preco - Novo preço da ferramenta.
     * @return - Verdadeiro se a atualização for bem-sucedida, falso caso
     * contrário.
     */
    public boolean updateFerramentaBD(int id, String nome, String marca, double preco) {
        Ferramenta objeto = new Ferramenta(id, nome, marca, preco);
        dao.updateFerramentaBD(objeto);
        return true;
    }

    /**
     * Carrega uma ferramenta do banco de dados.
     *
     * @param id - Identificador da ferramenta a ser carregada.
     * @return - Retorna a ferramenta carregada do banco de dados.
     */
    public Ferramenta carregaFerramenta(int id) {
        return dao.carregaFerramenta(id);
    }

    /**
     * Retorna o maior identificador de ferramenta no banco de dados.
     *
     * @return - Retorna o maior identificador de ferramenta no banco de dados.
     */
    public int maiorID() {
        return dao.maiorID();
    }
}