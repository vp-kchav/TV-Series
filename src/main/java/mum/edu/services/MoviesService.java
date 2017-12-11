/*
 * Created on Dec 9, 2017
 */
package mum.edu.services;

import java.util.List;

import mum.edu.domain.tv.AbstractTV;

public interface MoviesService {

    AbstractTV findById(Long id);
    
    AbstractTV save(AbstractTV serie);
    
    List<AbstractTV> getAll();

}
