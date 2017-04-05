/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;


import Lab5.Controllers.*;
import Lab5.Controllers.exceptions.NonexistentEntityException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lab5.entities.*;


/**
 *
 * @author 14034305
 */
public class App {
    Book book = new Book();
    Magazine Mag = new Magazine();
    Ticket tick = new Ticket();
    Format formatter = new SimpleDateFormat("MM-yyyy");  
    EntityManagerFactory emf=null;
    EntityManager em=null;
    List<Book> ListOfBooks = new ArrayList<>();
    List<Magazine> ListOfMagazines = new ArrayList<>();
    BookJpaController bookController = new BookJpaController(emf);
    MagazineJpaController magController = new MagazineJpaController(emf);
    public void run(){  
        
        
        try{
            
            emf=Persistence.createEntityManagerFactory("Lab5_Thomas_taylor");
            em=emf.createEntityManager();
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Entity Manager created ("+emf+")");
            
            Scanner input=new Scanner(System.in);
            em.getTransaction().begin();
            
            Date magDate = (Date) formatter.parseObject("08-2017");
            java.sql.Date magDate1 = new java.sql.Date(magDate.getTime());
        Book book1 = new Book();
        book1.setAuthor("Tom");
        book1.setTitle("Hunger");
        book1.setCopies(10);
        book1.setPrice(10.99);
        em.persist(book1);
        
        Book book2 = new Book();
        book2.setAuthor("Timmy");
        book2.setTitle("Thirst");
        book2.setCopies(15);
        book2.setPrice(15.99);
        em.persist(book2);
        
        Magazine mag1 = new Magazine();
        mag1.setTitle("Drummer");
        mag1.setPrice(12.99);
        mag1.setCopies(20);
        mag1.setCurrentIssue(magDate1);
        mag1.setQuantity(10);
        em.persist(mag1);
        
        
        em.getTransaction().commit();
          
            
            int Choice = -1;
            int Choice1 = -1;
            int Choice2 = -1;
            String Pub;
            while (Choice < 0){
            
            System.out.print("---------Main---------"+
                             "\n1. Books" + 
                             "\n2. Magazines" +
                             "\n3. Tickets" +
                             "\n4. Checkout" +
                             "\n5. Exit" + 
                             "\nChoose the section you want: ");
            
            Choice = input.nextInt();
            
            switch(Choice){
                case 1:
                    System.out.print("\n1. Add A Book"
                                     + "\n2. Edit A Book"
                                     + "\n3. Delete A Book"
                                     + "\n4. Sell A Book"
                                     + "\n5. Return to main Menu");
                    System.out.print("\nWhat would you like to do?");        
                    Choice1 = input.nextInt(); 
                    Pub = "Book";
                    do{
                     // switch statement to control which option the user chooses.
                    switch(Choice1){
                    case 1:
                        Choice = AddABook(Choice1, Pub);
                        break;
                    case 2:
                        Choice = EditABook(Choice1, Pub);  
                        break;
                    case 3:
                        Choice = DeleteABook(Choice1, Pub);
                        break;
                    case 4:
                        //Choice = SellBook(Choice1, Pub);
                        break;
                    case 5:
                       Choice = -1;
                       break;                        
                    }}while (Choice != -1);
                    break;
                case 2:
                    System.out.print("\n1. Add A Magazine"
                                     + "\n2. Edit A Magazine"
                                     + "\n3. Delete A Magazine"
                                     + "\n4. Sell A Magazine"
                                     + "\n5. Return to main Menu");
                    System.out.print("\nWhat would you like to do?");        
                    Choice1 = input.nextInt();   
                    Pub = "Magazine";
                    do{
                     // switch statement to control which option the user chooses.
                    switch(Choice1){
                    case 1:
                        Choice = AddABook(Choice1, Pub);
                        break;
                    case 2:
                        Choice = EditABook(Choice1, Pub);  
                        break;
                    case 3:
                        Choice = DeleteABook(Choice1, Pub);
                        break;
                    case 4:
                        //Choice = SellBook(Choice1, Pub);
                        break;
                    case 5: break;
                    }}while (Choice != -1);
                    break;
                /*case 3:
                    System.out.println("-------------Tickets------------"  
                                     + "\n1. Add A Ticket"
                                     + "\n2. Edit A Ticket"
                                     + "\n3. Delete A Ticket"
                                     + "\n4. Sell A Ticket"
                                     + "\n5. Return to main Menu\n");
                    Choice2 = input.nextInt();
                    Pub = "Ticket";
                    switch(Choice2){
                        case 1:
                            Choice = AddABook(Choice1, Pub);
                            break;
                        case 2:
                            Choice = EditABook(Choice1, Pub);
                            break;
                        case 3:
                            Choice = DeleteABook(Choice1, Pub);
                            break;
                        case 4:
                            //System.out.print("Currently out of order!");
                            Choice = SellBook(Choice1, Pub);
                            break;
                        case 5:
                            break;
                    }
                    break;*/
                case 4:
                    System.out.print("Currently Out Of Order. Try again later!");
                    break;
                case 5:
                    //Sales.showTotal();
                    em.getTransaction().commit();
                    break;
                    
                }  
            }
            /*em.persist(mag);
            em.getTransaction().commit();
            
            List<Publication> ListOfPublications = em.createQuery("SELECT c FROM Customer c").getResultList();
            System.out.println("List of Publications");
            for(Publication book:ListOfPublications){
                System.out.println(book.getTitle());
            }*/       
    
            
        }catch(Exception e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(emf!=null)
                emf.close();
//            if(em!=null)
//                em.close();
        }
  
    
  /**
     *
     * @param Choice
     * @param Pub
     * @return
     */
    }
public int AddABook(int Choice, String Pub)throws ParseException, Exception{
        Scanner input=new Scanner(System.in);
        String author;
        int quantity;
        String currentIssue;
        String title;
        String client;
        double price;
        Date magDate;
        
        
        System.out.print("Add a " + Pub);
            
        if (Pub.equals("Book")){
                    
                    System.out.print("\nTitle: ");
                    title = input.next();
                    book.setTitle(title);
                    System.out.print("\nQuantity to Order: ");
                    quantity = input.nextInt();
                    book.setCopies(quantity);
                    System.out.print("\nPrice: ");
                    price = input.nextFloat();
                    book.setPrice(price);
                    System.out.print("\nAuthor: ");
                    author = input.next();
                    book.setAuthor(author);
                    bookController.create(book);
                    
        } else if (Pub.equals("Magazine")){    
                
                    System.out.print("\nTitle: ");
                    title = input.next();
                    Mag.setTitle(title);
                    System.out.print("\nQuantity to Order: ");
                    quantity = input.nextInt();
                    Mag.setQuantity(quantity);
                    System.out.print("\nPrice per copy: ");
                    price = input.nextFloat();
                    Mag.setPrice(price);
                    System.out.print("\nDate of current Issue: ");
                    currentIssue = input.next();
                    magDate = (Date) formatter.parseObject(currentIssue);
                    java.sql.Date magDate1 = new java.sql.Date(magDate.getTime());
                    Mag.setCurrentIssue(magDate1);                    
                    magController.create(Mag);
                    
                    
        } /*else if (Pub.equals("Ticket")){
            
            input.nextLine();
            System.out.print("\nTicket Type: ");
            title = input.nextLine();
            tickz.setDescription(title);
            System.out.print("\nTicket Price: ");
            client = input.next();
            tickz.setClient(client);
        }*/
        
        return Choice = -1;   
    }
public int EditABook(int Choice, String Pub) throws ParseException{
        int counter = 1;
        int change = 0;
        Scanner input=new Scanner(System.in);
        System.out.print("Here are the "+ Pub + "'s currently in the system:");
             if(Pub.equals("Book")){
                Book bookEdit = new Book();     
                ListOfBooks = bookController.findBookEntities();
                if(ListOfBooks == null)
                {
                    System.out.print("\nThere are no books to edit.");
                     return Choice = -1;
                }
                // a loop to print out all the books in the store
            
                System.out.println("\nList of Books\n");
                for(Book book:ListOfBooks){
                System.out.println("\n"+book.getId()+"."+book.getTitle());
                counter += 1;
            }
        
                System.out.print("\n Choose which book you would like to edit: ");
                counter = input.nextInt();
                bookEdit = ListOfBooks.get(counter - 1);
                System.out.print("\n Choose which section you would like to edit:" 
                              +"\n1. Edit the Title"
                              +"\n2. Edit the Order Quantity"
                              +"\n3. Edit the Price"  
                              +"\n4. Edit the Author "
                              +"\n5. Return to Menu\n");
                change = input.nextInt();
                switch(change){
                case 1: 
                    System.out.print("\n Edit the Title: ");
                    input = new Scanner(System.in);
                    bookEdit.setTitle(input.nextLine());
                    
                    break;
                case 2:
                    System.out.print("\nEdit the Order Quantity: ");
                    bookEdit.setCopies(input.nextInt());
                   
                    break;
                case 3:
                    System.out.print("\nEdit the Price: ");
                    bookEdit.setPrice(input.nextInt());
                    
                    break;
                case 4:
                    System.out.print("\nEdit the Author: ");
                    bookEdit.setAuthor(input.next());
                    
                    break;
                case 5:
                    
                    break;
                }   
             } else if(Pub.equals("Magazine")){
      
                
                if(ListOfMagazines == null)
                {
                    System.out.print("\nThere are no magazines to edit.");
                     return Choice = -1;
                }
                // a loop to print out all the magazines in the store
                System.out.println("\nList of Magazines");
                for(Magazine mag:ListOfMagazines){
                System.out.println("\n"+mag.getId()+"."+mag.getTitle());
                counter += 1;
                }
                System.out.print("\n Choose which Magazine you would like to edit: ");
                counter = input.nextInt();
        
                System.out.print("\n Choose which section you would like to edit:" 
                              +"\n1. Edit the Title"
                              +"\n2. Edit the Order Quantity"
                              +"\n3. Edit the Price"  
                              +"\n4. Edit the Current Issue "
                              +"\n5. Return to Menu\n");
                change = input.nextInt();
                switch(change){
                /*case 1: 
                    System.out.print("\n Edit the Title: ");
                    mags.get(counter - 1).setTitle(input.next());
                    break;
                case 2:
                    System.out.print("\nEdit the Order Quantity: ");
                    Magazine.get(counter - 1).setCopies(input.nextInt());
                    break;
                case 3:
                    System.out.print("\nEdit the Price: ");
                    Magazine.get(counter - 1).setPrice(input.nextInt());
                    break;
                case 4:
                    System.out.print("\nEdit the Current Issue: ");
                    String currentIssue = input.next();
                    Date magDate = (Date) formatter.parseObject(currentIssue);
                    Magazine.get(counter - 1).setCurrIssue(magDate);
                    break;*/
                case 5:
                    
                    break;
                }
            } /*else if (Pub.equals("Ticket")){
                if(Ticket.get(counter) == null)
                {
                    System.out.print("\nThere are no tickets to edit.");
                     return Choice = -1;
                }
                // a loop to print out all the tickets in the store
                for( counter = 0; counter < Ticket.size(); counter++){
                    System.out.print("\n" + ((counter + 1) + ". ") + Ticket.get(counter).getDescription());                    
                }    
        
                System.out.print("\n Choose which Ticket you would like to edit: ");
                counter = input.nextInt();
        
                System.out.print("\n Choose which section you would like to edit:" 
                              +"\n1. Edit the Ticket Name"
                              +"\n2. Edit the Price"
                              +"\n3. Return to Menu\n");
                change = input.nextInt();
                switch(change){
                case 1: 
                    System.out.print("\n Edit the Ticket Name: ");
                    Ticket.get(counter - 1).setDescription(input.next());
                    break;
                case 2:
                    System.out.print("\nEdit the Ticket Price: ");
                    Ticket.get(counter - 1).setClient(input.next());
                    break;
                case 3:
                    break;
                
                }
            }   */
             
       return Choice = -1;
    }

public int DeleteABook(int Choice, String Pub) throws NonexistentEntityException{
        Scanner input2=new Scanner(System.in);
        int counter = 1;
        long Id;
        System.out.print("Here is a list of the " + Pub + "'s: \n");
        
            if (Pub.equals("Book")){
                Book bookDel = new Book();
                
                System.out.println("\nList of Books\n");
                for(Book book:ListOfBooks){
                System.out.println("\n"+book.getId()+"."+book.getTitle());
                counter += 1;
                }    
                
                System.out.print("\nChoose the book you would like to remove from inventory:");
                
                counter = input2.nextInt();
                bookDel = ListOfBooks.get(counter - 1); 
                //Id = bookDel.getId();
                bookController.destroy(bookDel.getId());
                
                
            } else if (Pub.equals("Magazine")){
                Magazine magDel = new Magazine();
                
                System.out.println("\nList of Books\n");
                for(Magazine book:ListOfMagazines){
                System.out.println("\n"+counter+"."+book.getTitle());
                counter += 1;
                }      
                System.out.print("\nChoose the Magazine you would like to remove from inventory:");
                counter = input2.nextInt();
                magDel = ListOfMagazines.get(counter - 1);
                
            } /*else if (Pub.equals("Ticket")){
                for( counter = 0; counter < tick.size(); counter++){
                    System.out.print("\n" + ((counter + 1) + ". ") + tick.get(counter).getDescription());                    
                }    
                System.out.print("\nChoose the Ticket you would like to remove from inventory:");
                counter = input2.nextInt();
                tick.remove(tick.get(counter - 1));
            }        */ 
        return Choice = -1;
    }
}
   
  

    

