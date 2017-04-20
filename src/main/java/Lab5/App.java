/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;


import Lab5.Controllers.BookJpaController;
import Lab5.Controllers.MagazineJpaController;
import Lab5.Controllers.TicketJpaController;
import Lab5.Controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
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
public class App implements Serializable{
    
    Book book = new Book();
    Magazine Mag = new Magazine();
    Ticket tick = new Ticket();
    Format formatter = new SimpleDateFormat("MM-yyyy");  
    EntityManagerFactory emf;
    EntityManager em;    
    List<Book> ListOfBooks = new ArrayList<>();
    List<Magazine> ListOfMags = new ArrayList<>();
    List<Ticket> ListOfTicks = new ArrayList<>();
    
    
    public void run(){  
        
        
        try{
            
            emf=Persistence.createEntityManagerFactory("Lab5_Thomas_taylor");
            em=emf.createEntityManager();
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Entity Manager created ("+emf+")");            
            Scanner input=new Scanner(System.in);  
            Date magDate = (Date) formatter.parseObject("08-2017");
            java.sql.Date magDate1 = new java.sql.Date(magDate.getTime());
            em.getTransaction().begin();
            
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
                        Choice = SellBook(Choice1, Pub);                       
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
                        Choice = SellBook(Choice1, Pub);                        
                        break;
                    case 5: break;
                    }}while (Choice != -1);
                    break;
                case 3:
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
                            Choice = SellBook(Choice1, Pub);
                            break;
                        case 5:
                            break;
                    }
                    break;
                case 4:
                    CashTill Sales = new CashTill();
                    Sales.showTotal(); 
                    break;
                case 5:                                       
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
  
    
 
    }
public int AddABook(int Choice, String Pub)throws ParseException, Exception{
        Scanner input=new Scanner(System.in);
        BookJpaController bookController=new BookJpaController(emf);
        MagazineJpaController magController = new MagazineJpaController(emf);
        TicketJpaController tickController = new TicketJpaController(emf);
        String author;
        int quantity;
        String currentIssue;
        String title;
        String client;
        double price;
        Date magDate;
        
        
        System.out.print("Add a " + Pub);
            
        if (Pub.equals("Book")){
                   Book book1 = new Book();
                    System.out.print("\nTitle: ");
                    title = input.next();
                    book1.setTitle(title);
                    System.out.print("\nQuantity to Order: ");
                    quantity = input.nextInt();
                    book1.setCopies(quantity);
                    System.out.print("\nPrice: ");
                    price = input.nextFloat();
                    book1.setPrice(price);
                    System.out.print("\nAuthor: ");
                    author = input.next();
                    book1.setAuthor(author);
                    bookController.create(book1);
                    
        } else if (Pub.equals("Magazine")){    
                Magazine mag1 = new Magazine();
                    System.out.print("\nTitle: ");
                    title = input.next();
                    mag1.setTitle(title);
                    System.out.print("\nQuantity to Order: ");
                    quantity = input.nextInt();
                    mag1.setQuantity(quantity);
                    System.out.print("\nPrice per copy: ");
                    price = input.nextFloat();
                    mag1.setPrice(price);
                    System.out.print("\nDate of current Issue: ");
                    currentIssue = input.next();
                    magDate = (Date) formatter.parseObject(currentIssue);
                    java.sql.Date magDate1 = new java.sql.Date(magDate.getTime());
                    mag1.setCurrentIssue(magDate1);                    
                    magController.create(mag1);
                    
                    
        } else if (Pub.equals("Ticket")){
            Ticket tickz = new Ticket();
            System.out.print("\nTicket Description: ");
            title = input.nextLine();
            tickz.setDescription(title);            
            System.out.print("\nTicket Price: ");
            price = input.nextDouble();    
            tickz.setPrice(price);
            System.out.print("\nTicket Client: ");
            client = input.next();
            tickz.setClient(client);
            tickController.create(tickz);
        }
        
        return Choice = -1;   
    }
