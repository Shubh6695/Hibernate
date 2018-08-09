package co.in.main;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

import co.in.DTO.*;


public class Test 
{

	
	public static void InsertALL() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		StudentDTO sdto= new StudentDTO(); 
		
	//	sdto.setSid(101);
		
		sdto.setSname("Aman");
		
		sdto.setSemail("aman@gmail.com");
		
		sdto.setSgender("Male");
		
		sdto.setSmobile(999666333);
		
		
		
														AddressDTO adto=new AddressDTO();
														
														adto.setAid(202);
		
														adto.setCity("Mumbai");
		
														adto.setState("Maharashtra");
		
														adto.setCountry("India");
														
														adto.setPincode(222000);
		
													
														
		sdto.setAddressChild(adto);
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.save(sdto);
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void GetALL() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		Query q=sess.createQuery("from StudentDTO");
		
		
		List rows=q.list();
		
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			StudentDTO sdto=(StudentDTO) itr.next();
			
			
			AddressDTO adto=sdto.getAddressChild();
			
			
			System.out.println("Student Information");
			
			System.out.println(sdto.getSid()+"\t"+sdto.getSname()+"\t"+sdto.getSemail()+"\t"+sdto.getSgender()+"\t"+sdto.getSmobile()+"\n");
			
			
			System.out.println("Address Information");
			
			
			System.out.println(adto.getAid()+"\t"+adto.getCity()+"\t"+adto.getState()+"\t"+adto.getCountry()+"\t"+adto.getPincode()+"\n");
			
		}
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	InsertALL();
		
	//	GetALL();
		
		
	}
	
}
