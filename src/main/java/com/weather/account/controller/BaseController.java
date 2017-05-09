package com.weather.account.controller;

import org.apache.log4j.Logger;
import com.weather.account.model.*;
import com.weather.account.service.*;
import com.weather.account.repository.*;
import com.weather.account.validator.UserValidator;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collection;

/**
 * 
 * @author Mohamed Elkashif
 *
 */
@Controller
public class BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityServiceImpl securityService;
    
    @Autowired
    private NoteRepository noteRepository;
    
    private static final Logger logger = Logger.getLogger(BaseController.class);
    @Autowired
    private UserValidator userValidator;
     
    
    /**
     * function that get the registeration page 
     * @param model
     * @return
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        logger.debug(String.format("Function to get registeration JSP view "));
        return "registration";
    }
     /**
      * function that execute the regestration action and saving the data in database
      * @param userForm
      * @param bindingResult
      * @param model
      * @return
      */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        /**
         * the validation of the info entered by user
         */
    	userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        logger.debug(String.format("Registeration function is called"));
        logger.debug(String.format("Registeration function $s parameters", userForm.getUsername()));
        
        return "redirect:/welcome";
    }
    /**
     * function that return the login page
     * @param model
     * @param error
     * @param logout
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
     
        return "login";
    }
    
     /**
      * function that return welcome page if the user has ROLE_USER and 
      * return welcome admin page if user has ROLE_ADMIN 
      * @param model
      * @return
      */
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
    	
    	model.addAttribute("cityForm", new City());
    	if(hasRole("ROLE_USER")){
    		logger.debug(String.format(" %s successfully!", "ROLE_USER"));
    		return "welcome";
    	}
    	if(hasRole("ROLE_ADMIN")){
    		logger.debug(String.format(" %s successfully!", "ROLE_ADMIN"));
    		return "welcomeAdmin";
    	}
    	
    	return "welcome";
    }
    /**
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/welcomeAdmin", method = RequestMethod.GET)
    public String welcomeAdmin(Model model) {
    	model.addAttribute("cityForm", new City());
        return "welcomeAdmin";
    }
    /**
     * function to get adding note page
     * @param model
     * @return
     */
    @RequestMapping(value = "/addNote", method = RequestMethod.GET)
    public String addNote(Model model){
    	model.addAttribute("noteForm", new Note());
    	return "addNote";
    }
    /**
     * function that save and post the created note to database
     * @param noteForm
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = "/addNote", method = RequestMethod.POST)
    public String city(@ModelAttribute("noteForm") Note noteForm, BindingResult bindingResult, Model model){
    	logger.debug(String.format("Auto login %s successfully!", noteForm.getNote()));
    	noteRepository.save(noteForm);
    	model.addAttribute("noteForm", new Note());
    	return "addNote";
    }
    
   
    
    /**
     * function that check the role of logged user
     * @param role
     * @return
     */
    public boolean hasRole(String role) {
    	  Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
    	  SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    	  boolean hasRole = false;
    	  for (GrantedAuthority authority : authorities) {
    	     hasRole = authority.getAuthority().equals(role);
    	     if (hasRole) {
    	      break;
    	     }
    	  }
    	  return hasRole;
    	}
}
