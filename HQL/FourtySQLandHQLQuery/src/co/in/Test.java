package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


//Query 1:- Select * from studetails; 

public class Test {

	
	public static void SQLQUERY() throws Exception
	{
		
		
		System.out.println("SQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		//SQL Query
		
		Query s1=s.createSQLQuery("select * from studetails");
		
	
		((SQLQuery) s1).addEntity(StudentDTO.class);
		
		
		// Useing List Interface 
		
		List rows=s1.list();
		
		
		// Useing Iterator Interface 
		
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
		
		//HQL Query	
		
		Query h1=s.createQuery("from StudentDTO");
		
		
		
		List rows=h1.list();
		
		
		Iterator itr=rows.iterator();
		
		
		StudentDTO dto;
		
		
		while(itr.hasNext())
		{
			
			// Type cast itr.next() into StudentDTO
			
			dto=(StudentDTO)itr.next();
			
			System.out.println(dto.getRollno()+"\t"+dto.getName()+"\t"+dto.getPhysics()+"\t"+dto.getChemistry()+"\t"+dto.getMaths());
			
			System.out.println();
		}
		
		
		
		s.close();
		

		
		
	}
	
	
	
	
	public static void CRITERIAQUERY() throws Exception 
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Criteria crit=s.createCriteria(StudentDTO.class);
		
		
		List rows =crit.list();
		
		
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
		
				System.out.println();
				System.out.println();
		
		HQLQUERY();

				System.out.println();
				System.out.println();
		
		
		CRITERIAQUERY();		
		
	}

}
