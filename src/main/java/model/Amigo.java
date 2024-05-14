package model;

import dao.AmigoDAO;
import java.util.ArrayList;

public class Amigo {

    // Atributos
    private int id;
    private String nome;
    private int telefone;
    AmigoDAO dao;

    // Construtor de Objeto Vazio
    public Amigo() {
        this(0, "", 0);
    }

    // Construtor com parâmetro
    public Amigo (int id, String Nome, int Telefone) {
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

    public void setNome(String Nome) {
        this.nome = nome;
    }
    
    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int Telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return super.toString() + "nome=" + nome + ", Telfone=" + telefone;
    }

    public ArrayList<Amigo> getMinhaLista() {
        return dao.getMinhaLista();
    }

    public boolean insertAmigoBD(String nome, int telefone) {
        int id = this.maiorID() + 1;
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.insertAmigoBD(objeto);
        return true;

    }

    public boolean deleteAmigoBD(int id) {
        dao.deleteAmigoBD(id);
        return true;
    }

    public boolean updateAmigoBD(int id, String nome, int telefone) {
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