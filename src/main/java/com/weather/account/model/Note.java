package com.weather.account.model;


import javax.persistence.*;
import java.util.Set;

/**
 * 
 * @author Mohamed Elkashif
 *
 */
@Entity
@Table(name = "note")
public class Note {
    private Long id;
    private String date;
    private String note;
    

   
    /**
     * 
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    /**
     * 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 
     * @return
     */
    public String getNote() {
        return note;
    }
    /**
     * 
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }
    /**
     * 
     * @return
     */
    public String getDate() {
        return date;
    }
    /**
     * 
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    
}