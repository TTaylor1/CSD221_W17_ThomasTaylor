/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author 14034305
 */
public class BookStore {
    Scanner input=new Scanner(System.in);
    ArrayList<Ticket> tick = new ArrayList<>();
    ArrayList<Books> book1 = new ArrayList<>();
    ArrayList<Magazines> mags = new ArrayList<>();
    CashTill Sales = new CashTill();
   Format formatter = new SimpleDateFormat("MM-yyyy");
    public void run() throws Exception{
        //ArrayList<Publication> books = new ArrayList<Publication>();
        
        int Choice = -1;
        int Choice1 = -1;
        int Choice2 = -1;
        Date magDate = (Date) formatter.parseObject("08-2017");
        String Pub;
    
    
    Ticket Train = new Ticket("Ottawa", 29.95);
    Ticket Movie = new Ticket("Ottawa", 29.95);
    Ticket Bus = new Ticket("Ottawa", 29.95);
    Magazines Ford = new Magazines(5, magDate, "Rawr", 10.0, 15);
    Books Dodge = new Books("Thomas", "Rawr on the Shore", 10, 30);
    Books Chevy = new Books("Timmy", "Rawr on the Water", 10, 30);
    Books Toyota = new Books("Taylor", "Rawr on the Rocks", 10, 30);
    Magazines Porsche = new Magazines(15, magDate, "Meow", 10.0, 15);
    
    // preassigned books/magazines added to the bookstore.
    tick.add(Train);
    tick.add(Bus);
    tick.add(Movie);
    mags.add(Ford);
    book1.add(Dodge);
    book1.add(Chevy);
    book1.add(Toyota);
    mags.add(Porsche);        
        
        while (Choice < 0){
            
            System.out.print("---------Main---------"+
                             "\n1. Books" + 
                             "\n2. Magazines" +
                             "\n3. Tickets" +
                             "\n4. Checkout" +
                             "\n5. Exit");
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
                    case 5: break;
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
                            System.out.print("Currently out of order!");
                            break;
                        case 5:
                            break;
                    }
                    break;
                case 4:
                    System.out.print("Currently Out Of Order. Try again later!");
                    break;
                case 5:
                    break;
                    
                }           
            }
    }
    
    public int AddABook(int Choice, String Pub) throws Exception {
        String author;
        int quantity;
        String currentIssue;
        String title;
        double price;
        Date magDate;
        
        Books bookz = new Books();
        Magazines magz = new Magazines();
        Ticket tickz = new Ticket();
        System.out.print("Add a " + Pub);
            
        if (Pub.equals("Book")){
                    
                    System.out.print("\nTitle: ");
                    title = input.next();
                    bookz.setTitle(title);
                    System.out.print("\nQuantity to Order: ");
                    quantity = input.nextInt();
                    bookz.setCopies(quantity);
                    System.out.print("\nPrice: ");
                    price = input.nextFloat();
                    bookz.setPrice(price);
                    System.out.print("\nAuthor: ");
                    author = input.next();
                    bookz.setAuthor(author);
                    book1.add(bookz);
                 
        } else if (Pub.equals("Magazine")){    
                
                    System.out.print("\nTitle: ");
                    title = input.next();
                    magz.setTitle(title);
                    System.out.print("\nQuantity to Order: ");
                    quantity = input.nextInt();
                    magz.setOrderQty(quantity);
                    System.out.print("\nPrice per copy: ");
                    price = input.nextFloat();
                    magz.setPrice(price);
                    System.out.print("\nDate of current Issue: ");
                    currentIssue = input.next();
                    magDate = (Date) formatter.parseObject(currentIssue);
                    magz.setCurrIssue(magDate);                    
                    mags.add(magz);
        } else if (Pub.equals("Ticket")){
            input.nextLine();
            System.out.print("\nTicket Type: ");
            title = input.nextLine();
            tickz.setTitle(title);
            System.out.print("\nTicket Price: ");
            price = input.nextDouble();
            tickz.setPrice(price);
        }
                
        return Choice = -1;   
    }
    
    public int EditABook(int Choice, String Pub) throws ParseException{
        int counter = 0;
        int change = 0;
        System.out.print("Here are the "+ Pub + "'s currently in the system:");
             if(Pub.equals("Book")){
                     
                
                if(book1.get(counter) == null)
                {
                    System.out.print("\nThere are no books to edit.");
                     return Choice = -1;
                }
                // a loop to print out all the books in the store
                for( counter = 0; counter < book1.size(); counter++){
                    System.out.print("\n" + ((counter + 1) + ". ") + book1.get(counter).getTitle());                    
                }    
        
                System.out.print("\n Choose which book you would like to edit: ");
                counter = input.nextInt();
        
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
                    book1.get(counter - 1).setTitle(input.next());
                    break;
                case 2:
                    System.out.print("\nEdit the Order Quantity: ");
                    book1.get(counter - 1).setCopies(input.nextInt());
                    break;
                case 3:
                    System.out.print("\nEdit the Price: ");
                    book1.get(counter - 1).setPrice(input.nextInt());
                    break;
                case 4:
                    System.out.print("\nEdit the Author: ");
                    book1.get(counter - 1).setAuthor(input.next());
                    break;
                case 5:break;
                }   
             } else if(Pub.equals("Magazine")){
      
                
                if(mags.get(counter) == null)
                {
                    System.out.print("\nThere are no magazines to edit.");
                     return Choice = -1;
                }
                // a loop to print out all the magazines in the store
                for( counter = 0; counter < book1.size(); counter++){
                    System.out.print("\n" + ((counter + 1) + ". ") + book1.get(counter).getTitle());                    
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
                case 1: 
                    System.out.print("\n Edit the Title: ");
                    mags.get(counter - 1).setTitle(input.next());
                    break;
                case 2:
                    System.out.print("\nEdit the Order Quantity: ");
                    mags.get(counter - 1).setCopies(input.nextInt());
                    break;
                case 3:
                    System.out.print("\nEdit the Price: ");
                    mags.get(counter - 1).setPrice(input.nextInt());
                    break;
                case 4:
                    System.out.print("\nEdit the Current Issue: ");
                    String currentIssue = input.next();
                    Date magDate = (Date) formatter.parseObject(currentIssue);
                    mags.get(counter - 1).setCurrIssue(magDate);
                    break;
                case 5:break;
                }
            } else if (Pub.equals("Ticket")){
                if(tick.get(counter) == null)
                {
                    System.out.print("\nThere are no tickets to edit.");
                     return Choice = -1;
                }
                // a loop to print out all the tickets in the store
                for( counter = 0; counter < tick.size(); counter++){
                    System.out.print("\n" + ((counter + 1) + ". ") + tick.get(counter).getTitle());                    
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
                    tick.get(counter - 1).setTitle(input.next());
                    break;
                case 2:
                    System.out.print("\nEdit the Ticket Price: ");
                    tick.get(counter - 1).setPrice(input.nextDouble());
                    break;
                case 3:
                    break;
                
                }
            }
       return Choice = -1;
    }
    
    public int DeleteABook(int Choice, String Pub){
        Scanner input2=new Scanner(System.in);
        int counter;
        
        System.out.print("Here is a list of the " + Pub + "'s: \n");
        
            if (Pub.equals("Book")){
                
                for( counter = 0; counter < book1.size(); counter++){
                    System.out.print("\n" + ((counter + 1) + ". ") + book1.get(counter).getTitle());                    
                }      
                System.out.print("\nChoose the book you would like to remove from inventory:");
                counter = input2.nextInt();
                book1.remove(book1.get(counter - 1));
                
            } else if (Pub.equals("Magazine")){
                
                for( counter = 0; counter < mags.size(); counter++){
                    System.out.print("\n" + ((counter + 1) + ". ") + mags.get(counter).getTitle());                    
                }    
                System.out.print("\nChoose the Magazine you would like to remove from inventory:");
                counter = input2.nextInt();
                book1.remove(book1.get(counter - 1));
            } else if (Pub.equals("Ticket")){
                for( counter = 0; counter < mags.size(); counter++){
                    System.out.print("\n" + ((counter + 1) + ". ") + mags.get(counter).getTitle());                    
                }    
                System.out.print("\nChoose the Ticket you would like to remove from inventory:");
                counter = input2.nextInt();
                tick.remove(tick.get(counter - 1));
            }         
        return Choice = -1;
    }
    
    public int SellBook(int Choice, String Pub) throws ParseException{
         //int counter;
            System.out.print("System is currently out of order. Please try again later");
             /*if(Pub.equals("Book")){
                     System.out.print("\nHere is a list of the books: \n");
                
                     for( counter = 0; counter < book1.size(); counter++){
                     System.out.print("\n" + ((counter + 1) + ". ") + book1.get(counter).getTitle());                    
                     }      
                     System.out.print("\n ----------------");
                
                     System.out.print("\nEnter the book number to sell: ");
                     counter = input.nextInt();
                     Sales.sellItem(book1.get(counter));
                           
             } else if(Pub.equals("Magazine")){        
                 
                     System.out.print("Here is a list of the magazines: \n");
                
                     for( counter = 0; counter < mags.size(); counter++){
                     System.out.print("\n" + ((counter + 1) + ". ") + mags.get(counter).getTitle());                    
                    }      
                     System.out.print("\n ----------------");
                     
                     System.out.print("\nEnter the magazine number to sell: ");
                     counter = input.nextInt() - 1;
                     Sales.sellItem(mags.get(counter));
                           
             }   */
        return Choice = -1;
    }        
}