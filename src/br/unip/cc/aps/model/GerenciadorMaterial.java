
package br.unip.cc.aps.model;


import br.unip.cc.aps.dao.DaoException;
import br.unip.cc.aps.dao.MaterialDAO;
import br.unip.cc.aps.dao.MaterialJpa;
import java.util.List;


public class GerenciadorMaterial {
    
     
    private MaterialDAO dao = MaterialJpa.getInstance(); 
    public List<Material> getTodos() throws DaoException {
       return dao.getTodos();
    }

    public void salvar(Material material) throws DaoException {
         if(material.getId()==0){
       
            dao.incluir(material);
                 
        }else{
            dao.atualizar(material);
        }
    }

    public void excluir(Material material) throws DaoException {
        dao.excluir(material);
    }

    public Material criaMaterial(TipoMaterial tipo){
        Material material = new Material();
        material.setId(0);
        material.setTipo(tipo);
        return material;
    }
    
    private static GerenciadorMaterial instance;

    static {
        instance = new GerenciadorMaterial();
    }

    private GerenciadorMaterial() {
    }

    public static GerenciadorMaterial getInstance() {
        return instance;
    }
 
     public List<Material> getMaterialPorTipo(TipoMaterial tipo) throws DaoException {
        return dao.getMaterialPorTipo(tipo);
    }
    
    
    
    
    
    
    
    
    
    
}
