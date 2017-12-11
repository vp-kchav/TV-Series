/*
 * Created on Nov 17, 2017
 */
package mum.edu.domain.dto;

import java.io.Serializable;

public class SearchDto implements Serializable  {
     
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String textSearch;
    private String type;
    
    public String getTextSearch() {
        return textSearch;
    }
    
    public void setTextSearch(String textSearch) {
        this.textSearch = textSearch;
    }
     
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
