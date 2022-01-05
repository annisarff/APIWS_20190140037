/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cemilan.cemilan;

import com.cemilan.cemilan.exceptions.NonexistentEntityException;
import com.cemilan.cemilan.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author annis
 */
public class DatacemilanJpaController implements Serializable {

    public DatacemilanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.cemilan_cemilan_jar_0.0.1-SNAPSHOTPU");

    DatacemilanJpaController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Datacemilan datacemilan) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(datacemilan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDatacemilan(datacemilan.getId()) != null) {
                throw new PreexistingEntityException("Datacemilan " + datacemilan + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Datacemilan datacemilan) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            datacemilan = em.merge(datacemilan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = datacemilan.getId();
                if (findDatacemilan(id) == null) {
                    throw new NonexistentEntityException("The datacemilan with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Datacemilan datacemilan;
            try {
                datacemilan = em.getReference(Datacemilan.class, id);
                datacemilan.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The datacemilan with id " + id + " no longer exists.", enfe);
            }
            em.remove(datacemilan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Datacemilan> findDatacemilanEntities() {
        return findDatacemilanEntities(true, -1, -1);
    }

    public List<Datacemilan> findDatacemilanEntities(int maxResults, int firstResult) {
        return findDatacemilanEntities(false, maxResults, firstResult);
    }

    private List<Datacemilan> findDatacemilanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Datacemilan.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Datacemilan findDatacemilan(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Datacemilan.class, id);
        } finally {
            em.close();
        }
    }

    public int getDatacemilanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Datacemilan> rt = cq.from(Datacemilan.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
