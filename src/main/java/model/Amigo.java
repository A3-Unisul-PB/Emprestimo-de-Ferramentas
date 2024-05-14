package model;

import dao.AmigoDAO;
import java.util.ArrayList;

public class Amigo {

    // Atributos
    private int id;
    private String nome;
    private String telefone;
    AmigoDAO dao;

    // Construtor de Objeto Vazio
    public Amigo() {
        this(0, "", "");
    }

    // Construtor com parâmetro
    public Amigo (int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        dao = new AmigoDAO();
    }

    // Métodos GET e SET
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return super.toString() + "nome=" + nome + ", Telfone=" + telefone;
    }

    public ArrayList<Amigo> getMinhaLista() {
        return dao.getMinhaLista();
    }

    public boolean insertAmigoBD(String nome, String telefone) {
        int id = this.maiorID() + 1;
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.insertAmigoBD(objeto);
        return true;

    }

    public boolean deleteAmigoBD(int id) {
        dao.deleteAmigoBD(id);
        return true;
    }

    public boolean updateAmigoBD(int id, String nome, String telefone) {
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.updateAmigoBD(objeto);
        return true;
    }

    public Amigo carregaAmigo(int id) {
        return dao.carregaAmigo(id);
    }

    public int maiorID() {
        return dao.maiorID();
    }
}