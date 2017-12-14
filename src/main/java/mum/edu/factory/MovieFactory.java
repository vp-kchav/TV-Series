/*
 * Created on Nov 17, 2017
 */
package mum.edu.factory;

import mum.edu.domain.dto.MovieDto;
import mum.edu.domain.tv.Movie;


public class MovieFactory {
    
    private static MovieFactory INSTANCE = null;
 
    // private constructor restricted to this class itself
    private MovieFactory()
    {
  
    }
    // static method to create instance of Singleton class
    public static MovieFactory getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new MovieFactory();
 
        return INSTANCE;
    }
    
     public Movie createMovieFromDto(MovieDto dto) {
         Movie movie = new Movie();
         movie.setName(dto.getName());
         movie.setRating(dto.getRating());
         movie.setDescirption(dto.getDescirption());
//         movie.setDirector(dto.getDirector());
         // isEmpty means file exists BUT NO Content
         if (dto.getImage() != null) {
             try {
                 movie.setPicture(dto.getImage().getBytes());
             } catch (Exception e) {
                 System.out.println("Unable to save image ");
             }
         }
         return movie;
    }

}
