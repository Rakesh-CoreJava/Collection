package com.hibernate.Test;

import org.hibernate.*;  
import org.hibernate.cfg.*;

import com.hibernate.Pojo.ChequePayment;
import com.hibernate.Pojo.CreditCardPayment;  
  
public class Client {  
public static void main(String[] args) {  
    Configuration cfg=new Configuration();
    cfg.configure("com/hibernate/congiguration/payment.cfg.xml");  
   SessionFactory factory=cfg.buildSessionFactory();
   Session session=factory.openSession();  
    Transaction t=session.beginTransaction();  
      CreditCardPayment ccp1=new CreditCardPayment();
      ccp1.setPaymentid(1003);
      ccp1.setAmount(50030);
      ccp1.setCardType("VISA");
      
      ChequePayment cp1=new ChequePayment();
      cp1.setPaymentid(104);
      cp1.setAmount(80030);
      cp1.setChequeType("order");
      session.save(cp1);
      session.save(ccp1);
    t.commit();  
    session.close();  
    System.out.println("success");  
}  
} 