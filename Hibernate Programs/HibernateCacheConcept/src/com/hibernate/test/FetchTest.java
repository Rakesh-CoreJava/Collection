package com.hibernate.test;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.cfg.Configuration;

import com.hibernate.pojo.Student;  

public class FetchTest {  
public static void main(String[] args) {  
Configuration cfg=new Configuration().configure("com/hibernate/configuration/student.cfg.xml");  
SessionFactory factory=cfg.buildSessionFactory();  
    
  Session session1=factory.openSession();  
  Student s2=(Student)session1.load(Student.class,1);  
  System.out.println(s2.getSid()+"  "+s2.getSname()+"   "+s2.getAge());  
  session1.close();  
    
  Session session2=factory.openSession();  
  Student s3=(Student)session1.load(Student.class,1);  
  System.out.println(s3.getSid()+"  "+s3.getSname()+"   "+s3.getAge());  
  session2.close();  
    
}  
}  