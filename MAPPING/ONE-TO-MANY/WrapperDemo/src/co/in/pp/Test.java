package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;



public class Test 
{

	
	public static void Demo() throws Exception
	{
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Query q=s.createQuery("from UserDTO");
		
		
		List rows=q.list();
		
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
			UserDTO dto=(UserDTO) itr.next();
			
			
			System.out.println(dto.getEid()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();
		}
		
		s.close();
		
		sf.close();
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		
		Demo();
		
	}
	
	
}
