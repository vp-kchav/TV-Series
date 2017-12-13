/*
 * Created on Nov 28, 2017
 */
package mum.edu.domain.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;

import mum.edu.domain.AbstractLongEntity;

@Entity
public class MovieTest extends AbstractLongEntity{

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private int rating;
    @Lob
    @Column(length = 16777215)
    private byte[] cover;
    
    public Long getId() {
        return Id;
    }
    
    public void setId(Long id) {
        Id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getRating() {
        return rating;
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public byte[] getCover() {
        return cover;
    }
    
    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public int getEntityVersion() {
        // TODO Auto-generated method stub
        return 0;
    }
          
}
