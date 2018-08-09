package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test6 {

	
	// Query 6 :- select count(*) from studetails
	
	
	public static void SQLQUERY() throws Exception
	{
		
		
		System.out.println("SQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		//SQL Query
		
		Query q=s.createSQLQuery("select count(*) from studetails");
		
	
		//	((SQLQuery) s1).addEntity(StudentDTO.class);
		
		
		List rows=q.list();
		
		
		System.out.println("Total is Record availabe is :- "+rows);
		
		
		s.close();
		
		
	}
	
	
	public static void HQLQUERY() throws Exception
	{

		
		System.out.println("HQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		// HQL Query
		
		
		Query h=s.createQuery("select count(*) from StudentDTO");
	
			
		
		
		
		Long total=(Long)h.uniqueResult();
		
		
		System.out.println("Total is Record availabe is :- "+total);
		

		s.close();

			
		
	}
	

	
	
	public static void main(String[] args) throws Exception
	{
		

		SQLQUERY();
		
		HQLQUERY();
		
		
	}

}
