/*
 * Created on Dec 9, 2017
 */
package mum.edu.domain.tv;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import mum.edu.domain.AbstractLongEntity;

@Entity
public class Episode extends AbstractLongEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public Episode() {
        // TODO Auto-generated constructor stub
    }

    private String description;
    
    @Temporal(TemporalType.DATE)
    private Date dateAired;

    
    public String getDescription() {
        return description;
    }

    
    public void setDescription(String description) {
        this.description = description;
    }

    
    public Date getDateAired() {
        return dateAired;
    }

    
    public void setDateAired(Date dateAired) {
        this.dateAired = dateAired;
    }
}
