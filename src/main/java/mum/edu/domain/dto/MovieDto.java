/*
 * Created on Dec 11, 2017
 */
package mum.edu.domain.dto;

import org.springframework.web.multipart.MultipartFile;

import mum.edu.domain.person.Director;

public class MovieDto {

    public MovieDto() {
        // TODO Auto-generated constructor stub
    }

    private String name;
    private String descirption;
    private int rating;
    private Director director;
    private MultipartFile image;
    
    public int getRating() {
        return rating;
    }
    
    
    public void setRating(int rating) {
        this.rating = rating;
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
    
    public Director getDirector() {
        return director;
    }
    
    public void setDirector(Director director) {
        this.director = director;
    }
    
    public MultipartFile getImage() {
        return image;
    }
    
    public void setImage(MultipartFile image) {
        this.image = image;
    }
    
}
