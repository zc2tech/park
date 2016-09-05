package com.niyaowin.park;

import org.hibernate.Session;

import com.niyaowin.park.entity.Staff;
import com.niyaowin.park.util.HibernateUtil;

public class Main2 {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Staff superStaff = (Staff) session.createQuery(
			    "from Staff where is_super = ?")
			    .setBoolean(0,true)
			    .uniqueResult();
		System.out.println(superStaff.toString());

	}

}
