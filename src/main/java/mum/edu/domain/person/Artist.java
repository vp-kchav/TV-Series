/*
 * Created on Dec 9, 2017
 */
package mum.edu.domain.person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("Artist")
@Entity
public class Artist extends Person {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Artist() {
    }

}
