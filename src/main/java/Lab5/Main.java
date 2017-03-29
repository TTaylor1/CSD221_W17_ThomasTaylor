/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Lab5.entities.*;

/**
 *
 * @author 14034305
 */
public class Main {
  public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;
        
        try{
            emf=Persistence.createEntityManagerFactory("Lab5_Thomas_taylor");
            em=emf.createEntityManager();
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Entity Manager created ("+emf+")");
            em.getTransaction().begin();  
            Book book = new Book();
            Magazine mag =  new Magazine();
            
            book.setAuthor("Thomas");
            book.setTitle("Hell Yea");
            
            mag.setOrderQty(20);
            mag.setTitle("Hell No");
            
            em.persist(book);
            em.persist(mag);
            em.getTransaction().commit();
            
            List<Publication> ListOfPublications = em.createQuery("SELECT c FROM Customer c").getResultList();
            System.out.println("List of Publications");
            for(Publication customer:ListOfPublications){
                System.out.println(customer.getTitle());
            }
            
            
            
        }catch(Exception e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(emf!=null)
                emf.close();
//            if(em!=null)
//                em.close();
        }
    }

}  

