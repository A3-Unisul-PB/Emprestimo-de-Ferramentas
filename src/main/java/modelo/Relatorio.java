package modelo;

import dao.ConexaoBancoDeDados;
import dao.RelatorioDAO;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Classe para representar um relatório.
 */
public class Relatorio {
    
   public String amigoNome;
   public String FerramentaNome;
   public String telefone;
   public Double preco;
   
   private RelatorioDAO dao;

    /**
     * Construtor da classe Relatorio.
     * @param amigoNome O nome do amigo.
     * @param FerramentaNome O nome da ferramenta.
     * @param telefone O telefone do amigo.
     * @param preco O preço da ferramenta.
     */
    public Relatorio(String amigoNome, String FerramentaNome, String telefone, Double preco) {
        this.amigoNome = amigoNome;
        this.FerramentaNome = FerramentaNome;
        this.telefone = telefone;
        this.preco = preco;
         dao = new RelatorioDAO();
    }

    /**
     * Construtor padrão da classe Relatorio.
     */
    public Relatorio() {
        this("","","",0.0);
    }

    /**
     * Método para obter o nome do amigo.
     * @return O nome do amigo.
     */
    public String getAmigoNome() {
        return amigoNome;
    }

    /**
     * Método para definir o nome do amigo.
     * @param amigoNome O nome do amigo.
     */
    public void setAmigoNome(String amigoNome) {
        this.amigoNome = amigoNome;
    }

    /**
     * Método para obter o nome da ferramenta.
     * @return O nome da ferramenta.
     */
    public String getFerramentaNome() {
        return FerramentaNome;
    }

    /**
     * Método para definir o nome da ferramenta.
     * @param FerramentaNome O nome da ferramenta.
     */
    public void setFerramentaNome(String FerramentaNome) {
        this.FerramentaNome = FerramentaNome;
    }

    /**
     * Método para obter o telefone do amigo.
     * @return O telefone do amigo.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Método para definir o telefone do amigo.
     * @param telefone O telefone do amigo.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Método para obter o preço da ferramenta.
     * @return O preço da ferramenta.
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * Método para definir o preço da ferramenta.
     * @param preco O preço da ferramenta.
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    /**
     * Método para obter os totais dos relatórios.
     * @return Uma lista de objetos Relatorio com os totais.
     */
    public ArrayList<Relatorio> getTotais(){
        return dao.getTotais();
    }
    
    /**
     * Método para obter os relatórios ativos.
     * @return Uma lista de objetos Relatorio com os relatórios ativos.
     */
    public ArrayList<Relatorio> getAtivos(){
        return dao.getAtivos();
    }
    
    /**
     * Método para obter os relatórios atrasados.
     * @return Uma lista de objetos Relatorio com os relatórios atrasados.
     */
    public ArrayList<Relatorio> getAtrasados(){
        return dao.getAtrasados();
    }
}
