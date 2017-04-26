/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test4;

import Test4_Controllers.SquareJpaController;
import Test4_Controllers.TriangleJpaController;
import Test4_practical.Shape;
import Test4_practical.Square;
import Test4_practical.Triangle;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author 14034305
 */
public class App {
    public void run(){
        EntityManagerFactory emf=null;
        EntityManager em=null;
        
        try{
            emf=Persistence.createEntityManagerFactory("Thomas_Taylor_Test4_PU");
            em=emf.createEntityManager();
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Entity Manager created ("+emf+")");
            em.getTransaction().begin();
            Square sq = new Square();
            Triangle tri = new Triangle();
            
            // Square one Entity Manager
            sq.setTheLength(20);
            sq.setWidth(15);
            sq.setArea(sq.getWidth() * sq.getTheLength());
            //Triangle one Entity Manager
            tri.setBase(15);
            tri.setHeight(25);
            tri.setArea(tri.getBase() * tri.getHeight());
            
            em.persist(tri);
            em.persist(sq);   
            em.getTransaction().commit();
            
            List<Square> ListOfSquares = em.createQuery("Select c FROM Square c").getResultList();
            System.out.println("List of Squares: ");
            for(Square Sq:ListOfSquares){
                System.out.println(Sq.getArea());
            }
            
            List<Triangle> ListOfTriangles = em.createQuery("Select c FROM Triangle c").getResultList();
            System.out.println("List of Triangles: ");
            for(Triangle Tri:ListOfTriangles){
                System.out.println(Tri.getArea());
            }
            
            SquareJpaController SquareController = new SquareJpaController(emf);
            TriangleJpaController TriangleController = new TriangleJpaController(emf);
            
            Square sq1 = new Square();
            sq1.setWidth(25);
            sq1.setTheLength(15);
            sq1.setArea(sq1.getWidth() * sq1.getTheLength());
            SquareController.create(sq1);
            
            Triangle tri1 = new Triangle();
            tri1.setBase(30);
            tri1.setHeight(25);
            tri1.setArea(tri1.getBase() * tri1.getHeight());
            TriangleController.create(tri1);
            
                int counter;
                ListOfSquares = SquareController.findSquareEntities();
                counter = 1;
                System.out.println("\nList of Squares:");
                for(Square Sq:ListOfSquares){
                System.out.println("\nSquare "+counter+": " +
                                    "\nArea: "+Sq.getArea() +
                                   "\nLength: " + Sq.getTheLength()
                                   +"\nWidth: " + Sq.getWidth());
                counter += 1;
                }
                                
                ListOfTriangles = TriangleController.findTriangleEntities();
                counter = 1;
                System.out.println("\nList of Triangles:");
                for(Triangle Tri:ListOfTriangles){
                System.out.println("\nTriangle "+counter+": " +
                                    "\nArea: "+Tri.getArea() +
                                   "\nBase: " + Tri.getBase()
                                   +"\nHeight: " + Tri.getHeight());
                counter += 1;
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

