/*
 * Created on Dec 9, 2017
 */
package mum.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.domain.person.Director;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Long> {
    
    @Query(value = "SELECT distinct d FROM Director d order by d.name")
    public List<Director> findDistinctOrderByName();
}
