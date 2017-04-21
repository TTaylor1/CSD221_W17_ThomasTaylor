/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5.entities;

import Lab5.entities.SaleableItem;



/**
 *
 * @author 14034305
 */
public class CashTill {
    private double runningTotal;
    
    CashTill()
            {
             runningTotal = 0;   
            }
    
    public void sellItem(SaleableItem pPub, String Pub)
    {
        runningTotal = runningTotal + pPub.getPrice();
        /*if (Pub.equals("Book") || Pub.equals("Magazine") || Pub.equals("Ticket")){
        pPub.sellCopy();
        }*/
        System.out.println("Sold " + pPub +  " @ " + pPub.getPrice() + "\nsubTotal = " + runningTotal);
    }
    
    public void showTotal()
    {
        System.out.print("GRAND TOTAL: " + runningTotal);
    }

}
