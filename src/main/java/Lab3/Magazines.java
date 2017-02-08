/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 14034305
 */
public class Magazines extends Publication{
    private int orderQty;
    private Date currIssue;
    
    Format formatter = new SimpleDateFormat("MM-yyyy");
    
   
    
    public Magazines(){
        
    }
    
    
    public Magazines(int orderQty, Date currIssue){
        this.orderQty = orderQty;
        this.currIssue = currIssue;
    }
    
    public Magazines(int orderQty, Date currIssue, String title, Double price, int copies){
        super(title,price,copies);
        this.orderQty = orderQty;
        this.currIssue = currIssue;
    }
    
    public void receiveNewIssue(Date newIssue){
        
    }
    
    public void adjustQty(int n){
        
    }
    Format fmt = new SimpleDateFormat("MM-yyyy");
    @Override
    public String toString(){
       String m = fmt.format(currIssue);
        return "\nTitle: " + super.getTitle() +
       "\nQuantity Ordered: " + getOrderQty() +
       "\nCurrent Issue Date: " + m +
       "\nPrice: " + super.getPrice();
       
    }

    /**
     * @return the orderCopy
     */
    public int getOrderQty() {
        return orderQty;
    }

    /**
     * @param orderQty the orderCopy to set
     */
    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    /**
     * @return the currIssue
     */
    public Date getCurrIssue() {
        return currIssue;
    }

    /**
     * @param currIssue the currIssue to set
     */
    public void setCurrIssue(Date currIssue) {
        this.currIssue = currIssue;
    }
    
}
