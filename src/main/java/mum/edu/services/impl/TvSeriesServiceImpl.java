/*
 * Created on Dec 9, 2017
 */
package mum.edu.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.domain.tv.TVSeries;
import mum.edu.repository.TvSeriesRepository;
import mum.edu.services.TvSeriesService;

@Service
public class TvSeriesServiceImpl implements TvSeriesService {

    @Autowired
    private TvSeriesRepository seriesDao;
    

    
    public TvSeriesRepository getSeriesdao() {
        return seriesDao;
    }

    
    public void setSeriesdao(TvSeriesRepository seriesdao) {
        this.seriesDao = seriesdao;
    }

    public TvSeriesServiceImpl() {
    }

    public TVSeries findById(Long id) {
        return seriesDao.findOne(id);
    }

    public TVSeries save(TVSeries serie) {
        return seriesDao.save(serie);
    }

    public List<TVSeries> getAll() {
        return (List<TVSeries>) seriesDao.findAll();
    }

}
