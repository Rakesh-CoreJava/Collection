package com.hibernate.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.hibernate.pojo.Student;
public class StoredData {
	public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("com/hibernate/configuration/student.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session session=factory.openSession();
	Transaction transaction=session.beginTransaction();
	Student s1=new Student();
	s1.setSid(1);
	s1.setSname("Ram");
	s1.setAge(12);
	session.save(s1);
	transaction.commit();
	session.close();
	factory.close();
	System.out.println("Data Saved...");
	}
}