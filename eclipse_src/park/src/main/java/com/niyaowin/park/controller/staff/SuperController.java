package com.niyaowin.park.controller.staff;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.thymeleaf.util.StringUtils;

import com.niyaowin.park.form.FormStaff;
import com.niyaowin.park.jpa.entity.Staff;


@Controller
@SessionAttributes("superUser")
public class SuperController {

	// create a staff user
    @RequestMapping(value="/super/register", method=RequestMethod.GET)
    public String register(WebRequest wr,HttpSession hs,Model model) { 
    	if (!checkSuperUser(hs)) {
    		 model.addAttribute("form", new FormStaff());
    		return "super/login";
    	}
    	FormStaff form = new FormStaff();
        model.addAttribute("staff", form);
        return "super/register_staff";
    }
 
    
    // super user login
    @RequestMapping(value="/super/doLogin", method=RequestMethod.POST)
    public String doLogin(FormStaff form, BindingResult bindingResult,Model model) { 
    	//Object f2 = model.
    	//FormStaff form = new FormStaff();
    	
    	
    	
        model.addAttribute("form", form);
        return "super/login";
    }    
    
    private boolean checkSuperUser(HttpSession hs) {
    	Staff superUser = (Staff)hs.getAttribute("superUser");
    	if (superUser != null && superUser.isSuper()) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    @RequestMapping(value="/super/login", method=RequestMethod.GET)
    public String login(@SessionAttribute("loginUser") FormStaff staff,Model model) {
        return "super/register_staff";
    }    
    
    @RequestMapping(value="/session", method=RequestMethod.GET)
    public String checkSuper(Model model) {
    	model.addAttribute("staff", new FormStaff());
    	return "session";
    }
    
    
}
