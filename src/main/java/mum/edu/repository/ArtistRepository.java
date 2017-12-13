/*
 * Created on Dec 9, 2017
 */
package mum.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.domain.person.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {
    
}
