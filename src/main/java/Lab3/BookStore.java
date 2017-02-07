/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 14034305
 */
public class BookStore {
    Scanner input=new Scanner(System.in);
    ArrayList<Books> book1 = new ArrayList<>();
    ArrayList<Magazines> mags = new ArrayList<>();
    public void run() {
        //ArrayList<Publication> books = new ArrayList<Publication>();
        
        int Choice = -1;
        
    //Magazines Ford = new Magazines(5, , "Rawr", 10, 15);
    Books Dodge = new Books("Thomas", "Rawr on the Shore", 10, 30);
    Books Chevy = new Books("Timmy", "Rawr on the Water", 10, 30);
    Books Toyota = new Books("Taylor", "Rawr on the Rocks", 10, 30);
    //Publication Porsche = new Publication("Tom T.",10, 15);
    
    // preassigned cars added to the car lot.
    //books.add(Ford);
    book1.add(Dodge);
    book1.add(Chevy);
    book1.add(Toyota);
    //books.add(Porsche);
        
        
        while (Choice < 0){
        System.out.print("\n1. Add A Publication"
                + "\n2. Edit A Publication"
                + "\n3. Delete A Publication"
                + "\n4. View Publications"
                + "\n5. Exit the program.");
        System.out.print("\nWhat would you like to do?");        
        Choice = input.nextInt();        
        do{
            // switch statement to control which option the user chooses.
        switch(Choice){
            case 1:
                Choice = AddABook(Choice);
                break;
            case 2:
                Choice = EditABook(Choice);  
                break;
            case 3:
                Choice = DeleteABook(Choice);
                break;
            case 4:
                Choice = ViewAllBooks(Choice);
                break;             
            case 5:
                // exit the program
               System.exit(0);            
        }}while (Choice != -1);
        }           
}
    
    public int AddABook(int Choice){
        String author;
        int quantity;
        String title;
        float price;
        int Type = -1;
        
        Books bookz = new Books();
        Publication book = new Publication();
        
        while (Type < 0){
            System.out.print("\nWhat would you like to add?" 
                            +"\n1. Add a Book"
                            +"\n2. Add a Magazine"
                            +"\n3. Back to Main Menu");
            Type = input.nextInt();
            
            switch(Type){
                case 1:
                    System.out.print("Add a Book");
        
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
                    Type = -1;
                    break;
                case 2:
                    System.out.print("Add a Book");
        
                    System.out.print("\nTitle: ");
                    author = input.next();
                    bookz.setAuthor(author);
                    System.out.print("\nQuantity to Order: ");
                    quantity = input.nextInt();
                    book.setCopies(quantity);
                    System.out.print("\nTitle of book: ");
                    title = input.next();
                    book.setTitle(title);
                    System.out.print("\nPrice per copy: ");
                    price = input.nextFloat();
                    book.setPrice(price);
                    
                    book1.add(bookz);
                    Type = -1;
                    break;
                case 3: break;
            }
            
            
        
        /*System.out.print("Add a Book");
        
        System.out.print("\nTitle: ");
        author = input.next();
        bookz.setAuthor(author);
        System.out.print("\nQuantity to Order: ");
        quantity = input.nextInt();
        book.setCopies(quantity);
        System.out.print("\nTitle of book: ");
        title = input.next();
        book.setTitle(title);
        System.out.print("\nPrice per copy: ");
        price = input.nextFloat();
        book.setPrice(price);
        
        book1.add(bookz);*/
        }
        return Choice = -1;
        
    }
    
    public int EditABook(int Choice){
        int counter = 0;
        String author;
        int quantity;
        String title;
        double price;
        System.out.print("Here are the books currently in the system:");
                // a loop to print out all the books in the store
                if(book1.get(counter) == null)
                {
                    System.out.print("\nThere are no books to edit.");
                     return Choice = -1;
                }
                
                for( counter = 0; counter < book1.size(); counter++){
                    System.out.print("\n" + ((counter + 1) + ". ") + book1.get(counter).getTitle());                    
                }    
        
        System.out.print("\n Choose which book you would like to edit: ");
        counter = input.nextInt();
        author = book1.get(counter-1).getAuthor();
        quantity = book1.get(counter - 1).getCopies();
        title = book1.get(counter - 1).getTitle();
        price = book1.get(counter - 1).getPrice();
        
        return Choice = -1;
    }
    
    
    public int DeleteABook(int Choice){
        Scanner input2=new Scanner(System.in);
        int counter;
                System.out.print("Here is a list of the books: \n");
                
                for( counter = 0; counter < book1.size(); counter++){
                    System.out.print("\n" + ((counter + 1) + ". ") + book1.get(counter).getTitle());                    
                }      
                
                boolean DeleteChoice = false;
                System.out.print("\nChoose the book you would like to remove from inventory:");
                counter = input2.nextInt();
                book1.remove(book1.get(counter - 1));
                
                counter = 1;
                // a loop to repack the array so their are no null entries between books
                while (DeleteChoice != true){
                if (book1.get(counter) == null && book1.get(counter + 1) != null){                    
                //books.get(counter) = books.get(counter + 1);
                book1.remove(book1.get(counter + 1));
            }
                else if (book1.get(counter) == null && book1.get(counter+1) == null){
                    DeleteChoice = true;                    
                }
                counter++;
                }   
        return Choice = -1;
    }
    
    public int ViewAllBooks(int Choice){
         int counter;
         int Type = -1;
         
         while(Type < 0){
             System.out.print("\nChoose which list you would like to view:"
                              +"\n1. View all Books"
                              +"\n2. View All Magazines"
                              +"\n3. Return to Menu");
             Type = input.nextInt();
             
             switch(Type){
                 case 1:
                     System.out.print("Here is a list of the books: \n");
                
                for( counter = 0; counter < book1.size(); counter++){
                    System.out.print("\n" + ((counter + 1) + ". ") + book1.get(counter).getTitle());                    
                }      
                System.out.print("\n ----------------");
                Type = -1;
                break;
                        
                 case 2:
                     System.out.print("Here is a list of the books: \n");
                
                     for( counter = 0; counter < book1.size(); counter++){
                     System.out.print("\n" + ((counter + 1) + ". ") + book1.get(counter).getTitle());                    
                    }      
                     System.out.print("\n ----------------");
                     Type = -1;
                     break;
                 case 3: break;
             }
         
                /*System.out.print("Here is a list of the books: \n");
                
                for( counter = 0; counter < book1.size(); counter++){
                    System.out.print("\n" + ((counter + 1) + ". ") + book1.get(counter).getTitle());                    
                }      
                System.out.print("\n ----------------");*/
    }
        return Choice = -1;
    }
    
    
}