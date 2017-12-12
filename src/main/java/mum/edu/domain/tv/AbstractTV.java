/*
 * Created on Dec 9, 2017
 */
package mum.edu.domain.tv;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import mum.edu.domain.AbstractLongEntity;
import mum.edu.domain.person.Artist;
import mum.edu.domain.person.Director;

@Entity
@Table(name = "TVSeries")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type", discriminatorType = DiscriminatorType.STRING)
public class AbstractTV extends AbstractLongEntity {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String name;
    
    private String descirption;
    
    private int rating;
  
    private List<Artist> casts = new ArrayList<Artist>();
    
    private List<String> comments = new ArrayList<String>();
    

    private List<String> genres = new ArrayList<String>();
    
    
    private Director director;
    
    @ElementCollection
    public List<String> getComments() {
        return comments;
    }
    
    
    public void setComments(List<String> comments) {
        this.comments = comments;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescirption() {
        return descirption;
    }
    
    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }
    
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="tv_id")
    public List<Artist> getCasts() {
        return casts;
    }
    
    public void setCasts(List<Artist> casts) {
        this.casts = casts;
    }
    
    @ElementCollection()
    public List<String> getGenres() {
        return genres;
    }
    
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
    
    public int getRating() {
        return rating;
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    public Director getDirector() {
        return director;
    }
    
    public void setDirector(Director director) {
        this.director = director;
    }
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
