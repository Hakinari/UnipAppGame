
package br.unip.cc.aps.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@NamedQueries({
    @NamedQuery(name = "Material.getTodos", query = "Select material from Material material"),
    @NamedQuery(name = "Material.getPorTipo", 
// :nomeDoParametro veja abaixo o exemplo tipo
            query = "Select material from Material material where material.tipo = :tipo"),
    
})
@Entity
@Table(name = "TB_MATERIAL")
public class Material implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;
    @Column(name = "IMAGEM", nullable = false)
    private String imagem;
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", nullable = false)
    private TipoMaterial tipo;

    public Material(int id, String imagem, TipoMaterial tipo) {
        this.id = id;
        this.imagem = imagem;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public TipoMaterial getTipo() {
        return tipo;
    }

    public void setTipo(TipoMaterial tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.imagem);
        hash = 29 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Material other = (Material) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.imagem, other.imagem)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", imagem=" + imagem + ", tipo=" + tipo + '}';
    }
    
    
  

    public Material() {
    }

    
  
    
    
}