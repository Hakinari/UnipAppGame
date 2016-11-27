/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unip.cc.aps.dao;


import br.unip.cc.aps.model.Material;
import br.unip.cc.aps.model.TipoMaterial;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class MaterialJpa implements MaterialDAO{
    
    
    private static final MaterialJpa instance;
    private final EntityManager entityManager;
    
     static {
        instance = new MaterialJpa(JpaUtil.getEntityManager());
    }

    public static MaterialJpa getInstance() {
        return instance;
    }

    private MaterialJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public  List<Material> getTodos() throws DaoException {
          List<Material> listaDeMateriais = null;
        try {
            Query query = entityManager.createNamedQuery("Material.getTodos");
            listaDeMateriais = query.getResultList();
        } catch (Exception ex) {
            throw new DaoException(
                    "Não foi possível recuperar todos materiais", ex);
        }
        return listaDeMateriais;
    }
    @Override
    public Material[] getArrayMateriais(){
        Material[] arrayMateriais = null;
        try {
            List<Material> listaDeMateriais = getTodos();
             arrayMateriais = new Material[listaDeMateriais.size()];
            int i = 0;
            for(Material material:listaDeMateriais){
                arrayMateriais[i] = material;
                i++;
            }
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao recuperar Materiais");
        }
            return arrayMateriais;
    }
}
