package br.unip.cc.aps.model;


public class Material {
  
    private int id;
    private String imagem;
    private TipoMaterial tipo;

    public Material(String imagem) {
        this.imagem = imagem;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Material(int id, String imagem, TipoMaterial tipo) {
        this.id = id;
        this.imagem = imagem;
        this.tipo = tipo;
    }
    public int getId() {
        return id;
    }
    public TipoMaterial getTipo() {
        return tipo;
    }
    public String getImagem() {
        return imagem;
    }


}