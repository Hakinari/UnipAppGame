/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unip.cc.aps.dao;

import br.unip.cc.aps.model.Recorde;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Teste
 */
public class RecordeJpa implements RecordeDAO{
    
    private static final RecordeJpa instance;
    private final EntityManager entityManager;
    
    static {
        instance = new RecordeJpa(JpaUtil.getEntityManager());
    }
    public RecordeJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    @Override
    public List<Recorde> getTodos() throws DaoException {
       List<Recorde> listaDeRecordes = null;
        try {
            Query query = entityManager.createNamedQuery("Recorde.getTodos");
            listaDeRecordes = query.getResultList();
        } catch (Exception ex) {
            throw new DaoException(
                    "Não foi possível recuperar os recordes", ex);
        }
        return listaDeRecordes;  
    }

    

    public static RecordeJpa getInstance() {
        return instance;
    }

    @Override
    public void incluir(Recorde recorde) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(recorde);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new DaoException(
                    "Não foi possível incluir recorde", ex);
        }
    }

    @Override
    public void excluir(Recorde recorde) throws DaoException {
           try {
            entityManager.getTransaction().begin();
            if(!entityManager.contains(recorde)){
                entityManager.merge(recorde);
            }
            entityManager.remove(recorde);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new DaoException("Não foi possível atualizar recorde", ex);
        }
    }

    @Override
    public Recorde[] getArrayRecorde(){
        Recorde[] arrayRecordes = null;
        try {
            List<Recorde> listaDeRecordes = getTodos();
             arrayRecordes = new Recorde[listaDeRecordes.size()];
            int i = 0;
            for(Recorde recorde:listaDeRecordes){
                arrayRecordes[i] = recorde;
                i++;
            }
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao recuperar recordes");
        }
            return arrayRecordes;
    }

    
    

    
}
