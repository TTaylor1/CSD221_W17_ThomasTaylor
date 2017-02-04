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
    
    
    public void run() {
        ArrayList<Book> books = new ArrayList<Book>();
        int Choice = -1;
        
    Book Ford = new Book("Tom T.",10, "Mustang", 50);
    Book Dodge = new Book("Tom T.",10, "Charger", 30);
    Book Chevy = new Book("Tom T.",10, "Impala", 25);
    Book Toyota = new Book("Tom T.",10, "4Runner", 20);
    Book Porsche = new Book("Tom T.",10, "Carerra", 15);
    
    // preassigned cars added to the car lot.
    books.add(Ford);
    books.add(Dodge);
    books.add(Chevy);
    books.add(Toyota);
    books.add(Porsche);
        
        
        while (Choice < 0){
        System.out.print("\n1. Add A Book"
                + "\n2. Edit A Book"
                + "\n3. Delete A Book"
                + "\n4. View All Books"
                + "\n5. Exit the program.");
        System.out.print("\nWhat would you like to do?");        
        Choice = input.nextInt();        
        do{
            // switch statement to control which option the user chooses.
        switch(Choice){
            case 1:
                Choice = AddABook(Choice, books);
                break;
            case 2:
                Choice = EditABook(Choice, books);  
                break;
            case 3:
                Choice = DeleteABook(Choice, books);
                break;
            case 4:
                Choice = ViewAllBooks(Choice, books);
                break;             
            case 5:
                // exit the program
               System.exit(0);            
        }}while (Choice != -1);
        }           
}
    
    public int AddABook(int Choice, ArrayList<Book> books){
        String author;
        int quantity;
        String title;
        float price;
        Book book = new Book();
        System.out.print("Add a Book(q to quit)");
        
        System.out.print("\nAuthor's Name: ");
        author = input.next();
        book.setAuthor(author);
        System.out.print("\nQuantity to Order: ");
        quantity = input.nextInt();
        book.setQuantity(quantity);
        System.out.print("\nTitle of book: ");
        title = input.next();
        book.setTitle(title);
        System.out.print("\nPrice per copy: ");
        price = input.nextFloat();
        book.setPrice(price);
        books.add(book);
        return Choice = -1;
    }
    
    public int EditABook(int Choice, ArrayList<Book> books){
        int counter = 0;
        String author;
        int quantity;
        String title;
        float price;
        System.out.print("Here are the books currently in the system:");
                // a loop to print out all the books in the store
                if(books.get(counter) == null)
                {
                    System.out.print("\nThere are no books to edit.");
                     return Choice = -1;
                }
                
                for( counter = 0; counter < books.size(); counter++){
                    System.out.print("\n" + ((counter + 1) + ". ") + books.get(counter).getTitle());                    
                }    
        
        System.out.print("\n Choose which book you would like to edit: ");
        counter = input.nextInt();
        author = books.get(counter-1).getAuthor();
        quantity = books.get(counter - 1).getQuantity();
        title = books.get(counter - 1).getTitle();
        price = books.get(counter - 1).getPrice();
        
        return Choice = -1;
    }
    
    
    public int DeleteABook(int Choice, ArrayList<Book> books){
        Scanner input2=new Scanner(System.in);
        int counter;
                System.out.print("Here is a list of the books: \n");
                
                for( counter = 0; counter < books.size(); counter++){
                    System.out.print("\n" + ((counter + 1) + ". ") + books.get(counter).getTitle());                    
                }      
                
                boolean DeleteChoice = false;
                System.out.print("\nChoose the book you would like to remove from inventory:");
                counter = input2.nextInt();
                books.remove(books.get(counter - 1));
                
                counter = 1;
                // a loop to repack the array so their are no null entries between books
                while (DeleteChoice != true){
                if (books.get(counter) == null && books.get(counter + 1) != null){
                books.get(counter) = books.get(counter + 1);
                books.remove(books.get(counter + 1));
            }
                else if (books.get(counter) == null && books.get(counter+1) == null){
                    DeleteChoice = true;                    
                }
                counter++;
                }   
        return Choice = -1;
    }
    
    public int ViewAllBooks(int Choice, ArrayList<Book> books){
         int counter;
                System.out.print("Here is a list of the books: \n");
                
                for( counter = 0; counter < books.size(); counter++){
                    System.out.print("\n" + ((counter + 1) + ". ") + books.get(counter).getTitle());                    
                }      
                System.out.print("\n ----------------");
        
        return Choice = -1;
    }
    
    
}