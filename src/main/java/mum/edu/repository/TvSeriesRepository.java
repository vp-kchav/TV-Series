/*
 * Created on Dec 9, 2017
 */
package mum.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.domain.tv.TVSeries;

@Repository
public interface TvSeriesRepository extends CrudRepository<TVSeries, Long> {
    
}
