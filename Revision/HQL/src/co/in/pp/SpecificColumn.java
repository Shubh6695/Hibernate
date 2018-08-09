package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.*;

public class SpecificColumn 
{

	public static void SQLQUERY() throws Exception
	{
		
		
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Query q=s.createSQLQuery("select FIRST_NAME, LAST_NAME from users");
		
		
		List rows=q.list();
		
		
		Iterator itr=rows.iterator();
		

		System.out.println("Select fname, lname by SQL QUERY");
		System.out.println();

		
		while(itr.hasNext())
		{
			Object[] columns= (Object[]) itr.next();
			
			String fname=(String) columns[0];
			
			String lname=(String) columns[1];
		
			
			System.out.println(fname+"\t"+lname);
			
			System.out.println();
			
		}
		
		
		s.close();
		
	}
	

	public static void HQLQUERY() throws Exception
	{
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();

		
		Query q=s.createQuery("select fname, lname from UserDTO");
		
		
		List rows=q.list();
		
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
			Object[] columns= (Object[]) itr.next();
			
			String fname=(String) columns[0];
			
			String lname=(String) columns[1];
		
			
			System.out.println(fname+"\t"+lname);
			
			System.out.println();
			
		}
		
		
		s.close();
	}
	
	
	public static void CRITERIAQUERY() throws Exception
	{
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();

		
		Criteria crit=s.createCriteria(UserDTO.class);
		
		
		ProjectionList p=Projections.projectionList();
		
		p.add(Projections.property("fname")); 
		
		p.add(Projections.property("lname"));
		
		crit.setProjection(p);
		
		
		List rows=crit.list();
		
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			Object[] columns=(Object[]) itr.next();
			
			String fname=(String) columns[0];
			
			String lname=(String) columns[1];
			
			
			System.out.println(fname+"\t"+lname);
			
			System.out.println();
		}
		
		s.close();
		
	}

	
	
	
	
	public static void main(String[] args) throws Exception
	{
		

		SQLQUERY();
		
					System.out.println();
					System.out.println();
					
		HQLQUERY();			
					
					System.out.println();
					System.out.println();	
		
		CRITERIAQUERY();			
					
					
	}

}
