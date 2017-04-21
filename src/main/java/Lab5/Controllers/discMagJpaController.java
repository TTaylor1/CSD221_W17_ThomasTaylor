/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5.Controllers;

import Lab5.Controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lab5.entities.discMag;

/**
 *
 * @author 14034305
 */
public class discMagJpaController implements Serializable {

    public discMagJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(discMag discMag) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(discMag);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(discMag discMag) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            discMag = em.merge(discMag);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = discMag.getId();
                if (finddiscMag(id) == null) {
                    throw new NonexistentEntityException("The discMag with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            discMag discMag;
            try {
                discMag = em.getReference(discMag.class, id);
                discMag.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The discMag with id " + id + " no longer exists.", enfe);
            }
            em.remove(discMag);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<discMag> finddiscMagEntities() {
        return finddiscMagEntities(true, -1, -1);
    }

    public List<discMag> finddiscMagEntities(int maxResults, int firstResult) {
        return finddiscMagEntities(false, maxResults, firstResult);
    }

    private List<discMag> finddiscMagEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(discMag.class));
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

    public discMag finddiscMag(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(discMag.class, id);
        } finally {
            em.close();
        }
    }

    public int getdiscMagCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<discMag> rt = cq.from(discMag.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
