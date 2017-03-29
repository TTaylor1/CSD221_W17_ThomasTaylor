//
// This file was generated by the JPA Modeler
//
package lab5.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class Publication implements Serializable, SaleableItem {

    @Basic
    private double Price;

    @Basic
    private int Copies;

    @Basic
    private String Title;

    @Id
    private Long id;

    public Publication() {

    }
   
    public double getPrice() {
        return this.Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
   
    public int getCopies() {
        return this.Copies;
    }

    public void setCopies(int Copies) {
        this.Copies = Copies;
    }
   
    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
   
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
