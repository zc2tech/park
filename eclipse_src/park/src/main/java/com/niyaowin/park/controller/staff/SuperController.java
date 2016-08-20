package com.niyaowin.park.controller.staff;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.niyaowin.park.Const;
import com.niyaowin.park.form.FormStaff;
import com.niyaowin.park.jpa.StaffRepository;
import com.niyaowin.park.jpa.entity.Staff;
import com.niyaowin.park.util.CryptoUtils;


/**
 * Used by Super User to register/update staff user
 * 
 * @author Administrator
 *
 */
@Controller
public class SuperController {

	@Autowired
	private StaffRepository rep;
	
//	@InitBinder
//    protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(new FormStaffValidator());
////        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////        dateFormat.setLenient(false);
////        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//    }

	// create a staff user
	@Valid
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
   
    @RequestMapping(value="/super/login", method=RequestMethod.GET)
    public String superLogin(Model model) { 
    	model.addAttribute("form", new FormStaff());
        return "super/login";
    } 
    
    // super user login
    @RequestMapping(value="/super/doLogin", method=RequestMethod.POST)
    public String doLogin(HttpSession hs,FormStaff form, BindingResult bindingResult,Model model) { 
    	//Object f2 = model.
    	//FormStaff form = new FormStaff();
    	
    	Staff staff = rep.findFirstByIsSuper(true);
    	if (CryptoUtils.verify(staff.getPasswordHash(), form.getPassword(), staff.getSalt()) ) {
    		// passed
    		hs.setAttribute(Const.SESSION_SUPER, staff);
    		return "super/manage";
    	}
    	
        model.addAttribute("form", form);
        return "super/login";
    }    
    
    private boolean checkSuperUser(HttpSession hs) {
    	Staff superUser = (Staff)hs.getAttribute(Const.SESSION_SUPER);
    	if (superUser != null && superUser.isSuper()) {
    		return true;
    	} else {
    		return false;
    	}
    }
   
    
}