public int EditABook(int Choice, String Pub) throws ParseException, Exception{
        int counter = 1;
        int change = 0;
        BookJpaController bookController=new BookJpaController(emf);
        MagazineJpaController magController = new MagazineJpaController(emf);
        TicketJpaController tickController = new TicketJpaController(emf);
        ListOfBooks=bookController.findBookEntities();
        ListOfMags = magController.findMagazineEntities();
        ListOfTicks = tickController.findTicketEntities();
        Scanner input=new Scanner(System.in);
        System.out.print("Here are the "+ Pub + "'s currently in the system:");
             if(Pub.equals("Book")){
                Book bookEdit = new Book();                
                
                if(ListOfBooks == null)
                {
                    System.out.print("\nThere are no books to edit.");
                     return Choice = -1;
                }
                // a loop to print out all the books in the store
            
                System.out.println("\nList of Books\n");
                for(Book book1:ListOfBooks){
                System.out.println("\n"+counter+"."+book1.getTitle());
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
                    bookController.edit(bookEdit);
                    break;
                case 2:
                    System.out.print("\nEdit the Order Quantity: ");
                    bookEdit.setCopies(input.nextInt());
                    bookController.edit(bookEdit);
                    break;
                case 3:
                    System.out.print("\nEdit the Price: ");
                    bookEdit.setPrice(input.nextInt());
                    bookController.edit(bookEdit);
                    break;
                case 4:
                    System.out.print("\nEdit the Author: ");
                    bookEdit.setAuthor(input.next());
                    bookController.edit(bookEdit);
                    break;
                case 5:
                    
                    break;
                }   
             } else if(Pub.equals("Magazine")){
                Magazine magEdit = new Magazine();
                
                if(ListOfMags == null)
                {
                    System.out.print("\nThere are no magazines to edit.");
                     return Choice = -1;
                }
                // a loop to print out all the magazines in the store
                System.out.println("\nList of Magazines");
                for(Magazine mag:ListOfMags){
                System.out.println("\n"+counter+"."+mag.getTitle());
                counter += 1;
                }
                System.out.print("\n Choose which Magazine you would like to edit: ");
                counter = input.nextInt();
                magEdit = ListOfMags.get(counter - 1);
                System.out.print("\n Choose which section you would like to edit:" 
                              +"\n1. Edit the Title"
                              +"\n2. Edit the Order Quantity"
                              +"\n3. Edit the Price"  
                              +"\n4. Edit the Current Issue "
                              +"\n5. Return to Menu\n");
                change = input.nextInt();
                switch(change){
                case 1: 
                    System.out.print("\n Edit the Title: ");
                    magEdit.setTitle(input.next());
                    magController.edit(magEdit);
                    break;
                case 2:
                    System.out.print("\nEdit the Order Quantity: ");
                    magEdit.setCopies(input.nextInt());
                    magController.edit(magEdit);
                    break;
                case 3:
                    System.out.print("\nEdit the Price: ");
                    magEdit.setPrice(input.nextInt());
                    magController.edit(magEdit);
                    break;
                case 4:
                    System.out.print("\nEdit the Current Issue: ");
                    String currentIssue = input.next();
                    Date magDate = (Date) formatter.parseObject(currentIssue);
                    java.sql.Date magDate1 = new java.sql.Date(magDate.getTime());
                    magEdit.setCurrentIssue(magDate1);
                    magController.edit(magEdit);
                    break;
                case 5:
                    
                    break;
                }
            } else if (Pub.equals("Ticket")){
                Ticket tickEdit = new Ticket();
                if(ListOfTicks == null)
                {
                    System.out.print("\nThere are no tickets to edit.");
                     return Choice = -1;
                }
                // a loop to print out all the tickets in the store
                System.out.print("\nList of Tickets");
                for(Ticket tick1: ListOfTicks){
                    System.out.print("\n" + counter + ". " + tick1.getDescription());                    
                }    
        
                System.out.print("\n Choose which Ticket you would like to edit: ");
                counter = input.nextInt();
                tickEdit = ListOfTicks.get(counter - 1);
                System.out.print("\n Choose which section you would like to edit:" 
                              +"\n1. Edit the Ticket Description"
                              +"\n2. Edit the Price"
                              +"\n3. Edit the Client"
                              +"\n4. Return to Menu\n");
                change = input.nextInt();
                switch(change){
                case 1: 
                    System.out.print("\n Edit the Ticket Name: ");
                    tickEdit.setDescription(input.next());
                    tickController.edit(tickEdit);
                    break;
                case 2:
                    System.out.print("\nEdit the Ticket Price: ");
                    tickEdit.setPrice(input.nextDouble());
                    tickController.edit(tickEdit);
                    break;
                case 3:
                    System.out.print("\nEdit the Ticket Client: ");
                    tickEdit.setClient(input.next());
                    tickController.edit(tickEdit);
                    break;
                case 4:
                    break;
                
                }
            }   
             
       return Choice = -1;
    }

