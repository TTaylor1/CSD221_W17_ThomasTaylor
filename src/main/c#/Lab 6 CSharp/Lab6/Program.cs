using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab6
{
    class Program
    {
        static List<Publication> Mags = new List<Publication>();
        static List<Book> Books = new List<Book>();
        static List<Publication> list = new List<Publication>();
        static void Main(string[] args)
        {
           /* Console.WriteLine("Hello World");
            Publication pub = new Publication();
            pub.Title = "I Love Programming";
            pub.Price = 10.99;
            pub.Copies = 10;

            Book book = new Book();
            book.Author = "Thomas Taylor";
            book.Title = "I Love Linux";
            book.Copies = 12;
            book.Price = 100;
            Console.Write("\n");
            Console.WriteLine(pub);
            Console.Write("\n");
            Console.WriteLine(book);

            list.Add(pub);
            list.Add(book);

            foreach (Publication p in list)
            {
                Console.Write("\n");
                Console.WriteLine(p);
            }*/
            int choice = -1;
            int choice1 = -1;
            string Pub;


            while (choice < 0) {
                Console.Write("--------Main--------" +
                              "\n1. Books" +
                              "\n2. Magazines" +
                              "\n3. Tickets" +
                              "\n4. Checkout" +
                              "\n5. Exit \n");
                choice = Convert.ToInt32(Console.ReadLine());
                
                switch (choice)
                {
                    case 1:
                        Console.WriteLine("\n1. Add A Book" +
                                          "\n2. Edit A Book" +
                                          "\n3. Delete A Book" +
                                          "\n4. Sell A Book" +
                                          "\n5. Return to Main Menu" +
                                          "\n What would you like to do?");
                        choice1 = Convert.ToInt32(Console.ReadLine());

                        Pub = "Book";
                    do{
                     // switch statement to control which option the user chooses.
                    switch(choice1){
                    case 1:
                        choice = Add(choice1, Pub);
                        break;
                    case 2:
                        choice = Edit(choice1, Pub);  
                        break;
                    case 3:
                        choice = Delete(choice1, Pub);
                        break;
                    case 4:
                        choice = Sell(choice1, Pub);
                        break;
                    case 5: break;
                    }}while (choice != -1);
                    break;

                    case 2:
                        Console.WriteLine("\n1. Add A Magazine" +
                                          "\n2. Edit A Magazine" +
                                          "\n3. Delete A Magazine" +
                                          "\n4. Sell A Magazine" +
                                          "\n5. Return to Main Menu" +
                                          "\n What would you like to do?");
                        choice1 = Convert.ToInt32(Console.ReadLine());

                        Pub = "Magazine";
                    do{
                     // switch statement to control which option the user chooses.
                    switch(choice1){
                    case 1:
                        choice = Add(choice1, Pub);
                        break;
                    case 2:
                        choice = Edit(choice1, Pub);  
                        break;
                    case 3:
                        choice = Delete(choice1, Pub);
                        break;
                    case 4:
                        choice = Sell(choice1, Pub);
                        break;
                    case 5: break;
                    }}while (choice != -1);
                        break;

                    case 3:
                        Console.WriteLine("\n1. Add A Ticket" +
                                          "\n2. Edit A Ticket" +
                                          "\n3. Delete A Ticket" +
                                          "\n4. Sell A Ticket" +
                                          "\n5. Return to Main Menu" +
                                          "\n What would you like to do?");
                        choice1 = Convert.ToInt32(Console.ReadLine());

                        Pub = "Ticket";
                    do{
                     // switch statement to control which option the user chooses.
                    switch(choice1){
                    case 1:
                        choice = Add(choice1, Pub);
                        break;
                    case 2:
                        choice = Edit(choice1, Pub);  
                        break;
                    case 3:
                        choice = Delete(choice1, Pub);
                        break;
                    case 4:
                        choice = Sell(choice1, Pub);
                        break;
                    case 5: break;
                    }}while (choice != -1);
                        break;
                    case 4:
                        Console.WriteLine("Currently out of order");
                        break;

                    case 5: break;
                }

                
            }
        }


            static int Add(int choice, string Pub){

                Book bookz = new Book();
                

                if (Pub == "Book")
                {
                    Console.WriteLine("Title: ");
                    bookz.Title = Console.ReadLine();
                    Console.WriteLine("Quantity to Order: ");
                    bookz.Copies = Convert.ToInt32(Console.ReadLine());
                    Console.WriteLine("Price: ");
                    bookz.Price = Convert.ToDouble(Console.ReadLine());
                    Console.WriteLine("Author: ");
                    bookz.Author = Console.ReadLine();

                    Books.Add(bookz);
                }

                else if (Pub == "Magazine")
                {
                    Console.WriteLine("Title: ");
                    bookz.Title = Console.ReadLine();
                    Console.WriteLine("Quantity to Order: ");
                    bookz.Copies = Convert.ToInt32(Console.ReadLine());
                    Console.WriteLine("Price: ");
                    bookz.Price = Convert.ToDouble(Console.ReadLine());
                    Console.WriteLine("Date of Current Issue: ");
                    //bookz. = Console.ReadLine();

                    Books.Add(bookz);
                }

                else if (Pub == "Ticket")
                {

                }

                return choice = -1;
            }

            static int Edit(int choice, string Pub)
            {
                int counter = 0;
                int change = 0;

                Console.WriteLine("Here are the " + Pub + "'s currently in the system:");
                if (Pub == "Book")
                {
                    if (Books[counter] == null)
                    {
                        Console.WriteLine("There are currently no Books in the System.");
                        return choice = -1;
                    }
                    for (counter = 0; counter < Books.Count; counter++)
                    {
                        Console.WriteLine("\n" + ((counter + 1) + ". ") + Books[counter].Title);
                    }
                    Console.WriteLine("\n Choose which book you would like to edit: ");
                    counter = Convert.ToInt32(Console.ReadLine());

                    Console.WriteLine("\n Choose which section you would like to edit:"
                                  + "\n1. Edit the Title"
                                  + "\n2. Edit the Order Quantity"
                                  + "\n3. Edit the Price"
                                  + "\n4. Edit the Author "
                                  + "\n5. Return to Menu\n");
                    change = Convert.ToInt32(Console.ReadLine());
                    switch (change)
                    {
                        case 1:
                            Console.WriteLine("\n Edit the Title: ");
                            Books[counter - 1].Title = Console.ReadLine();
                            break;
                        case 2:
                            Console.WriteLine("\nEdit the Order Quantity: ");
                            Books[counter - 1].Copies = Convert.ToInt32(Console.ReadLine());
                            break;
                        case 3:
                            Console.WriteLine("\nEdit the Price: ");
                            Books[counter - 1].Price = Convert.ToInt32(Console.ReadLine());
                            break;
                        case 4:
                            Console.WriteLine("\nEdit the Author: ");
                            Books[counter - 1].Author = Console.ReadLine();
                            break;
                        case 5: break;
                    }
                    
                }
                
                return choice = -1;
            }


            static int Delete(int choice, string Pub)
            {

                int counter = 0;

                Console.WriteLine("Here are the " + Pub + "'s currently in the system:");
                if (Pub == "Book")
                {
                    if (Books[counter] == null)
                    {
                        Console.WriteLine("There are currently no Books in the System.");
                        return choice = -1;
                    }
                    for (counter = 0; counter < Books.Count; counter++)
                    {
                        Console.WriteLine("\n" + ((counter + 1) + ". ") + Books[counter].Title);
                    }
                    Console.WriteLine("\n Choose which book you would like to remove from inventory: ");
                    counter = Convert.ToInt32(Console.ReadLine());

                    Books.RemoveAt(counter - 1);

                }
                return choice = -1;
            }

            static int Sell(int choice, string Pub)
            {

                return choice = -1;
            }
        }
    }

