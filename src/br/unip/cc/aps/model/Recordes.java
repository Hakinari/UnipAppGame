package br.unip.cc.aps.model;

public class Recordes {
    
    private String nome;
    private int pontos;

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public Recordes(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }
}
