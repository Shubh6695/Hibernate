package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test15 {

	
	// Query 6 :- select min(maths) from studetails
	
	
	public static void SQLQUERY() throws Exception
	{
		
		
		System.out.println("SQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		//SQL Query
		
		Query q=s.createSQLQuery("select min(maths) from studetails");
		
	
		//	((SQLQuery) s1).addEntity(StudentDTO.class);
		
		
		List min=q.list();
		
		
		System.out.println("Minimum marks in Maths is :- "+min);
		
		
		s.close();
		
		
	}
	
	
	public static void HQLQUERY() throws Exception
	{

		
		System.out.println("HQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		// HQL Query
		
		
		Query h=s.createQuery("select min(maths) from StudentDTO");
	
		
		
		Integer min=(Integer)h.uniqueResult();
		
		
		System.out.println("Minimum marks in Maths is :- "+min);
		

		s.close();

			
		
	}
	

	
	
	public static void main(String[] args) throws Exception
	{
		

	//	SQLQUERY();
		
		HQLQUERY();
		
		
	}

}
