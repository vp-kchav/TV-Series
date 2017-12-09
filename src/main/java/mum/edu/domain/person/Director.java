/*
 * Created on Dec 9, 2017
 */
package mum.edu.domain.person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Director")
public class Director extends Person {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Director() {
    }

}
