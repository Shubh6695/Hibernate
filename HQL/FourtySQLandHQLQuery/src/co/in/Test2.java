package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


//Query 2:- Select * from studetails where s_name like 'a%';

public class Test2 {

	public static void SQLQUERY() throws Exception
	{
		
		System.out.println("SQL Part is Executing");
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
				
		Session s=sf.openSession();
		
		//SQL Query
		
		Query q=s.createSQLQuery("select * from studetails Where s_name like 'a%'");
		
		((SQLQuery) q).addEntity(StudentDTO.class);
		
		
		
		List li=q.list();
		
		
		Iterator it=li.iterator();
		
		
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
		
		Query h=s.createQuery("from StudentDTO where name like 'a%'");
		

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
