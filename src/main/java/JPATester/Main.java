/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPATester;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import test.Address;
import test.Customer;
import test.Employee;

/**
 *
 * @author fcarella
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;
        
        try{
            emf=Persistence.createEntityManagerFactory("JPATester_mvn_PU");
            em=emf.createEntityManager();
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Entity Manager created ("+emf+")");
            em.getTransaction().begin();
            Customer c=new Customer();
            c.setName("Fred");
            c.setAge(54);
            c.setAddress(new Address());
            c.getAddress().setCity("SSM");
            c.getAddress().setStreet("Ashmun");
            c.getAddress().setState("MI");
            em.persist(c);
            Customer c2=new Customer();
            c2.setName("Carella");
            c2.setAge(55);
            em.persist(c2);
            Employee e=new Employee();
            e.setName("FredEmp");
            e.setAge(54);
            em.persist(e);
            em.getTransaction().commit();
            
            List<Customer> ListOfCustomers = em.createQuery("SELECT c FROM Customer c").getResultList();
            System.out.println("List of Customers");
            for(Customer customer:ListOfCustomers){
                System.out.println(customer.getName());
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