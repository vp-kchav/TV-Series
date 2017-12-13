/*
 * Created on Dec 9, 2017
 */
package mum.edu.domain.tv;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import mum.edu.domain.AbstractLongEntity;

@Entity
public class Season extends AbstractLongEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Season() {
    }

    private String name;
    
    @Lob
    @Column(length = 10485760) // 10 MB 
    private byte[] poster;

    private String summary;

    private int year;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "series_id")
    private TVSeries series;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "season")
    private List<Episode> episodes = new ArrayList<Episode>();
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    public TVSeries getSeries() {
        return series;
    }

    public void setSeries(TVSeries series) {
        this.series = series;
    }
    

   
    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public void addEpisode(Episode episode) {
        episodes.add(episode);
        episode.setSeason(this);
    }
    
    public void removeEpisode(Episode episode) {
        episode.setSeason(null);
        episodes.remove(episode);
    }
    
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] postet) {
        this.poster = postet;
    }
}
