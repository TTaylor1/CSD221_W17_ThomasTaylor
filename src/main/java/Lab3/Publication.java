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
public class Publication {
    private String title;
    private double price;
    private int copies;
    
    
    
    public Publication(){
    
}
    
    public Publication(String title, double price, int copies){
        this.title = title;
        this.price = price;
        this.copies = copies;        
    }
    
    public void sellCopy(){        
    }
    
    @Override
    public String toString(){
        String s="";
        s+= "\nTitle: " + getTitle()+
            "\nPrice: " + getPrice()+
            "\nCopies: " + getCopies();  
        return s;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the copies
     */
    public int getCopies() {
        return copies;
    }

    /**
     * @param copies the copies to set
     */
    public void setCopies(int copies) {
        this.copies = copies;
    }
}
