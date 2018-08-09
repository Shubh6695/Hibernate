package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;



public class Test8 
{

	
	//Query 8:- select * from studetails Where s_name NOT like 'a%'
	

	public static void SQLQUERY() throws Exception
	{
		
		System.out.println("SQL Part is Executing");
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
				
		Session s=sf.openSession();
		
		//SQL Query
		
		Query q=s.createSQLQuery("select * from studetails Where s_name NOT like 'a%'");
		
		((SQLQuery) q).addEntity(StudentDTO.class);
		
		
		
		List rows=q.list();
		
		
		Iterator it=rows.iterator();
		
		
		StudentDTO dto;
		
		
		while(it.hasNext())
		{

			dto=(StudentDTO)it.next();
			
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
		
		Query h=s.createQuery("from StudentDTO where name NOT like 'a%'");
		

		List rows=h.list();
		
		
		Iterator it=rows.iterator();
		
		
		StudentDTO dto;
		
		
		while(it.hasNext())
		{

			dto=(StudentDTO)it.next();
			
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
