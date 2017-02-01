//
// This file was generated by the JPA Modeler
//
package test;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductOrder implements Serializable {

    @Basic
    private String Type;

    @Id
    private Long id;

    @Basic
    private String Name;

    public ProductOrder() {

    }

    public String getType() {
        return this.Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
