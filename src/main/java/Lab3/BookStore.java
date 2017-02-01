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
                // a loop to print out all the cars on the lot
                if(books.get(counter) == null)
                {
                    System.out.print("\nThere are no books to edit.");
                     return Choice = -1;
                }
                
                while(books.get(counter) != null){
                    System.out.print("\n" + (counter + 1) + "." + books.get(counter));
                    counter++;
                }
                
                
        System.out.print("\n Choose which book you would like to edit: ");
        counter = input.nextInt();
        author = books.get(counter-1).getAuthor();
        quantity = books.get(counter - 1).getQuantity();
        title = books.get(counter - 1).getTitle();
        price = books.get(counter - 1).getPrice();
        
        return Choice = -1;
    }
    
    
    public int DeleteABook(int Choice){
        
        return Choice = -1;
    }
    
    public int ViewAllBooks(int Choice){
        
        
        return Choice = -1;
    }
    
    
}
