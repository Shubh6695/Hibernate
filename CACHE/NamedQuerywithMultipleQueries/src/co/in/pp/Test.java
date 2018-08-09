package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;



public class Test {

	public static void NamedDemo() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Query q1=s.getNamedQuery("allpart");							// Query 1
		
		
		System.out.println("From Query Q1");
		
		
		List rows=q1.list();
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			UserDTO dto=(UserDTO) itr.next();
			
			
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();
			
		}
		
		
		
		
		
		Query q2=s.getNamedQuery("allpart");							// Query 2
		
		System.out.println("From Query Q2");
		
		
		List rows2=q2.list();
		
		Iterator itr2=rows2.iterator();
		
		
		while(itr2.hasNext())
		{
			
			UserDTO dto=(UserDTO) itr2.next();
		
			
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();
	
			
		}
		
		
		
		
		s.close();
		
		sf.close();
		
	}
	
	
	
	public static void main(String[] args)throws Exception
	{
	
		NamedDemo();
		
		
	}
	
	
}
