package co.in.dto;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test {

	public static void TestInsert() throws Exception
	{
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		VendorDTO v=new VendorDTO();					// Parent Class Object
		
		v.setVendorid(101);
		
		v.setVendorname("DELL");
		
		
		
		CustomerDTO c=new CustomerDTO();				// 1 - Child Class Object  
		
		c.setCustomerid(201);
		
		c.setCustomername("Shubham");
		
		c.setForeignVID(101);
		
		
		
		CustomerDTO c1=new CustomerDTO();				// 2 - Child Class Object
		
		c1.setCustomerid(202);
		
		c1.setCustomername("Aman");
		
		c1.setForeignVID(101);
		

		CustomerDTO c2=new CustomerDTO();				// 3 - Child Class Object
		
		c2.setCustomerid(203);
		
		c2.setCustomername("Ajay");
		
		c2.setForeignVID(101);
		
		
		
	Set s=new HashSet();
	
	s.add(c);
	
	s.add(c1);	
		
	s.add(c2);	
		
	
	v.setChildren(s);
	
	
	Transaction ts=sess.beginTransaction();
	
	sess.save(v);
	
	ts.commit();
	
	
	sess.close();
	
	sf.close();
	
	
	
	
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		
		TestInsert();
		
	}

}
