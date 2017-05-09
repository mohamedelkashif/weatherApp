package com.weather.account.service;

import org.springframework.stereotype.Service;
/**
 * 
 * @author Mohamed Elkashif
 *
 */
public interface SecurityService {
    String findLoggedInUsername();
    /**
     * 
     * @param username
     * @param password
     */
    void autologin(String username, String password);
}
