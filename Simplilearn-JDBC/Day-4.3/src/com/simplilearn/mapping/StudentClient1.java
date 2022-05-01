package com.simplilearn.mapping;

import org.hibernate.*;

public class StudentClient1 {
	public static void main(String[] args) {
		Transaction tx = null;

		try {
			SessionFactory sf = AHibernateUtil.getFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			Student stu = new Student("OM", "OM@abc", "911111");
			session.save(stu);

			Address add = new Address("thakur", "Bang", "TN");
			session.save(add);
			
			stu.setAddress(add);
			
			
			tx.commit();
			session.close();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
	}
}
