/*
 * Created on Dec 9, 2017
 */
package mum.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.domain.tv.AbstractTV;

@Repository
public interface MoviesRepository extends CrudRepository<AbstractTV, Long> {
    
}
