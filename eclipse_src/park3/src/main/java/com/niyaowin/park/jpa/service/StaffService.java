package com.niyaowin.park.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;

import com.niyaowin.park.entity.Staff;

public class StaffService {
    private Session session;

    public static StaffService getStaffService(Session ses) {
    	return new StaffService(ses);
    }
    
    public StaffService(Session ses) {
    	this.session = ses;
    }        
    
    public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
    public Staff findSuperUser() {
		//session = HibernateUtil.getSessionFactory().openSession();
		
		Staff superStaff = (Staff) session.createQuery(
			    "from Staff where is_super = ?")
			    .setBoolean(0,true)
			    .uniqueResult();		

		return superStaff;
    }
}