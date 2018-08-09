package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test17 {

	
	// Query 6 :- select sum(maths) from studetails
	
	
	public static void SQLQUERY() throws Exception
	{
		
		
		System.out.println("SQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		//SQL Query
		
		Query q=s.createSQLQuery("select sum(maths) from studetails");
		
	
		//	((SQLQuery) s1).addEntity(StudentDTO.class);
		
		
		List sum=q.list();
		
		
		System.out.println("Total Sum of Record is :- "+sum);
		
		
		s.close();
		
		
	}
	
	
	public static void HQLQUERY() throws Exception
	{

		
		System.out.println("HQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		// HQL Query
		
		
		Query h=s.createQuery("select sum(maths) from StudentDTO");
	
		
		
		Long sum=(Long)h.uniqueResult();
		
		
		System.out.println("Total Sum of Record is :- "+sum);
		

		s.close();

			
		
	}
	

	
	
	public static void main(String[] args) throws Exception
	{
		

		SQLQUERY();
		
		HQLQUERY();
		
		
	}

}
