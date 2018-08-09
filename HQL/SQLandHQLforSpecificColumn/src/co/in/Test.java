package co.in;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;


public class Test 
{

	public static void SQLQUERY() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Query h=s.createQuery("select rollno, name from studetails");
		
		
		
		List rows=h.list();
		
		Iterator itr=rows.iterator();
		
	
		Object[] columns;
		
		
		while(itr.hasNext())
		{
		
			columns=(Object[])itr.next();
	
			
			Integer rollno=(Integer)columns[0];
			
			String name=(String)columns[1];
			
			
			System.out.println(rollno+"\t"+name);
			
		}
		
		
		s.close();
		
		
		
	}
	
	
	public static void HQLQUERY() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Query h=s.createQuery("select a.rollno, a.name from StudentDTO a");
		
		
		
		List rows=h.list();
		
		Iterator itr=rows.iterator();
		
	
		Object[] columns;
		
		
		while(itr.hasNext())
		{
		
			columns=(Object[])itr.next();
	
			
			Integer rollno=(Integer)columns[0];
			
			String name=(String)columns[1];
			
			
			System.out.println(rollno+"\t"+name);
			
		}
		
		
		s.close();
		
		
	}
	
	
	
	
	
	public static void CRITERIAQUERY() throws Exception
	{
		
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Criteria crit=s.createCriteria(StudentDTO.class);
		
		
		List rows=crit.list();
		
		
		Iterator itr=rows.iterator();
		
		
		StudentDTO dto;
		
		
		while(itr.hasNext())
		{
			
			dto=(StudentDTO)itr.next();
			
			
			System.out.println(dto.getRollno()+"\t"+dto.getName()+"\t"+dto.getPhysics()+"\t"+dto.getChemistry()+"\t"+dto.getMaths());
			
			System.out.println();
			
			
		}
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception 
	{
		
		
		SQLQUERY();
		
		
		HQLQUERY();
		
		
		CRITERIAQUERY();
		
		
	}
	
	
}
