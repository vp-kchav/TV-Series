/*
 * Created on Dec 9, 2017
 */
package mum.edu.services;

import java.util.List;

import mum.edu.domain.tv.TVSeries;

public interface TvSeriesService {

    TVSeries findById(Long id);
    
    TVSeries save(TVSeries serie);
    
    List<TVSeries> getAll();

}
