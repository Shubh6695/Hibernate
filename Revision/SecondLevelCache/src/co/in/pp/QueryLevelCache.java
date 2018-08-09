package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class QueryLevelCache {
	
	
	public static void QueryDemo() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s1=sf.openSession();


		System.out.println("This Query from Session s1 ");
		
long start1=System.currentTimeMillis();

		Query q1= s1.createQuery("from UserDTO");
		

long end1=System.currentTimeMillis();



System.out.println("Difference :---"+(end1-start1));

		q1.setCacheable(true);
		
		List rows1=q1.list();
		
		Iterator itr1=rows1.iterator();
		
		
		while(itr1.hasNext())
		{
			
			UserDTO dto=(UserDTO) itr1.next();
			
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();
			
		}
		
	s1.close();	
		
		
	
	Session s2=sf.openSession();
	
	
	System.out.println("This Query from Session s2 ");
	
long start2=System.currentTimeMillis();

	
	Query q2=s2.createQuery("from UserDTO");

long end2=System.currentTimeMillis();


System.out.println("Difference of s2 :---"+(end2-start2));
	
	List rows2=q2.list();
	
	Iterator itr2=rows2.iterator();
	
	while(itr2.hasNext())
	{

		UserDTO dto=(UserDTO) itr2.next();
		
		System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
		
		System.out.println();

	}
	
	
	s2.close();
	
	
	
	Session s3=sf.openSession();
	
	System.out.println("This Query from Session s3 ");
	
long start3=System.currentTimeMillis();
	
	for(int i=1; i<=6; i++)
	{
		
		UserDTO dto=(UserDTO) s3.load(UserDTO.class, i);
		
		System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
		
		System.out.println();
		
		
	}
	
long end3=System.currentTimeMillis();

System.out.println("Difference of s3 :---"+(end3-start3));
	
	s3.close();
	
	sf.close();
	
	}
	
	public static void main(String[] args) throws Exception
	{
		
		QueryDemo();
		
		
	}
	

}
