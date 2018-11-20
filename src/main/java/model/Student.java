package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="STUDENT")
public class Student {
    @Id
    @Column(name="ID_STUDENT")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="NAME")
    private String name;

    @ManyToOne
    private Department department;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }

    public String toString() {
        return "Student id: " + getId() + " name: " + getName() + 
               " with " + getDepartment();
    }
}