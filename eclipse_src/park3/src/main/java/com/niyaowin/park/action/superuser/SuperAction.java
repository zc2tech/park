package com.niyaowin.park.action.staff;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.niyaowin.park.Const;
import com.niyaowin.park.entity.Staff;
import com.niyaowin.park.jpa.service.StaffService;
import com.niyaowin.park.model.MessageStore;
import com.niyaowin.park.util.CryptoUtils;
import com.niyaowin.park.util.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Acts as a Struts 2 controller that responds
 * to a user action by setting the value
 * of the Message model class, and returns a String 
 * result.
 * @author Bruce Phillips
 *
 */
public class SuperAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	/**
	 * The model class that stores the message
	 * to display in the view.
	 */
	private MessageStore messageStore;
	
	private Map<String, Object> userSession ;
	
	private static final String HELLO_COUNT = "helloCount";
		
	private String userName;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}    
   
    public String login() { 
        return SUCCESS;
    }
    
	public void validate(){
		System.out.println("In validate");
//		if ( personBean.getFirstName().length() == 0 ){	
//
//			addFieldError( "personBean.firstName", "First name is required." );
//			
//		}
//		
//				
//		if ( personBean.getEmail().length() == 0 ){	
//
//			addFieldError( "personBean.email", "Email is required." );
//			
//		}
//		
//		if ( personBean.getAge() < 18 ){	
//
//			addFieldError( "personBean.age", "Age is required and must be 18 or older" );
//			
//		}		
	}
	
    public String doLogin() { 
    	if (StringUtils.isEmpty(this.password)) {
    		addFieldError( "password", "Password is empty" );
    		return INPUT;
    	}
    	
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	StaffService svs = StaffService.getStaffService(session);
    	Staff superStaff = svs.findSuperUser();
    	if (superStaff != null 
    			&& CryptoUtils.verify(superStaff.getPasswordHash(), 
    					this.password,superStaff.getSalt()) )
    	{
    		userSession.put(Const.SESSION_SUPER, superStaff);
    		 return SUCCESS;
    	} else {
    		addFieldError( "password", "Wrong Password" );
    		return INPUT;
    	}
       
    }    
	
	public void setSession(Map<String, Object> session) {
		
		userSession = session ;

	}
	
	

}
