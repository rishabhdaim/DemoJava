/**
 * 
 */
package demo.java.journel.dev.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Rishabh.Daim
 *
 */
@Entity
@Table(name="Person")
public class Person {
	
	@Id
    @Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_sequence")
	@SequenceGenerator(name="id_sequence", sequenceName="person_seq")
    private int id;
     
    private String name;
     
    private String country;
 
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
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
     
    @Override
    public String toString(){
        return "id="+id+", name="+name+", country="+country;
    }
}
