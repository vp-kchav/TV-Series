/*
 * Created on Dec 9, 2017
 */
package mum.edu.services;

import java.util.List;

import mum.edu.domain.person.Director;

public interface DirectorService {

    Director findById(Long id);
    
    List<Director> getAll();
    

}
