package com.niyaowin.park.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niyaowin.park.jpa.StaffRepository;
import com.niyaowin.park.jpa.entity.Staff;
import com.niyaowin.park.util.CryptoUtils;


@RestController
public class RestStaffController {

	@Autowired
	private StaffRepository rep;
	
    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/rest/super/getPasswordHash")
    public HttpEntity<String> getPasswordHash(
            @RequestParam(value = "password") String password, 
            @RequestParam(value = "salt") String salt) {      
        return new ResponseEntity<String>("thehash", HttpStatus.OK);
    }
    
    @RequestMapping("/rest/super/generatePassword/{staffId}/{password}")
    public HttpEntity<String> generatePassword(
            @PathVariable long staffId,@PathVariable String password) {   
    	    	
    	Staff staff = rep.findOne(staffId);
    	if (staff == null) {
    		return  new ResponseEntity<String>("Not Exist", HttpStatus.OK);
    	} else {
    		String salt = CryptoUtils.getSalt();
    		String hash = CryptoUtils.getHash(password, salt);
    		staff.setSalt(salt);
    		staff.setPasswordHash(hash);
    		rep.save(staff);
    		return  new ResponseEntity<String>("Generated For ID:" + staffId, HttpStatus.OK);
    	}
        
    }    
}
