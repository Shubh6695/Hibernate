package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;



public class Test {

	public static void NamedDemo() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Query q1=s.getNamedQuery("allpart");							
		
		
		System.out.println("From Query Q1");
		
		
		List rows=q1.list();
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			UserDTO dto=(UserDTO) itr.next();
			
			
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
