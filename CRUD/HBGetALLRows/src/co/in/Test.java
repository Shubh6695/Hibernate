package co.in;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;



public class Test {

	
	public static void testGETALL() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Query q=s.createQuery("from StudentDTO");
		
		
		List li=q.list();
		
		
		Iterator itr=li.iterator();
		
		
		StudentDTO dto;
		
		
		while(itr.hasNext())
		{
			
			dto=(StudentDTO)itr.next();
			
			
		
			System.out.println(dto.getRollno()+"\t"+dto.getName()+"\t"+dto.getPhysics()+"\t"+dto.getChemistry()+"\t"+dto.getMaths());
		
			System.out.println();
			
		}
		
		
		s.close();
		
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		testGETALL();
	}
	
}
