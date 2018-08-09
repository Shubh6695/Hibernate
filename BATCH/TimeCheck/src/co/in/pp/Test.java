package co.in.pp;


import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;


public class Test 
{

	
	public static void getALL() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		long start=System.currentTimeMillis();
		
		int count=0;
		
		System.out.println("Start Time :-- "+start);
		
		
					Query q=sess.createQuery("from CustomerDTO");
					
					List rows=q.list();
					
					Iterator itr=rows.iterator();
					
					while(itr.hasNext())
					{
						
						
						CustomerDTO cdto=(CustomerDTO) itr.next();
						
						
						System.out.println(cdto.getCustomerid()+"\t"+cdto.getCustomername()+"\t"+cdto.getCity()+"\t"+cdto.getState());
						
						
						count++;
					}
					
		
		long end=System.currentTimeMillis();
		
		System.out.println("End Time :--  "+end);
					
					
		System.out.println("Difference in Time :-- " +(end-start));
		
		
		System.out.println("Total Count is :-- "+count);
		
		sess.close();
	
		sf.close();
		
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		
		
		getALL();
		
	}
	
	
}
