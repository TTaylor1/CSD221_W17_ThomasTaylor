/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

/**
 *
 * @author 14034305
 */
public class Ticket implements SaleableItem {
    private String Description;
    private double Price;
    private String client;
    
    public Ticket(){}
    
    public Ticket(String Title, double Price, String client){
        this.Description = Title;
        this.Price = Price;
        this.client = client;
    }
    
    
     @Override
        public String toString(){
            String t = "";
            t +=
             "\nDescription: " + getDescription() +
             "\nPrice: " + getPrice() +             
             "\nClient: " + getClient();             
            return t;
        }
    @Override
    public void sellCopy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getPrice() {
        return Price;
    }


    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the client
     */
    public String getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(double Price) {
        this.Price = Price;
    }
}
