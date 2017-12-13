/*
 * Created on Dec 9, 2017
 */
package mum.edu.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.domain.person.Director;
import mum.edu.repository.DirectorRepository;
import mum.edu.services.DirectorService;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    DirectorRepository directorRepository;
    
    public Director findById(Long id) {
        return directorRepository.findOne(id);
    }
    
    public List<Director> getAll(){
        return (List<Director>) directorRepository.findDistinctOrderByName();
        
    }
    

}
