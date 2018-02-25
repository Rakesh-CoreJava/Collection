package com.hibernate.Test;

import org.hibernate.*;  
import org.hibernate.cfg.*;
import com.hibernate.Pojo.ChequePayment;
import com.hibernate.Pojo.CreditCardPayment;  
public class Client {  
public static void main(String[] args) {  
      Configuration cfg=new Configuration();
      cfg.configure("com/hibernate/mapping/payment.cfg.xml");  
      SessionFactory factory=cfg.buildSessionFactory();
      Session session=factory.openSession();  
      Transaction t=session.beginTransaction();  
      CreditCardPayment ccp=new CreditCardPayment();
      ccp.setAmount(8000);
      ccp.setCardType("Mastro");
      ccp.setPaymentid(1001);
      ChequePayment cq=new ChequePayment();
      cq.setAmount(20000);
      cq.setChequeType("Order");
      cq.setPaymentid(103);
      session.save(ccp);
      session.save(cq);  
      t.commit();  
      session.close();  
      factory.close();
      System.out.println("success");  
}  
} 