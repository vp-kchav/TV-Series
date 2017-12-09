/*
 * Created on Dec 9, 2017
 */
package mum.edu.domain.tv;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import mum.edu.domain.AbstractLongEntity;
import mum.edu.domain.person.Address;

@Entity
public class Studio extends AbstractLongEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public Studio() {
    }
    
    private String name;
    
    @Embedded
    private Address Location;
    
    private int size;

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public Address getLocation() {
        return Location;
    }

    
    public void setLocation(Address location) {
        Location = location;
    }

    
    public int getSize() {
        return size;
    }

    
    public void setSize(int size) {
        this.size = size;
    }
}
