package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Department {
    @Id
    @Column(name="ID_DEPARTMENT")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="NAME")
    private String name;
    @OneToMany(mappedBy="department")
    @OrderBy("name ASC")
    private List<Student> students;

    public Department() {
        students = new ArrayList<Student>();
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String deptName) {
        this.name = deptName;
    }
    
    public void addStudent(Student student) {
        if (!getStudents().contains(student)) {
            getStudents().add(student);
            if (student.getDepartment() != null) {
                student.getDepartment().getStudents().remove(student);
            }
            student.setDepartment(this);
        }
    }
    
    public Collection<Student> getStudents() {
        return students;
    }

    public String toString() {
        return "Department id: " + getId() + 
               ", name: " + getName();
    }
}