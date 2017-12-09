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
    
    private String summary;
    
    private int year;
    
    @Lob
    @Column(length = 10485760) // 10 MB 
    private byte[] postet;

    private List<Episode> episodes = new ArrayList<Episode>();
    
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="season_id")
    public List<Episode> getEpisodes() {
        return episodes;
    }
    
    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
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

    
    public byte[] getPostet() {
        return postet;
    }

    
    public void setPostet(byte[] postet) {
        this.postet = postet;
    }
}

