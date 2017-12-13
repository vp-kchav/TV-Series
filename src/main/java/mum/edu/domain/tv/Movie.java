/*
 * Created on Dec 9, 2017
 */
package mum.edu.domain.tv;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Movie")
public class Movie extends AbstractTV {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Movie() {
        // TODO Auto-generated constructor stub
    }    
    
}
