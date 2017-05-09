package com.weather.account.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.weather.account.model.User;

/**
 * 
 * @author Mohamed Elkashif
 *
 */
public interface UserService {
	/**
	 * 
	 * @param user
	 */
    void save(User user);
    /**
     * 
     * @param username
     * @return
     */
    User findByUsername(String username);
}
