package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test16 {

	
	// Query 6 :- select max(maths) from studetails
	
	
	public static void SQLQUERY() throws Exception
	{
		
		
		System.out.println("SQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		//SQL Query
		
		Query q=s.createSQLQuery("select max(maths) from studetails");
		
	
		//	((SQLQuery) s1).addEntity(StudentDTO.class);
		
		
		List max=q.list();
		
		
		System.out.println("Maximum marks in Maths is :- "+max);
		
		
		s.close();
		
		
	}
	
	
	public static void HQLQUERY() throws Exception
	{

		
		System.out.println("HQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		// HQL Query
		
		
		Query h=s.createQuery("select max(maths) from StudentDTO");
	
		
		
		Integer max=(Integer)h.uniqueResult();
		
		
		System.out.println("Maximum marks in Maths is :- "+max);
		

		s.close();

			
		
	}
	

	
	
	public static void main(String[] args) throws Exception
	{
		

		SQLQUERY();
		
		HQLQUERY();
		
		
	}

}
