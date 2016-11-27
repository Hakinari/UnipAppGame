
package br.unip.cc.aps.model;


import br.unip.cc.aps.dao.MaterialDAO;
import br.unip.cc.aps.dao.MaterialJpa;
import java.util.Random;
import javax.swing.JOptionPane;


public class GerenciadorMaterial {
    
     
    private MaterialDAO dao = MaterialJpa.getInstance(); 
    private Material[] arrayDeMateriais;
    
    private static GerenciadorMaterial instance;

    static {
        instance = new GerenciadorMaterial();
    }

    private GerenciadorMaterial() {
        this.arrayDeMateriais = dao.getArrayMateriais();
    }

    public static GerenciadorMaterial getInstance() {
        return instance;
    }

    public Material pegaMaterialAleatorio() {
        if(arrayDeMateriais.length!= 0){
        Random r = new Random();
        int aleatorio = (int)r.nextInt(arrayDeMateriais.length);
            
        return pegaMaterialDoArray(aleatorio);
        }else{
            JOptionPane.showMessageDialog(null,"Erro, BD vazio");
        }
        return null;
    }
    
    private Material pegaMaterialDoArray(int aleatorio) {
        return arrayDeMateriais[aleatorio];
    }
    
    
}