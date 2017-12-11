/*
 * Created on Dec 9, 2017
 */
package mum.edu.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.domain.tv.AbstractTV;
import mum.edu.repository.MoviesRepository;
import mum.edu.services.MoviesService;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository moviesDao;
    

    
    public MoviesRepository getSeriesdao() {
        return moviesDao;
    }

    
    public void setSeriesdao(MoviesRepository moviesDao) {
        this.moviesDao = moviesDao;
    }

    public MoviesServiceImpl() {
    }

    public AbstractTV findById(Long id) {
        return moviesDao.findOne(id);
    }

    public AbstractTV save(AbstractTV serie) {
        return moviesDao.save(serie);
    }

    public List<AbstractTV> getAll() {
        return (List<AbstractTV>) moviesDao.findAll();
    }

}
