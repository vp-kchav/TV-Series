/*
 * Created on Dec 10, 2017
 */
package mum.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.constant.Constant;
import mum.edu.domain.dto.MovieDto;
import mum.edu.domain.dto.SearchDto;
import mum.edu.domain.person.Artist;
import mum.edu.domain.person.Director;
import mum.edu.domain.tv.AbstractTV;
import mum.edu.domain.tv.Movie;
import mum.edu.factory.MovieFactory;
import mum.edu.services.ArtistService;
import mum.edu.services.DirectorService;
import mum.edu.services.MoviesService;

@Controller
public class MovieController {

    @Autowired 
    MoviesService moviesService;
    @Autowired
    DirectorService directorService;
    @Autowired
    ArtistService artistService;
    
    public MovieController() {
        // TODO Auto-generated constructor stub
    }
    
    @PostMapping("searchMovie")
    public String searchMovie(@ModelAttribute("searchDto") SearchDto search, Model model, RedirectAttributes ra) {
        List<AbstractTV> listMovies = null;
        String textSearch = search.getTextSearch();
        if(search.getType().equalsIgnoreCase(Constant.SEARCH_ALL)) {
            listMovies=moviesService.findWithNameAndDescription(textSearch);
        } else if(search.getType().equalsIgnoreCase(Constant.SEARCH_NAME)) {
            listMovies=moviesService.findByName(textSearch);
        } else if(search.getType().equalsIgnoreCase(Constant.SEARCH_GENRE)) {
            listMovies=moviesService.findByGenre(textSearch);
        } else if(search.getType().equalsIgnoreCase(Constant.SEARCH_RATE)) {
            listMovies=moviesService.findByRate(Integer.valueOf(textSearch));
        } else if(search.getType().equalsIgnoreCase(Constant.SEARCH_DIRECTOR)) {
            listMovies=moviesService.findByDirector(textSearch);
        } else if(search.getType().equalsIgnoreCase(Constant.SEARCH_ARTIST)) {
            listMovies=moviesService.findByArtist(textSearch);
        }
        
//        List<AbstractTV> listMovies = moviesService.findByName(search.getTextSearch());
        ra.addFlashAttribute("listMovies",listMovies);
        return "redirect:/SearchedMovies";
    }
    
    @RequestMapping(value = { "/SearchedMovies"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "ListTv";
    }
    
   @GetMapping(value= "/addmovies")
   public String addMoviesView(@ModelAttribute("newMovie") MovieDto movie,Model model) {
       List<Director> directors = directorService.getAll();
       List<Artist> artists = artistService.getAll();
       model.addAttribute("directors",directors);
       model.addAttribute("artists",artists);
       return "addmovies";
   }

   @PostMapping(value="/saveMovie")
   public String saveMovie(@Valid @ModelAttribute("newMovie") MovieDto movieDto,BindingResult result,Model model ) {
       Movie movie = MovieFactory.getInstance().createMovieFromDto(movieDto);
       moviesService.save(movie);
       return "redirect:/addmovies";
   }
}
