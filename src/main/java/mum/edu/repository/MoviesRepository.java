/*
 * Created on Dec 9, 2017
 */
package mum.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.edu.domain.tv.AbstractTV;

@Repository
public interface MoviesRepository extends CrudRepository<AbstractTV, Long> {
    
    List<AbstractTV> findByGenres(String genre);
    
    @Query(value = "SELECT tv FROM AbstractTV tv Where tv.name like CONCAT('%',:name,'%')")
    List<AbstractTV> findByName(@Param("name") String name);
    
    @Query(value = "SELECT tv FROM AbstractTV tv Where tv.rating = :rate")
    List<AbstractTV> findByRate(@Param("rate") int rate);
    
    @Query(value = "SELECT tv FROM AbstractTV tv inner join tv.casts c Where c.name like CONCAT('%',:artistName,'%')")
    List<AbstractTV> findByArtist(@Param("artistName") String artistName);
    
    @Query(value = "SELECT tv FROM AbstractTV tv inner join tv.director d where d.name like CONCAT('%',:directorName,'%')")
    List<AbstractTV> findByDirector(@Param("directorName") String directorName);
    
    @Query(value = "SELECT tv FROM AbstractTV tv Where tv.name like CONCAT('%',:text,'%') OR tv.descirption like CONCAT('%',:text,'%')")
    List<AbstractTV> findWithNameAndDescription(@Param("text") String text);
}
