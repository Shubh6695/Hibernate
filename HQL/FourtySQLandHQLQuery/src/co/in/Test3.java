package co.in;


import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


//Query 3:- select ROLL_NO, S_NAME from studetails;

public class Test3 

{

	public static void SQLQUERY() throws Exception
	{
System.out.println("SQL Part is Executing");
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
				
		Session s=sf.openSession();
		
		
		//SQL Query
		
		Query q=s.createSQLQuery("select ROLL_NO, S_NAME from studetails");
		
	//	((SQLQuery) q3).addEntity(StudentDTO.class);
		
		
		
		List rows=q.list();
		
		
		Iterator it=rows.iterator();
		
		// Creating array of columns type of object class.
		
		Object columns[];
		
		StudentDTO dto;
		
		
		System.out.println("Rollno \t Name");
		
		while(it.hasNext())
		{

			columns=(Object[])it.next();
			
			Integer rollno=(Integer) columns[0];
			
			String  name=(String) columns[1];
			
			System.out.println(rollno+"\t"+name);
			
		}
		
		
		s.close();

		
	}
	
	
	public static void HQLQUERY() throws Exception
	{
	System.out.println("HQL Part is Executing");
		

		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();

		
		//HQL Query
		
		Query h=s.createQuery("select a.rollno, a.name from StudentDTO a");
		
		List rows=h.list();
		
		
		Iterator it=rows.iterator();
		
		
		Object[] columns;
		
		
		System.out.println("Roll No \t Name");
		
		
		while(it.hasNext())
		{
			
			columns=(Object[])it.next();
			
			Integer rollno=(Integer)columns[0];
			
			String name=(String)columns[1];
			
			System.out.println(rollno+"\t"+name);
			
		}
			
		
		s.close();

		

		
	}
	
	
	
public static void main(String[] args)throws Exception
{
	
	
	SQLQUERY();
	
	HQLQUERY();
	
	
}
	
}
