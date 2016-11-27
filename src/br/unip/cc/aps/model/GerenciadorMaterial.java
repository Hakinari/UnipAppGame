
package br.unip.cc.aps.model;


import br.unip.cc.aps.dao.MaterialDAO;
import br.unip.cc.aps.dao.MaterialJpa;
import java.util.Random;


public class GerenciadorMaterial {
    
     
    private MaterialDAO dao = MaterialJpa.getInstance(); 
    private Material[] arrayDeMateriais = dao.getArrayMateriais();
    
    private static GerenciadorMaterial instance;

    static {
        instance = new GerenciadorMaterial();
    }

    private GerenciadorMaterial() {
    }

    public static GerenciadorMaterial getInstance() {
        return instance;
    }

    public Material pegaMaterialAleatorio() {
        Random r = new Random();
        int aleatorio = r.nextInt(arrayDeMateriais.length);
        return pegaMaterialDoArray(aleatorio);
    }
    
    private Material pegaMaterialDoArray(int aleatorio) {
        return arrayDeMateriais[aleatorio];
    }
    
    
}