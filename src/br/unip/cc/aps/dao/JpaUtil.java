/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unip.cc.aps.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Carlos
 */
public class JpaUtil {
    
    private static EntityManager em;

    public static EntityManager getEntityManager() {
        if(em==null){             
            EntityManagerFactory entityManagerFactory = 
                    Persistence.createEntityManagerFactory("ControleDeMateriaisPU");
            em = entityManagerFactory.createEntityManager();
        }
        return em;
    }
    
    public static void fechar(){
        if(em!=null && em.isOpen()){
            //em.flush();
            em.close();
        }
    }
}
