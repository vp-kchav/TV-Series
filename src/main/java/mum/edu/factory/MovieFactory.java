/*
 * Created on Nov 17, 2017
 */
package mum.edu.factory;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.security.crypto.codec.Base64;

import mum.edu.domain.dto.MovieDto;
import mum.edu.domain.tv.AbstractTV;
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

     public void addConvertedImage(List<AbstractTV> movies) throws UnsupportedEncodingException {
         for(AbstractTV movie: movies) {
             if(movie.getPicture() != null) {
                 byte[] bytes = movie.getPicture();
                 byte[] encodeBase64 = Base64.encode(bytes);
                 String base64Encoded = new String(encodeBase64, "UTF-8");
                 movie.setBase64Image(base64Encoded);
             }
         }
//         return movies;
     }
}
