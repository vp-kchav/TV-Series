/*
 * Created on Dec 9, 2017
 */
package mum.edu.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.domain.person.Artist;
import mum.edu.repository.ArtistRepository;
import mum.edu.services.ArtistService;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    ArtistRepository artistRepository;
    
    public Artist findById(Long id) {
        return artistRepository.findOne(id);   
    }
    
    public List<Artist> getAll() {
        return (List<Artist>) artistRepository.findAll();
    }
    

}
