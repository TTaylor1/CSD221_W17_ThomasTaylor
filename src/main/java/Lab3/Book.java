/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

/**
 *
 * @author 14034305
 */
public class Book {
    private String Author;
    private int Quantity;
    private String Title;
    private float Price;
    
    public Book(){
        
    }
    
    public Book(String Author, int Quantity, String Title, float Price){
        this.Author = Author;
        this.Quantity = Quantity;
        this.Title = Title;
        this.Price = Price;
    }
    
    @Override
    public String toString(){
        String s="";
        s+= "\nAuthor: " + getAuthor()+
            "\nQuantity Ordered: " + getQuantity()+
            "\nTitle: " + getTitle() +
            "\nPrice: " + getPrice();  
        return s;
    }

    /**
     * @return the Author
     */
    public String getAuthor() {
        return Author;
    }

    /**
     * @param Author the Author to set
     */
    public void setAuthor(String Author) {
        this.Author = Author;
    }

    /**
     * @return the Quantity
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * @return the Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * @return the Price
     */
    public float getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(float Price) {
        this.Price = Price;
    }
    
    
}
