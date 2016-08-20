package com.niyaowin.park;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;


public class WebSecurity  extends WebSecurityExpressionRoot {

	public WebSecurity(Authentication a, FilterInvocation fi) {
		super(a,fi);
	}
	
	public boolean check(Authentication authentication, HttpServletRequest request) {
		return true;
	}
}