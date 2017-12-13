/*
 * Created on Dec 9, 2017
 */
package mum.edu.domain.tv;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("TV-Series")
public class TVSeries extends AbstractTV{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

   
    @OneToMany(cascade = CascadeType.ALL,
            fetch=FetchType.EAGER,
            mappedBy="series")
    private List<Season> seasons = new ArrayList<Season>();

    public List<Season> getSeasons() {
        return seasons;
    }

    
    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public void addSeason(Season season) {
        seasons.add(season);
        season.setSeries(this);
    }
    
    public void removeSeason(Season season) {
        season.setSeries(null);
        seasons.remove(season);
    }
    
    public TVSeries() {
    }

}
