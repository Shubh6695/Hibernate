package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class MultipleQuery 
{

	
	public static void MultipleDemo() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		System.out.println("From Query q1");
		
		
		Query q1=s.getNamedQuery("user1");								// Query 1
		
		List rows1=q1.list();
		
		
		Iterator itr1=rows1.iterator();
		
		
		while(itr1.hasNext())
		{
		
			UserDTO dto=(UserDTO) itr1.next();
			
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();

		}
		
		
		
		System.out.println("From Query q2");
		
		Query q2=s.getNamedQuery("user2");							// Query 2
		
		List rows2=q2.list();
		
		
		Iterator itr2=rows2.iterator();
		
		
		while(itr2.hasNext())
		{
		
			UserDTO dto=(UserDTO) itr2.next();
			
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();

		}
		
		
		
		
		System.out.println("From Query q3");
		
		
		Query q3=s.getNamedQuery("user3");
		
		
		List rows3=q3.list();
		
		
		Iterator itr3=rows3.iterator();
		
		
		while(itr3.hasNext())
		{
			
			UserDTO dto=(UserDTO) itr3.next();
			
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();


		}
		
		
		
		System.out.println("From Query q4");
		
		Query q4=s.getNamedQuery("user4");
		
		
		q4.setString(0, "sv@gmail.com");
		
		q4.setInteger(1, 666333);
		
		
		List rows4=q4.list();
		
		
		Iterator itr4=rows4.iterator();
		
		
		while(itr4.hasNext())
		{
			UserDTO dto=(UserDTO) itr4.next();
			
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();
			
		}
		
		
		
		s.close();
		
		
		sf.close();
		
	}
	
	
	
	public static void main(String[] args)throws Exception
	{
		
		MultipleDemo();
				
	}
	
	
	
}