public int DeleteABook(int Choice, String Pub) throws NonexistentEntityException, Lab5.exceptions.NonexistentEntityException{
        Scanner input2=new Scanner(System.in);
        int counter = 1;
        BookJpaController bookController=new BookJpaController(emf);
        MagazineJpaController magController = new MagazineJpaController(emf);
        TicketJpaController tickController = new TicketJpaController(emf);
        ListOfBooks=bookController.findBookEntities();
        ListOfMags = magController.findMagazineEntities();
        ListOfTicks = tickController.findTicketEntities();
        
        
        System.out.print("Here is a list of the " + Pub + "'s: \n");
        
            if (Pub.equals("Book")){
                Book bookDel = new Book();
                
                System.out.println("\nList of Books\n");
                for(Book book1:ListOfBooks){
                System.out.println("\n"+counter+"."+book1.getTitle());
                counter += 1;
                }    
                
                System.out.print("\nChoose the book you would like to remove from inventory:");
                
                counter = input2.nextInt();
                bookDel = ListOfBooks.get(counter - 1); 
                
                bookController.destroy(bookDel.getId());
                
                
            } else if (Pub.equals("Magazine")){
                Magazine magDel = new Magazine();
                
                System.out.println("\nList of Books\n");
                for(Magazine mag:ListOfMags){
                System.out.println("\n"+counter+"."+mag.getTitle());
                counter += 1;
                }      
                System.out.print("\nChoose the Magazine you would like to remove from inventory:");
                counter = input2.nextInt();
                magDel = ListOfMags.get(counter - 1);
                
                magController.destroy(magDel.getId());
                
            } else if (Pub.equals("Ticket")){
                Ticket tickDel = new Ticket();
                
                for(Ticket tick1:ListOfTicks){
                    System.out.print("\n" + counter + ". " + tick.getDescription());                    
                }    
                System.out.print("\nChoose the Ticket you would like to remove from inventory:");
                counter = input2.nextInt();
                tickDel = ListOfTicks.get(counter - 1);
                
                tickController.destroy(tickDel.getId());
            }        
        return Choice = -1;
    }

   
  
public int SellBook(int Choice, String Pub) throws ParseException{
         Scanner input=new Scanner(System.in);
         int counter = 1;
         BookJpaController bookController=new BookJpaController(emf);
         MagazineJpaController magController = new MagazineJpaController(emf);
         TicketJpaController tickController = new TicketJpaController(emf);
         ListOfBooks=bookController.findBookEntities();
         ListOfMags = magController.findMagazineEntities();
         ListOfTicks = tickController.findTicketEntities();
         CashTill Sales = new CashTill();
         
             if(Pub.equals("Book")){
                     Book bookSell = new Book();
                     System.out.print("\nHere is a list of the books: \n");
                
                     for(Book book1: ListOfBooks){
                     System.out.print("\n" + counter  + ". " + book1.getTitle()); 
                     counter += 1;
                     }      
                     System.out.print("\n ----------------");
                
                     System.out.print("\nEnter the book number to sell: ");
                     counter = input.nextInt() - 1;
                     bookSell = ListOfBooks.get(counter);
                     Sales.sellItem(bookSell, Pub);
                           
             } else if(Pub.equals("Magazine")){        
                     Magazine magSell = new Magazine();
                     System.out.print("Here is a list of the magazines: \n");
                
                     for( Magazine mag: ListOfMags){
                     System.out.print("\n" + counter + ". " + mag.getTitle());                    
                    }      
                     System.out.print("\n ----------------");
                     
                     System.out.print("\nEnter the magazine number to sell: ");
                     counter = input.nextInt() - 1;
                     magSell = ListOfMags.get(counter);
                     Sales.sellItem(magSell, Pub);
                           
             } else if (Pub.equals("Ticket")){
                    Ticket tickSell = new Ticket();
                    System.out.print("Here is a list of the Tickets: \n");
                
                     for( Ticket ticks: ListOfTicks){
                     System.out.print("\n" + counter + ". " + ticks.getDescription());                    
                    }      
                     System.out.print("\n ----------------");
                     
                     System.out.print("\nEnter the ticket number to sell: ");
                     counter = input.nextInt() - 1;
                     tickSell = ListOfTicks.get(counter);
                     Sales.sellItem(tickSell, Pub);
            }
        return Choice = -1;
    }  
}
  
    

