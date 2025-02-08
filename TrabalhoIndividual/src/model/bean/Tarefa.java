  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author yanma
 */
public class Tarefa {
    
    private int id;
    private String importancia;
    private String nome;
    private String descricao;
    private String tipo;
    private String datafinal;
    private String estado;

    public Tarefa(int id, String importancia, String nome, String descricao, String tipo, String datafinal, String estado) {
        this.id = id;
        this.importancia = importancia;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.datafinal = datafinal;
        this.estado = estado;
    }

    public Tarefa(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(String datafinal) {
        this.datafinal = datafinal;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return "Importancia:" + this.importancia + "\n"+
                "Nome: "      + this.nome        + "\n"+
                "Descrição: " + this.descricao   + "\n"+
                "Tipo: "      + this.tipo        + "\n"+
                "datafinal: " + this.datafinal   + "\n"+           
                "estado: " + this.estado   + "\n";           
    }
}
