package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;



public class Test25 {

	// Query 7 :- select * from studetails where roll_no  not between 1001 and 1005

	public static void SQLQUERY() throws Exception
	{
		
		
		System.out.println("SQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		
		Query s1=s.createSQLQuery("select * from studetails where roll_no not between 1001 and 1005");
		
	
		((SQLQuery) s1).addEntity(StudentDTO.class);
		
		
		 
		
		List rows=s1.list();
		
		
		 
		
		Iterator itr=rows.iterator();
		
		
		StudentDTO dto;
		
		
		while(itr.hasNext())
		{
			
			dto=(StudentDTO)itr.next();
			
			System.out.println(dto.getRollno()+"\t"+dto.getName()+"\t"+dto.getPhysics()+"\t"+dto.getChemistry()+"\t"+dto.getMaths());
			
			System.out.println();
		}
		
		
		
		s.close();

		
	}
	
	
	public static void HQLQUERY() throws Exception
	{
		
		
		System.out.println("HQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
			
		
		Query h1=s.createQuery("from StudentDTO where rollno not  between 1001 and 1005");
		
		
		
		List rows=h1.list();
		
		
		Iterator itr=rows.iterator();
		
		
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
	

		SQLQUERY();
		
		HQLQUERY();
	}

}
