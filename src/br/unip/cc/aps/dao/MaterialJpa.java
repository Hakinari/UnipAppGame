/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unip.cc.aps.dao;


import br.unip.cc.aps.model.Material;
import br.unip.cc.aps.model.TipoMaterial;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
    public List<Material> getTodos() throws DaoException {
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
    public List<Material> getMaterialPorTipo(TipoMaterial tipo) throws DaoException {
    List<Material> listaDeMateriais = null;
        try{
            Query query = entityManager.createNamedQuery("Material.getPorTipo");
            query.setParameter("tipo", tipo);
            listaDeMateriais = query.getResultList();
        }catch(Exception ex){
            throw new DaoException(
                    "Não foi possível recuperar os Materiais por tipo", ex);
        }
        return listaDeMateriais; 
    }

    @Override
    public void incluir(Material material) throws DaoException {
     try {
            entityManager.getTransaction().begin();
            entityManager.persist(material);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new DaoException(
                    "Não foi possível incluir", ex);
        }
    }

    @Override
    public void excluir(Material material) throws DaoException {
 try {
            entityManager.getTransaction().begin();
            if(!entityManager.contains(material)){
                entityManager.merge(material);
            }
            entityManager.remove(material);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new DaoException("Não foi possível excluir", ex);
        }
    }

    @Override
    public void atualizar(Material material) throws DaoException {
try {
            entityManager.getTransaction().begin();
            // verifica se o objeto nao e gerenciado pelo entityManager
            if (!entityManager.contains(material)) {
                // se nao for torna gerenciavel
                entityManager.merge(material);
            }
          
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new DaoException("Não foi possível atualizar", ex);
        }
    }
}
