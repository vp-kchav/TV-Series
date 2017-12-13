/*
 * Created on Dec 9, 2017
 */
package mum.edu.services;

import java.util.List;

import mum.edu.domain.person.Artist;

public interface ArtistService {

    Artist findById(Long id);
    
    List<Artist> getAll();
    

}
