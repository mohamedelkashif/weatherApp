package com.weather.account.repository;

import com.weather.account.model.Note;
import com.weather.account.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * @author Mohamed Elkashif
 *
 */
public interface NoteRepository extends JpaRepository<Note, Long>{
}
