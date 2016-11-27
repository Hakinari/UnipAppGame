package br.unip.cc.aps.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "Recorde.getTodos", query = "Select recorde from Recorde recorde")
@Entity
@Table(name = "TB_RECORDE")
public class Recorde implements Serializable{
    
    @Id
    @Column(name = "POSICAO",nullable = false)
    private int posicao;
    @Column(name = "NOME",nullable = false)
    private String nome;
    @Column(name = "PONTOS",nullable = false)
    private int pontos;
    
    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public Recorde(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public Recorde(int posicao, String nome, int pontos) {
        this.posicao = posicao;
        this.nome = nome;
        this.pontos = pontos;
    }

    public Recorde(String nome) {
        this.nome = nome;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
}
