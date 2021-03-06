//
// This file was generated by the JPA Modeler
//
package test;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee extends Person implements Serializable {

    @Id
    private Long id;

    @ManyToOne(targetEntity = Department.class)
    private Department department;

    public Employee() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
