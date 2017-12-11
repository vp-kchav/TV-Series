/*
 * Created on Dec 9, 2017
 */
package mum.edu.dao;

import org.springframework.data.repository.CrudRepository;

import mum.edu.domain.tv.TVSeries;

//@Repository
public interface TvSeriesDao extends CrudRepository<TVSeries, Long> {
    
}
