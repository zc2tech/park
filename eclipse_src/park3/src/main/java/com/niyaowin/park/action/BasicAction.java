package com.niyaowin.park.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.cfg.Configuration;

import com.niyaowin.park.model.MessageStore;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;

/**
 * Acts as a Struts 2 controller that responds
 * to a user action by setting the value
 * of the Message model class, and returns a String 
 * result.
 * @author Bruce Phillips
 *
 */
public class ThymeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * The model class that stores the message
	 * to display in the view.
	 */
	private MessageStore messageStore;
	
	private Map<String, Object> userSession ;
	
	private static final String HELLO_COUNT = "helloCount";
	
	
	private String welcome = "ThymeAction.welcome" ;
	private String message = "My Message" ;
	
	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;

		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String userName ="myusername";

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*
	 * Creates the MessageStore model object, 
	 * increase helloCount stored in the HTTP session by 1 and 
	 * returns success.  The MessageStore model
	 * object will be available to the view.
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {		
		return SUCCESS;
	}
	
	/**
	 * Increase the value of HELLO_COUNT stored in the user's 
	 * HTTP session.  
	 */
	private void increaseHelloCount() {
			
		Integer helloCount = (Integer) userSession.get(HELLO_COUNT);
		
		if (helloCount == null ) {
		
			helloCount = 1;
			
		} else {
			
			helloCount++;
		}
		
		userSession.put(HELLO_COUNT, helloCount);
	
	}

	public MessageStore getMessageStore() {
		return messageStore;
	}

	public void setMessageStore(MessageStore messageStore) {
		this.messageStore = messageStore;
	}

	
	public void setSession(Map<String, Object> session) {
		
		userSession = session ;

	}
	
	public boolean acceptableParameterName(String parameterName) {
		
		boolean allowedParameterName = true ;
		
		if ( parameterName.contains("session")  || parameterName.contains("request") ) {
		
			allowedParameterName = false ;
			
		} 
		
		return allowedParameterName;
	}
	
	

}
