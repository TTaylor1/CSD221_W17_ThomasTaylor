/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test4_Controllers;

import Test4_Controllers.exceptions.NonexistentEntityException;
import Test4_Controllers.exceptions.PreexistingEntityException;
import Test4_practical.Triangle;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 14034305
 */
public class TriangleJpaController implements Serializable {

    public TriangleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Triangle triangle) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(triangle);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTriangle(triangle.getId()) != null) {
                throw new PreexistingEntityException("Triangle " + triangle + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Triangle triangle) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            triangle = em.merge(triangle);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = triangle.getId();
                if (findTriangle(id) == null) {
                    throw new NonexistentEntityException("The triangle with id " + id + " no longer exists.");
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
            Triangle triangle;
            try {
                triangle = em.getReference(Triangle.class, id);
                triangle.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The triangle with id " + id + " no longer exists.", enfe);
            }
            em.remove(triangle);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Triangle> findTriangleEntities() {
        return findTriangleEntities(true, -1, -1);
    }

    public List<Triangle> findTriangleEntities(int maxResults, int firstResult) {
        return findTriangleEntities(false, maxResults, firstResult);
    }

    private List<Triangle> findTriangleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Triangle.class));
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

    public Triangle findTriangle(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Triangle.class, id);
        } finally {
            em.close();
        }
    }

    public int getTriangleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Triangle> rt = cq.from(Triangle.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
