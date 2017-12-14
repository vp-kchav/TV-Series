/*
 * Created on Nov 15, 2017
 */
package mum.edu.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import mum.edu.domain.person.Address;
import mum.edu.domain.person.Artist;
import mum.edu.domain.person.Director;
import mum.edu.domain.tv.AbstractTV;
import mum.edu.domain.tv.Episode;
import mum.edu.domain.tv.Movie;
import mum.edu.domain.tv.Season;
import mum.edu.domain.tv.TVSeries;
import mum.edu.factory.MovieFactory;
import mum.edu.services.MoviesService;
import mum.edu.services.TvSeriesService;

@Controller
@SessionAttributes("currentUser")
public class HomeController {

    @Autowired
    public TvSeriesService seriesService;
    
    @Autowired 
    MoviesService moviesService;

    @RequestMapping(value = { "/", "/index", "/home" }, method = RequestMethod.GET)
    public String index(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails currentUser = (UserDetails) principal;
            model.addAttribute("currentUser", currentUser);
        }
//        deployData();
//        deployDataMovie();
        List<AbstractTV> listMovies = moviesService.getAll();
        try {
            MovieFactory.getInstance().addConvertedImage(listMovies);
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        model.addAttribute("listMovies",listMovies);
        return "ListTv";
    }
    
    protected void deployData() {
        TVSeries s = new TVSeries();

        List<Artist> casts = new ArrayList<Artist>();
        Address address = new Address();
        address.setCity("Fairfield");
        address.setState("IA");
        address.setStreet("4th street");
        address.setZipCode("52557");
        Artist cast1 = new Artist();
        cast1.setBiography("I am cast 1");
        cast1.setDateOfbirth(new Date(1988, 7, 01));
        cast1.setName("Linda Chun");
        cast1.setPlaceOfBirth(address);
        Artist cast2 = new Artist();
        cast2.setBiography("I am cast 2");
        cast2.setDateOfbirth(new Date(1988, 9, 01));
        cast2.setName("Raymond Lam");
        cast2.setPlaceOfBirth(address);
        casts.add(cast1);
        casts.add(cast2);
        s.setCasts(casts);

        List<String> comments = new ArrayList<String>();
        comments.add("comment 1");
        comments.add("comment 2");
        s.setComments(comments);

        s.setDescirption("this film is a very good film just release 2017");

        Director dir = new Director();
        dir.setBiography("I am cast 1");
        dir.setDateOfbirth(new Date(1988, 7, 01));
        dir.setName("Kimtey Chav");
        dir.setPlaceOfBirth(address);
        s.setDirector(dir);

        List<String> genes = new ArrayList<String>();
        genes.add("Comedy");
        genes.add("Love");
        s.setGenres(genes);

        s.setName("The way back");
        s.setRating(9);

        Season season1 = new Season();
        season1.setName("season1");
        season1.setSummary("sumeray seasion 1");
        season1.setYear(2017);
        Episode ep1 = new Episode();
        ep1.setDateAired(new Date());
        ep1.setDescription("decription of Epi1");
        ep1.setName("Episode 1");
        ep1.setSeason(season1);
        season1.addEpisode(ep1);
        s.addSeason(season1);
        seriesService.save(s);
    }
    
    protected void deployDataMovie() {
         Movie m = new Movie();

        List<Artist> casts = new ArrayList<Artist>();
        Address address = new Address();
        address.setCity("Fairfield");
        address.setState("IA");
        address.setStreet("4th street");
        address.setZipCode("52557");
        Artist cast1 = new Artist();
        cast1.setBiography("I am cast 1");
        cast1.setDateOfbirth(new Date(1988, 7, 01));
        cast1.setName("Linda Chun");
        cast1.setPlaceOfBirth(address);
        Artist cast2 = new Artist();
        cast2.setBiography("I am cast 2");
        cast2.setDateOfbirth(new Date(1988, 9, 01));
        cast2.setName("Raymond Lam");
        cast2.setPlaceOfBirth(address);
        casts.add(cast1);
        casts.add(cast2);
        m.setCasts(casts);

        List<String> comments = new ArrayList<String>();
        comments.add("comment 1");
        comments.add("comment 2");
        m.setComments(comments);

        m.setDescirption("this film is a very good film just release 2017");

        Director dir = new Director();
        dir.setBiography("I am cast 1");
        dir.setDateOfbirth(new Date(1988, 7, 01));
        dir.setName("Kimtey Chav");
        dir.setPlaceOfBirth(address);
        m.setDirector(dir);

        List<String> genes = new ArrayList<String>();
        genes.add("Comedy");
        genes.add("Love");
        m.setGenres(genes);

        m.setName("Spiderman Homecoming");
        m.setRating(8);

//        Season season1 = new Season();
//        season1.setName("season1");
//        season1.setSummary("sumeray seasion 1");
//        season1.setYear(2017);
//        Episode ep1 = new Episode();
//        ep1.setDateAired(new Date());
//        ep1.setDescription("decription of Epi1");
//        ep1.setName("Episode 1");
//        ep1.setSeason(season1);
//        season1.addEpisode(ep1);
//        s.addSeason(season1);
        moviesService.save(m);
    }
}
