package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test18 {

	
	// Query 6 :- select avg(maths) from studetails
	
	
	public static void SQLQUERY() throws Exception
	{
		
		
		System.out.println("SQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		//SQL Query
		
		Query q=s.createSQLQuery("select avg(maths) from studetails");
		
	
		//	((SQLQuery) s1).addEntity(StudentDTO.class);
		
		
		List avg=q.list();
		
		
		System.out.println("Average of Maths Marks :- "+avg);
		
		
		s.close();
		
		
	}
	
	
	public static void HQLQUERY() throws Exception
	{

		
		System.out.println("HQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		// HQL Query
		
		
		Query h=s.createQuery("select avg(maths) from StudentDTO");
	
		
		
		Double avg=(Double)h.uniqueResult();
		
		
		System.out.println("Average of Maths Marks :- "+avg);
		

		s.close();

			
		
	}
	

	
	
	public static void main(String[] args) throws Exception
	{
		

		SQLQUERY();
		
		HQLQUERY();
		
		
	}

}
