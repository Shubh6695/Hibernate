package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;



public class QueryWithFirstLevelTest 
{

	public static void Cache1()  throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s1=sf.openSession();										// Session 1 Start
		
		
		Query q=s1.createQuery("from UserDTO where id=1");
		

		q.setCacheable(true);											// Store Perticular Query in cache memory 
		
		List rows=q.list();
		
		
		Iterator itr=rows.iterator();
		
		
		
		while(itr.hasNext())
		{
			
			UserDTO dto=(UserDTO) itr.next();
			
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
		
			System.out.println();
			
		}
	
		s1.close();																// Session 1 close
		
		
		
		
		
		
		Session s2=sf.openSession();										// Session 2 Start
		
		Query q2=s2.createQuery("from UserDTO where id=2"); 
		
		
		
		List rows2=q2.list();
		
		Iterator itr2=rows2.iterator();
		
		
		while(itr2.hasNext())
		{
			
			UserDTO dto2=(UserDTO) itr2.next();
			
			System.out.println(dto2.getId()+"\t"+dto2.getFname()+"\t"+dto2.getLname()+"\t"+dto2.getEmail()+"\t"+dto2.getAddress()+"\t"+dto2.getMobile()+"\t"+dto2.getAge());
			
			System.out.println();
		}
		
		
		s2.close();															// Session 2 close
		
		
		
		Session s3=sf.openSession();										// Session 3 Start
		
			UserDTO dto3=(UserDTO) s3.load(UserDTO.class, 1);
			
			
			System.out.println(dto3.getId()+"\t"+dto3.getFname()+"\t"+dto3.getLname()+"\t"+dto3.getEmail()+"\t"+dto3.getAddress()+"\t"+dto3.getMobile()+"\t"+dto3.getAge());
						
			System.out.println();
		
		
		s3.close();															// Session 3 close
	

		
		Session s4=sf.openSession();										// Session 4 Start
		
		UserDTO dto4=(UserDTO) s4.load(UserDTO.class, 2);
		
		
		System.out.println(dto4.getId()+"\t"+dto4.getFname()+"\t"+dto4.getLname()+"\t"+dto4.getEmail()+"\t"+dto4.getAddress()+"\t"+dto4.getMobile()+"\t"+dto4.getAge());
					
		System.out.println();
	
	
	s4.close();															// Session 4 close
	
		
		
	sf.close();	
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		Cache1();
		
	}
	
}
